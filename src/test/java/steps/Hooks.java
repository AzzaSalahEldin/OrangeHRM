package steps;

import base.Base;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class Hooks extends Base {
    @BeforeAll
    public static void beforeAll() {
        launchApp();
    }
    @AfterAll
    public static void afterAll() {
        closeDriver();
    }
    @AfterStep
    public void afterEachStep(Scenario scenario) {
        if (driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Step Screenshot", new ByteArrayInputStream(screenshot));
        }
    }
    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
        }
    }
}
