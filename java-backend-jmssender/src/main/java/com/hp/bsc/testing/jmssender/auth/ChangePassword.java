
package com.hp.bsc.testing.jmssender.auth;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for changePassword complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="changePassword">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="securityObject" type="{http://ch/hpbsc/zss/dto/v3/}securityObject"/>
 *         &lt;element name="oldPassword" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="newPassword" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "changePassword", propOrder = {
    "securityObject",
    "oldPassword",
    "newPassword"
})
public class ChangePassword {

    @XmlElement(required = true)
    protected SecurityObject securityObject;
    @XmlElement(required = true)
    protected byte[] oldPassword;
    @XmlElement(required = true)
    protected byte[] newPassword;

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

    /**
     * Gets the value of the oldPassword property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getOldPassword() {
        return oldPassword;
    }

    /**
     * Sets the value of the oldPassword property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setOldPassword(byte[] value) {
        this.oldPassword = value;
    }

    /**
     * Gets the value of the newPassword property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getNewPassword() {
        return newPassword;
    }

    /**
     * Sets the value of the newPassword property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setNewPassword(byte[] value) {
        this.newPassword = value;
    }

}
