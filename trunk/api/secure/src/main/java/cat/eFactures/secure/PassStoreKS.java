package cat.eFactures.secure;

import java.security.cert.X509Certificate;
import es.mityc.javasign.pkstore.IPassStoreKS;

/**
 * Manual PassStore for Mityc Libs
 * @author @santicasas
 *
 */
public class PassStoreKS implements IPassStoreKS {
	private transient String password;

	/**
	 * Constructor
	 * @param pass
	 */
 	public PassStoreKS(final String pass) {
  		this.password = new String(pass);
  	}
 	
 	/**
 	 * Password getter (in byte array)
 	 */
  	public char[] getPassword(final X509Certificate certificate, final String alias) {
	  		return password.toCharArray();
   	}

}
