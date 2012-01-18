package cat.eFactures.deliver.pimefactura;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import cat.eFactures.common.Constants;
import cat.eFactures.deliver.EndPoint;
import cat.eFactures.deliver.pimefactura.ws.PimecInvoiceReceptor;
import cat.eFactures.deliver.pimefactura.ws.PimecInvoiceReceptorPortType;
import cat.eFactures.transform.XMLInvoice;

/**
 *  "pimefactura" endPoint for deliver invoices
 *  "pimefactura" is a envoicing service of PIMEC (www.pimefactura.com)
 *  Is a SOAP WebService
 * @author @santicasas
 *
 */
public class EndPointPimefactura extends EndPoint {

	private String ak;
	private final static QName PIMECINVOICERECEPTOR_QNAME = new QName("http://Service.Reception.Invoice.Pimec", "PimecInvoiceReceptor");
	private URL url;
	
	/**
	 * Constructor
	 * 
	 * @param ak Issuer Web Service Key
	 * @param environment Environment (Production or PreProduction)
	 * @throws MalformedURLException
	 */
	public EndPointPimefactura(String ak, String environment) throws MalformedURLException {
		this.ak = ak;
		if (!environment.equals(Constants.prod_environment))
			url = getClass().getClassLoader().getResource("PimecInvoiceReceptor_prepro.wsdl");
		else
			url = getClass().getClassLoader().getResource("PimecInvoiceReceptor_prod.wsdl");
	}
	
	@Override
	public String deliverInvoice(XMLInvoice xmlInvoice) throws Exception {
		PimefacturaWsXml pwx = new PimefacturaWsXml(xmlInvoice,ak);
		PimecInvoiceReceptor service = new PimecInvoiceReceptor(url, PIMECINVOICERECEPTOR_QNAME);
		PimecInvoiceReceptorPortType port = service.getPimecInvoiceReceptorHttpSoap12Endpoint();
		String result = port.summitInvoice(pwx.getRoot());
		return result;
	}

}
