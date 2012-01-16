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

public class SigningCertificate {
	private IPKStoreManager storeManager = null;
	private List<X509Certificate> certs = null;
	private X509Certificate certificate = null;
	private PrivateKey privateKey = null;
	private Provider provider = null;
	
	public X509Certificate getCertificate() {
		return certificate;
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public Provider getProvider() {
		return provider;
	}

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
