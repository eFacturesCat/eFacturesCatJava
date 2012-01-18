package cat.eFactures.secure;

import cat.eFactures.common.Constants;
import cat.eFactures.common.EFacturesException;
import cat.eFactures.transform.Facturae_3_2;

/**
 * Spanish facturae 3.2 secured (signed invoice)
 * 
 * @author @santicasas
 *
 */
public class SecuredFacturae_3_2 extends SecuredInvoice {

	/**
	 * Constructor
	 * 
	 * @param xml Invoice facturae3.2 invoice to be signed
	 */
	public SecuredFacturae_3_2(Facturae_3_2 xmlInvoice) {
		super(xmlInvoice);
	}
	
	/**
	 * Secure (sign with XAdES-EPES) the invoice
	 * 
	 * @param cert Signing certificate
	 * @param format Signature format
	 * @throws Exception
	 */
	public void signInvoice(SigningCertificate cert, String format) throws Exception {
		if (format.equals(Constants.XAdES_EPES_Enveloped))
		{
			this.signInvoiceXadesEpesEnveloped(cert, Constants.facturae31policy);
		} else {
			throw new EFacturesException("Signature Format " + format + " not implemented yet.");
		}			
	}
}
