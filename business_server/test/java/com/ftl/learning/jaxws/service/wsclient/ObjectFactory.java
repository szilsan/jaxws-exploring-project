
package com.ftl.learning.jaxws.service.wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ftl.learning.jaxws.service.wsclient package. 
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

    private final static QName _SumProd_QNAME = new QName("http://service.jaxws.learning.ftl.com/", "sumProd");
    private final static QName _Invert_QNAME = new QName("http://service.jaxws.learning.ftl.com/", "invert");
    private final static QName _SumProdResponse_QNAME = new QName("http://service.jaxws.learning.ftl.com/", "sumProdResponse");
    private final static QName _InvertResponse_QNAME = new QName("http://service.jaxws.learning.ftl.com/", "invertResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ftl.learning.jaxws.service.wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Invert }
     * 
     */
    public Invert createInvert() {
        return new Invert();
    }

    /**
     * Create an instance of {@link SumProd }
     * 
     */
    public SumProd createSumProd() {
        return new SumProd();
    }

    /**
     * Create an instance of {@link InvertResponse }
     * 
     */
    public InvertResponse createInvertResponse() {
        return new InvertResponse();
    }

    /**
     * Create an instance of {@link SumProdResponse }
     * 
     */
    public SumProdResponse createSumProdResponse() {
        return new SumProdResponse();
    }

    /**
     * Create an instance of {@link InvertDTO }
     * 
     */
    public InvertDTO createInvertDTO() {
        return new InvertDTO();
    }

    /**
     * Create an instance of {@link SumProdResponseDTO }
     * 
     */
    public SumProdResponseDTO createSumProdResponseDTO() {
        return new SumProdResponseDTO();
    }

    /**
     * Create an instance of {@link SumProdDTO }
     * 
     */
    public SumProdDTO createSumProdDTO() {
        return new SumProdDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SumProd }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.learning.ftl.com/", name = "sumProd")
    public JAXBElement<SumProd> createSumProd(SumProd value) {
        return new JAXBElement<SumProd>(_SumProd_QNAME, SumProd.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Invert }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.learning.ftl.com/", name = "invert")
    public JAXBElement<Invert> createInvert(Invert value) {
        return new JAXBElement<Invert>(_Invert_QNAME, Invert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SumProdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.learning.ftl.com/", name = "sumProdResponse")
    public JAXBElement<SumProdResponse> createSumProdResponse(SumProdResponse value) {
        return new JAXBElement<SumProdResponse>(_SumProdResponse_QNAME, SumProdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.learning.ftl.com/", name = "invertResponse")
    public JAXBElement<InvertResponse> createInvertResponse(InvertResponse value) {
        return new JAXBElement<InvertResponse>(_InvertResponse_QNAME, InvertResponse.class, null, value);
    }

}
