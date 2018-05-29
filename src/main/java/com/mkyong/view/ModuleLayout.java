package com.mkyong.view;

import com.mkyong.model.Module;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class ModuleLayout extends VerticalLayout {

    private GridLayout gridLayout = new GridLayout();
    public ModuleLayout() {
    }
public void  init(List<Module> modules) {

    this.setSizeFull();
    for (Module module : modules) {
         VerticalLayout box= new VerticalLayout();
         box.setStyleName("boxmodule");
        box.addComponent(new Label("id : " + String.valueOf(module.getId())));
        box.addComponent(new Label("nom du téléphone : " + module.getPhonename()));
        box.addComponent(new Label("nombre de chute : " + String.valueOf(module.getTriggered().size())));
        Button button = new Button("");
        button.setData(module.getId());
        button.setIcon(VaadinIcons.MINUS);
        box.addComponent(button);
        gridLayout.addComponent(box);
    }
    this.setStyleName("ModuleLayout");
    this.addComponent(gridLayout);
}}