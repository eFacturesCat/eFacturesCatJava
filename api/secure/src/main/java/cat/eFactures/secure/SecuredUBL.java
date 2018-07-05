package cat.eFactures.secure;

import java.nio.file.SecureDirectoryStream;

import cat.eFactures.common.Constants;
import cat.eFactures.common.EFacturesException;
import cat.eFactures.transform.UBLInvoice;

/**
 * UBL secured (signed invoice)
 * 
 * @author Joaquín López
 *
 */
public class SecuredUBL extends SecuredInvoice {

	/**
	 * Constructor
	 * 
	 * @param xml Invoice UBL to be signed
	 */
	public SecuredUBL(UBLInvoice xmlInvoice) {
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
			this.signInvoiceXadesEpesEnveloped(cert, Constants.ublpolicy);
		} else {
			throw new EFacturesException("Signature Format " + format + " not implemented yet.");
		}			
	}
}
