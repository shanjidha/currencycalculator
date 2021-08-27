package testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class currencyConversion {
    WebDriver driver;

    @Test
    public void TestMethod() throws InterruptedException {
        //Launch chrome browser
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //maximize the browser
        driver.manage().window().maximize();

        //open the url

        driver.get("https://www.paysera.lt/v2/en-LT/fees/currency-conversion-calculator#/");

        //Here is the First Task

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        //WebElement buy = driver.findElement(By.xpath("//*[@id=\"currency-exchange-app\"]/div/div/div[2]/div[1]/form/div[4]/button"));
        WebElement buy = driver.findElement(By.xpath("/html/body/main/article/section[3]/div/div[3]/div/div/div[2]/div[1]/form/div[3]/input"));

        String textInsideInputBox = buy.getAttribute("value");

        if(textInsideInputBox.isEmpty())
        {
            System.out.println("Buy field is empty");
        }

        else {
            System.out.println("Buy field is not empty");

        }

       // driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


        WebElement sell = driver.findElement(By.xpath("/html/body/main/article/section[3]/div/div[3]/div/div/div[2]/div[1]/form/div[1]/input"));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        sell.clear();
        sleep(5000);
        buy.sendKeys("200");


        sleep(3000);
        String textInsideInputBox2 = sell.getAttribute("value");

        if(textInsideInputBox2.isEmpty())
        {
            System.out.println("sell field is empty");
        }

        else {
            System.out.println("sell field is not empty");

        }

   //Here is the Second task

        WebElement usdpay = driver.findElement(By.xpath("/html/body/main/article/section[3]/div/div[3]/div/div/div[2]/table/tbody/tr[1]/td[4]/span/span/span"));

        System.out.println(usdpay.getText());
        String usdpayserAmountLithhhunia= usdpay.getText();
        js.executeScript("window.scrollBy(0,15000)", "");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        WebElement dropdown = driver.findElement(By.xpath("/html/body/footer/div[2]/div/div/div[2]/div/span/span[2]/span"));
        dropdown.click();


        WebElement countrydropdown = driver.findElement(By.xpath("//*[@id=\"countries-dropdown\"]/span[2]"));
        countrydropdown.click();

        Thread.sleep(3000);
        WebElement country = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[1]/div/div/ul/li[14]"));
        country.click();

        Thread.sleep(3000);
        WebElement usdpayukarine = driver.findElement(By.xpath("/html/body/main/article/section[3]/div/div[3]/div/div/div[2]/table/tbody/tr[2]/td[4]/span/span/span"));

        System.out.println(usdpayukarine.getText());
        String usdpayserAmountUkarine= usdpayukarine.getText();

        verifyValuesArenotEqual(usdpayserAmountLithhhunia, usdpayserAmountUkarine);

        driver.quit();

    }
    public void verifyValuesArenotEqual(String value1, String value2)
    {


        Assert.assertNotEquals(value1, value2);
        System.out.println("The value has been updated after changing the country");

    }



}



