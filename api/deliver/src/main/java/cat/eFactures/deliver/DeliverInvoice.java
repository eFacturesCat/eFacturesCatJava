package cat.eFactures.deliver;

import cat.eFactures.transform.XMLInvoice;

public class DeliverInvoice {
	private XMLInvoice xmlInvoice;
	private EndPoint endPoint;

	public DeliverInvoice (XMLInvoice xmlInvoice, EndPoint endPoint) {
		setEndPoint(endPoint);
		setXmlInvoice(xmlInvoice);
	}
	
	public XMLInvoice getXmlInvoice() {
		return xmlInvoice;
	}

	public void setXmlInvoice(XMLInvoice xmlInvoice) {
		this.xmlInvoice = xmlInvoice;
	}

	public EndPoint getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(EndPoint endPoint) {
		this.endPoint = endPoint;
	}

	public String deliverInvoice() throws Exception {
		return endPoint.deliverInvoice(xmlInvoice);
	}
}
