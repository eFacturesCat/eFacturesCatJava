package cat.eFactures.secure;

import cat.eFactures.common.Constants;
import cat.eFactures.common.EFacturesException;
import cat.eFactures.transform.Facturae_3_2;

public class SecuredFacturae_3_2 extends SecuredInvoice {

	public SecuredFacturae_3_2(Facturae_3_2 xmlInvoice) {
		super(xmlInvoice);
	}
	
	public void signInvoice(SigningCertificate cert, String format) throws Exception {
		if (format.equals(Constants.XAdES_EPES_Enveloped))
		{
			this.signInvoiceXadesEpesEnveloped(cert, Constants.facturae31policy);
		} else {
			throw new EFacturesException("Signature Format " + format + " not implemented yet.");
		}			
	}
}
