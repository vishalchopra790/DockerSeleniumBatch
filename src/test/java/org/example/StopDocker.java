package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Calendar;

public class StopDocker {

    @Test
    public void stopDocker() throws IOException, InterruptedException {
        Runtime run = Runtime.getRuntime();
        run.exec("cmd /c start Dockerdo.bat");
        boolean flag = false;
        String f = "output.txt";
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 60);
        long stopNow = cal.getTimeInMillis();
        Thread.sleep(5000);

        while (System.currentTimeMillis() < stopNow) {
            if (flag) {
                break;
            }
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String currentLine = reader.readLine();


            while (currentLine != null && !flag) {
                if (currentLine.contains("selenium-hub exited")) {
                    System.out.println("got the text");
                    flag = true;
                    break;

                }
                currentLine = reader.readLine();
            }
            reader.close();

        }
        Thread.sleep(10000);
        Assert.assertTrue(flag);
        File fi=new File("output.txt");
        if(fi.exists()){
            if(fi.delete()){
                System.out.println("Deleted");
            }
        }

        run.exec("cmd /c start cmdclose.bat");
    }
}
