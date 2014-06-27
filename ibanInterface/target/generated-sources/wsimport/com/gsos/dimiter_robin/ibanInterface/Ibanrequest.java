
package com.gsos.dimiter_robin.ibanInterface;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ibanrequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ibanrequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bankcode" type="{http://gsos.com/dimiter_robin/ibanrequest}bankcode"/>
 *         &lt;element name="rekeningnummer" type="{http://gsos.com/dimiter_robin/ibanrequest}rekeningnummer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ibanrequest", propOrder = {
    "bankcode",
    "rekeningnummer"
})
public class Ibanrequest {

    @XmlElement(required = true)
    protected Bankcode bankcode;
    @XmlElement(required = true)
    protected BigInteger rekeningnummer;

    /**
     * Gets the value of the bankcode property.
     * 
     * @return
     *     possible object is
     *     {@link Bankcode }
     *     
     */
    public Bankcode getBankcode() {
        return bankcode;
    }

    /**
     * Sets the value of the bankcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bankcode }
     *     
     */
    public void setBankcode(Bankcode value) {
        this.bankcode = value;
    }

    /**
     * Gets the value of the rekeningnummer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRekeningnummer() {
        return rekeningnummer;
    }

    /**
     * Sets the value of the rekeningnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRekeningnummer(BigInteger value) {
        this.rekeningnummer = value;
    }

}
