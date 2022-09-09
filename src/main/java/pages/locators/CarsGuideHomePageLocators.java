package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CarsGuideHomePageLocators {
	
	
	@FindBy(how=How.LINK_TEXT,using="buy + sell")
	public WebElement carsForSaleLink;
	
	@FindBy(how=How.LINK_TEXT,using="Sell My Car")
	public WebElement sellMyCarLink;
	
	@FindBy(how=How.LINK_TEXT,using="Car Reviews")
	public WebElement carReviewsLink;
	
	@FindBy(how=How.XPATH,using="//a[normalize-space()='Search Cars']")
	public WebElement searchCarsLink;
	
	@FindBy(how=How.XPATH,using="//a[normalize-space()='Used']")
	public WebElement usedSearchCarsLink;

}
