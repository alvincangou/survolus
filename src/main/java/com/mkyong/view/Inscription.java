package com.mkyong.view;

import com.mkyong.model.Utilisateur;
import com.mkyong.repositories.UtilisateurRepository;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

public class Inscription extends VerticalLayout {

    Resource resource = new ThemeResource("images/survolusico.png");

    public Inscription(UtilisateurRepository repositoryu) {


        Image image = new Image("",resource);
        image.setHeight("200px");
        image.setWidth("200px");

        final TextField name = new TextField();
        name.setCaption("Type your login here:");

        final TextField password = new TextField();
        password.setCaption("Type your password here:");

        final TextField firstname = new TextField();
        firstname.setCaption("Type your firstname here:");

        final TextField lastname = new TextField();
        lastname.setCaption("Type your lastname here:");

        Button button = new Button("Inscription");
        button.addClickListener( e -> {
            try {
                inscription(name.getValue(),password.getValue(),firstname.getValue(),lastname.getValue(),repositoryu);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


        this.addComponents(image,name,password,firstname,lastname, button);
        this.setComponentAlignment(image,Alignment.MIDDLE_CENTER);
        this.setComponentAlignment(name, Alignment.MIDDLE_CENTER);
        this.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
        this.setComponentAlignment(firstname, Alignment.MIDDLE_CENTER);
        this.setComponentAlignment(lastname, Alignment.MIDDLE_CENTER);
        this.setComponentAlignment(button, Alignment.MIDDLE_CENTER);
    }

    public void inscription(String login, String passwordValue, String firstnameValue, String lastnameValue, UtilisateurRepository repositoryu){


        Utilisateur utilisateur= new Utilisateur(firstnameValue,lastnameValue,login,passwordValue,null);
repositoryu.saveAndFlush(utilisateur);
        Notification.show("inscription réussie");
        Page.getCurrent().reload();
    }
}
