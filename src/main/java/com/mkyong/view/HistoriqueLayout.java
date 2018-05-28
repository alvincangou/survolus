package com.mkyong.view;

import com.mkyong.model.Module;
import com.mkyong.model.Triggered;
import com.mkyong.repositories.TriggeredRepository;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class HistoriqueLayout extends VerticalLayout {

    public HistoriqueLayout() {
    }
public void init(List<Module> modules, TriggeredRepository repositoryt){
    this.setSizeFull();

    for (Module module:modules){


        for (Triggered t : repositoryt.findAllByModule(module)) {
      this.addComponent(new Label(module.getPhonename()));
      this.addComponent(new Label(String.valueOf(t.getDate())));
      this.addComponent(new Label(String.valueOf(t.getLaditude())));
      this.addComponent(new Label(String.valueOf(t.getLongitude())));

        }
    }

}

}
