package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AramaTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        WebElement usernameKutusu=driver.findElement(By.id("user-name"));
        usernameKutusu.sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordKutusu= driver.findElement(By.xpath("//input[@id='password']"));
        passwordKutusu.sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.id("login-button"));
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        //6. Add to Cart butonuna basin
        //7. Alisveris sepetine tiklayin
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        //9. Sayfayi kapatin

    }
}
