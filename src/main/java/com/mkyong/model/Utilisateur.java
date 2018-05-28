package com.mkyong.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;
    private String lastname;

    private String login;

    private String password;

    @OneToMany(mappedBy = "utilisateur",fetch =FetchType.EAGER)
    private List<Module> Modules;


    public Utilisateur(String firstname, String lastname, String login, String password, List<Module> modules) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        Modules = modules;
    }

    public Utilisateur() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Module> getModules() {
        return Modules;
    }

    public void setModules(List<Module> modules) {
        Modules = modules;
    }
}
