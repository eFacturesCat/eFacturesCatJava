package cat.eFactures.secure;

import java.io.IOException;

/**
 * Abstract class for "secured" invoices (i.e. Signed Xml Invoices)
 * 
 * @author @santicasas
 *
 */
public interface SecuredInvoiceInterface {

	public void signInvoice(SigningCertificate cert, String format) throws Exception;
	public void saveInvoiceSigned(String fileName) throws IOException;	
}
