package com.peru.app.views.theming;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;
import com.peru.app.views.main.MainView;

@Route(value = "demo-theming", layout = MainView.class)
@PageTitle("Theming")
@CssImport("./styles/views/theming/theming-view.css")
@CssImport(value = "./styles/views/theming/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class ThemingView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public ThemingView() {
        setId("theming-view");
        name = new TextField("Your name");
        sayHello = new Button("Theme Types");
        add(name, sayHello);
        
        
        setVerticalComponentAlignment(Alignment.END, name, sayHello);
        sayHello.addClickListener( e-> {
            Notification.show("Hello " + name.getValue());
        });

        //Themes options
        name.addThemeName("bordered");   //add class theme
        

        Button buttonCss = new Button("My theme Style"); //add css variables
        buttonCss.addClassName("my-button");
        
        Button buttonLumo = new Button("Lumo style");  //add Lumo Style 
        buttonLumo.addThemeVariants(ButtonVariant.LUMO_ERROR);
        sayHello.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        Button buttonPrimary = new Button("Primary");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY); 
        

        add(buttonCss,buttonLumo,buttonPrimary);

    }

}
