
package com.hp.bsc.testing.jmssender.auth;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for verifyCredential complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="verifyCredential">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="securityObject" type="{http://ch/hpbsc/zss/dto/v3/}securityObject"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifyCredential", propOrder = {
    "securityObject"
})
public class VerifyCredential {

    @XmlElement(required = true)
    protected SecurityObject securityObject;

    /**
     * Gets the value of the securityObject property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityObject }
     *     
     */
    public SecurityObject getSecurityObject() {
        return securityObject;
    }

    /**
     * Sets the value of the securityObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityObject }
     *     
     */
    public void setSecurityObject(SecurityObject value) {
        this.securityObject = value;
    }

}
