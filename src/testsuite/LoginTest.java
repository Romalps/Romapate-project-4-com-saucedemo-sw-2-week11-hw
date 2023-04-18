package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
2. Create the package ‘testsuite’ and create the
following class inside the ‘testsuite’ package.
1. LoginTest
3. Write down the following test into ‘LoginTest’ class
1. userShouldLoginSuccessfullyWithValid
Credentials
* Enter “standard_user” username
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify the text “PRODUCTS”
2. verifyThatSixProductsAreDisplayedOnPage
* Enter “standard_user” username
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify that six products are displayed
on page
 */
public class LoginTest extends BaseTest {

    String baseUrl=" https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials(){

        // Find Username field element and send username element
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Find Password field element and send password element
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
        // Find Login button field and click
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
        String expectedMessage= "Products";
        WebElement actualTextElement= driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualMessage= actualTextElement.getText();

        Assert.assertEquals("Products text displayed",expectedMessage,actualMessage);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        // Find Username field element and send username element
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        // Find Password field element and send password element
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        // Find Login button element and click
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        String expectedMessage= "Sauce Labs Backpack\n" +
                "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\n" +
                "$29.99\n" +
                "Add to cart\n"+"Sauce Labs Bike Light\n" +
                "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.\n" +
                "$9.99\n" +
                "Add to cart\n"+"Sauce Labs Bolt T-Shirt\n" +
                "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.\n" +
                "$15.99\n" +
                "Add to cart\n"+"Sauce Labs Fleece Jacket\n" +
                "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.\n" +
                "$49.99\n" +
                "Add to cart\n"+"Sauce Labs Onesie\n" +
                "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.\n" +
                "$7.99\n" +
                "Add to cart\n"+"Test.allTheThings() T-Shirt (Red)\n" +
                "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.\n" +
                "$15.99\n" +
                "Add to cart";
        WebElement actualTextElement= driver.findElement(By.xpath("//div[@id='inventory_container' and @class='inventory_container']"));
        String actualMessage=actualTextElement.getText();

        Assert.assertEquals("Six Products are displayed on page",expectedMessage,actualMessage);


    }

@After
    public void tearDown(){
        closeBrowser();
}

}
