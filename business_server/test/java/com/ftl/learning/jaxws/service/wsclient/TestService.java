
package com.ftl.learning.jaxws.service.wsclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "testService", targetNamespace = "http://service.jaxws.learning.ftl.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TestService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "invert", targetNamespace = "http://service.jaxws.learning.ftl.com/", className = "com.ftl.learning.jaxws.service.wsclient.Invert")
    @ResponseWrapper(localName = "invertResponse", targetNamespace = "http://service.jaxws.learning.ftl.com/", className = "com.ftl.learning.jaxws.service.wsclient.InvertResponse")
    @Action(input = "http://service.jaxws.learning.ftl.com/testService/invertRequest", output = "http://service.jaxws.learning.ftl.com/testService/invertResponse")
    public String invert(
        @WebParam(name = "arg0", targetNamespace = "")
        InvertDTO arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.ftl.learning.jaxws.service.wsclient.SumProdResponseDTO
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sumProd", targetNamespace = "http://service.jaxws.learning.ftl.com/", className = "com.ftl.learning.jaxws.service.wsclient.SumProd")
    @ResponseWrapper(localName = "sumProdResponse", targetNamespace = "http://service.jaxws.learning.ftl.com/", className = "com.ftl.learning.jaxws.service.wsclient.SumProdResponse")
    @Action(input = "http://service.jaxws.learning.ftl.com/testService/sumProdRequest", output = "http://service.jaxws.learning.ftl.com/testService/sumProdResponse")
    public SumProdResponseDTO sumProd(
        @WebParam(name = "arg0", targetNamespace = "")
        SumProdDTO arg0);

}
