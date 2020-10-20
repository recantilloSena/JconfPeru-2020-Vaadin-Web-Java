package com.peru.app.views.intro;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.peru.app.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "intro-vaadin", layout = MainView.class)
@PageTitle("Intro")
@CssImport("./styles/views/intro/intro-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class IntroView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public IntroView() {
        setId("intro-view");
        name = new TextField("Escribe tu Nombre");
        sayHello = new Button("Saludos");
        
        add(name, sayHello);
        
        //API para componenetes
        setVerticalComponentAlignment(Alignment.END, name, sayHello);

        sayHello.addClickListener( e-> {
            Notification.show("Bienvenido a Vaadin " + name.getValue()
            );
            add(new Paragraph(name.getValue() ));
        });
    }

}
