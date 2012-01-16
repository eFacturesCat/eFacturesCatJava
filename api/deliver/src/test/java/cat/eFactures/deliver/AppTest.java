package cat.eFactures.deliver;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import cat.eFactures.common.TestConstants;
import cat.eFactures.deliver.pimefactura.EndPointPimefactura;
import cat.eFactures.transform.XMLInvoice;

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
    	
    	try {
    		EndPointPimefactura epf = new EndPointPimefactura(TestConstants.AK_test, TestConstants.environment);
			XMLInvoice invoice = new XMLInvoice(TestConstants.fileNameSigned);
			DeliverInvoice deliver = new DeliverInvoice(invoice, epf);
			String result = deliver.deliverInvoice();
			System.out.println("Result = " + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue( false );
		} 
        assertTrue( true );
    }
}
