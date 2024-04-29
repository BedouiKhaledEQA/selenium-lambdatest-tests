package steps;


import com.selenium_lambdatest_test.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;


public class hooks extends Base {
    @Before
    public void BeforeALlMethode(){
        System.out.println("**** STARTING TEST ****");
    }

    @After
    public void AfterAllMethode(Scenario sc){
        try {
            // Capture d'écran
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshot, "image/jpeg", "image");
        } catch (WebDriverException e) {
            System.err.println("Une exception s'est produite lors de la capture d'écran : " + e.getMessage());
        } finally {
            // Fermeture du navigateur
            if (driver != null) {
                driver.quit();
            }
        }
}}