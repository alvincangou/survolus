package com.mkyong.view;

import com.mkyong.model.Module;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class ModuleLayout extends VerticalLayout {
    public ModuleLayout() {
    }
public void  init(List<Module> modules) {
    this.setSizeFull();
    for (Module module : modules) {
        this.addComponent(new Label("id : " + String.valueOf(module.getId())));
        this.addComponent(new Label("nom du téléphone : " + module.getPhonename()));
        this.addComponent(new Label("nombre de chute : " + String.valueOf(module.getTriggered().size())));

    }

}}