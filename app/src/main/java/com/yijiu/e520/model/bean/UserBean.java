package com.yijiu.e520.model.bean;

import java.util.List;

/**
 * Created by Mr.yang on 2017/12/04
 *
 * @description
 * @Version
 */

public class UserBean {
    private String userName;
    private String password;
    private String token;
    private List<SupplierBean> list;
    private String contactsMobile;
    private String empEmail;
    private String empno;
    private String leader;
    private String loginName;
    private String loginPassword;
    private String name;
    private Integer servicerType;
    private Long sid;
    private String x;


    public List<SupplierBean> getList() {
        return list;
    }

    public void setList(List<SupplierBean> list) {
        this.list = list;
    }

    public String getToken() {
        return token;
    }

    public String getContactsMobile() {
        return contactsMobile;
    }

    public void setContactsMobile(String contactsMobile) {
        this.contactsMobile = contactsMobile;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getServicerType() {
        return servicerType;
    }

    public void setServicerType(Integer servicerType) {
        this.servicerType = servicerType;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
