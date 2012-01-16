package cat.eFactures.secure;
import java.io.FileNotFoundException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import cat.eFactures.common.Constants;
import cat.eFactures.common.TestConstants;
import cat.eFactures.transform.Facturae_3_2;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {    	

    	
		SecuredFacturae_3_2 sFe32 = null;
		SigningCertificate cert = new SigningCertificate();
		
		try {			
			// Create Secured Facturae 3.2 structure
			sFe32 = new SecuredFacturae_3_2(new Facturae_3_2(TestConstants.fileName));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			assertTrue( false );
		}
		if (sFe32!=null) {
			try {
				// Open PKCS12 key and certificate
				cert.importPKCS12(TestConstants.pkcs12_fileName, TestConstants.pkcs12_password);
			} catch (Exception e) {
				e.printStackTrace();
				assertTrue( false );
			}
			if (cert.getProvider()!=null) {
				try {
					// Sign Invoice with XAdES_EPES
					sFe32.signInvoice(cert, Constants.XAdES_EPES_Enveloped);
					// Save Signed Invoice File
					sFe32.saveInvoiceSigned(TestConstants.fileNameSigned);
					assertTrue( true );
				} catch (Exception e) {
					e.printStackTrace();
					assertTrue( false );
				}
			}
		}
    }
}
