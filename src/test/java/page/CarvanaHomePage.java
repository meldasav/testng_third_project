package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarvanaHomePage {
    public CarvanaHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

  @FindBy(xpath = "//div[@data-qa='navigation-wrapper']/div/a")
    public List<WebElement> navigationSectionItems;

  @FindBy(xpath = "//div[@data-qa='header-menu-wrapper']/div[1]")
    public WebElement carVaNaLogo;

  @FindBy(css = "a[data-cv-test='headerSignInLink']")
    public WebElement signInLink;

  @FindBy(css = "div[data-cv-test='Header.Modal']")
    public WebElement signInModel;

  @FindBy(id="usernameField")
    public WebElement userNameInputBox;

  @FindBy(css = "label[for='usernameField']")
    public  WebElement userNameLabel;

    @FindBy(id="passwordField")
    public WebElement passwordInputBox;

    @FindBy(css = "label[for='passwordField']")
    public  WebElement passwordLabel;

    @FindBy(css = "button[data-cv='sign-in-submit']")
    public WebElement signInButton;

    @FindBy(css="div[data-qa='error-message-container']")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@data-qa='header-items']/a[1]")
    public WebElement searchCarButton;
    }

