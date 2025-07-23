import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class q2 {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Разворачивает окно браузера
    }

    @Test
    void testUserRegistration() {
        // 1. Открытие главной страницы
        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.name("username")).sendKeys("incorrectUser");
        driver.findElement(By.name("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();




        // 7. Ожидание заголовка с нужным текстом
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.textToBePresentInElementLocated(
                        By.tagName("body"),
                        "Your username is invalid!"
                ));

        System.out.println("✅ Введите правильный логин!");
    }


}
