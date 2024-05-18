package com.amtraxtge.cookingpowder.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface CookingPowderLogger {
    Logger LOGGER = LoggerFactory.getLogger("CookingPowder");

    static void info(String message) { LOGGER.info(message); }
}
