package com.mkyong.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Module {

    public Module(String phonename, Utilisateur utilisateur, List<Triggered> triggered) {
        this.phonename = phonename;
        this.utilisateur = utilisateur;
        this.triggered = triggered;
    }

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phonename;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="idutilisateur")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "module",fetch =FetchType.EAGER,orphanRemoval=true)
    private List<Triggered> triggered;

    public Module() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhonename() {
        return phonename;
    }

    public void setPhonename(String phonename) {
        this.phonename = phonename;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Triggered> getTriggered() {
        return triggered;
    }

    public void setTriggered(List<Triggered> triggered) {
        this.triggered = triggered;
    }
}
