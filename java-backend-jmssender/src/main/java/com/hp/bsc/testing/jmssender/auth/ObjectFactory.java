
package com.hp.bsc.testing.jmssender.auth;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hp.bsc.testing.jmssender.auth package. 
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

    private final static QName _UserNotAuthenticated_QNAME = new QName("http://ch/hpbsc/zss/exc/v3", "UserNotAuthenticated");
    private final static QName _VerifyCredentialResponse_QNAME = new QName("http://ch/hpbsc/zss/authentication/v3/", "verifyCredentialResponse");
    private final static QName _ChangePassword_QNAME = new QName("http://ch/hpbsc/zss/authentication/v3/", "changePassword");
    private final static QName _InvalidPassword_QNAME = new QName("http://ch/hpbsc/zss/authentication/exc/v3/", "InvalidPassword");
    private final static QName _Login_QNAME = new QName("http://ch/hpbsc/zss/authentication/v3/", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://ch/hpbsc/zss/authentication/v3/", "loginResponse");
    private final static QName _ChangePasswordResponse_QNAME = new QName("http://ch/hpbsc/zss/authentication/v3/", "changePasswordResponse");
    private final static QName _SecurityObject_QNAME = new QName("http://ch/hpbsc/zss/dto/v3/", "securityObject");
    private final static QName _VerifyCredential_QNAME = new QName("http://ch/hpbsc/zss/authentication/v3/", "verifyCredential");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hp.bsc.testing.jmssender.auth
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SecurityObject }
     * 
     */
    public SecurityObject createSecurityObject() {
        return new SecurityObject();
    }

    /**
     * Create an instance of {@link UserNotAuthenticated }
     * 
     */
    public UserNotAuthenticated createUserNotAuthenticated() {
        return new UserNotAuthenticated();
    }

    /**
     * Create an instance of {@link ChangePasswordResponse }
     * 
     */
    public ChangePasswordResponse createChangePasswordResponse() {
        return new ChangePasswordResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link VerifyCredential }
     * 
     */
    public VerifyCredential createVerifyCredential() {
        return new VerifyCredential();
    }

    /**
     * Create an instance of {@link VerifyCredentialResponse }
     * 
     */
    public VerifyCredentialResponse createVerifyCredentialResponse() {
        return new VerifyCredentialResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link ChangePassword }
     * 
     */
    public ChangePassword createChangePassword() {
        return new ChangePassword();
    }

    /**
     * Create an instance of {@link InvalidPassword }
     * 
     */
    public InvalidPassword createInvalidPassword() {
        return new InvalidPassword();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserNotAuthenticated }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch/hpbsc/zss/exc/v3", name = "UserNotAuthenticated")
    public JAXBElement<UserNotAuthenticated> createUserNotAuthenticated(UserNotAuthenticated value) {
        return new JAXBElement<UserNotAuthenticated>(_UserNotAuthenticated_QNAME, UserNotAuthenticated.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyCredentialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch/hpbsc/zss/authentication/v3/", name = "verifyCredentialResponse")
    public JAXBElement<VerifyCredentialResponse> createVerifyCredentialResponse(VerifyCredentialResponse value) {
        return new JAXBElement<VerifyCredentialResponse>(_VerifyCredentialResponse_QNAME, VerifyCredentialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangePassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch/hpbsc/zss/authentication/v3/", name = "changePassword")
    public JAXBElement<ChangePassword> createChangePassword(ChangePassword value) {
        return new JAXBElement<ChangePassword>(_ChangePassword_QNAME, ChangePassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidPassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch/hpbsc/zss/authentication/exc/v3/", name = "InvalidPassword")
    public JAXBElement<InvalidPassword> createInvalidPassword(InvalidPassword value) {
        return new JAXBElement<InvalidPassword>(_InvalidPassword_QNAME, InvalidPassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch/hpbsc/zss/authentication/v3/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch/hpbsc/zss/authentication/v3/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangePasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch/hpbsc/zss/authentication/v3/", name = "changePasswordResponse")
    public JAXBElement<ChangePasswordResponse> createChangePasswordResponse(ChangePasswordResponse value) {
        return new JAXBElement<ChangePasswordResponse>(_ChangePasswordResponse_QNAME, ChangePasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch/hpbsc/zss/dto/v3/", name = "securityObject")
    public JAXBElement<SecurityObject> createSecurityObject(SecurityObject value) {
        return new JAXBElement<SecurityObject>(_SecurityObject_QNAME, SecurityObject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyCredential }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ch/hpbsc/zss/authentication/v3/", name = "verifyCredential")
    public JAXBElement<VerifyCredential> createVerifyCredential(VerifyCredential value) {
        return new JAXBElement<VerifyCredential>(_VerifyCredential_QNAME, VerifyCredential.class, null, value);
    }

}
