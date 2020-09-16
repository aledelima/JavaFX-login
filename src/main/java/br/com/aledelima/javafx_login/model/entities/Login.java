package br.com.aledelima.javafx_login.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Login implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private User user;
    private LocalDateTime login;
    private LocalDateTime logout;

    public Login() {
    }

    public Login(Long id, User user, LocalDateTime login, LocalDateTime logout) {
        this.id = id;
        this.user = user;
        this.login = login;
        this.logout = logout;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLogin() {
        return login;
    }

    public void setLogin(LocalDateTime login) {
        this.login = login;
    }

    public LocalDateTime getLogout() {
        return logout;
    }

    public void setLogout(LocalDateTime logout) {
        this.logout = logout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login)) return false;
        Login login = (Login) o;
        return Objects.equals(id, login.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", user=" + user +
                ", login=" + login +
                ", logout=" + logout +
                '}';
    }
}
