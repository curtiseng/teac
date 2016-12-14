package teac.master.entity;

import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 基础注册用户实体
 * Created by yangzifeng on 2016/10/27.
 */
@Repository
public class UserInfo{
    private long userId;
    private Long teacId;
    private Long organId;
    private String nickname;
    private long groupId;
    private String avatar;
    private String surname;
    private char sex;
    private Date birthday;
    private String areaCode;
    private String address;
    private Timestamp lastLogin;
    private Timestamp createTime;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Long getTeacId() {
        return teacId;
    }

    public void setTeacId(Long teacId) {
        this.teacId = teacId;
    }

    public Long getOrganId() {
        return organId;
    }

    public void setOrganId(Long organId) {
        this.organId = organId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", teacId=" + teacId +
                ", organId=" + organId +
                ", nickname='" + nickname + '\'' +
                ", groupId=" + groupId +
                ", avatar='" + avatar + '\'' +
                ", surname='" + surname + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", areaCode='" + areaCode + '\'' +
                ", address='" + address + '\'' +
                ", lastLogin=" + lastLogin +
                ", createTime=" + createTime +
                '}';
    }
}
