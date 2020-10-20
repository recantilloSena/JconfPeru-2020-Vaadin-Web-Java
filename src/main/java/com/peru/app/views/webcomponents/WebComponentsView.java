package com.peru.app.views.webcomponents;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.peru.app.views.main.MainView;

@Route(value = "web-components", layout = MainView.class)
@PageTitle("Web Components")
@CssImport("./styles/views/webcomponents/web-components-view.css")
public class WebComponentsView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;
    private TextField spinnner = new TextField("Cargando");

    private ToggleButton toggleButton = new ToggleButton("Estado");
    
    private CardExample cardExample;
    
    public WebComponentsView() {
        this.cardExample = new CardExample("/images/logo.png", "Card Java", "Este es un componente del Directorio de Vaadin...!");
        setId("web-components-view");
        name = new TextField("Your name");
        sayHello = new Button("Say hello");

        add(name, sayHello, toggleButton, cardExample);

        //add theme to toggle
        toggleButton.setChecked(true);
        
        setVerticalComponentAlignment(Alignment.END, name, sayHello);
        sayHello.addClickListener( e-> {
            showNotification();            
        });



        

    }



    public void showNotification() {
        Notification notification = new  Notification(spinnner);
        notification.setDuration(3000);
        notification.open();
    }

}
