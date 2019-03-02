package com.aleksuson.npbcurrencieser.view;

import javafx.scene.Parent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ViewFactory {

    private FxmlLoader loader;
    private Map<String, Parent> viewInstances;

    public ViewFactory(FxmlLoader loader) {
        this.loader = loader;
        this.viewInstances = new HashMap<>();
    }

    /**
     * Lazily instantiate a JavaFX Parent Node
     */
    public Parent getView(String view) {
        Parent node = viewInstances.get(view);

        if (node == null) {
            log.debug("Loading view");
            node = loader.load(view);
            viewInstances.put(view, node);

            return node;
        } else {
            log.debug("View already loaded");
        }

        return node;
    }
}

