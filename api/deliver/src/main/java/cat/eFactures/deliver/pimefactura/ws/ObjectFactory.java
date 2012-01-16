
package cat.eFactures.deliver.pimefactura.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cat.eFactures.deliver.pimefactura.ws package. 
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

    private final static QName _SummitInvoiceOmrequest_QNAME = new QName("http://Service.Reception.Invoice.Pimec", "omrequest");
    private final static QName _SummitInvoiceResponseReturn_QNAME = new QName("http://Service.Reception.Invoice.Pimec", "return");
    private final static QName _HelloName_QNAME = new QName("http://Service.Reception.Invoice.Pimec", "name");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cat.eFactures.deliver.pimefactura.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link SummitInvoice }
     * 
     */
    public SummitInvoice createSummitInvoice() {
        return new SummitInvoice();
    }

    /**
     * Create an instance of {@link SummitInvoiceResponse }
     * 
     */
    public SummitInvoiceResponse createSummitInvoiceResponse() {
        return new SummitInvoiceResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service.Reception.Invoice.Pimec", name = "omrequest", scope = SummitInvoice.class)
    public JAXBElement<Object> createSummitInvoiceOmrequest(Object value) {
        return new JAXBElement<Object>(_SummitInvoiceOmrequest_QNAME, Object.class, SummitInvoice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service.Reception.Invoice.Pimec", name = "return", scope = SummitInvoiceResponse.class)
    public JAXBElement<String> createSummitInvoiceResponseReturn(String value) {
        return new JAXBElement<String>(_SummitInvoiceResponseReturn_QNAME, String.class, SummitInvoiceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service.Reception.Invoice.Pimec", name = "return", scope = HelloResponse.class)
    public JAXBElement<String> createHelloResponseReturn(String value) {
        return new JAXBElement<String>(_SummitInvoiceResponseReturn_QNAME, String.class, HelloResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service.Reception.Invoice.Pimec", name = "name", scope = Hello.class)
    public JAXBElement<String> createHelloName(String value) {
        return new JAXBElement<String>(_HelloName_QNAME, String.class, Hello.class, value);
    }

}
