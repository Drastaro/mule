
package com.mule.generated.pojo;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Address {

    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("postcode")
    @Expose
    private String postcode;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("telephone")
    @Expose
    private String telephone;
    @SerializedName("country_id")
    @Expose
    private String countryId;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("address_type")
    @Expose
    private String addressType;
    @SerializedName("prefix")
    @Expose
    private String prefix;
    @SerializedName("middlename")
    @Expose
    private String middlename;
    @SerializedName("suffix")
    @Expose
    private String suffix;
    @SerializedName("company")
    @Expose
    private String company;

    /**
     * 
     * @return
     *     The region
     */
    public String getRegion() {
        return region;
    }

    /**
     * 
     * @param region
     *     The region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    public Address withRegion(String region) {
        this.region = region;
        return this;
    }

    /**
     * 
     * @return
     *     The postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * 
     * @param postcode
     *     The postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Address withPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    /**
     * 
     * @return
     *     The lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * 
     * @param lastname
     *     The lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    /**
     * 
     * @return
     *     The street
     */
    public String getStreet() {
        return street;
    }

    /**
     * 
     * @param street
     *     The street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    public Address withStreet(String street) {
        this.street = street;
        return this;
    }

    /**
     * 
     * @return
     *     The city
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    public Address withCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public Address withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * 
     * @return
     *     The telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 
     * @param telephone
     *     The telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Address withTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    /**
     * 
     * @return
     *     The countryId
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * 
     * @param countryId
     *     The country_id
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Address withCountryId(String countryId) {
        this.countryId = countryId;
        return this;
    }

    /**
     * 
     * @return
     *     The firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * 
     * @param firstname
     *     The firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Address withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    /**
     * 
     * @return
     *     The addressType
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * 
     * @param addressType
     *     The address_type
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public Address withAddressType(String addressType) {
        this.addressType = addressType;
        return this;
    }

    /**
     * 
     * @return
     *     The prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * 
     * @param prefix
     *     The prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Address withPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    /**
     * 
     * @return
     *     The middlename
     */
    public String getMiddlename() {
        return middlename;
    }

    /**
     * 
     * @param middlename
     *     The middlename
     */
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Address withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    /**
     * 
     * @return
     *     The suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * 
     * @param suffix
     *     The suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Address withSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    /**
     * 
     * @return
     *     The company
     */
    public String getCompany() {
        return company;
    }

    /**
     * 
     * @param company
     *     The company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    public Address withCompany(String company) {
        this.company = company;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
