package com.mkyong.view;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import org.vaadin.jouni.animator.Animator;

import java.util.ArrayList;
import java.util.List;

public class ContentVerticalLayout extends VerticalLayout {


    private List<String> context;
    private boolean opened ;
    public ContentVerticalLayout(){

        this.setMargin(true);
this.setStyleName("accordeContent");
        opened =false;
        HorizontalLayout headaccordeonlayout = new HorizontalLayout();
headaccordeonlayout.setMargin(true );
        headaccordeonlayout.addComponent(new Label("headaccordeonlayout"));

        headaccordeonlayout.setStyleName("headaccordeonlayout");
        HorizontalLayout selctionLayout= new HorizontalLayout();
        CheckBox checkbox1 = new CheckBox("Checkbox1 checked");
        CheckBox checkbox2 = new CheckBox("Checkbox2 checked");
selctionLayout.addComponent(checkbox1);
selctionLayout.addComponent(checkbox2);
this.addComponent(selctionLayout);
        headaccordeonlayout.addLayoutClickListener(event -> {
            Notification.show("clicked");
            context= new ArrayList<>();
            if(opened==true) {
                this.removeComponent(this.getComponent(this.getComponentCount()-1));

                opened=false;
            }else {
                if( checkbox1.getValue()==true){
                context.add(checkbox1.getCaption());
                }
                if( checkbox2.getValue()==true){
                    context.add(checkbox2.getCaption());

                }
                this.addComponent(new ContentVerticalLayout(context));
                opened=true;
            }

        });
        this.addComponent(headaccordeonlayout);
    }

    public ContentVerticalLayout(List<String> context){
this.setMargin(true);
        this.setStyleName("accordeContent");
       // HorizontalLayout headaccordeonlayout = new HorizontalLayout();
      /*  this.addComponent(headaccordeonlayout);
        headaccordeonlayout.addComponent(new Label("headaccordeonlayout"));
        headaccordeonlayout.setStyleName("headaccordeonlayout");*/
        HorizontalLayout accordeContent = new HorizontalLayout();
        for (String c: context) {
            accordeContent.addComponent(new Label(c));
        }
      this.addComponent(accordeContent);

    }
}