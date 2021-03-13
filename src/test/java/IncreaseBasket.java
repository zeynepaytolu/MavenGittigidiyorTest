import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class IncreaseBasket {

    private WebDriver driver ;
    IncreaseBasket(WebDriver _driver)
    {
        driver = _driver;
    }


    @Test
    public void increaseBasket() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 8);//Sayfayı Bekletir.

        Thread.sleep(3000);
        //sepetteki ürünü 2 yapar.
        WebElement addDropdown = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div[4]/div/div[2]/select"));
        Select number = new Select(addDropdown);
        //Ürün adedini 2 yapması için index 1 seçilmelidir.
        number.selectByIndex(1);


        ClearBasket clear = new ClearBasket(driver);
        clear.clearBasket();

        Assert.assertTrue(true);
    }

}
