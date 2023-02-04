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
        Waiter.waitForVisibilityOfElement(driver, carvanaHomePage.carVaNaLogo, 2);
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
        Waiter.pause(2);
        carvanaHomePage.emailInputBox.sendKeys("johndoe@gmail.com");
        carvanaHomePage.continueButton.click();
        carvanaHomePage.passwordInputBox.sendKeys("abcd1234");
        carvanaHomePage.signInButton.click();
        Assert.assertTrue(carvanaHomePage.emailLabel.isDisplayed());
        Assert.assertTrue(carvanaHomePage.emailInputBox.isEnabled());
        Assert.assertTrue(carvanaHomePage.passwordLabel.isDisplayed());
        Assert.assertTrue(carvanaHomePage.passwordInputBox.isEnabled());
        Assert.assertEquals(carvanaHomePage.errorMessage.getText(), "Email address and/or password combination is incorrect.");

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
        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));

        while (carvanaSearchCarsPage.nextButton.isEnabled()) {

            for (int i = 0; i < carvanaSearchCarsPage.tileImages.size(); i++) {
                Assert.assertTrue(carvanaSearchCarsPage.tileImages.get(i).isDisplayed());
                Assert.assertTrue(carvanaSearchCarsPage.addFavoriteIcon.get(i).isDisplayed());
                Assert.assertTrue(carvanaSearchCarsPage.inventoryType.get(i).isDisplayed());
                Assert.assertNotNull(carvanaSearchCarsPage.inventoryType.get(i).getText());
                Assert.assertTrue(carvanaSearchCarsPage.year_ModelTexts.get(i).isDisplayed());
                Assert.assertNotNull(carvanaSearchCarsPage.year_ModelTexts.get(i).getText());
                Assert.assertTrue(carvanaSearchCarsPage.trimMileageInformation.get(i).isDisplayed());
                Assert.assertNotNull(carvanaSearchCarsPage.trimMileageInformation.get(i).getText());
                Assert.assertTrue(carvanaSearchCarsPage.prices.get(i).isDisplayed());
                Assert.assertTrue(Integer.parseInt(carvanaSearchCarsPage.prices.get(i).getText().replaceAll("[$,]", "")) > 0);
                Assert.assertTrue(carvanaSearchCarsPage.monthlyInformation.get(i).isDisplayed());
                Assert.assertNotNull(carvanaSearchCarsPage.monthlyInformation.get(i).getText());
                Assert.assertTrue(carvanaSearchCarsPage.downPayments.get(i).isDisplayed());
                Assert.assertNotNull(carvanaSearchCarsPage.downPayments.get(i).getText());
                Assert.assertTrue(carvanaSearchCarsPage.deliveryChip.get(i).isDisplayed());
            }
            carvanaSearchCarsPage.nextButton.click();
        }

    }

}

