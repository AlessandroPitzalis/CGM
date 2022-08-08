import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import java.util.Arrays;





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
        boolean fuelType=driver.findElement(By.cssSelector("button[id='fuelTypeFilter'] span[class='label___2A7vZ']")).isDisplayed();
        if (fuelType==true) {
            driver.findElement(By.cssSelector("button[id='fuelTypeFilter'] span[class='label___2A7vZ']")).click();
            WebElement alimentation = driver.findElement(By.cssSelector("label[data-qa-selector-value='diesel'] span[class='checkbox___1G2UZ unchecked___3F6Qw']"));					
            alimentation.click();
        } else {
            driver.findElement(By.cssSelector("div[class='filters___1PYsR stickyFiltersButtons'] span[class='desktopText___Iw_nJ']")).click();
            WebElement alimentationFilter = driver.findElement(By.cssSelector("div[data-qa-selector='side-menu-fuelTypeFilter'] div[role='button']"));
            JavascriptExecutor je = (JavascriptExecutor) driver;
            je.executeScript("arguments[0].scrollIntoView(true);",alimentationFilter);
            alimentationFilter.click();
            Thread.sleep(2000);
            WebElement diesel = driver.findElement(By.cssSelector("body > div:nth-child(12) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(2) > div:nth-child(1) > label:nth-child(2) > div:nth-child(3)"));
            diesel.click();
        }
        driver.navigate().refresh();
        Thread.sleep(500);
        //Verify the filters
        driver.findElement(By.cssSelector("div[class='filters___1PYsR stickyFiltersButtons'] span[class='desktopText___Iw_nJ']")).click();
        Thread.sleep(500);
        String brand = driver.findElement(By.cssSelector("div[class='ah-collapse-extra'] div:nth-child(1)")).getText();
        String startPrice = driver.findElement(By.cssSelector("div[data-qa-selector='side-menu-priceFilter'] div[role='button'] div div:nth-child(1)")).getText();
        String immatricolazione = driver.findElement(By.cssSelector("div[data-qa-selector='side-menu-yearFilter'] div[class='itemRightLabel___RghBH']")).getText();
        String fuel = driver.findElement(By.cssSelector("div[data-qa-selector='side-menu-fuelTypeFilter'] div[class='itemRightLabel___RghBH']")).getText();

        if(brand.equals("Mercedes-Benz") && startPrice.equals("25.000 € - 30.000 €") && immatricolazione.equals("Da 2019") && fuel.equals("Diesel") ) {
        //User defined message on console
        System.out.println("Value match as Expected");
        }
        else{
        System.out.println("Value NOT match as Expected" + brand +" " + startPrice + " " + immatricolazione + " " + fuel);
        }
        driver.navigate().refresh();

        //verify the year of cars
        
        String number = driver.findElement(By.cssSelector(".carsCounter___2KKEu.carsCounter___3zFvA")).getText();
        int first =number.charAt(0);

        for(int x=0 ; x<=first; x++){
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement year = driver.findElement(By.xpath("(//li[@data-qa-selector='spec-year'])["+x+"]"));
        je.executeScript("arguments[0].scrollIntoView(true);",year);
        year.getText();
        System.out.println(year);
            } 



        
        
    }
}