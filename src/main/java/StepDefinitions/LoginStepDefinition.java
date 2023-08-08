package StepDefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LoginStepDefinition {
    WebDriver driver;
//Global Hooks----@Before and @After is a global Hooks
    @Before
    // @Given("^User is already on Login Page$")
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Given("^User is already on Login Page$")
    public void user_Already_On_Login_Page() {

        System.out.println("Browser is launched after entering URL");
        System.out.println("User is already on Login Page");

    }


    @When("^Title of Login Page is Let's Shop$")
    public void title_Of_Login_Page_Is_Lets_Shop() {
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title is : " + actualTitle);
        Assert.assertEquals(actualTitle, "Let's Shop");
    }
    //Data Driven testing approach
   /* @Then("^User enters \"(.*)\" and \"(.*)\"$")
    public void enter_EmailID_And_Password(String userName,String password) {
        driver.findElement(By.id("userEmail")).sendKeys(userName);
        driver.findElement(By.id("userPassword")).sendKeys(password);
    }*/

    //DataTable (Data Driven Testing Approach)
    /*   @Then("^User enters userName and password$")
    public void enter_EmailID_And_Password(DataTable credential) {
          List <List<String>> data= credential.asLists();
        driver.findElement(By.id("userEmail")).sendKeys(data.get(0).get(0));
        driver.findElement(By.id("userPassword")).sendKeys(data.get(0).get(1));
    }*/

    @Then("^User enters userName and password$")
    public void enter_EmailID_And_Password(DataTable credentials) {
        for (Map<String, String> mapData : credentials.asMaps(String.class, String.class)) {
            driver.findElement(By.id("userEmail")).sendKeys(mapData.get("userName"));
            driver.findElement(By.id("userPassword")).sendKeys(mapData.get("password"));
        }
    }


    @Then("^User clicks on Login button$")
    public void click_On_Login_Button() {
        driver.findElement(By.id("login")).click();
    }

    @And("^User is on Home Page$")
    public void user_Is_On_Home_Page() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        String actualMessage = driver.findElement(By.id("toast-container")).getText();


        Assert.assertEquals(actualMessage, "Login Successfully");
    }
}
