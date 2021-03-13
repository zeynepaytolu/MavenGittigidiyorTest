import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Search {

    private WebDriver driver ;
    Search(WebDriver _driver)
    {
        driver = _driver;
    }

    @Test
    public void search() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 8);//Sayfayı Bekletir.

        //arama çubuğuna tıklanır.
        WebElement searchBarClick = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]"))));
        searchBarClick.click();

        //Arama cubuguna bilgisayar kelimesi girilir ve arama işlemi yapılır.
        WebElement search = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input"));
        search.sendKeys("bilgisayar");

        //bul buttonuna tıklanır.
        WebElement searchClick = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[2]/button"))));
        searchClick.click();

        Add_toBasket addbasket = new Add_toBasket(driver);
        addbasket.add_toBasket();

        Assert.assertTrue(true);
    }

}
