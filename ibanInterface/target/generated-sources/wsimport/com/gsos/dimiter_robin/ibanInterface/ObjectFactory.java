
package com.gsos.dimiter_robin.ibanInterface;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gsos.dimiter_robin.ibanInterface package. 
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

    private final static QName _Ibanrequest_QNAME = new QName("http://gsos.com/dimiter_robin/ibanrequest", "ibanrequest");
    private final static QName _Ibanresponse_QNAME = new QName("http://gsos.com/dimiter_robin/ibanresponse", "ibanresponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gsos.dimiter_robin.ibanInterface
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Ibanrequest }
     * 
     */
    public Ibanrequest createIbanrequest() {
        return new Ibanrequest();
    }

    /**
     * Create an instance of {@link IbanResponse }
     * 
     */
    public IbanResponse createIbanResponse() {
        return new IbanResponse();
    }

    /**
     * Create an instance of {@link Fault }
     * 
     */
    public Fault createFault() {
        return new Fault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ibanrequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gsos.com/dimiter_robin/ibanrequest", name = "ibanrequest")
    public JAXBElement<Ibanrequest> createIbanrequest(Ibanrequest value) {
        return new JAXBElement<Ibanrequest>(_Ibanrequest_QNAME, Ibanrequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IbanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gsos.com/dimiter_robin/ibanresponse", name = "ibanresponse")
    public JAXBElement<IbanResponse> createIbanresponse(IbanResponse value) {
        return new JAXBElement<IbanResponse>(_Ibanresponse_QNAME, IbanResponse.class, null, value);
    }

}
