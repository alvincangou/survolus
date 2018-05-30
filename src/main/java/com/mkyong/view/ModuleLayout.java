package com.mkyong.view;

import com.mkyong.model.Module;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

import java.util.List;

public class ModuleLayout extends Panel {

    private GridLayout gridLayout = new GridLayout(3,1);
    public ModuleLayout() {
    }
public void  init(List<Module> modules) {

    this.setSizeFull();
    int i=0;
    int j=0;
    for (Module module : modules) {

            VerticalLayout box = new VerticalLayout();
            box.setStyleName("boxmodule");
            Image image =new Image("",new ThemeResource("images/modulesurv.png"));
            image.setHeight("60px");
            image.setWidth("60px");
            box.addComponent(image);
            box.addComponent(new Label("Id : " + String.valueOf(module.getId())));
            box.addComponent(new Label("Nom du téléphone : " + module.getPhonename()));
            box.addComponent(new Label("Nombre de chute : " + String.valueOf(module.getTriggered().size())));

            Button button = new Button("");
            button.setData(module.getId());
            button.setIcon(VaadinIcons.MINUS);
            box.addComponent(button);
            if (i>2) {
                i=0;
                j++;}
                gridLayout.setRows(j+1);
                gridLayout.addComponent(box,i,j);
        i++;
    }
    this.setStyleName("panelmodule");
    this.setContent(gridLayout);
}}