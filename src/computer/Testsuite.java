package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Testsuite extends Utility {

    String baseUrl = "https://demowebshop.tricentis.com/";
@Before
    public void open() {
        openBrowser(baseUrl);
    }

    //1. Test name verifyProductArrangeInAlphaBaticalOrder()
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        // Click on the "Computers" menu
        clickOnElement(By.linkText("Computers"));

        // Click on the "Desktops" submenu
        clickOnElement(By.linkText("Desktops"));

        //  Select Sort By option "Name: Z to A"
        selectByValueFromDropDown(By.id("products-orderby"), "Name: Z to A");

        //  Verify the products are arranged in descending order
        List<String> actualorder = new ArrayList<>();
        for (WebElement product : driver.findElements(By.xpath("//h2[@class='product-title']/a"))) {
            actualorder.add(product.getText());
        }

        // Create a sorted copy of the product names in descending order
        List<String> expectedorder = new ArrayList<>(actualorder);
        Collections.sort(expectedorder, Collections.reverseOrder());

        // Assert that the product names are sorted correctly
        Assert.assertEquals("Products are not sorted in descending order!", expectedorder, actualorder);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
// click on computers Menu
        clickOnElement(By.linkText("Computers"));
        //click on Desktop
        clickOnElement(By.linkText("Desktops"));
        //2.3 Select Sort By option "Name: A to Z"
        selectByValueFromDropDown(By.id("products-orderby"), "Name: A to Z");

        //2.4 Click on the "Add To Cart" button of the product name ‘Build your own computer’
        clickOnElement(By.xpath("//div[@class=\"page-body\"]//div[2]//div[1]//div[2]//div[3]//div[2]//input[1]"));

        //2.5 Verify the Text "Build your own computer"
        String expextedText = "Build your own computer";
        String actualtext = driver.findElement(By.xpath("//h1[@itemprop=\"name\"]")).getText();
        Assert.assertEquals("Wrong puduct", expextedText, actualtext);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using the Select class
        selectByValueFromDropDown(By.xpath("//select[@id=\"product_attribute_16_5_4\"]"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using the Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id=\"product_attribute_16_6_5\"]"), "8GB [+60.00]");
        //2.8 Select HDD radio button "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_16_3_6_19']"));
//2.9 Select the OS radio button "Windows 10 [+$60.00]"
        clickOnElement(By.id("product_attribute_16_4_7_21"));
        //2.10 Check Two Checkboxes "Microsoft Office [+$50.00]" and "Total Commander
        //[+$5.00]"
        clickOnElement(By.xpath("//input[@id=\"product_attribute_16_8_8_22\"]"));
        clickOnElement(By.xpath("//input[@id=\"product_attribute_16_8_8_24\"]"));

        //2.11 Verify the price "1200.00"
        String expText = "1200.00";
        String actText = driver.findElement(By.xpath("//span[@class=\"price-value-16\"]")).getText();
        Assert.assertEquals("Wrong Price ", expText, actText);

        //2.12 Click on the "Add to card" Button.
        clickOnElement(By.id("add-to-cart-button-16"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on the
        //Top green Bar
        Assert.assertTrue("Success message mismatch!",
                getTextFromElement(By.xpath("//p[@class='content']")).contains("The product has been added to your shopping cart"));

        //2.14 After that close the bar by clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.15 Then MouseHover on "Shopping cart" and click on the "Go to cart" button.
        mouseHoverToElement(By.xpath("//span[normalize-space()=\"Shopping cart\"]"));
        mouseHoverToElementAndClick(By.xpath("//input[@value=\"Go to cart\"]"));
        // 2.16 Verify the message "Shopping cart"
        Assert.assertEquals("Cart mismatch", "Shopping cart",
                getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']")));

        //2.17 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@id=\"addtocart_16_EnteredQuantity\"]")).clear();
        driver.findElement(By.xpath("//input[@id=\"addtocart_16_EnteredQuantity\"]")).sendKeys("2");
        clickOnElement(By.xpath("//input[@name='updatecart']"));

        //2.18 Verify the Total "2,950.00"
        Assert.assertEquals("Total price mismatch!", "2950.00",
                getTextFromElement(By.xpath("//span[@class='product-subtotal']")));

        //2.19 click on the checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        // Click on "Checkout"
        clickOnElement(By.xpath("//button[@id='checkout']"));

        // Verify the text "Welcome, Please Sign In!"
        Assert.assertEquals("Sign-in title mismatch!", "Welcome, Please Sign In!",
                getTextFromElement(By.xpath("//h1")));

        // Click on "Checkout as Guest" tab
        clickOnElement(By.xpath("//input[@value='Checkout as Guest']"));

        //2.23 Enter the First name
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "shaveta");
        //laastname
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Sethi");
        //Email
        sendTextToElement(By.id("BillingNewAddress_Email"), "ss@gmail.com");
        //Company
        sendTextToElement(By.id("BillingNewAddress_Company"), "Prime testing Ltd");
        // Select UK
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        // City
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        //Address
        sendTextToElement(By.id("BillingNewAddress_Address1"), "Adress");
        //Postcode
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "RG31 7RJ");
        //PhoneNumber
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "0725723895");

        //2.31 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@onclick='Billing.save()']"));
        // click on Continue
        clickOnElement(By.xpath("//input[@onclick='Billing.save()']"));

        //2.33 Click on the Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        //2.34 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@class='button-1 shipping-method-next-step-button']"));

        //2.35 Select the Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id=\"paymentmethod_2\"]"));

        //2.36 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@class=\"button-1 payment-method-next-step-button\"]"));

        //2.37 Select “Master card” From the Select credit card dropdown using the Select class
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");

        //2.38 Enter the Cardholder's name
        sendTextToElement(By.id("CardholderName"), "ssss");
        //card number
        sendTextToElement(By.id("CardNumber"), "3462357926");
        //exp date
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "05");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2030");
        //2.41 Enter the Card code
        sendTextToElement(By.id("CardCode"), "456");

        //2.42 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']"));

        // Verify “Payment Method” is Credit Card
        Assert.assertEquals("Incorrect Payment method ","Credit Card",
                getTextFromElement(By.xpath("//li[@class='payment-method']")) );

        //Cant continue ,Says "Wrong Card number"


    }
    @After
    public void close(){
        closeBrowser();
    }
}


