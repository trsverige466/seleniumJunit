package day07_assertions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YoutubeTesti {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
    //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //	 ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //	○ wrongTitleTest	=> Sayfa basliginin “youtube” olmadigini dogrulayin

    static
    WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }

    @Test
    public void titleTest(){
//	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle=driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertEquals("baslik karsilastirmasi",actualTitle,expectedTitle);
    }

    @Test
    public void imageTest(){
//	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement imgTest= driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]"));
        Assert.assertTrue("logo var",imgTest.isDisplayed());
    }

    @Test
    public void searchBoxTest(){
//	 ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue("search box ulasilir",searchBox.isEnabled());
    }
    @Test
    public void wrongTitleTest(){
//	○ wrongTitleTest	=> Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle= driver.getTitle();
        String expectedTitle="youtube";
        Assert.assertFalse("Title is not true",expectedTitle.equals(actualTitle));
    }

    @AfterClass
    public static void teardown(){

        driver.close();

    }
}
