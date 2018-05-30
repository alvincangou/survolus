
package com.mkyong.view;

import com.mkyong.Histo;
import com.mkyong.model.Module;
import com.mkyong.model.Triggered;
import com.mkyong.repositories.TriggeredRepository;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class GPSLayout extends VerticalLayout {
    private GoogleMap googleMap;
    private final String apiKey = "AIzaSyB1Gx_j2h6Ku9Wp0SC_XbPJbg7Qk0X9Nms";
  public GPSLayout(){
  }
  public void init(List<Module> modules, TriggeredRepository repositoryt) {
      List<Histo> histos = new ArrayList<>();
      Panel panel = new Panel();
      panel.setSizeFull();
      panel.setStyleName("panelgps");
      this.setStyleName("GPSprofile");
      this.setSizeFull();
      googleMap = new GoogleMap(null, null, null);
      googleMap.setCenter(new LatLon(16.2239362, -61.5311338));
googleMap.setSizeFull();
googleMap.setHeight("600px");
      for (Module module:modules){


      for (Triggered t : repositoryt.findAllByModule(module)) {
         /* googleMap.addMarker("NOT DRAGGABLE: Iso-Heikkilä", new LatLon(
                  60.450403, 22.230399), false, null);*/

          googleMap.addMarker(t.getModule().getPhonename() + " Déclanchement " + t.getDate() + "-" + t.getModule().getId(), new LatLon(
                  Double.parseDouble(t.getLaditude()), Double.parseDouble(t.getLongitude())), false, "https://i.imgur.com/vUbslYY.png");
          Histo histo = new Histo(module.getPhonename(),String.valueOf(t.getDate()),String.valueOf(t.getLaditude()),String.valueOf(t.getLongitude()));
          histos.add(histo);

      }
  }

      googleMap.setZoom(10);
      googleMap.setSizeFull();
this.addComponent(googleMap);

Grid<Histo> grid= new Grid();
      grid.setItems(histos);
      grid.setSizeFull();
      grid.setSelectionMode(Grid.SelectionMode.MULTI);
      grid.setStyleName("gridgps");
      grid.addColumn(Histo::getPhonename).setCaption("Smartphone");
      grid.addColumn(Histo::getDate).setCaption("Date");
      grid.addColumn(Histo::getLaditude).setCaption("Latitude");
      grid.addColumn(Histo::getLongitude).setCaption("Longitude");
panel.setContent(grid);
this.addComponent(panel);

  }
}

