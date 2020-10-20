package com.peru.app.views.webcomponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.shared.Registration;

/**
 *
 * @author RICARDO
 */
@Tag("paper-toggle-button")
@JsModule("@polymer/paper-toggle-button/paper-toggle-button.js")
public class ToggleButton extends Component {

    
    public ToggleButton(String etiqueta ) {
        getElement().setText(etiqueta);
    }
    
    public void setChecked(boolean checked){
        getElement().setProperty("checked", checked);       
    }
    
    
    
    
    
    @Synchronize(value="checked-changed")
    public boolean isChecked(){
        return getElement().getProperty("checked", false);
    }   
    
    @DomEvent("checked-changed")
    public static class CheckedChangeEvent extends ComponentEvent<ToggleButton>{
        
        public CheckedChangeEvent(ToggleButton source, boolean fromClient) {
            super(source, fromClient);
        }
     }

    public Registration addCheckListener(ComponentEventListener<CheckedChangeEvent> componentEventListener){
        return this.addListener(CheckedChangeEvent.class, componentEventListener);
        
    }
    

    
    
}
