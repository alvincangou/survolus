package com.mkyong.view;

import com.mkyong.model.Module;
import com.mkyong.model.Utilisateur;
import com.mkyong.repositories.ModuleRepository;
import com.mkyong.view.popup.MyPopupWindow;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

import java.util.List;

public class ModuleLayout extends Panel {

    private GridLayout gridLayout = new GridLayout(3,1);
    public ModuleLayout() {
    }
public void  init(List<Module> modules, ModuleRepository repositorym, Utilisateur user) {

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
            button.addClickListener(event -> {
                Long id = (Long) event.getButton().getData();
                MyPopupWindow popupWindow = new MyPopupWindow();
                popupWindow.init(id,repositorym,this,user);
// Add it to the root component
                UI.getCurrent().addWindow(popupWindow);

/*Long id = (Long) event.getButton().getData();
repositorym.deleteById(id);*/
            });
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
}
    public  GridLayout refreshedlayout(List<Module>modules,ModuleRepository repositorym,Utilisateur user){
        GridLayout gridLayoutr = new GridLayout(3,1);
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
            button.addClickListener(event -> {
                Long id = (Long) event.getButton().getData();
                MyPopupWindow popupWindow = new MyPopupWindow();
                popupWindow.init(id,repositorym,this,user);
// Add it to the root component
                UI.getCurrent().addWindow(popupWindow);

/*Long id = (Long) event.getButton().getData();
repositorym.deleteById(id);*/
            });
            box.addComponent(button);
            if (i>2) {
                i=0;
                j++;}
            gridLayoutr.setRows(j+1);
            gridLayoutr.addComponent(box,i,j);
            i++;
        }
        return gridLayoutr;
    }
}