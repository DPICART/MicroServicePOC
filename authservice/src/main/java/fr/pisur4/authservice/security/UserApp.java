package fr.pisur4.authservice.security;

import lombok.Getter;
import lombok.Setter;

class UserApp {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String username, password;

    @Getter
    @Setter
    private String role;

    public UserApp(Integer id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

}
