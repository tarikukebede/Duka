package com.halleta.duka.Models.Youtube.playerResponse;

import java.io.Serializable;

public class Microformat implements Serializable {

    private PlayerMicroformatRenderer playerMicroformatRenderer;

    public PlayerMicroformatRenderer getPlayerMicroformatRenderer() {
        return playerMicroformatRenderer;
    }

    public void setPlayerMicroformatRenderer(PlayerMicroformatRenderer playerMicroformatRenderer) {
        this.playerMicroformatRenderer = playerMicroformatRenderer;
    }

    @Override
    public String toString() {
        return
                "Microformat{" +
                        "playerMicroformatRenderer = '" + playerMicroformatRenderer + '\'' +
                        "}";
    }
}
