package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class CarvanaHomePageTest extends Base {

    @Test(priority = 1, description = "TEST CASE :  Validate Carvana home page title and url")
    public void testCarvanaUrlAndTitle() {
        driver.get("https://www.carvana.com/");
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    @Test(priority = 2, description = "TEST CASE 2 :  Validate the Carvana logo")
    public void testLogo() {
        driver.get("https://www.carvana.com/");
        Waiter.pause(2);
        Assert.assertTrue(carvanaHomePage.carVaNaLogo.isDisplayed());
    }

    @Test(priority = 3, description = "Test case 3:Validate the main navigation section items")
    public void testNavigationSection() {
        driver.get("https://www.carvana.com/");
        String[] navigationSectionItemsTexts = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};
        for (int i = 0; i < carvanaHomePage.navigationSectionItems.size(); i++) {
            Assert.assertTrue(carvanaHomePage.navigationSectionItems.get(i).isDisplayed());
            Assert.assertEquals(carvanaHomePage.navigationSectionItems.get(i).getText(), navigationSectionItemsTexts[i]);
        }
    }

    @Test(priority = 4, description = "TEST CASE 4 :  Validate the sign in error message")
    public void testSignInErrorMessage() {
        driver.get("https://www.carvana.com/");
        carvanaHomePage.signInLink.click();
        Assert.assertTrue(carvanaHomePage.signInModel.isDisplayed());
        carvanaHomePage.userNameInputBox.sendKeys("meldasav@gmail.com");
        carvanaHomePage.passwordInputBox.sendKeys("1983");
        carvanaHomePage.signInButton.click();
        Assert.assertTrue(carvanaHomePage.userNameLabel.isDisplayed());
        Assert.assertTrue(carvanaHomePage.userNameInputBox.isEnabled());
        Assert.assertTrue(carvanaHomePage.passwordLabel.isDisplayed());
        Assert.assertTrue(carvanaHomePage.passwordInputBox.isEnabled());
        Assert.assertEquals(carvanaHomePage.errorMessage.getText(), "Email address and/or password combination is incorrect\n" +
                "Please try again or reset your password.");
    }

    @Test(priority = 5, description = "TestCase 5 : Validate the search filter options and search button")
    public void TestSearchCars() {
        driver.get("https://www.carvana.com/");
        carvanaHomePage.searchCarButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        String[] filterOptionsTexts = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
        for (int i = 0; i < carvanaSearchCarsPage.filterOptions.size(); i++) {
            Assert.assertTrue(carvanaSearchCarsPage.filterOptions.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.filterOptions.get(i).isEnabled());
            Assert.assertEquals(carvanaSearchCarsPage.filterOptions.get(i).getText(), filterOptionsTexts[i]);


        }
    }

    @Test(priority = 6, description = "TEST CASE 6 :Validate the search result tiles")
    public void TestSearchResult() {

        driver.get("https://www.carvana.com/");
        carvanaHomePage.searchCarButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        carvanaSearchCarsPage.searchInputBox.sendKeys("mercedes-benz");
        carvanaSearchCarsPage.goButton.click();

        Waiter.waitUntilURLIs(driver, 5, "https://www.carvana.com/cars/mercedes-benz?email-capture=");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars/mercedes-benz?email-capture=");

        Waiter.waitUntilTitleIs(driver, 5, "Used Mercedes-Benz For Sale Online | Carvana");
        Assert.assertEquals(driver.getTitle(), "Used Mercedes-Benz For Sale Online | Carvana");

        for (WebElement element : carvanaSearchCarsPage.resultImages) {
            if (element.getAttribute("data-test") != null) {
                Assert.assertTrue(element.isDisplayed());
            }
        }
        for (WebElement element : carvanaSearchCarsPage.resultImages) {
            if (element.getAttribute("fill-rule") != null) {
                Assert.assertTrue(element.isDisplayed());
            }
        }

        for (int i = 0; i < carvanaSearchCarsPage.topFrameElements.size(); i++) {
            Assert.assertTrue(carvanaSearchCarsPage.topFrameElements.get(i).isDisplayed());
        }
        //middleFrameElements validation

        for (int i = 0; i < carvanaSearchCarsPage.middleFrameElements.size(); i++) {
            if (carvanaSearchCarsPage.middleFrameElements.get(i).getText() != null) {
                Assert.assertTrue(carvanaSearchCarsPage.middleFrameElements.get(i).isDisplayed());
            }

            if (carvanaSearchCarsPage.year_ModelTexts.get(i).getText() != null) {
                Assert.assertTrue(carvanaSearchCarsPage.year_ModelTexts.get(i).isDisplayed());
            }
            if (carvanaSearchCarsPage.trimMileageInformation.get(i).getText() != null) {
                Assert.assertTrue(carvanaSearchCarsPage.trimMileageInformation.get(i).isDisplayed());
            }
            String price = carvanaSearchCarsPage.prices.get(i).getText().substring(1).replace(",", "");
            Assert.assertTrue(Integer.parseInt(price) > 0);

            if (carvanaSearchCarsPage.monthlyInformation.get(i).getText() != null) {
                Assert.assertTrue(carvanaSearchCarsPage.monthlyInformation.get(i).isDisplayed());
            }

            if (carvanaSearchCarsPage.downPayments.get(i).getText() != null) {
                Assert.assertTrue(carvanaSearchCarsPage.downPayments.get(i).isDisplayed());
            }
        }

        //BottomFrameElements Validation
        for (int i = 0; i < carvanaSearchCarsPage.bottomFrameElements.size(); i++) {
            if (carvanaSearchCarsPage.bottomFrameElements.get(i).getText() != null) {
                Assert.assertTrue(carvanaSearchCarsPage.bottomFrameElements.get(i).isDisplayed());
            }
            Waiter.pause(2);
            // delivery message is dynamic it is changing evrytime you run the scripts.Validate with getAttribute method
            //    Assert.assertTrue(carvanaSearchCarsPage.deliveryChip.get(i).getText().contains("Shipping"));

            if (carvanaSearchCarsPage.deliveryChip.get(i).getAttribute("data-test") != null) {
                Assert.assertTrue(carvanaSearchCarsPage.deliveryChip.get(i).isDisplayed());
            }

        }

    }
}


