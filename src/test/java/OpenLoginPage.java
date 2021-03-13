import Base.DriverClient;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OpenLoginPage {

    private WebDriver driver ;
    OpenLoginPage(WebDriver _driver)
    {
        driver = _driver;
    }

    @Test
    public void openLoginPage() throws InterruptedException {

        //www.gittigidiyor.com sitesi açılır.
        driver.navigate().to("https://www.gittigidiyor.com/");
        //Ana sayfanın açıldığı kontrol edilmek için bir süre beklenir.
        WebDriverWait wait = new WebDriverWait(driver, 8);//Sayfayı Bekletir.

        driver.manage().window().maximize();
        //Giriş yap navbarda görünene kadar bekler ve tıklar
        WebElement navBarLogin = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div[1]/div[3]/div/div[1]/div/div[2]"))));
        navBarLogin.click();

        //acılan giriş Yap Butonuna Tıklar
        WebElement loginClick = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a/span"))));
        loginClick.click();

        Fill_inLoginInformation login = new Fill_inLoginInformation(driver);
        login.fill_inLoginInformation();

        Assert.assertTrue(true);
    }
}
