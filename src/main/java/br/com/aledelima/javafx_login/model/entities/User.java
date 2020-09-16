package br.com.aledelima.javafx_login.model.entities;

import br.com.aledelima.javafx_login.model.enums.UserLevel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private String name;
    private String password;
    private UserLevel level;
    private Boolean active;
    private List<Login> logins = new ArrayList<>();

    public User() {
    }

    public User (Integer id, String name, String password, UserLevel level, Boolean active) {
        this. id = id;
        this. name = name;
        this.password = password;
        this.level = level;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    public List<Login> getLogins() {
        return new ArrayList<Login>(this.logins);
    }
    
    public void addLogin(Login login) {
        this.logins.add(login);
    }
    
    public void removeLogin(Login login) {
        this.logins.remove(login);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
