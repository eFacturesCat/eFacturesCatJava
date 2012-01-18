package cat.eFactures.deliver;

import cat.eFactures.transform.XMLInvoice;

/**
 * Abstract Class for endPoints to deliver invoices
 * 
 * @author Santi
 *
 */
public abstract class EndPoint {
	/**
	 * Method to deliverInvoice
	 * @param xmlInvoice XmlInovice to be delivered
	 * @return Result of delivery
	 * @throws Exception
	 */
	public abstract String deliverInvoice(XMLInvoice xmlInvoice) throws Exception;

}
