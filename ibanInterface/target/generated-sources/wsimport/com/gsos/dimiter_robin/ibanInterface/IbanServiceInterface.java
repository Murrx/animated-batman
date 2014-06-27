
package com.gsos.dimiter_robin.ibanInterface;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ibanServiceInterface", targetNamespace = "http://gsos.com/dimiter_robin")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IbanServiceInterface {


    /**
     * 
     * @param ibanrequest
     * @return
     *     returns java.lang.String
     * @throws Fault_Exception
     */
    @WebMethod
    @WebResult(name = "ibanresponse", targetNamespace = "http://gsos.com/dimiter_robin/ibanresponse", partName = "ibanresponse")
    public String toIban(
        @WebParam(name = "ibanrequest", targetNamespace = "http://gsos.com/dimiter_robin/ibanrequest", partName = "ibanrequest")
        Ibanrequest ibanrequest)
        throws Fault_Exception
    ;

}
