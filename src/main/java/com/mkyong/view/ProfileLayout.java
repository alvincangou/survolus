package com.mkyong.view;

import com.mkyong.model.Utilisateur;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class ProfileLayout extends VerticalLayout {
   private Utilisateur utilisateur;
    public ProfileLayout() {
    }
    public void init(List<Utilisateur> utilisateurs){
       utilisateur=utilisateurs.get(0);
        this.setSizeFull();
        this.addComponent(new Label("prénom :"+utilisateur.getFirstname()));
        this.addComponent(new Label("nom :"+utilisateur.getLastname()));
        this.addComponent(new Label("nombre de modules: "+String.valueOf(utilisateur.getModules().size())));


    }
}
