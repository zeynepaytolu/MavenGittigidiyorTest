import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Fill_inLoginInformation {

    private WebDriver driver ;
    Fill_inLoginInformation(WebDriver _driver)
    {
        driver = _driver;
    }

    @Test
    public void fill_inLoginInformation() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 8);//Sayfayı Bekletir.

        //Username textbox'ı için veri gönderir
        WebElement username = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/form/div[1]/div[1]/div[1]/div[2]/input"));
        username.sendKeys("testgittigidiyorzeynep@gmail.com");

        //Password textbox'ı için veri gönderir
        WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/form/div[1]/div[2]/div/div[2]/input"));
        password.sendKeys("test1234");

        //Giriş Yap Butonuna Tıklar
        WebElement loginClick2 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/form/div[2]/div/div[2]/div[1]/input[13]"))));
        loginClick2.click();

        Search search = new Search(driver);
        search.search();

        Assert.assertTrue(true);
    }
}
