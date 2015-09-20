import cat.eFactures.common.Constants;
import cat.eFactures.common.TestConstants;
import cat.eFactures.secure.SecuredFacturae_3_2;
import cat.eFactures.secure.SigningCertificate;
import cat.eFactures.transform.Facturae_3_2;


public class SampleSign {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
    		
    		SecuredFacturae_3_2 sFe32 = null;
    		SigningCertificate cert = new SigningCertificate();
    		//String fileName = TestConstants.fileName.substring(3);
    		//String fileName = "/home/validatedid/eFactura_utf8.xml";
    		//String fileNameSigned = TestConstants.fileNameSigned.substring(3);
    		//String fileNameSigned = "/home/validatedid/eFactura_utf8_signed.xml";
    		//String pkcs12_fileName = TestConstants.pkcs12_fileName.substring(3);
    		//String pkcs12_password = TestConstants.pkcs12_password
    		
    		String base_dir = "/home/validatedid/git/eFacturesCatJava/resources/";
    		String fileName = base_dir + "SampleFacturae_3_2.xml";
    		String fileNameSigned = base_dir + "SampleFacturae_3_2_Signed.xml";
    		String pkcs12_fileName = base_dir + "factura-sw.p12";
    		String pkcs12_password = "189CBA9";
    		
  			// Create Secured Facturae 3.2 structure
   			sFe32 = new SecuredFacturae_3_2(new Facturae_3_2(fileName));

   			if (sFe32!=null) {
				// Open PKCS12 key and certificate
				cert.importPKCS12(pkcs12_fileName, pkcs12_password);
				if (cert.getProvider()!=null) {
					// Sign Invoice with XAdES_EPES
					sFe32.signInvoice(cert, Constants.XAdES_EPES_Enveloped);
					// Save Signed Invoice File
					sFe32.saveInvoiceSigned(fileNameSigned);
					
					System.out.println("Result file= " + fileNameSigned);					
				}
    		}
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
