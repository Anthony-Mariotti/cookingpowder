package com.amtraxtge.cookingpowder;

import com.amtraxtge.cookingpowder.utility.CookingPowderLogger;
import net.fabricmc.api.ModInitializer;

public class CookingPowder implements ModInitializer {
    public static final String MOD_ID = "cookingpowder";
    public static final String MOD_NAME = "CookingPowder";

    @Override
    public void onInitialize() {
        CookingPowderLogger.info("Initializing");
    }
}
