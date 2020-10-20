package com.peru.app.views.binddata;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.grid.contextmenu.GridMenuItem;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import com.peru.app.backend.Creditos;
import com.peru.app.backend.CreditosRepository;
import com.peru.app.views.main.MainView;

@Route(value = "bind-data", layout = MainView.class)
@PageTitle("BindData")
@CssImport("./styles/views/binddata/bind-data-view.css")
public class BindDataView extends HorizontalLayout {

    private final Grid<Creditos> grid;
    private final ComboBox<Creditos> combo;

    //Injectar Datos desde el Back, Java EE, SpringBoot, JPA, EJB, RestClient.
    @Autowired
    public BindDataView( CreditosRepository creditoService) {
        this.grid  = new Grid<>(Creditos.class);
        this.combo = new ComboBox<>();

        //setupGrid();

        Button boton = new Button("Cargar desde el Back");

        add(boton,combo,grid);

        boton.addClickListener((t) -> {
          grid.setItems(creditoService.findAll());

          combo.setItems(creditoService.findAll());
          combo.setItemLabelGenerator(Creditos::getNombre);

        });




    }

    private void setupGrid() {

        grid.removeAllColumns();
        
        //Expresiones o cálculos para las Columnas 
        grid.addColumn(credito ->  credito.getFecha().toString().substring(0, 4) ).setHeader("Año") ;
        
        //Type Safe Columns add
        grid.addColumn(Creditos::getNombre)
                                           .setHeader("Nombre Cliente") ;

        //Componentes en Columnas
        grid.addComponentColumn(  item -> createButton(grid,item) ) 
                                            .setHeader("Cupo de Crédito");

        
    }

    private Button createButton(Grid<Creditos> grid, Creditos item) {
        if( item.getCredito() > 0.6) { 
            return new Button("",new Icon(VaadinIcon.PLUS_SQUARE_O));
         }else{
             return new Button("", new Icon(VaadinIcon.MINUS_CIRCLE_O));
         }
    }

    


}
