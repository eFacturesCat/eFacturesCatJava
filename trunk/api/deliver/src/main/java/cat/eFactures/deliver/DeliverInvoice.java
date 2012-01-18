package cat.eFactures.deliver;

import cat.eFactures.transform.XMLInvoice;

/**
 * Generic class for Invoice Delivery
 * 
 * @author @santicasas
 *
 */
public class DeliverInvoice {

	private XMLInvoice xmlInvoice;
	private EndPoint endPoint;
	private void setXmlInvoice(XMLInvoice xmlInvoice) {
		this.xmlInvoice = xmlInvoice;
	}
	private void setEndPoint(EndPoint endPoint) {
		this.endPoint = endPoint;
	}

	/**
	 * Constructor
	 * 
	 * @param xmlInvoice Invoice to deliver
	 * @param endPoint endpoint to send invoice
	 */

	public DeliverInvoice (XMLInvoice xmlInvoice, EndPoint endPoint) {
		setEndPoint(endPoint);
		setXmlInvoice(xmlInvoice);
	}

	/**
	 * Method for deliver invoice
	 * @return Results of delivey
	 * @throws Exception
	 */
	public String deliverInvoice() throws Exception {
		return endPoint.deliverInvoice(xmlInvoice);
	}
	

}
