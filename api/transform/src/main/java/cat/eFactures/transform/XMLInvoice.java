package cat.eFactures.transform;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;

public class XMLInvoice {
	private InputStream xmlInputStream;

	public XMLInvoice(String fileName) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		this.xmlInputStream = fis;
	}
	
	public XMLInvoice(InputStream xmlInputStream) {
		this.xmlInputStream = xmlInputStream;
	}
	
	public XMLInvoice(Document doc) throws TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Source xmlSource = new DOMSource(doc);
		Result outputTarget = new StreamResult(outputStream);
		TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);
		xmlInputStream = new ByteArrayInputStream(outputStream.toByteArray());
	}

	public InputStream getXmlInputStream() {
		return xmlInputStream;
	}
	
	public void save(String fileName) throws IOException {		
		IOUtils.copy(xmlInputStream, new FileOutputStream(fileName));
	}
}
