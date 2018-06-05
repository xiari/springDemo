package com.elk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElkApp {
    private static Logger logger = LoggerFactory.getLogger(ElkApp.class);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            logger.error("Info log [" + i + "].");
            Thread.sleep(500);
        }
    }
}
