package com.mkyong.view.popup;

import com.mkyong.VaadinUI;
import com.mkyong.model.Module;
import com.mkyong.model.Utilisateur;
import com.mkyong.repositories.ModuleRepository;
import com.mkyong.view.ModuleLayout;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

import java.util.List;

public class MyPopupWindow extends Window {
    public MyPopupWindow() {

    }
    public void init(Long id, ModuleRepository repositorym, ModuleLayout moduleLayout, Utilisateur user) {
        this.center();
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setStyleName("conf");
        Label conf =new Label("Confirmer la supression du module ?");
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setStyleName("conf");
        Button confirm = new Button("confirm");
        confirm.setStyleName("confirm");
        confirm.addClickListener(event -> {
            repositorym.deleteById(id);
            List<Module> moduleList= repositorym.findByUtilisateur(user);

            moduleLayout.setContent(moduleLayout.refreshedlayout(moduleList,repositorym,user));
            this.close();
        });
        Button cancel = new Button("cancel");
        cancel.setStyleName("cancel");
        cancel.addClickListener(event -> {
                this.close();
        });
horizontalLayout.addComponent(confirm);
horizontalLayout.addComponent(cancel);
        verticalLayout.addComponent(conf);
        verticalLayout.addComponent(horizontalLayout);
        setContent(verticalLayout);
    }
}