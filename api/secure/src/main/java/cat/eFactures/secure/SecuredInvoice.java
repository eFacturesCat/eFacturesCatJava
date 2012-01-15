package cat.eFactures.secure;

import java.io.IOException;

import cat.eFactures.transform.XMLInvoice;

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

}
