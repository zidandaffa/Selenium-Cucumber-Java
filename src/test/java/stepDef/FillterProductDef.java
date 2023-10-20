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

public class FillterProductDef extends env {
    @Given("the user is on the Saucedemo website")
    public void theUserIsOnTheSaucedemoWebsite() {
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

    @When("the user logs in with the username {string} and the password {string}")
    public void theUserLogsInWithTheUsernameAndThePassword(String username, String password) {
        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @And("the user selects Name \\(A to Z) from the filter dropdown")
    public void theUserSelectsNameAToZFromTheFilterDropdown() {
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='az']")).click();

    }

    @Then("the products are displayed according to the Name \\(A to Z) filter: Sauce Labs Backpack, Sauce Labs Bike Light, Sauce Labs Bolt T-Shirt")
    public void theProductsAreDisplayedAccordingToTheNameAToZFilter() {
        driver.findElements(By.xpath("//*[@id=\"item_4_title_link\"]/div[contains(text(),'Sauce Labs Backpack')]"));
        driver.findElements(By.xpath("//*[@id=\"item_0_title_link\"]/div[contains(text(),'Sauce Labs Bike Light')]"));
        driver.findElements(By.xpath("//*[@id=\"item_1_title_link\"]/div[contains(text(),'Sauce Labs Bolt T-Shirt')]"));

        // Close the browser
        driver.quit();
    }

    @And("the user selects Name \\(Z to A) from the filter dropdown")
    public void theUserSelectsNameZToAFromTheFilterDropdown() {
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='za']")).click();
    }

    @Then("the products are displayed according to the Name \\(Z to A) filter: Test.allTheThings\\() T-Shirt \\(Red), Sauce Labs Onesie, Sauce Labs Fleece Jacket")
    public void theProductsAreDisplayedAccordingToTheNameZToAFilter() {
        driver.findElements(By.xpath("//*[@id=\"item_3_title_link\"]/div[contains(text(),'Test.allTheThings() T-Shirt (Red)')]"));
        driver.findElements(By.xpath("//*[@id=\"item_4_title_link\"]/div[contains(text(),'Sauce Labs Onesie')]"));
        driver.findElements(By.xpath("//*[@id=\"item_5_title_link\"]/div[contains(text(),'Sauce Labs Fleece Jacket')]"));

        driver.quit();
    }
}
