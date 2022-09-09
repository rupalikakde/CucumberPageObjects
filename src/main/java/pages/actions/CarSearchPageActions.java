package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.locators.CarSearchPageLocators;
import utils.SeleniumDriver;

public class CarSearchPageActions {

	CarSearchPageLocators CarSearchPageLocators = null;

	public CarSearchPageActions() {

		this.CarSearchPageLocators = new CarSearchPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), CarSearchPageLocators);
	}

	public void selectCarMaker(String carBrand) {

		SeleniumDriver.getDriver().findElement(By.xpath(".//select[@id='makes']")).click();
		Select selectCarMaker = new Select(CarSearchPageLocators.carMakerDropDown);
		selectCarMaker.selectByVisibleText("BMW");

	}

	public void selectCarModel(String carModel) {

		SeleniumDriver.getDriver().findElement(By.xpath("//select[@id='models']")).click();
		Select selectCarModel = new Select(CarSearchPageLocators.selectModelDropDown);
		selectCarModel.selectByVisibleText(carModel);
	}

	public void selectLocation(String location) {

		SeleniumDriver.getDriver().findElement(By.xpath("//select[@id='locations']")).click();
		Select selectLocation = new Select(CarSearchPageLocators.selectLocation);
		selectLocation.selectByVisibleText(location);
	}

	public void selectPrice(String price) {

		SeleniumDriver.getDriver().findElement(By.xpath("//select[@id='priceTo']")).click();
		Select selectPrice = new Select(CarSearchPageLocators.priceList);
		selectPrice.selectByVisibleText(price);
	}

	public void clickOnFindMyNextCarButton() {
		SeleniumDriver.getDriver().findElement(By.xpath(".//*[@id='block-system-main']/div/div/div/div/div/form"))
				.click();
		CarSearchPageLocators.findMyNextCarButton.click();

	}

}
