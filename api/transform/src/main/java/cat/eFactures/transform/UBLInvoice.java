package cat.eFactures.transform;

import java.io.FileNotFoundException;

/**
 * Class for UBL invoice (not secured - previus to sign)
 * 
 * @author Joaquín López
 *
 */
public final class UBLInvoice extends XMLInvoice {

	/**
	 * Constructor
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public UBLInvoice(String fileName) throws FileNotFoundException {
		super(fileName);
	}

}
