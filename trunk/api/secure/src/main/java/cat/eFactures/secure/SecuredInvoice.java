package cat.eFactures.secure;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import cat.eFactures.common.Utils;
import cat.eFactures.transform.XMLInvoice;
import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.EnumFormatoFirma;
import es.mityc.firmaJava.libreria.xades.FirmaXML;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.javasign.xml.refs.AllXMLToSign;
import es.mityc.javasign.xml.refs.ObjectToSign;

public abstract class SecuredInvoice {

	private XMLInvoice xmlInvoice;
	private XMLInvoice xmlInvoiceSigned = null;
	
	public XMLInvoice getXmlInvoiceSigned() {
		return xmlInvoiceSigned;
	}

	public void setXmlInvoiceSigned(XMLInvoice xmlInvoiceSigned) {
		this.xmlInvoiceSigned = xmlInvoiceSigned;
	}

	public SecuredInvoice(XMLInvoice xmlInvoice) {
		this.setXmlInvoice(xmlInvoice);	
	}
	
	public void signInvoice() {
	
	}

	public XMLInvoice getXmlInvoice() {
		return xmlInvoice;
	}

	public void setXmlInvoice(XMLInvoice xmlInvoice) {
		this.xmlInvoice = xmlInvoice;
	}
	
	public void saveInvoiceSigned(String fileName) throws IOException {
		xmlInvoiceSigned.save(fileName);
	}
	
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
