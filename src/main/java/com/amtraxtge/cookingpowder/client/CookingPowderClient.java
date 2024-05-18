package com.amtraxtge.cookingpowder.client;

import com.amtraxtge.cookingpowder.utility.CookingPowderLogger;
import net.fabricmc.api.ClientModInitializer;

public class CookingPowderClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CookingPowderLogger.info("Initializing Client");
    }
}
