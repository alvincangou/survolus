package com.mkyong.view;

import com.mkyong.Histo;
import com.mkyong.model.Module;
import com.mkyong.model.Triggered;
import com.mkyong.repositories.TriggeredRepository;
import com.mkyong.view.popup.MyPopupWindow;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HistoriqueLayout extends Panel {
    VerticalLayout verticalLayout= new VerticalLayout();

    public HistoriqueLayout() {
    }

public void init(List<Module> modules, TriggeredRepository repositoryt){
        verticalLayout.setSizeFull();
List<Histo> histos = new ArrayList<>();
    //List<Histo> histos = Arrays.asList();
    this.setSizeFull();
    this.setStyleName("panelhisto");

    for (Module module:modules){

        for (Triggered t : repositoryt.findAllByModule(module)) {

           /* VerticalLayout box= new VerticalLayout();
            box.setStyleName("boxhisto");
            box.addComponent(new Label(module.getPhonename()));
            box.addComponent(new Label(String.valueOf(t.getDate())));
            box.addComponent(new Label(String.valueOf(t.getLaditude())));
            box.addComponent(new Label(String.valueOf(t.getLongitude())));
            verticalLayout.addComponent(box);*/
           Histo histo = new Histo(t.getId(),module.getPhonename(),String.valueOf(t.getDate()),String.valueOf(t.getLaditude()),String.valueOf(t.getLongitude()));
           histos.add(histo);

        }


    }


    Grid<Histo> grid= new Grid();
    grid.setItems(histos);
    grid.setSizeFull();
    grid.addColumn(Histo::getPhonename).setCaption("Smartphone");
    grid.addColumn(Histo::getDate).setCaption("Date");
    grid.addColumn(Histo::getLaditude).setCaption("Latitude");
    grid.addColumn(Histo::getLongitude).setCaption("Longitude");
    verticalLayout.addComponent(grid);

    Button button = new Button("supprimer");
    button.setIcon(VaadinIcons.TRASH);
    button.addClickListener(event -> {
        for (Histo h:grid.getSelectedItems()) {
            repositoryt.deleteById(h.getId());
        }
this.setContent(refreshedLayout(modules,repositoryt));
    });

    verticalLayout.addComponent(button);
    this.setContent(verticalLayout);

}
public VerticalLayout refreshedLayout(List<Module> modules, TriggeredRepository repositoryt){
    VerticalLayout verticalLayout= new VerticalLayout();
    verticalLayout.setSizeFull();
    List<Histo> histos = new ArrayList<>();
    //List<Histo> histos = Arrays.asList();
    this.setSizeFull();
    this.setStyleName("panelhisto");

    for (Module module:modules){

        for (Triggered t : repositoryt.findAllByModule(module)) {

           /* VerticalLayout box= new VerticalLayout();
            box.setStyleName("boxhisto");
            box.addComponent(new Label(module.getPhonename()));
            box.addComponent(new Label(String.valueOf(t.getDate())));
            box.addComponent(new Label(String.valueOf(t.getLaditude())));
            box.addComponent(new Label(String.valueOf(t.getLongitude())));
            verticalLayout.addComponent(box);*/
            Histo histo = new Histo(t.getId(),module.getPhonename(),String.valueOf(t.getDate()),String.valueOf(t.getLaditude()),String.valueOf(t.getLongitude()));
            histos.add(histo);

        }


    }


    Grid<Histo> grid= new Grid();
    grid.setItems(histos);
    grid.setSizeFull();
    grid.addColumn(Histo::getPhonename).setCaption("Smartphone");
    grid.addColumn(Histo::getDate).setCaption("Date");
    grid.addColumn(Histo::getLaditude).setCaption("Latitude");
    grid.addColumn(Histo::getLongitude).setCaption("Longitude");
    verticalLayout.addComponent(grid);

    Button button = new Button("supprimer");
    button.setIcon(VaadinIcons.TRASH);
    button.addClickListener(event -> {
        for (Histo h:grid.getSelectedItems()) {
            repositoryt.deleteById(h.getId());
        }
        this.setContent(refreshedLayout(modules,repositoryt));
    });

    verticalLayout.addComponent(button);
    return verticalLayout;
}
}
