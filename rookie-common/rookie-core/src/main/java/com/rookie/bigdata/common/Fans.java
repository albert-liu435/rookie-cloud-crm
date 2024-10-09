package com.rookie.bigdata.common;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Class Fans
 * @Description
 * @Author rookie
 * @Date 2024/10/8 16:57
 * @Version 1.0
 */
public class Fans implements Serializable {

    private long id;

    private long userId;

    private String ouid;

    private String omid;

    private String nickName;

    private String phone;

    private String mixPhone;

    private String openId;

    private String unionId;

    //粉丝类型，枚举值,1:阿里粉丝
    private String type;


    //创建时间
    private LocalDateTime createTime;

    //更新时间
    private LocalDateTime updateTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMemberId() {
        return userId;
    }

    public void setMemberId(long memberId) {
        this.userId = memberId;
    }

    public String getOuid() {
        return ouid;
    }

    public void setOuid(String ouid) {
        this.ouid = ouid;
    }

    public String getOmid() {
        return omid;
    }

    public void setOmid(String omid) {
        this.omid = omid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMixPhone() {
        return mixPhone;
    }

    public void setMixPhone(String mixPhone) {
        this.mixPhone = mixPhone;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
