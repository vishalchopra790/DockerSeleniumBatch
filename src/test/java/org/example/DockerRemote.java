package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DockerRemote {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("firefox");
        URL u = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver=new RemoteWebDriver(u, cap);
        driver.get("https://www.google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.findElements(By.tagName("a")).size());
    }
}