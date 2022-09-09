package steps;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.SeleniumDriver;

public class AfterActions {

	public static String fileName;
	public static String filePath;

	public static void takeScreenshot() {

		Date d = new Date();

		fileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		filePath = System.getProperty("user.dir") + "/target/cucumber-reports/advanced-reports/extentreports/"
				+ fileName;

		File scrFile = ((TakesScreenshot) SeleniumDriver.getDriver()).getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(scrFile, new File(filePath));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		try {
			ExtentCucumberAdapter.getCurrentStep().addScreenCaptureFromPath(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@After
	public static void tearDown(Scenario scenario) {

		WebDriver driver = SeleniumDriver.getDriver();
		
		System.out.println(scenario.isFailed());
		if (scenario.isFailed()) {
			takeScreenshot();
			byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotBytes, "image/png", "screenshot");

		}
		SeleniumDriver.tearDown();
	}
}
