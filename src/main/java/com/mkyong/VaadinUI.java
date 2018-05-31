package com.mkyong;

import com.mkyong.model.Module;
import com.mkyong.model.Triggered;
import com.mkyong.model.Utilisateur;
import com.mkyong.repositories.ModuleRepository;
import com.mkyong.repositories.TriggeredRepository;
import com.mkyong.repositories.UtilisateurRepository;
import com.mkyong.view.GPSLayout;
import com.mkyong.view.HistoriqueLayout;
import com.mkyong.view.ModuleLayout;
import com.mkyong.view.ProfileLayout;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.*;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Widgetset("AppWidgetset")
@Theme("material")
@SpringUI
public class VaadinUI extends UI {
    public VerticalLayout layout = new VerticalLayout();
    @Autowired
    UtilisateurRepository repositoryu;

    @Autowired
    ModuleRepository repositorym;

    @Autowired
    TriggeredRepository repositoryt;

    private String usernames;

    private String passwords;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    Utilisateur utilisateur;

    Resource resource = new ThemeResource("images/survolusico.png");


    public VaadinUI() {

    }

    @Override
    protected void init(VaadinRequest request) {
     /*   List<Module> modules= new ArrayList<>();
        Utilisateur utilisateur = new Utilisateur("jhone","Doe","admin","admin",modules);
        List<Triggered> triggereds= new ArrayList<>();
        Module module= new Module("Samsing galaxy",utilisateur,triggereds);
        modules.add(module);
        Triggered triggered1= new Triggered("-61.5311338","16.2239362",new Date(),module);
        triggereds.add(triggered1);
        Triggered triggered2= new Triggered("-61.45368","16.207321109600947",new Date(),module);
        triggereds.add(triggered2);
        Triggered triggered3= new Triggered("-61.634405","16.090449",new Date(),module);
        triggereds.add(triggered3);
        repositoryu.saveAndFlush(utilisateur);
        repositorym.saveAndFlush(module);
        repositoryt.saveAndFlush(triggered1);
        repositoryt.saveAndFlush(triggered2);
        repositoryt.saveAndFlush(triggered3);
*/

       // final VerticalLayout layout = new VerticalLayout();
     //   FileResource resource = new FileResource(new File("src/main/resources/survolusico.png"));
Image image = new Image("",resource);
image.setHeight("200px");
        image.setWidth("200px");
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        final TextField password = new TextField();
        password.setCaption("Type your password here:");

        Button button = new Button("Connect");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Trying to connect user : " + name.getValue()));

            try {
                authenticate(name.getValue(),password.getValue());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        layout.addComponents(image,name,password, button);
        layout.setComponentAlignment(image,Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(name, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(button, Alignment.MIDDLE_CENTER);
        setContent(layout);


    }
    private void authenticate(String username, String password) throws Exception {
        List<Utilisateur> users = repositoryu.findAllByLoginAndPassword(username,password);
      Utilisateur user=users.get(0);

        if (user == null) {
            this.layout.addComponent(new Label("Login failed! " ));
            throw new Exception("Login failed!");

        } else {
           /*Module module = new Module("Samsung A5", user, null);
            repositorym.saveAndFlush(module);
            Module module2 = new Module("Alcatel 3x", user, null);
            repositorym.saveAndFlush(module2);
            Module module3 = new Module("Wiko Wim LITE", user, null);
            repositorym.saveAndFlush(module3);*/
           usernames=username;
           passwords=password;
           utilisateur=user;

            getUI().setContent(new Label("2 view"));
            this.setSizeFull();
            VerticalLayout layout = new VerticalLayout();
            MenuBar mainMenuBar = new MenuBar();
            VerticalLayout content = new VerticalLayout();
            layout.setSizeFull();
            setContent(layout);


            MenuBar.Command mycommandprofile = new MenuBar.Command() {
                @Override
                public void menuSelected(MenuBar.MenuItem selectedItem) {
                    content.removeAllComponents();
                    content.addComponent(new Label(selectedItem.getText()    ));
                    content.getComponent(0).setStyleName("top");
                    ProfileLayout profileLayout =new ProfileLayout();
                    profileLayout.init(repositoryu.findAllByLoginAndPassword(usernames,passwords));
                    content.addComponent(profileLayout);
                    for (MenuBar.MenuItem item: mainMenuBar.getItems()) {
                        item.setStyleName("none");
                    }
                    selectedItem.setStyleName("highlight");
                }
            };

            MenuBar.Command mycommandmodule = new MenuBar.Command() {
                @Override
                public void menuSelected(MenuBar.MenuItem selectedItem) {
                    content.removeAllComponents();
                    content.addComponent(new Label(selectedItem.getText()));
                    content.getComponent(0).setStyleName("top");
                    ModuleLayout moduleLayout = new ModuleLayout();
                    moduleLayout.init(repositorym.findByUtilisateur(user),repositorym,user);
                    content.addComponent(moduleLayout);
                    for (MenuBar.MenuItem item: mainMenuBar.getItems()) {
                        item.setStyleName("none");
                    }
                    selectedItem.setStyleName("highlight");
                }
            };

            MenuBar.Command mycommandhistorique = new MenuBar.Command() {
                @Override
                public void menuSelected(MenuBar.MenuItem selectedItem) {
                    content.removeAllComponents();
                    content.addComponent(new Label(selectedItem.getText()));
                    content.getComponent(0).setStyleName("top");
                    HistoriqueLayout historiqueLayout= new HistoriqueLayout();
                    historiqueLayout.init(repositorym.findByUtilisateur(repositoryu.findAllByLoginAndPassword(usernames,passwords).get(0)),repositoryt);
                    content.addComponent(historiqueLayout);
                    for (MenuBar.MenuItem item: mainMenuBar.getItems()) {
                        item.setStyleName("none");
                    }
                    selectedItem.setStyleName("highlight");
                }
            };
            MenuBar.Command mycommandGPS = new MenuBar.Command() {
                @Override
                public void menuSelected(MenuBar.MenuItem selectedItem) {
                    content.removeAllComponents();
                    content.addComponent(new Label(selectedItem.getText()    ));
                    content.getComponent(0).setStyleName("top");
                    GPSLayout gpsLayout = new GPSLayout();
                    gpsLayout.init(repositorym.findByUtilisateur(repositoryu.findAllByLoginAndPassword(usernames,passwords).get(0)),repositoryt);
                   content.addComponent(gpsLayout);

                    for (MenuBar.MenuItem item: mainMenuBar.getItems()) {
                        item.setStyleName("none");
                    }
                    selectedItem.setStyleName("highlight");
                }
            };
            mainMenuBar.addItem("Mon profile",mycommandprofile);
            mainMenuBar.addItem("Modules", mycommandmodule);
            mainMenuBar.addItem("Historique",mycommandhistorique);
            mainMenuBar.addItem("GPS",mycommandGPS);



//Initial Content
            HorizontalLayout header = new HorizontalLayout();
            header.addStyleName("alvin");
            header.setId("header");
            header.setWidth("100%");
            header.setHeight("80px");
            layout.addComponent(header);
            content.removeAllComponents();
            content.addComponent(new Label("Mon profile"   ));
            content.getComponent(0).setStyleName("top");
            ProfileLayout profileLayout =new ProfileLayout();
            profileLayout.init(repositoryu.findAllByLoginAndPassword(usernames,passwords));
            content.addComponent(profileLayout);
            for (MenuBar.MenuItem item: mainMenuBar.getItems()) {
                item.setStyleName("none");
            }
            mainMenuBar.getItems().get(0).setStyleName("highlight");
//inital content end
            layout.addComponent(content);
            layout.setExpandRatio(content,0.8f);
            HorizontalLayout footer = new HorizontalLayout();
            footer.setStyleName("footer");
            footer.setSizeFull();
           /* Resource resf = new ThemeResource("images/survolusico.png");
            Image imagef= new Image("",resf);
            imagef.setHeight("80px");
            imagef.setWidth("80px");
            footer.addComponent(imagef);
            footer.setExpandRatio(imagef,0.1f);*/
            footer.addComponent(new Label("© 2018 Survolus co. All rights reserved."));
            layout.addComponent(footer);
            layout.setExpandRatio(footer,0.2f);
            Resource res = new ThemeResource("images/survolusico2.png");
            Image image = new Image(null, res);
            image.setHeight("40px");
            image.setWidth("200px");
            header.addComponent(image);

            // menu principal
            header.addComponent(mainMenuBar);
            header.setExpandRatio(mainMenuBar, 0.8f);
            HorizontalLayout déconexion = new HorizontalLayout();
            déconexion.setSizeFull();
            déconexion.setStyleName("deconexion");

            Button deco = new Button();
            deco.setIcon(VaadinIcons.SIGN_OUT);
            deco.setStyleName("deco");
            deco.addClickListener(new Button.ClickListener() {
                public void buttonClick(Button.ClickEvent event) {
                     VerticalLayout layout1 = new VerticalLayout();
                    Image image = new Image("",resource);
                    image.setHeight("200px");
                    image.setWidth("200px");
                    final TextField name = new TextField();
                    name.setCaption("Type your name here:");
                    final TextField password = new TextField();
                    password.setCaption("Type your password here:");
                    Button button = new Button("Connect");
                    button.addClickListener( e -> {
                        layout1.addComponent(new Label("Trying to connect user : " + name.getValue()));
                        try {
                            authenticate(name.getValue(),password.getValue());
                        } catch (Exception e1) {
                            e1.printStackTrace(); } });
                    layout1.addComponents(image,name,password, button);
                    layout1.setComponentAlignment(image,Alignment.MIDDLE_CENTER);
                    layout1.setComponentAlignment(name, Alignment.MIDDLE_CENTER);
                    layout1.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
                    layout1.setComponentAlignment(button, Alignment.MIDDLE_CENTER);
                    UI.getCurrent().setContent(layout1);
                }
            });
            déconexion.addComponent(deco);
            header.addComponent(déconexion);
            header.setExpandRatio(déconexion, 0.2f);

        }
    }
}
