package Suporte;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshoot {
    public static void tirar(WebDriver navegador, String arquivo){
        TakesScreenshot screenshotTaker = (TakesScreenshot)navegador;
        File screenshoot = screenshotTaker.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshoot, new File(arquivo));
        }catch (Exception e){
            System.out.println("Erro no screenshot");
        }


    }
}
