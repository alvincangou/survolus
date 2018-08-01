package com.mkyong.view;

import com.gargoylesoftware.htmlunit.javascript.host.css.CSS;
import com.mkyong.model.Utilisateur;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import org.vaadin.jouni.animator.Animator;

import java.util.List;

public class ProfileLayout extends Panel {
private Boolean opened;
   private Utilisateur utilisateur;

    public ProfileLayout() {
    }
    public void init(List<Utilisateur> utilisateurs){
        opened=false;

        VerticalLayout layoutprofile = new VerticalLayout();
        VerticalLayout box= new VerticalLayout();
        HorizontalLayout boxinfo= new HorizontalLayout();
        boxinfo.setStyleName("boxinfo");
        Image image1=new Image("détéction de chute",new ThemeResource("images/chute.png"));
        image1.setHeight("50px");
        image1.setWidth("50px");
        boxinfo.addComponent(image1);
        Image image2=new Image("deploiement du parachute",new ThemeResource("images/parachute.png"));
        image2.setHeight("50px");
        image2.setWidth("50px");
        boxinfo.addComponent(image2);
        Image image3=new Image("localisation gps",new ThemeResource("images/geo.png"));
        image3.setHeight("50px");
        image3.setWidth("50px");
        boxinfo.addComponent(image3);
        Image image4=new Image("application android",new ThemeResource("images/phone.png"));
        image4.setHeight("50px");
        image4.setWidth("50px");
        boxinfo.addComponent(image4);
        box.setStyleName("boxprofile");
       utilisateur=utilisateurs.get(0);

        box.addComponent(new Label("Prénom :"+utilisateur.getFirstname()));
        box.addComponent(new Label("Nom :"+utilisateur.getLastname()));
        box.addComponent(new Label("Nombre de modules: "+String.valueOf(utilisateur.getModules().size())));
        layoutprofile.setStyleName("layoutprofile");
        layoutprofile.setSizeFull();
        layoutprofile.addComponent(box);
        layoutprofile.setExpandRatio(box,0.5f);
        layoutprofile.addComponent(boxinfo);
        layoutprofile.setExpandRatio(boxinfo,0.5f);
        this.setSizeFull();
        this.setStyleName("panelprofile");

        HorizontalLayout headaccordeonlayout = new HorizontalLayout();
        layoutprofile.addComponent(headaccordeonlayout);
        headaccordeonlayout.addComponent(new Label("headaccordeonlayout"));
        headaccordeonlayout.setStyleName("headaccordeonlayout");
            ContentVerticalLayout accordeContent = new ContentVerticalLayout();
        headaccordeonlayout.addLayoutClickListener(event -> {
            Notification.show("clicked");
            if(opened==true) {
                layoutprofile.removeComponent(layoutprofile.getComponent(layoutprofile.getComponentCount()-1));
                opened=false;
            }else {
                layoutprofile.addComponent(accordeContent);
                
                layoutprofile.setComponentAlignment(accordeContent,Alignment.MIDDLE_CENTER);
                opened=true;
            }

        });

this.setContent(layoutprofile);
    }
}
