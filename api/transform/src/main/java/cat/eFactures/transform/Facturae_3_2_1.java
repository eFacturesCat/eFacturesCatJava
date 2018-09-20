package cat.eFactures.transform;

import java.io.FileNotFoundException;

/**
 * Class for spanish facturae 3.2.1 invoice (not secured - previus to sign)
 * 
 * @author AleixM
 *
 */
public final class Facturae_3_2_1 extends XMLInvoice {

	/**
	 * Constructor
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public Facturae_3_2_1(String fileName) throws FileNotFoundException {
		super(fileName);
	}

}
