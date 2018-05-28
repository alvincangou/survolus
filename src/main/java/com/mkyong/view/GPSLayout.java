
package com.mkyong.view;

import com.mkyong.model.Module;
import com.mkyong.model.Triggered;
import com.mkyong.repositories.TriggeredRepository;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class GPSLayout extends VerticalLayout {
    private GoogleMap googleMap;
    private final String apiKey = "AIzaSyB1Gx_j2h6Ku9Wp0SC_XbPJbg7Qk0X9Nms";
  public GPSLayout(){
  }
  public void init(List<Module> modules, TriggeredRepository repositoryt) {

      this.setSizeFull();
      googleMap = new GoogleMap(null, null, null);
      googleMap.setCenter(new LatLon(16.2239362, -61.5311338));

      for (Module module:modules){


      for (Triggered t : repositoryt.findAllByModule(module)) {
         /* googleMap.addMarker("NOT DRAGGABLE: Iso-Heikkilä", new LatLon(
                  60.450403, 22.230399), false, null);*/

          googleMap.addMarker(t.getModule().getPhonename() + " Déclanchement " + t.getDate() + "-" + t.getModule().getId(), new LatLon(
                  Double.parseDouble(t.getLaditude()), Double.parseDouble(t.getLongitude())), false, null);


      }
  }

      googleMap.setZoom(10);
      googleMap.setSizeFull();
this.addComponent(googleMap);
this.setExpandRatio(googleMap, 1.0f);
  }
}

