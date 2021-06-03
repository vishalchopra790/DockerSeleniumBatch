package org.example;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class ChromeTest1
{
    /**
     * Rigorous Test :-)
     */
    StartDocker s=new StartDocker();
    @BeforeTest
    public void start() throws IOException, InterruptedException {

        s.startDocker();

    }
    @Test
    public void shouldAnswerWithTrue() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        URL u = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver=new RemoteWebDriver(u, cap);
        driver.get("https://www.microsoft.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.findElements(By.tagName("a")).size());
        driver.quit();
    }

    @AfterTest
    public void stop() throws IOException, InterruptedException {
        StopDocker s=new StopDocker();
        s.stopDocker();
    }
}
