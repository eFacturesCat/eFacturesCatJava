package cat.eFactures.transform;

import java.io.FileNotFoundException;

import cat.eFactures.transform.XMLInvoice;

/**
 * Class for spanish facturae 3.2 invoice (not secured - previus to sign)
 * 
 * @author Santi
 *
 */
public final class Facturae_3_2 extends XMLInvoice {

	/**
	 * Constructor
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public Facturae_3_2(String fileName) throws FileNotFoundException {
		super(fileName);
	}

}
