package entities;

import java.io.Serializable;

public class Admin implements Serializable{
    private int adminId;
    private String login;
    private String password;

    public Admin(){}

    public Admin(int adminIs, String login, String password) {
        this.adminId = adminIs;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}
