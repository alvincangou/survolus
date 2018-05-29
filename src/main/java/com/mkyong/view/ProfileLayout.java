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
        VerticalLayout box= new VerticalLayout();
        box.setStyleName("boxprofile");
       utilisateur=utilisateurs.get(0);
        this.setSizeFull();
        box.addComponent(new Label("prénom :"+utilisateur.getFirstname()));
        box.addComponent(new Label("nom :"+utilisateur.getLastname()));
        box.addComponent(new Label("nombre de modules: "+String.valueOf(utilisateur.getModules().size())));
this.setStyleName("layoutprofile");
this.addComponent(box);
    }
}
