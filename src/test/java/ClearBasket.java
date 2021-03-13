import Base.DriverClient;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ClearBasket {

    private WebDriver driver ;
    ClearBasket(WebDriver _driver)
    {
        driver = _driver;
    }


    @Test
    public void clearBasket() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 8);//Sayfayı Bekletir.

        Thread.sleep(3000);
        //Sepetten silme.
        WebElement deleteBasket = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div[3]/div/div[2]/div/a/i"))));
        deleteBasket.click();

        Thread.sleep(3000);
        driver.quit(); //programı çalışmayı durdurur.
    }
}
