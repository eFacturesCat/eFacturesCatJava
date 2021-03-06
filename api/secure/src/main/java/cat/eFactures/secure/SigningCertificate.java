package cat.eFactures.secure;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import es.mityc.javasign.pkstore.CertStoreException;
import es.mityc.javasign.pkstore.IPKStoreManager;
import es.mityc.javasign.pkstore.keystore.KSStore;

/**
 * Class to acces Signing Certificates (with private key)
 * 
 * @author @santicasas
 *
 */
public class SigningCertificate {
	private IPKStoreManager storeManager = null;
	private List<X509Certificate> certs = null;
	private X509Certificate certificate = null;
	private PrivateKey privateKey = null;
	private Provider provider = null;
	
	/**
	 * Certificate getter
	 * @return The Certificate
	 */
	public X509Certificate getCertificate() {
		return certificate;
	}

	/**
	 * PrivateKey getter
	 * @return the PrivateKey
	 */
	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	/**
	 * Crypto Provider getter
	 * @return The Crypto Provider
	 */
	public Provider getProvider() {
		return provider;
	}

	/**
	 * Import data from PKCS#12 file
	 * 
	 * @param fileName PCKS12 file name
	 * @param password to access file
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 * @throws CertStoreException
	 */
	public void importPKCS12(String fileName, String password) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, CertStoreException {
		KeyStore ks = KeyStore.getInstance("PKCS12");
		FileInputStream fis = new FileInputStream(fileName);
		ks.load(fis,password.toCharArray());
		storeManager = new KSStore(ks, new PassStoreKS(password));
		certs = storeManager.getSignCertificates();
		if ((certs == null) || (certs.size() == 0)) throw new CertStoreException("No signing certificate");
		certificate = certs.get(0);
		privateKey = storeManager.getPrivateKey(certificate);
		provider = storeManager.getProvider(certificate);
	}

}
