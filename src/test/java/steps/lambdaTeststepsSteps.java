package steps;

import com.selenium_lambdatest_test.Base;
import com.selenium_lambdatest_test.Pages.lambdaTestPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class lambdaTeststepsSteps extends Base {
    lambdaTestPage Lambdatestpage;
    @Given("User is on LambdaTest website homepage")
    public void user_is_on_lambda_test_website_homepage() {
        luncher();

    }
    @When("User waits for all elements to be available")
    public void user_waits_for_all_elements_to_be_available() {
        Lambdatestpage =new lambdaTestPage();
        Lambdatestpage.waitForAllElements();

    }
    @And("User scrolls to SEE ALL INTEGRATIONS link")
    public void user_scrolls_to_see_all_integrations_link() {
        Lambdatestpage.scrollToSeeAllIntegrations();

    }
    @And("User clicks on SEE ALL INTEGRATIONS link and verifies URL")
    public void user_clicks_on_see_all_integrations_link_and_verifies_url() throws InterruptedException {
        Lambdatestpage.clickSeeAllIntegrations();

    }
    @And("User scrolls to Codeless Automation")
    public void user_scrolls_to_codeless_automation() {
        Lambdatestpage.scrollToCodelessAutomation();

    }
    @And("User clicks on LEARN MORE for Testing Whiz and verifies page title")
    public void user_clicks_on_learn_more_for_testing_whiz_and_verifies_page_title()  {
        Lambdatestpage.clickLearnMoreForTestingWhiz();
        Lambdatestpage.verifyPageTitle();

    }
    @Then("User closes the current window")
    public void user_closes_the_current_window() {
        String windowHandle = driver.getWindowHandle();
        Lambdatestpage.closeCurrentWindow(windowHandle);

    }
    @And("User sets the URL")
    public void user_sets_the_url_to_https_www_lambdatest_com_blog() {
        luncher2();

    }
    @And("User clicks on Community link and verifies URL")
    public void user_clicks_on_community_link_and_verifies_url() {
        Lambdatestpage =new lambdaTestPage();
        Lambdatestpage.clickCommunityLinkAndVerifyURL();

    }
    @Then("User closes the current browser window")
    public void user_closes_the_current_browser_window() {
        String windowHandle = driver.getWindowHandle();
        Lambdatestpage.closeCurrentWindow( windowHandle);

    }

}
