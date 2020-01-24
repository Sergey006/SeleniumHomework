import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestClass2 {
    public static WebDriver webDriver = null;

    @BeforeClass
    public static void TestUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/drivers/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public static void CleanUp(){
        webDriver.close();
        webDriver.quit();
    }

    @Test
    public void sberbankCheck() throws InterruptedException {
        webDriver.get("https://www.sberbank.ru/ru/person");

        webDriver.findElement(By.xpath("//div[@class='hd-ft-region__title']")).click();
        webDriver.findElement(By.xpath("//a[contains(text(), 'Нижегородская область')]")).click();
        String title = webDriver.findElement(By.xpath("//div[@class='hd-ft-region__title']")).getText();

        Assert.assertTrue(title.contains("Нижегородская область"));

        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement facebook = webDriver.findElement(By.xpath("//a[contains(@title, 'Facebook')]"));
        WebElement twitter = webDriver.findElement(By.xpath("//a[contains(@title, 'Twitter')]"));
        WebElement youtube = webDriver.findElement(By.xpath("//a[contains(@title, 'Youtube')]"));
        WebElement instagram = webDriver.findElement(By.xpath("//a[contains(@title, 'Instagram')]"));
        WebElement vk = webDriver.findElement(By.xpath("//a[contains(@title, 'Вконтакте')]"));
        WebElement ok = webDriver.findElement(By.xpath("//a[contains(@title, 'Одноклассники')]"));

        Assert.assertTrue(facebook.isDisplayed());
        Assert.assertTrue(twitter.isDisplayed());
        Assert.assertTrue(youtube.isDisplayed());
        Assert.assertTrue(instagram.isDisplayed());
        Assert.assertTrue(vk.isDisplayed());
        Assert.assertTrue(ok.isDisplayed());
    }
}
