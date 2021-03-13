import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Add_toBasket {

    private WebDriver driver ;
    Add_toBasket(WebDriver _driver)
    {
        driver = _driver;
    }

    @Test
    public void add_toBasket() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 8);//Sayfayı Bekletir.

        driver.navigate().to("https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");

        //Sayfadaki ürünlerin hepsi getirilir.
        List<WebElement> listOfElements =  driver.findElements(By.xpath(".//*[@class='catalog-view clearfix products-container']/li"));

        //Random ürün seçilir.
        Random rand = new Random();
        int randomIndex = rand.nextInt(listOfElements.size());
        WebElement randomProduct = listOfElements.get(randomIndex);

        //Seçilen ürün text getirilir ve üstüne tıklanır.
        randomProduct.click();

        //Ürün sepete ekle
        int  a =driver.findElements(By.id("add-to-basket")).size();

        if(a==1)
        {
            WebElement addToBasketElement = driver.findElement(By.id("add-to-basket"));

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", addToBasketElement);

        }
        else {
            System.out.println("...");
        }

        Thread.sleep(3000);
        //Sepete git.
        WebElement selectBasket = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[3]/a"))));
        selectBasket.click();

        IncreaseBasket incBasket = new IncreaseBasket(driver);
        incBasket.increaseBasket();


        Assert.assertTrue(true);
    }
}
