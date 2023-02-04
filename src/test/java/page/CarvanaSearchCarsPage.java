package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarvanaSearchCarsPage {
    public CarvanaSearchCarsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[data-qa='search-bar-input']")
    public WebElement searchInputBox;

    @FindBy(css = "button[data-cv-test='Cv.Search.keywordSearchInput.go']")
    public WebElement goButton;

    @FindBy(xpath = "//div[@data-qa='menu-flex']/button")
    public List<WebElement> filterOptions;

    @FindBy(css = "div[data-qa='base-inventory-type']")
    public List<WebElement> inventoryType;
    @FindBy(css = "picture[data-qa='base-vehicle-image']>img")
    public List<WebElement> tileImages;
    @FindBy(css = "div[data-qa='base-favorite-vehicle']")
    public List<WebElement> addFavoriteIcon;

    @FindBy(css = ".year-make")
    public List<WebElement> year_ModelTexts;

    @FindBy(css = ".trim-mileage")
    public List<WebElement> trimMileageInformation;

    @FindBy(css = "div[data-testid='price']")
    public List<WebElement> prices;

    @FindBy(css = ".monthly-payment")
    public List<WebElement> monthlyInformation;

    @FindBy(css = ".down-payment")
    public List<WebElement> downPayments;


    @FindBy(css = "div[class*='bottom-frame'] div:nth-child(2)")
    public List<WebElement> deliveryChip;

}
