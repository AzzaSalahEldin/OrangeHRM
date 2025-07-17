package base;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Base {
	public static WebDriver driver;
	private static final String screenshotDir = "screenshots/";
	public static void initializeDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}

	public static void launchApp() {
		initializeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	public static void closeDriver() {
		if (driver != null) {
            driver.quit();
            driver = null;
        }
	}
	protected static void saveScreenshotToFile(Scenario scenario) {
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String filename = screenshotDir + scenario.getName().replaceAll(" ", "_") + "_" + timestamp + ".png";
			File destFile = new File(filename);
			destFile.getParentFile().mkdirs(); // Ensure directory exists
			FileUtils.copyFile(srcFile, destFile);
			Allure.addAttachment("Failure Screenshot", new FileInputStream(destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
