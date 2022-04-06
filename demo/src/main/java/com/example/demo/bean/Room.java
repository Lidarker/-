package com.example.demo.bean;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table room
 */
public class Room {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.rid
     *
     * @mbg.generated
     */
    private Integer rid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.rtype
     *
     * @mbg.generated
     */
    private String rtype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.raddress
     *
     * @mbg.generated
     */
    private String raddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.rprice
     *
     * @mbg.generated
     */
    private Integer rprice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.rimage
     *
     * @mbg.generated
     */
    private String rimage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room.certificateid
     *
     * @mbg.generated
     */
    private String certificateid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.rid
     *
     * @return the value of room.rid
     *
     * @mbg.generated
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.rid
     *
     * @param rid the value for room.rid
     *
     * @mbg.generated
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.rtype
     *
     * @return the value of room.rtype
     *
     * @mbg.generated
     */
    public String getRtype() {
        return rtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.rtype
     *
     * @param rtype the value for room.rtype
     *
     * @mbg.generated
     */
    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.raddress
     *
     * @return the value of room.raddress
     *
     * @mbg.generated
     */
    public String getRaddress() {
        return raddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.raddress
     *
     * @param raddress the value for room.raddress
     *
     * @mbg.generated
     */
    public void setRaddress(String raddress) {
        this.raddress = raddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.rprice
     *
     * @return the value of room.rprice
     *
     * @mbg.generated
     */
    public Integer getRprice() {
        return rprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.rprice
     *
     * @param rprice the value for room.rprice
     *
     * @mbg.generated
     */
    public void setRprice(Integer rprice) {
        this.rprice = rprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.description
     *
     * @return the value of room.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.description
     *
     * @param description the value for room.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.rimage
     *
     * @return the value of room.rimage
     *
     * @mbg.generated
     */
    public String getRimage() {
        return rimage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.rimage
     *
     * @param rimage the value for room.rimage
     *
     * @mbg.generated
     */
    public void setRimage(String rimage) {
        this.rimage = rimage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room.certificateid
     *
     * @return the value of room.certificateid
     *
     * @mbg.generated
     */
    public String getCertificateid() {
        return certificateid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room.certificateid
     *
     * @param certificateid the value for room.certificateid
     *
     * @mbg.generated
     */
    public void setCertificateid(String certificateid) {
        this.certificateid = certificateid;
    }

    @Override
    public String toString() {
        return "com.example.demo.bean.Room{" +
                "rid=" + rid +
                ", rtype='" + rtype + '\'' +
                ", raddress='" + raddress + '\'' +
                ", rprice=" + rprice +
                ", description='" + description + '\'' +
                ", rimage='" + rimage + '\'' +
                ", certificateid='" + certificateid + '\'' +
                '}';
    }
}