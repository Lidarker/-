package com.example.demo.bean;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table browse
 */
public class Browse {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column browse.bid
     *
     * @mbg.generated
     */
    private Integer bid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column browse.uid
     *
     * @mbg.generated
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column browse.sid
     *
     * @mbg.generated
     */
    private Integer sid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column browse.time
     *
     * @mbg.generated
     */
    private Date time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column browse.bid
     *
     * @return the value of browse.bid
     *
     * @mbg.generated
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column browse.bid
     *
     * @param bid the value for browse.bid
     *
     * @mbg.generated
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column browse.uid
     *
     * @return the value of browse.uid
     *
     * @mbg.generated
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column browse.uid
     *
     * @param uid the value for browse.uid
     *
     * @mbg.generated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column browse.sid
     *
     * @return the value of browse.sid
     *
     * @mbg.generated
     */
    public Integer getSid() {
        return sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column browse.sid
     *
     * @param sid the value for browse.sid
     *
     * @mbg.generated
     */
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column browse.time
     *
     * @return the value of browse.time
     *
     * @mbg.generated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column browse.time
     *
     * @param time the value for browse.time
     *
     * @mbg.generated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    public Browse() {
    }

    public Browse(Integer uid, Integer sid) {
        this.uid = uid;
        this.sid = sid;
    }

    public Browse(Integer bid, Integer uid, Integer sid, Date time) {
        this.bid = bid;
        this.uid = uid;
        this.sid = sid;
        this.time = time;
    }

    @Override
    public String toString() {
        return "com.example.demo.bean.Browse{" +
                "bid=" + bid +
                ", uid=" + uid +
                ", sid=" + sid +
                ", time=" + time +
                '}';
    }
}