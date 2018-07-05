package cat.eFactures.secure;

import java.io.IOException;

import org.w3c.dom.Document;

import cat.eFactures.common.Utils;
import cat.eFactures.transform.XMLInvoice;
import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.EnumFormatoFirma;
import es.mityc.firmaJava.libreria.xades.FirmaXML;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.javasign.xml.refs.AllXMLToSign;
import es.mityc.javasign.xml.refs.ObjectToSign;

/**
 * Abstract class for "secured" invoices (i.e. Signed Xml Invoices)
 * 
 * @author @santicasas
 *
 */
public abstract class SecuredInvoice implements SecuredInvoiceInterface {

	private XMLInvoice xmlInvoice;
	private XMLInvoice xmlInvoiceSigned = null;
	
	private void setXmlInvoiceSigned(XMLInvoice xmlInvoiceSigned) {
		this.xmlInvoiceSigned = xmlInvoiceSigned;
	}
	private XMLInvoice getXmlInvoice() {
		return xmlInvoice;
	}

	private void setXmlInvoice(XMLInvoice xmlInvoice) {
		this.xmlInvoice = xmlInvoice;
	}

	/**
	 * Constructor
	 * @param xmlInvoice XmlInvoice to be securized
	 */
	public SecuredInvoice(XMLInvoice xmlInvoice) {
		this.setXmlInvoice(xmlInvoice);	
	}

	/**
	 * Save the invoice secured
	 * @param fileName to save
	 * @throws IOException
	 */
	public void saveInvoiceSigned(String fileName) throws IOException {
		xmlInvoiceSigned.saveXML(fileName);
	}
	
	/**
	 * General Method to Secure Invoices with XAdES-EPES Enveloped Signature (i.e. Spanish facturae)
	 * @param cert
	 * @param policy
	 * @throws Exception
	 */
	public void signInvoiceXadesEpesEnveloped(SigningCertificate cert, String policy) throws Exception {
		DataToSign dataToSign = new DataToSign();
        dataToSign.setXadesFormat(EnumFormatoFirma.XAdES_BES);
        dataToSign.setEsquema(XAdESSchemas.XAdES_132);
        dataToSign.setPolicyKey(policy);
        dataToSign.setAddPolicy(true);
        dataToSign.setXMLEncoding("UTF-8");
        dataToSign.setEnveloped(true);        
        Document docToSign;
		docToSign = Utils.readXml(this.getXmlInvoice().getXmlInputStream());
		dataToSign.addObject(new ObjectToSign(new AllXMLToSign(), "Policy " + policy, null, "text/xml", null));
		dataToSign.setDocument(docToSign);
		FirmaXML firma = new FirmaXML();
		Object[] res = firma.signFile(cert.getCertificate(), dataToSign, cert.getPrivateKey(), cert.getProvider());
		this.setXmlInvoiceSigned(new XMLInvoice((Document) res[0]));
	}
}
