package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin
        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualSayfaTitle=driver.getTitle();
        String arananKelime="google";

        if (actualSayfaTitle.contains(arananKelime)){
            System.out.println("title testi PASSED");
        }else{
            System.out.println("title testi FAİLED");
        }

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //6-Bulunan sonuc sayisini yazdirin
        WebElement SonucSayisiElementi= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(SonucSayisiElementi.getText());
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucSayisiString=SonucSayisiElementi.getText();
        String sonucKelimeleri[]=sonucSayisiString.split(" ");
        String sonucNutellaSayisi=sonucKelimeleri[1];
        sonucNutellaSayisi=sonucNutellaSayisi.replace(".","");

        int nutellaAramaSonucu=Integer.parseInt(sonucNutellaSayisi);

        if (nutellaAramaSonucu>10000000){
            System.out.println("nutella arama testi PASS");
        }else {
            System.out.println("nutella arama testi FAİLED");
        }
        //8-Sayfayi kapatin
        driver.close();

    }
}
