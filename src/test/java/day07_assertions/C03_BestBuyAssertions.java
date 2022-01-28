package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestBuyAssertions {

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @Test
    public void test01() {
        //1)Bir class oluşturun: BestBuy Assertions
        //2)https://www.bestbuy.com/ A dresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        driver.get("https://www.bestbuy.com/");
        //○Sayfa URL’inin https://www.bestbuy.com/ com/‘a esit oldugunu test edin
        String actualURL= driver.getCurrentUrl();
        String expectedURL= "https://www.bestbuy.com/";

        Assert.assertEquals(expectedURL,actualURL);
        //○titleTest => Sayfa başlığının “ R est” içer me diğini(contains) test edin
        String actualTitle= driver.getTitle();
        String istenmeyenKelime="Rest";

        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
        //○logoTest => BestBuy logosunun görüntülen digini test edin
        WebElement logoElement=  driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assert.assertTrue("logo gorunmuyor",logoElement.isDisplayed());
        //○Francais LinkTest => Fransizca Linkin görüntülen diğini test edin
        WebElement Francais=driver.findElement(By.xpath("//button[text()='Français']"));

        Assert.assertTrue(Francais.isDisplayed());
    }


    @After
    public void teardown() {

    }

}
