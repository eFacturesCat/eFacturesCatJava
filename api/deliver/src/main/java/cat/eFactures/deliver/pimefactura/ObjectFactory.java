//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.16 at 09:04:47 AM CET 
//


package cat.eFactures.deliver.pimefactura;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cat.eFactures.deliver.pimefactura package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Ak_QNAME = new QName("", "ak");
    private final static QName _Param1_QNAME = new QName("", "param1");
    private final static QName _Param2_QNAME = new QName("", "param2");
    private final static QName _Param3_QNAME = new QName("", "param3");
    private final static QName _Base64Document_QNAME = new QName("", "base64Document");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cat.eFactures.deliver.pimefactura
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Facturas }
     * 
     */
    public Facturas createFacturas() {
        return new Facturas();
    }

    /**
     * Create an instance of {@link Factura }
     * 
     */
    public Factura createFactura() {
        return new Factura();
    }

    /**
     * Create an instance of {@link Root }
     * 
     */
    public Root createRoot() {
        return new Root();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ak")
    public JAXBElement<String> createAk(String value) {
        return new JAXBElement<String>(_Ak_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "param1")
    public JAXBElement<String> createParam1(String value) {
        return new JAXBElement<String>(_Param1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "param2")
    public JAXBElement<String> createParam2(String value) {
        return new JAXBElement<String>(_Param2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "param3")
    public JAXBElement<String> createParam3(String value) {
        return new JAXBElement<String>(_Param3_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "base64Document")
    public JAXBElement<byte[]> createBase64Document(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Document_QNAME, byte[].class, null, ((byte[]) value));
    }

}