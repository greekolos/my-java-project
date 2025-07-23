import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class stop {
    private WebDriver driver;

    // Список запрещённых слов (примеры)
    private final List<String> forbiddenWords = List.of("пороорно", "орлор", "рпор");

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    void checkForbiddenWords() {
        driver.get("https://video.porno365s.me/"); // открываем сайт

        String pageText = driver.findElement(By.tagName("body")).getText().toLowerCase();

        for (String word : forbiddenWords) {
            if (pageText.contains(word.toLowerCase())) {
                System.out.println("Найдено запрещённое слово: " + word);
                driver.quit(); // закрываем браузер
                Assertions.fail("Обнаружено запрещённое слово: " + word);
                return;
            }
        }

        System.out.println("Запрещённых слов не найдено.");
    }

//    @AfterEach
//    void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}