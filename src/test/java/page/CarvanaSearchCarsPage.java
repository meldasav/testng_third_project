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

    @FindBy(xpath = "//section[@id='results-section']/div")
    public List<WebElement> resultImages;

    @FindBy(css = "div[class='tk-frame top-frame']")
    public List<WebElement> topFrameElements;

    @FindBy(css = "div[class='tk-frame middle-frame']")
    public List<WebElement> middleFrameElements;

    @FindBy(css = ".year-make")
    public List<WebElement> year_ModelTexts;

    @FindBy(css = ".trim-mileage")
    public List<WebElement> trimMileageInformation;

    @FindBy(css = "div[class='price ']")
    public List<WebElement> prices;

    @FindBy(css = ".monthly-payment")
    public List<WebElement> monthlyInformation;

    @FindBy(css = ".down-payment")
    public List<WebElement> downPayments;

    @FindBy(css = "div[class*='bottom-fram']")
    public List<WebElement> bottomFrameElements;

    @FindBy(css = "div[class*='bottom-frame'] div:nth-child(2)")
    public List<WebElement> deliveryChip;

}
