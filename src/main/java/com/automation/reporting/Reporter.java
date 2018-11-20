package com.automation.reporting;

import java.util.Date;

public class Reporter {
    public static void logEvent(Object event) {
        System.out.println(new Date() + ":" + event);
    }

}
