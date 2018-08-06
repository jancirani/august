import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class AddToBasketStepDef {

    WebDriver driver;
    @After
    public void closebrowser()
    {
        driver.quit();
    }

    @Given("^I am on the home page$")
    public void i_am_on_the_home_page() throws Throwable {
        System.setProperty("webdriver.gecko.driver", "src\\test\\java\\amazon\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.amazon.co.uk/");
    }

    @When("^I search for the \"([^\"]*)\"$")
    public void i_search_for_the(String arg1) throws Throwable {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(arg1);
        driver.findElement(By.className("nav-input")).click();
    }

    @Then("^the result should be shown$")
    public void the_result_should_be_shown() throws Throwable {
       driver.findElement(By.cssSelector("#result_0 > div > div.a-row.a-spacing-base > div > div")).isDisplayed();
    }

    @When("^I select the first product$")
    public void i_select_the_first_product() throws Throwable {
        driver.findElement(By.cssSelector("#result_0 > div > div.a-row.a-spacing-base > div > div")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Then("^I should navigate to detailed page$")
    public void i_should_navigate_to_detailed_page() throws Throwable {
        WebElement element = driver.findElement(By.cssSelector("#add-to-cart-button"));
        Assert.assertTrue(element.isDisplayed());
    }

    @When("^I click on add to basket$")
    public void i_click_on_add_to_basket() throws Throwable {
        driver.findElement(By.cssSelector("#add-to-cart-button")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
    }

    @Then("^the item should be add to the basket$")
    public void the_item_should_be_add_to_the_basket() throws Throwable {
      String basketCount = driver.findElement(By.cssSelector("#nav-cart-count")).getText();
        Assert.assertEquals(basketCount, "1");
    }
}
