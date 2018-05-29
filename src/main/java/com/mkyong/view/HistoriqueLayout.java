package com.mkyong.view;

import com.mkyong.Histo;
import com.mkyong.model.Module;
import com.mkyong.model.Triggered;
import com.mkyong.repositories.TriggeredRepository;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HistoriqueLayout extends Panel {
    //VerticalLayout verticalLayout= new VerticalLayout();
    public HistoriqueLayout() {
    }
public void init(List<Module> modules, TriggeredRepository repositoryt){
List<Histo> histos = new ArrayList<>();
    //List<Histo> histos = Arrays.asList();
    this.setSizeFull();
    this.setStyleName("panelhisto");

    for (Module module:modules){

VerticalLayout verticalLayout= new VerticalLayout();
verticalLayout.setSizeUndefined();
        for (Triggered t : repositoryt.findAllByModule(module)) {

           /* VerticalLayout box= new VerticalLayout();
            box.setStyleName("boxhisto");
            box.addComponent(new Label(module.getPhonename()));
            box.addComponent(new Label(String.valueOf(t.getDate())));
            box.addComponent(new Label(String.valueOf(t.getLaditude())));
            box.addComponent(new Label(String.valueOf(t.getLongitude())));
            verticalLayout.addComponent(box);*/
           Histo histo = new Histo(module.getPhonename(),String.valueOf(t.getDate()),String.valueOf(t.getLaditude()),String.valueOf(t.getLongitude()));
           histos.add(histo);

        }


    }
    Grid<Histo> grid= new Grid();
    grid.setItems(histos);
    grid.setSizeFull();
    grid.addColumn(Histo::getPhonename).setCaption("smatphone");
    grid.addColumn(Histo::getDate).setCaption("Date");
    grid.addColumn(Histo::getLaditude).setCaption("Latitude");
    grid.addColumn(Histo::getLongitude).setCaption("Longitude");
    this.setContent(grid);
}

}
