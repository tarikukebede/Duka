package com.halleta.duka.Models.Youtube.playerResponse;

import java.io.Serializable;

public class ActionButton implements Serializable {

    private ButtonRenderer buttonRenderer;

    public ButtonRenderer getButtonRenderer() {
        return buttonRenderer;
    }

    public void setButtonRenderer(ButtonRenderer buttonRenderer) {
        this.buttonRenderer = buttonRenderer;
    }

    @Override
    public String toString() {
        return
                "ActionButton{" +
                        "buttonRenderer = '" + buttonRenderer + '\'' +
                        "}";
    }
}
