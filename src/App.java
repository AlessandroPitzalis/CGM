import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;



public class App {
    public static void main(String[] args) throws Exception {
        //Open the website
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.autohero.com/it/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //Accept cookie bar
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(500);
        //Filter for Marca e modello
        driver.findElement(By.linkText("Trova ora la tua auto")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("button[id='carMakeFilter'] span[class='label___2A7vZ']")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("ul[class='list___2FIuh'] input[value='Mercedes-Benz']")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("label[data-qa-selector-value='select_all'] span[class='checkbox___1G2UZ unchecked___3F6Qw']")).click();
        //Filter for price
        Thread.sleep(500);
        driver.findElement(By.cssSelector("button[id='priceFilter'] span[class='label___2A7vZ']")).click();
        Thread.sleep(500);
        driver.findElement(By.id("rangeStart")).click();
        Thread.sleep(500);Select s = new Select(driver.findElement(By.id("rangeStart")));
        s.selectByValue("7");
        Thread.sleep(500);
        driver.findElement(By.id("rangeEnd")).click();
        Thread.sleep(500);Select e = new Select(driver.findElement(By.id("rangeEnd")));
        e.selectByValue("8");
        //Filter for Immatricolazione)
        Thread.sleep(500);
        driver.findElement(By.cssSelector("button[id='yearFilter'] span[class='label___2A7vZ']")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > label:nth-child(1) > select:nth-child(4)")).click();
        Thread.sleep(500);
        Select i = new Select(driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > label:nth-child(1) > select:nth-child(4)")));
        i.selectByValue("4");
        //Filter by alimentation
        Thread.sleep(500);
        driver.findElement(By.cssSelector("button[id='fuelTypeFilter'] span[class='label___2A7vZ']")).click();
        Thread.sleep(500);
        WebElement alimentation = driver.findElement(By.cssSelector("label[data-qa-selector-value='diesel'] span[class='checkbox___1G2UZ unchecked___3F6Qw']"));								
        alimentation.click();
        


        
        
    }
}