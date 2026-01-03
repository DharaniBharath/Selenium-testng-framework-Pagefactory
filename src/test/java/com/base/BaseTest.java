package com.base;

import com.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

     public WebDriver driver;
     public Properties pf;
    public Properties dataprop;

    public void loadpropertiesFile()  {
         pf= new Properties();
        File file=new File("src/main/java/com/config/Config.properties");
        try {
            FileInputStream fi=new FileInputStream(file);
            pf.load(fi);
        }catch (Throwable e){
            e.getStackTrace();
        }

        dataprop=new Properties();
        File file1=new File("src/main/java/com/TestData/testData.properties");
        try {
            FileInputStream f1=new FileInputStream(file1);
            dataprop.load(f1);
        }catch (Throwable e){
            e.getStackTrace();
        }
    }

    public WebDriver initializebrowserandopenAppURL(String browser)
    {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.PAGE_LOAD_TIME));
        driver.get(pf.getProperty("url"));
        return driver;
    }

}
