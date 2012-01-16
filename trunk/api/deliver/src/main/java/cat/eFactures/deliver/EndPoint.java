package cat.eFactures.deliver;

import cat.eFactures.transform.XMLInvoice;

public abstract class EndPoint {
	public abstract String deliverInvoice(XMLInvoice xmlInvoice) throws Exception;

}
