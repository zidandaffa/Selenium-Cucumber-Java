package stepDef;

import config.env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerifyDetailProductDef extends env {
    @Given("User is on the Saucedemo website")
    public void userIsOnTheSaucedemoWebsite() {
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

    @And("User is logged in")
    public void userIsLoggedIn() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("User clicks on a product")
    public void userClicksOnAProduct() {
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div[contains(text(),'Sauce Labs Backpack')]"));
        driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[1]/div[contains(text(),'carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.')]"));
        driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div"));
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"][contains(text(),'Add to cart')]"));
        driver.findElement(By.xpath("//*[@id=\"item_4_img_link\"]")).click();
    }

    @Then("User should see the Product Details page")
    public void userShouldSeeTheProductDetailsPage() {
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"][contains(text(),'Back to products')]"));
        driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[1]/img"));
    }

    @And("Product name should be {string}")
    public void productNameShouldBe(String arg0) {
        driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1][contains(text(),'Sauce Labs Backpack')]"));
    }

    @And("Product description should be {string}")
    public void productDescriptionShouldBe(String arg0) {
        driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2][contains(text(),'carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.')]"));
    }

    @And("Product price should be {string}")
    public void productPriceShouldBe(String arg0) {
        driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]"));
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"][contains(text(),'Add to cart')]"));

        driver.quit();
    }
}
