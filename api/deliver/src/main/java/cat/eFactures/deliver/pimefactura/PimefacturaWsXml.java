package cat.eFactures.deliver.pimefactura;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cat.eFactures.transform.XMLInvoice;

public class PimefacturaWsXml {
	
	private ObjectFactory factory = new ObjectFactory();
	private Root root = factory.createRoot();
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    
    
	public PimefacturaWsXml(XMLInvoice xmlInvoice, String ak) throws IOException, ParserConfigurationException {

		root.facturas = factory.createFacturas();
		root.facturas.ak = ak;
		root.facturas.param1="0";
		root.facturas.param2="";
		root.facturas.param3="";
		
		// encode xmlInvoice
		byte[] data = new byte[xmlInvoice.getXmlInputStream().available()];
		xmlInvoice.getXmlInputStream().read(data);
		String invoiceEncoded = Base64.encodeBase64String(data);
        invoiceEncoded = invoiceEncoded.replaceAll("\n", "");
        invoiceEncoded = invoiceEncoded.replaceAll("\r", "");
        root.facturas.factura = factory.createFactura();
        root.facturas.factura.setBase64Document(invoiceEncoded);        
	}
	
	public String marshall() throws JAXBException {
		StringWriter sw = new StringWriter();
		JAXBContext jc = JAXBContext.newInstance("cat.eFactures.deliver.pimefactura");
		Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		m.marshal(root,sw);
		return sw.toString();
	}
	
	public Element getRoot() throws ParserConfigurationException, JAXBException {

		JAXBContext jc = JAXBContext.newInstance("cat.eFactures.deliver.pimefactura");
		Marshaller m = jc.createMarshaller();
		Document doc = dbf.newDocumentBuilder().newDocument();
		m.marshal(root, doc);
		return (doc.getDocumentElement());
	}

}
