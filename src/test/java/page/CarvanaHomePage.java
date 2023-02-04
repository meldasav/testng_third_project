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

  @FindBy(xpath = "//div[@data-qa='menu-wrapper']")
  public List<WebElement> navigationSectionItems;

  @FindBy(css = "div[data-qa='header-menu-wrapper']>div:nth-child(1)")
  public WebElement carVaNaLogo;

  @FindBy(css = "a[data-cv-test='headerSignInLink']")
    public WebElement signInLink;

  @FindBy(css="input[type='email']")
    public WebElement emailInputBox;

  @FindBy(css = "input[label='Email']")
    public  WebElement emailLabel;

  @FindBy(css = "button[data-testid='Button']")
  public WebElement continueButton;
    @FindBy(css="input[type='password']")
    public WebElement passwordInputBox;

    @FindBy(css = "input[label='Password']")
    public  WebElement passwordLabel;

    @FindBy(css = "button[data-testid='Button']")
    public WebElement signInButton;

    @FindBy(id="error-banner")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@data-qa='header-items']/a[1]")
    public WebElement searchCarButton;
    }

