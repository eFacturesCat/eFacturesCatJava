package cat.eFactures.secure;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import org.apache.commons.io.IOUtils;

import cat.eFactures.transform.Facturae_3_2;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import cat.eFactures.common.Utils;
import es.mityc.javasign.pkstore.CertStoreException;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	private static String fileName = "C:\\SantiDocs\\dev\\eFacturesCat\\eFacturesCatJava\\resources\\SampleFacturae_3_2.xml";
	private static String fileNameSigned = "C:\\SantiDocs\\dev\\eFacturesCat\\eFacturesCatJava\\resources\\SampleFacturae_3_2_Signed.xml";
	private static String pkcs12_fileName = "C:\\SantiDocs\\dev\\eFacturesCat\\eFacturesCatJava\\resources\\factura-sw.pfx";
	private static String pkcs12_password = "1111";
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
		try {
			Facturae_3_2 fe32 = new Facturae_3_2(fileName);
			sFe32 = new SecuredFacturae_3_2(fe32);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			assertTrue( false );
		}
		if (sFe32!=null) {
			SigningCertificate cert = new SigningCertificate();
			try {
				cert.importPKCS12(pkcs12_fileName, pkcs12_password);
			} catch (KeyStoreException | NoSuchAlgorithmException
					| CertificateException | CertStoreException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				assertTrue( false );
			}
			if (cert.getProvider()!=null) {
				sFe32.signInvoice(cert);
				try {
					sFe32.saveInvoiceSigned(fileNameSigned);
					assertTrue( true );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					assertTrue( false );
				}
			}
		}
    }
}
