package py.com.icejas.quizz.user;

import py.com.icejas.quizz.constants.Role;

import java.sql.Timestamp;


public class UserDTO {
    private final String name;
    private  final String fullName;
    private  final String status;
    private final Integer totalScored;
    private final Timestamp lastAccess;
    private final Role role;
    private final String churchName;

    public UserDTO(String name, String fullName, String status, Integer totalScored,Timestamp lastAccess, Role role, String churchName) {
        this.name = name;
        this.fullName = fullName;
        this.status = status;
        this.totalScored = totalScored;
        this.lastAccess = lastAccess;
        this.role = role;
        this.churchName = churchName;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStatus() {
        return status;
    }

    public Integer getTotalScored() {
        return totalScored;
    }

    public Timestamp getLastAccess() {
        return lastAccess;
    }

    public Role getRole() {
        return role;
    }

    public String getChurchName() {
        return churchName;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", status='" + status + '\'' +
                ", totalScored=" + totalScored +
                ", role=" + role +
                ", churchName='" + churchName + '\'' +
                '}';
    }
}
