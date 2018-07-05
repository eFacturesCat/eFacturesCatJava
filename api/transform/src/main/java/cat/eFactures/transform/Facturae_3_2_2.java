package cat.eFactures.transform;

import java.io.FileNotFoundException;

/**
 * Class for spanish facturae 3.2.2 invoice (not secured - previus to sign)
 * 
 * @author Joaquín López
 *
 */
public final class Facturae_3_2_2 extends XMLInvoice {

	/**
	 * Constructor
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public Facturae_3_2_2(String fileName) throws FileNotFoundException {
		super(fileName);
	}

}
