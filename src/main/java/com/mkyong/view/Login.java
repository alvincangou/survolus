package com.mkyong.view;

import com.mkyong.VaadinUI;
import com.mkyong.repositories.UtilisateurRepository;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

public class Login extends VerticalLayout{
    HorizontalLayout horizontal = new HorizontalLayout();
    Resource resource = new ThemeResource("images/survolusico.png");
    public Login(UtilisateurRepository repositoryu) {
        VaadinUI ui = new VaadinUI();
        Image image = new Image("",resource);
        image.setHeight("200px");
        image.setWidth("200px");
        final TextField name = new TextField();
        name.setCaption("Type your login here:");
        final TextField password = new TextField();
        password.setCaption("Type your password here:");

        final Button inscription = new Button();
        inscription.setCaption("Inscription");
        inscription.setIcon(VaadinIcons.USERS);
        inscription.addClickListener( e -> {
            UI.getCurrent().setContent(new Inscription(repositoryu));
        });
        Button button = new Button("Connect");
        button.addClickListener( e -> {
            this.addComponent(new Label("Trying to connect user : " + name.getValue()));
            try {
                ui.authenticate(name.getValue(),password.getValue());
            } catch (Exception e1) {
                e1.printStackTrace(); } });
        horizontal.addComponents(button,inscription);
        this.addComponents(image,name,password, horizontal);
        this.setComponentAlignment(image,Alignment.MIDDLE_CENTER);
        this.setComponentAlignment(name, Alignment.MIDDLE_CENTER);
        this.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
        this.setComponentAlignment(horizontal, Alignment.MIDDLE_CENTER);
        UI.getCurrent().setContent(this);
    }
}
