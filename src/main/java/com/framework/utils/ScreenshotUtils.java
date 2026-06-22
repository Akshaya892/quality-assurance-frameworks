package com.framework.utils;

import com.framework.drivers.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static void takeScreenshot(String fileName) throws IOException {

        File srcFile = ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.FILE);

        File destFile = new File("screenshots/" + fileName + ".png");

        FileHandler.copy(srcFile, destFile);
    }
}