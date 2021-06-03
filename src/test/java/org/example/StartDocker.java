package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class StartDocker {

    @Test
    public void startDocker() throws IOException, InterruptedException {
        Runtime run = Runtime.getRuntime();
        run.exec("cmd /c start Dockerup.bat");
        boolean flag = false;
        String f = "output.txt";
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 30);
        long stopNow = cal.getTimeInMillis();
        Thread.sleep(5000);

        while (System.currentTimeMillis() < stopNow) {
            if (flag) {
                break;
            }
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String currentLine = reader.readLine();


            while (currentLine != null && !flag) {
                if (currentLine.contains("The node is registered to the hub and ready to use")) {
                    System.out.println("got the text");
                    flag = true;
                    break;

                }
                currentLine = reader.readLine();
            }
            reader.close();

        }
        Thread.sleep(3000);
        Assert.assertTrue(flag);
        run.exec("cmd /c start scaleup.bat");
        Thread.sleep(10000);

    }
}
