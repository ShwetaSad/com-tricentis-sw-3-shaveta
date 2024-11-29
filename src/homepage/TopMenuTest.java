package homepage;

import jdk.jshell.execution.Util;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demowebshop.tricentis.com/";

    @Before
    public void  open(){
        openBrowser(baseUrl);
    }
//1.1 create a method with the name "selectMenu()" It has one parameter name "menu"
//of type string
//1.2 This method should click on the menu whatever name is passed as a parameter.
    public void selectMenu(String Menu){
        driver.findElement(By.linkText(Menu)).click();
    }
//    1.3. create the @Test method name verifyPageNavigation(). Use the selectMenu()
 //   method to select the Menu and click on it and verify the page navigation.
    @Test
    public void verifyPaseNavigation(){
        selectMenu("Electronics");

        String expextedText = "Electronics";
        String actualText = driver.findElement(By.linkText("Electronics")).getText();
        Assert.assertEquals("Wrong page",expextedText,actualText);


    }
    @After
    public void close(){
        closeBrowser();
    }
}
