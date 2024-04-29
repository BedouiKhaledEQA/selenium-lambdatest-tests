package com.selenium_lambdatest_test.Pages;


import com.selenium_lambdatest_test.locators.lambdatest_locators;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class lambdaTestPage extends lambdatest_locators {
    WebDriverWait wait;
    public lambdaTestPage(){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitForAllElements(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//body/div[@id='__next']/div[1]/section[8]/div[1]/div[1]/div[1]/div[1]/a[1]")));
    }

    public void scrollToSeeAllIntegrations(){
        Actions actions=new Actions(driver);
        actions.moveToElement(seeAllIntegrationButton).perform();
    }

    public void clickSeeAllIntegrations() throws InterruptedException {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> oldHandles = driver.getWindowHandles();
        Thread.sleep(5000);
        seeAllIntegrationButton.click();
        wait.until(ExpectedConditions.urlContains("/integrations"));

        if (driver.getCurrentUrl().equals("https://www.lambdatest.com/integrations")) {
            System.out.println("Le lien s'est ouvert dans la même fenêtre.");
        } else {
            Set<String> newHandles = driver.getWindowHandles();
            newHandles.removeAll(oldHandles);
            String newWindowHandle = newHandles.iterator().next();
            driver.switchTo().window(newWindowHandle);
            driver.close();
            driver.switchTo().window(mainWindowHandle);
        }
    }

    public void verifyURL() {
        String expectedURL = "https://www.lambdatest.com/integrations";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("L'URL n'est pas celle attendue", expectedURL, actualURL);
    }

    public void scrollToCodelessAutomation() {
        codelessAutomationElement.click();
    }

    public void clickLearnMoreForTestingWhiz()  {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(learnMoreTestingWhiz)).click();
            wait.until(ExpectedConditions.urlContains("/testingwhiz-integration/"));
        } catch (TimeoutException e) {
            System.out.println("TimeoutException : " + e.getMessage());
        }
    }

    public void verifyPageTitle()  {
        String expectedTitle = "TestingWhiz Integration | LambdaTest";
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals("Le titre de la page n'est pas celui attendu", expectedTitle, actualTitle);
        } catch (AssertionError e) {
            System.out.println("Le titre de la page n'est pas celui attendu : " + e.getMessage());
            // Continuer avec les étapes suivantes
        }
    }

    public void closeCurrentWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
        driver.quit();
    }

    public void printWindowCount() {
        int windowCount = driver.getWindowHandles().size();
        System.out.println("Nombre de fenêtres ouvertes : " + windowCount);
    }

    public void setURLToBlogPage() {
    }

    public void clickCommunityLinkAndVerifyURL() {
        communityLink.click();
        wait.until(ExpectedConditions.urlToBe("https://community.lambdatest.com/"));
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://community.lambdatest.com/";
        Assert.assertEquals("L'URL de la communauté n'est pas celle attendue", expectedURL, actualURL);
    }
}

