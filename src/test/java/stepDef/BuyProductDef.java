package stepDef;

import config.env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

public class BuyProductDef extends env{
    @Given("User opens the Saucedemo website")
    public void userOpensTheSaucedemoWebsite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get(sauceDemo);

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
    }

    @When("User logs into Saucedemo")
    public void userLogsIntoSaucedemo() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @And("User adds a product to the cart")
    public void userAddsAProductToTheCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("User verifies that the product has been added to the cart")
    public void userVerifiesThatTheProductHasBeenAddedToTheCart() {
       driver.findElement(By.className("shopping_cart_badge"));
        driver.findElement(By.className("shopping_cart_container")).click();
        driver.findElement(By.className("title"));
        driver.findElement(By.className("cart_quantity"));
        driver.findElement(By.className("inventory_item_name"));
        driver.findElement(By.className("inventory_item_desc"));
        driver.findElement(By.className("inventory_item_price"));
        driver.findElement(By.xpath("//*[@id=\'remove-sauce-labs-backpack\'][contains(text(),'Remove')]"));
    }

    @And("User proceeds to checkout")
    public void userProceedsToCheckout() {

        driver.findElement(By.id("checkout")).click();
    }

    @And("User enters shipping information")
    public void userEntersShippingInformation() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span[contains(text(),'Checkout: Your Information')]"));

        driver.findElement(By.xpath("//input[contains(@placeholder, 'First Name')]")).sendKeys("Zidan");
        driver.findElement(By.xpath("//input[contains(@placeholder, 'Last Name')]")).sendKeys("Daffa");
        driver.findElement(By.xpath("//input[contains(@placeholder, 'Zip/Postal Code')]")).sendKeys("12345");

    }

    @And("User clicks the Continue button")
    public void userClicksTheContinueButton() {
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }

    @Then("User verifies that the product is correct on the overview page")
    public void userVerifiesThatTheProductIsCorrectOnTheOverviewPage() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span[contains(text(),'Checkout: Overview')]"));
        // Verify that product name is displayed correctly
       driver.findElement(By.className("inventory_item_name"));
        driver.findElement(By.className("inventory_item_desc"));
        driver.findElement(By.className("inventory_item_price"));
        driver.findElement(By.className("cart_quantity"));


        driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[1][contains(text(),'Payment Information')]"));
        driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]"));

        driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[3][contains(text(),'Shipping Information')]"));
        driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[4]"));

        driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5][contains(text(),'Price Total')]"));
        driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]"));
        driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]"));



    }

    @And("User clicks the finish button")
    public void userClicksTheFinishButton() {
        driver.findElement(By.xpath("//*[@id=\"finish\"][contains(text(),'Finish')]")).click();

    }

    @Then("User verifies that the order complete message is displayed")
    public void userVerifiesThatTheOrderCompleteMessageIsDisplayed() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span[contains(text(),'Checkout: Complete!')]"));
        driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/img"));
        driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2[contains(text(),'Thank you for your order!')]"));
        driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/div[contains(text(),'Your order has been dispatched, and will arrive just as fast as the pony can get there!')]"));
        driver.findElement(By.xpath("//*[@id='back-to-products'][contains(text(), 'Back Home')]"));

        driver.quit();
    }
}
