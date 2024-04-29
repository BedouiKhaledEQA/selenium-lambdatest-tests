package com.selenium_lambdatest_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.oer.its.etsi102941.Url;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class Base {

        public static WebDriver driver;
        public static Properties props =new Properties();
        public Base(){
            try {
                String environment = System.getProperty("env","local");
                File file;
                if("local".equalsIgnoreCase(environment)){
                    file=new File("src/main/java/com/selenium_lambdatest_test/Properties/local_config.Properties");
                } else if ("prod".equalsIgnoreCase(environment)) {
                    file=new File("src/main/java/com/selenium_lambdatest_test/Properties/prod_config.Properties");

                }else throw new RuntimeException("environment n'est pas pris en charge !");

                FileInputStream fis =new FileInputStream(file);
                props.load(fis);

            }catch (IOException e){
                e.printStackTrace();
            }

        }
        public WebDriver luncher() throws MalformedURLException {
            String Browser=System.getProperty("Browser","Chrome");
            switch (Browser){
                case "Chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    RemoteWebDriver driver = (new RemoteWebDriver(new URL("http://192.168.2.23:4444"),options) );

                }case "Firefox"->{
                    driver=new FirefoxDriver();
                }case "Edge"->{
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                }
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(props.getProperty("url"));
            return driver;
        }
    public WebDriver luncher2(){
        String Browser=System.getProperty("Browser","Chrome");
        switch (Browser){
            case "Chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);

            }case "Firefox"->{
                driver=new FirefoxDriver();
            }case "Edge"->{
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(props.getProperty("url2"));
        return driver;
    }
}
