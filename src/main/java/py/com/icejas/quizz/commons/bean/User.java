package py.com.icejas.quizz.commons.bean;

import java.sql.Timestamp;

public class User {
    private Integer id;
    private String name;
    private String fullName;
    private String password;
    private Timestamp createAt;
    private Timestamp lastAccess;
    private String status;
    private Integer totalScored;
    private Integer roleId;
    private Integer churchId;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Timestamp lastAccess) {
        this.lastAccess = lastAccess;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getChurchId() {
        return churchId;
    }

    public void setChurchId(Integer churchId) {
        this.churchId = churchId;
    }

    public Integer getTotalScored() {
        return totalScored;
    }

    public void setTotalScored(Integer totalScored) {
        this.totalScored = totalScored;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", createAt=" + createAt +
                ", lastAccess=" + lastAccess +
                ", status='" + status + '\'' +
                ", totalScored=" + totalScored +
                ", roleId=" + roleId +
                ", churchId=" + churchId +
                '}';
    }
}
