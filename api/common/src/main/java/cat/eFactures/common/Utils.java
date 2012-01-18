package cat.eFactures.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Utils Class 
 * @author @santicasas
 *
 */
public class Utils {
	/**
	 * Read XML as DOM
	 * @param is The input stream to read
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	  public static Document readXml(InputStream is) throws SAXException, IOException,
	      ParserConfigurationException {
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

	      dbf.setValidating(false);
	      dbf.setIgnoringComments(false);
	      dbf.setIgnoringElementContentWhitespace(true);
	      dbf.setNamespaceAware(true);

	      DocumentBuilder db = null;
	      db = dbf.newDocumentBuilder();
	      db.setEntityResolver(new NullResolver());
	      return db.parse(is);
	  }
	}


/**
 * NullResolver Class	
 * @author @santicasas
 */
class NullResolver implements EntityResolver {
	  public InputSource resolveEntity(String publicId, String systemId) throws SAXException,
	      IOException {
	    return new InputSource(new StringReader(""));
	  }
	}
