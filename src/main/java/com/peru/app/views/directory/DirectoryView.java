package com.peru.app.views.directory;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.util.Collection;

import com.peru.app.backend.Creditos;
import com.peru.app.backend.CreditosRepository;
import com.peru.app.views.main.MainView;

@Route(value = "directory-use", layout = MainView.class)
@PageTitle("Directory")
@CssImport("./styles/views/directory/directory-view.css")
public class DirectoryView extends VerticalLayout {

    private final GridCrud<Creditos> gridcrud;

    @Autowired 
    public DirectoryView(CreditosRepository creditosService) {
        this.gridcrud = new GridCrud<>(Creditos.class);

        //Activa BeanValidation - En los formularios 
        //gridcrud.getCrudFormFactory().setUseBeanValidation(true);
        
        gridcrud.setCrudListener(new CrudListener<Creditos>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public Collection<Creditos> findAll() {
                return creditosService.findAll();
            }

            @Override
            public Creditos add(Creditos creditos) {
                return creditosService.save(creditos);
            }

            @Override
            public Creditos update(Creditos creditos) {
                return creditosService.save(creditos);
            }

            @Override
            public void delete(Creditos creditos) {
                creditosService.deleteById(creditos.getId());
            }
        });

        //gridcrud.setHeight("30em");


        add(gridcrud);
    }

}
