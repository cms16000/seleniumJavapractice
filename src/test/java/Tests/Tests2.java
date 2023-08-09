package Tests;

import Actions.Setup;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Unit test for simple App.
 */
public class Tests2 extends Setup

{



    /**
     * Rigourous Test :-)
     */

    @org.testng.annotations.Test
    public void testApp() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gm.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-key")));
        driver.findElement(By.id("search-key")).sendKeys();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.id("search-key")));
    }

    @org.testng.annotations.Test
    public void TestAppWorking() throws InterruptedException {
        actions.getSharedActions().sharedClick(pageObjects.magnifyingGlass);
        actions.getSharedActions().sharedSendKeys(pageObjects.searchBar, "Mary Bara");
        actions.getSharedActions().sharedClick(pageObjects.searchSubmit.get(1));
        Assert.assertTrue(driver.findElement(By.xpath("//html")).getText().contains("Sorry no results"), "Incorrect message");


    }

    @org.testng.annotations.Test
    public void restTest() throws InterruptedException {
       Response response = given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
                body("data.id[0]", equalTo(7)).
                extract().
                response();
        System.out.println(response.body().prettyPrint());


    }

    @org.testng.annotations.Test
    public void restTest2() throws InterruptedException {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/todos/1");
        System.out.println(response.getBody().asString());
        Assert.assertTrue(response.jsonPath().get("userId").equals(1));
        Assert.assertTrue(response.jsonPath().get("title").equals("delectus aut autem"));

}
}
