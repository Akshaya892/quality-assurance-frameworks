package com.framework.hooks;

import com.framework.drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() throws InterruptedException {
        DriverFactory.initDriver();
        System.out.println("Browser Opened");
        Thread.sleep(5000);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
        System.out.println("Browser Closed");
    }
}