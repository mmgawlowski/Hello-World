import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumNokia {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\JetBrains\\IntelliJ IDEA Community Edition 2019.3.3\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element;
        
        driver.get("https://google.com");
        
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        element.sendKeys("Dlaczego warto pracować w Nokii");
        element.submit();
        Thread.sleep(3000);

        driver.get("https://nokiawroclaw.pl");

        element = wait.until(
                ExpectedConditions.elementToBeClickable((By.linkText("Dołącz do nas"))));
        element.click();

        element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Zobacz wszystkie oferty']")));
        driver.executeScript("arguments[0].scrollIntoView({behavior: \"smooth\", block: \"center\"});", element);
        element = wait.until(
                ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[text()='Zobacz wszystkie oferty']"))));
        Thread.sleep(2000);
        element.click();

        wait.until(
                ExpectedConditions.titleContains("Oferty pracy"));

        Select dropDwnType = new Select(driver.findElementByName("type"));
        dropDwnType.selectByValue("10");

        Select dropDwnSection = new Select(driver.findElementByName("section"));
        dropDwnSection.selectByValue("37");

        driver.findElementByXPath("//button[@class='btn btn--red btn--icon']").click();

        Thread.sleep(2000);
        driver.findElementByLinkText("Test Automation Engineer").click();

        wait.until(
                ExpectedConditions.titleContains("Test Automation Engineer"));

        driver.findElementByXPath("//a[@class='btn btn--red']").click();

        element = wait.until(
                ExpectedConditions.presenceOfElementLocated((By.name("name"))));
        element.sendKeys("Jan");

        element = wait.until(
                ExpectedConditions.presenceOfElementLocated((By.name("surname"))));
        element.sendKeys("Kowalski");

        element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("cv")));
        element.sendKeys("C:\\CV.docx");

        element = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='acceptance']")));
        element.click();
        Thread.sleep(5000);

        driver.findElementByClassName("close-button").click();
        Thread.sleep(3000);

        driver.quit();
    }
}
