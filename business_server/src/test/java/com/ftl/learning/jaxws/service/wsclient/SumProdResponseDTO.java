
package com.ftl.learning.jaxws.service.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sumProdResponseDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sumProdResponseDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="prod" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="sum" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sumProdResponseDTO", propOrder = {
    "prod",
    "sum"
})
public class SumProdResponseDTO {

    protected double prod;
    protected double sum;

    /**
     * Gets the value of the prod property.
     * 
     */
    public double getProd() {
        return prod;
    }

    /**
     * Sets the value of the prod property.
     * 
     */
    public void setProd(double value) {
        this.prod = value;
    }

    /**
     * Gets the value of the sum property.
     * 
     */
    public double getSum() {
        return sum;
    }

    /**
     * Sets the value of the sum property.
     * 
     */
    public void setSum(double value) {
        this.sum = value;
    }

}
