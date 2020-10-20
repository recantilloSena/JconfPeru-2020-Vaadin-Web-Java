package com.peru.app.views.componentes;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.peru.app.views.main.MainView;

@Route(value = "demo-components", layout = MainView.class)
@PageTitle("Componentes")
@CssImport("./styles/views/componentes/componentes-view.css")
public class ComponentesView extends VerticalLayout {


    Div value = new Div();

    public ComponentesView() {
        Tab tab1 = new Tab("Inputs Components");

        Div page1 = new Div();
        page1.add(fillPage1());

        Tab tab2 = new Tab("Complex UI");
        Div page2 = new Div();
        page2.add(fillPage2());
        page2.setVisible(false);

        Tab tab3 = new Tab("Data Components");
        Div page3 = new Div();
        page3.add(fillPage3());
        page3.setVisible(false);

        Map<Tab, Component> tabsToPages = new HashMap<>();
        tabsToPages.put(tab1, page1);
        tabsToPages.put(tab2, page2);
        tabsToPages.put(tab3, page3);
        Tabs tabs = new Tabs(tab1, tab2, tab3);
        Div pages = new Div(page1, page2, page3);

        tabs.addSelectedChangeListener(event -> {
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
        });


        
        add(tabs, pages, value);

    }

    private Component fillPage1() {
        FormLayout nameLayout = new FormLayout();

        TextField titleField = new TextField();
        titleField.setLabel("Title");
        titleField.setPlaceholder("Sir");
        TextField firstNameField = new TextField();
        firstNameField.setLabel("First name");
        firstNameField.setPlaceholder("John");

        DatePicker dateField = new DatePicker();
        LocalDate now = LocalDate.now();
        dateField.setLabel("Fecha");
        dateField.setValue(now);

        nameLayout.add(titleField, firstNameField, dateField);

        nameLayout.setResponsiveSteps(new ResponsiveStep("25em", 1), new ResponsiveStep("32em", 2),
                new ResponsiveStep("40em", 3));

        return nameLayout;
    }

    private Component fillPage2() {
        // BEGIN ACCORDION
        Accordion accordion = new Accordion();

        // ACCOUNT INFORMATION
        FormLayout accountForm = new FormLayout();
        accountForm.add(new TextField("Email"));
        accountForm.add(new TextField("Handle"));
        accountForm.add(new PasswordField("Password"));
        accountForm.add(new PasswordField("Confirm password"));

        accordion.add("Información Contable", accountForm);

        // PROFILE INFORMATION
        FormLayout profileInfoForm = new FormLayout();
        profileInfoForm.add(new TextField("First name"));
        profileInfoForm.add(new TextField("Last name"));
        RadioButtonGroup<String> languageGroup = new RadioButtonGroup<>();
        languageGroup.setLabel("Language");
        languageGroup.setItems("English", "Finnish");
        profileInfoForm.add(languageGroup);
        profileInfoForm.add(new DatePicker("Date of birth"));

        accordion.add("Perfil de Usuario", profileInfoForm);

        // TOPICS OF INTEREST
        FormLayout topicsForm = new FormLayout();
        topicsForm.add(new Checkbox("Culture"));
        topicsForm.add(new Checkbox("Environment"));
        topicsForm.add(new Checkbox("Fashion"));
        topicsForm.add(new Checkbox("Finance"));
        topicsForm.add(new Checkbox("Food", true));
        topicsForm.add(new Checkbox("Politics"));
        topicsForm.add(new Checkbox("Sports"));
        topicsForm.add(new Checkbox("Technology", true));

        accordion.add("Temas de Interés", topicsForm);

        // TERMS AND CONDITIONS
        Paragraph paragraph = new Paragraph();
        paragraph.setText("Términos y condiciones establecidas por Jconf Perú "
                + "Toda la información aquí consignada es un ejmeplo.");

        Button submit = new Button("Registro");
        submit.setEnabled(false);
        submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        submit.addClickListener(
                e -> Notification.show("Complete! \uD83D\uDC4D", 4000, Notification.Position.BOTTOM_END));
        Checkbox consent = new Checkbox("Acepto las condiciones.");
        consent.addValueChangeListener(e -> submit.setEnabled(e.getValue()));

        HorizontalLayout bottomPanel = new HorizontalLayout(consent, submit);
        bottomPanel.setWidthFull();
        bottomPanel.setFlexGrow(1, consent);
        VerticalLayout terms = new VerticalLayout(paragraph, bottomPanel);

        accordion.add("Términos y Condicones", terms);

        return accordion;
    }

    private Component fillPage3() {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setLabel("Componente Vaadin");
        comboBox.setItems("Grid", "ComboBox","TextField","Acordión","LoginForm", "AppLayout", "Responsive" );
        comboBox.setClearButtonVisible(true);

        
        value.setText("¿Cuál usas más?");
        comboBox.addValueChangeListener(event -> {
            if (event.getValue() == null) {
                value.setText("Nada ha sido elegido...!");
            } else {
                value.setText("El más usado es : " + event.getValue());
            }
        });
        add(comboBox, value);

        return comboBox;
    }

}
