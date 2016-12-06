package com.example.liudan.customproject.bean;

import java.io.Serializable;

/**
 * Created by liudan on 2016/11/23.
 * 用户登录储存的信息
 */

public class User implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // 1：登录成功
    // 2:待审核
    // 3：审核驳回
    // 4,5：新用户
    // 6：登录失败
    // 7：帐户名或密码错误，请重新输入
    // 8：用户名不存在
    /**
     * 1:登录成功
     */
    public static final int STATUS_1 = 1;
    /**
     * 2:待审核；
     */
    public static final int STATUS_2 = 2;
    /**
     * 3:审核未通过
     */
    public static final int STATUS_3 = 3;
    /**
     * 4:未激活
     */
    public static final int STATUS_4 = 4;
    /**
     * 5:未激活
     */
    public static final int STATUS_5 = 5;
    /**
     * 6：登录失败
     */
    public static final int STATUS_6 = 6;
    /**
     * 7：帐户名或密码错误，请重新输入
     */
    public static final int STATUS_7 = 7;
    /**
     * 8：用户名不存在
     */
    public static final int STATUS_8 = 8;
    /**
     * 9：未绑定区域
     */
    public static final int STATUS_9 = 9;
    /**
     * 10：请联系客服绑定代理区域
     */
    public static final int STATUS_10 = 10;
    /**
     * 11：请联系加盟商绑定代理区域
     */
    public static final int STATUS_11 = 11;
    /**
     * 签名错误
     */
    public static final int STATUS_88 = 88;

    /**
     * 用户的id
     */
    private String ID;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户的用户手机号
     */
    private String Mobile;
    /**
     * 用户邮箱
     */
    private String Email;
    /**
     * 所在地区
     */
    private String rgn_RegionID;
    /**
     * 详细地址
     */
    private String AddressMore;
    /**
     * 登录成功后由服务器返回，本地做存储，再次请求服务器时传入该值
     */
    private String token;
    /**
     * 1：登录成功 2:待审核 3：审核驳回  4,5：新用户 6：登录失败 7：帐户名或密码错误，请重新输入 8：用户名不存在
     */
    private int status;
    /**
     * 用户头像的url
     */
    private String user_head;
    /**
     * 用户点击过
     */
    private boolean click;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRgn_RegionID() {
        return rgn_RegionID;
    }

    public void setRgn_RegionID(String rgn_RegionID) {
        this.rgn_RegionID = rgn_RegionID;
    }

    public String getAddressMore() {
        return AddressMore;
    }

    public void setAddressMore(String addressMore) {
        AddressMore = addressMore;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUser_head() {
        return user_head;
    }

    public void setUser_head(String user_head) {
        this.user_head = user_head;
    }

    public boolean isClick() {
        return click;
    }

    public void setClick(boolean click) {
        this.click = click;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Email='" + Email + '\'' +
                ", rgn_RegionID='" + rgn_RegionID + '\'' +
                ", AddressMore='" + AddressMore + '\'' +
                ", token='" + token + '\'' +
                ", status=" + status +
                ", user_head='" + user_head + '\'' +
                ", click=" + click +
                '}';
    }
}
