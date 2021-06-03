package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class ChromeTest2
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws MalformedURLException {


        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        URL u = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver=new RemoteWebDriver(u, cap);
        driver.get("https://www.gmail.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.findElements(By.tagName("a")).size());
        driver.quit();
    }
}
