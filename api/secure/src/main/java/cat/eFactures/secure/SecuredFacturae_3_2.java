package cat.eFactures.secure;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import cat.eFactures.common.Utils;
import cat.eFactures.transform.Facturae_3_2;
import cat.eFactures.transform.XMLInvoice;
import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.EnumFormatoFirma;
import es.mityc.firmaJava.libreria.xades.FirmaXML;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.javasign.xml.refs.AllXMLToSign;
import es.mityc.javasign.xml.refs.ObjectToSign;

public class SecuredFacturae_3_2 extends SecuredInvoice {

	public SecuredFacturae_3_2(Facturae_3_2 xmlInvoice) {
		super(xmlInvoice);
		// TODO Auto-generated constructor stub
	}
	
	public void signInvoice(SigningCertificate cert) {
		DataToSign dataToSign = new DataToSign();
        dataToSign.setXadesFormat(EnumFormatoFirma.XAdES_BES);
        dataToSign.setEsquema(XAdESSchemas.XAdES_132);
        dataToSign.setPolicyKey("facturae31");
        dataToSign.setAddPolicy(true);
        dataToSign.setXMLEncoding("UTF-8");
        dataToSign.setEnveloped(true);        
        Document docToSign;
		try {
			docToSign = Utils.readXml(this.getXmlInvoice().getXmlInputStream());
			dataToSign.addObject(new ObjectToSign(new AllXMLToSign(), "Aval Candidatura", null, "text/xml", null));
			dataToSign.setDocument(docToSign);
			FirmaXML firma = new FirmaXML();
			Object[] res = firma.signFile(cert.getCertificate(), dataToSign, cert.getPrivateKey(), cert.getProvider());
			this.setXmlInvoiceSigned(new XMLInvoice((Document) res[0]));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
	}

}
