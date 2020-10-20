package com.peru.app.views.webcomponents;

import com.github.appreciated.card.Card;
import com.github.appreciated.card.content.IconItem;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 *
 * @author RICARDO
 */
public class CardExample extends VerticalLayout {
    
    
    public CardExample(String imagePath, String title, String description) {
        Image img = new Image(imagePath, title);
        img.setWidth("50px");
        img.setHeight("50px");
        Card card = new Card(
                new IconItem(img, title, description)
        );
        card.setWidth("100%");
        add(card);
    }
}
