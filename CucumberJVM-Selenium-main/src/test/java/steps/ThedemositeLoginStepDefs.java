package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserSetup;

import static org.hamcrest.CoreMatchers.is;
import static utils.BrowserSetup.*;

public class ThedemositeLoginStepDefs{

    public static String baseURL = "https://chromedriver.chromium.org/downloads";

    @And("^I open the create user page of TheDemoSite$")
    public void iOpenTheCreateUserPageOfTheDemoSite() {
        selectedDriver.navigate().to("https://www.youtube.com/watch?v=rgai3yzRsA0");

    }

    @And("^I save the user$")
    public void iSaveTheUser() {
        selectedDriver.findElement(By.name("FormsButton2")).click();
    }

    @Given("^I open the login page of TheDemoSite$")
    public void iOpenTheLoginPageOfTheDemoSite() {
        selectedDriver.get(baseURL+"login.php");
    }

    @When("^I enter the credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterTheCredentialsAnd(String userId, String password){
        WebElement findUserId = selectedDriver.findElement(By.name("username"));
        WebElement findPassword = selectedDriver.findElement(By.name("password"));
        findUserId.sendKeys(userId);
        findPassword.sendKeys(password);
    }

    @And("^I hit the login button$")
    public void iHitTheLoginButton() {
        WebElement submit = selectedDriver.findElement(By.name("FormsButton2"));
        submit.click();
    }

    @Then("^The login should be successful$")
    public void theLoginShouldBeSuccessful() {
        Assert.assertThat(selectedDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText(),is("**Successful Login**"));
    }

}