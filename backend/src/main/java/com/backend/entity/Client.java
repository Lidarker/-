package com.backend.entity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table client
 *
 * @mbg.generated do_not_delete_during_merge Mon Jan 24 17:35:01 CST 2022
 */
public class Client {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client.id
     *
     * @mbg.generated Mon Jan 24 17:35:01 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client.name
     *
     * @mbg.generated Mon Jan 24 17:35:01 CST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client.password
     *
     * @mbg.generated Mon Jan 24 17:35:01 CST 2022
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client.id
     *
     * @return the value of client.id
     *
     * @mbg.generated Mon Jan 24 17:35:01 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client.id
     *
     * @param id the value for client.id
     *
     * @mbg.generated Mon Jan 24 17:35:01 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client.name
     *
     * @return the value of client.name
     *
     * @mbg.generated Mon Jan 24 17:35:01 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client.name
     *
     * @param name the value for client.name
     *
     * @mbg.generated Mon Jan 24 17:35:01 CST 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client.password
     *
     * @return the value of client.password
     *
     * @mbg.generated Mon Jan 24 17:35:01 CST 2022
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client.password
     *
     * @param password the value for client.password
     *
     * @mbg.generated Mon Jan 24 17:35:01 CST 2022
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}