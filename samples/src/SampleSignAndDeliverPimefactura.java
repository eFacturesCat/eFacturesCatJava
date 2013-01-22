import cat.eFactures.common.Constants;
import cat.eFactures.common.TestConstants;
import cat.eFactures.deliver.DeliverInvoice;
import cat.eFactures.deliver.pimefactura.EndPointPimefactura;
import cat.eFactures.secure.SecuredFacturae_3_2;
import cat.eFactures.secure.SigningCertificate;
import cat.eFactures.transform.Facturae_3_2;
import cat.eFactures.transform.XMLInvoice;


public class SampleSignAndDeliverPimefactura {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	try {
    		
    		SecuredFacturae_3_2 sFe32 = null;
    		SigningCertificate cert = new SigningCertificate();
    		String fileName = TestConstants.fileName.substring(3);
    		String fileNameSigned = TestConstants.fileNameSigned.substring(3);
    		String pkcs12_fileName = TestConstants.pkcs12_fileName.substring(3);
    		
  			// Create Secured Facturae 3.2 structure
   			sFe32 = new SecuredFacturae_3_2(new Facturae_3_2(fileName));

   			if (sFe32!=null) {
				// Open PKCS12 key and certificate
				cert.importPKCS12(pkcs12_fileName, TestConstants.pkcs12_password);
				if (cert.getProvider()!=null) {
					// Sign Invoice with XAdES_EPES
					sFe32.signInvoice(cert, Constants.XAdES_EPES_Enveloped);
					// Save Signed Invoice File
					sFe32.saveInvoiceSigned(fileNameSigned);
					
		    		EndPointPimefactura epp = new EndPointPimefactura(TestConstants.AK_test, TestConstants.environment);
		            //EndPointEmail epp = new EndPointEmail("smtp.gmail.com", 465, "efacturescat@santicasas.net","pimefactura");
		            //epp.createMessage("efacturescat@santicasas.net", "me@sntc.eu", "Enviament de factura", "Trobarà adjunta la factura enviada");    		
					XMLInvoice invoice = new XMLInvoice(fileNameSigned);
					DeliverInvoice deliver = new DeliverInvoice(invoice, epp);
					String result = deliver.deliverInvoice();
					System.out.println("Result = " + result);					
				}
    		}
    		
    		
    		
    		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
