package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

// ******************************* Alert Methods *************************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert().accept();
    }

    // accept Alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    // dismissAlert()
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // getTextFromAlert()
    public void getTextFromAlert() {
        String alertText = driver.switchTo().alert().getText();
        System.out.println("AlertText:" + alertText);
    }

    // sendTextToAlert(String text)
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
// ***************************** Select Class Methods *********************************

    /**
     * This method will select the option by value
     */
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropdown = driver.findElement(by);
        //Create the object of Select class
        Select select = new Select(dropdown);
        // Select by visible text
        select.selectByVisibleText(value);
    }

    // selectByIndexFromDropDown(By by, int index)
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropdown = driver.findElement(by);
        //Create the object of Select class
        Select select = new Select(dropdown);
        // Select by Index
        select.selectByIndex(index);
    }


// selectByVisibleTextFromDropDown(By by, String text)
    public void selectByVisibleTextFromDropDown(By by, String text){

    WebElement dropdown = driver.findElement(by);
    //Create the object of Select class
    Select select = new Select(dropdown);
    // Select by visible text
    select.selectByVisibleText(text);
}




    // selectByContainsTextFromTheDropDown(By by, String text)


// ************************* Actions Methods ********************************************

    // mouseHoverToElement(By by)
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement webElement =driver.findElement(by);

       /* actions.moveToElement(webElement).build().perform();
        actions.moveToElement(desktop).click().build().perform();*/

        actions.moveToElement(webElement).build().perform();


    }

    //mouseHoverToElementAndClick(By by)
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement webElement =driver.findElement(by);

       /* actions.moveToElement(webElement).build().perform();
        actions.moveToElement(desktop).click().build().perform();*/

        actions.moveToElement(webElement).click().build().perform();

    }



}
