package com.selenium_lambdatest_test.locators;

import com.selenium_lambdatest_test.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class lambdatest_locators extends Base {
    public lambdatest_locators(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//body/div[@id='__next']/div[1]/section[8]/div[1]/div[1]/div[1]/div[1]/a[1]")
    protected WebElement seeAllIntegrationButton;
    @FindBy(xpath = "//span[@id='exit_popup_close']")
    protected WebElement crossButton;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[5]/div[1]/div[4]/a[1]")
    protected WebElement learnMoreTestingWhiz;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[5]/div[1]/div[4]/a[1]")
    protected WebElement codelessAutomationElement;
    @FindBy(xpath = "//body[1]/section[1]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[5]/a[1]")
    protected WebElement communityLink;
}
