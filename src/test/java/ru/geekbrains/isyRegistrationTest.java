package ru.geekbrains;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class isyRegistrationTest {
    private static final String SITE_URL = "https://www.icy-veins.com";
    private static final WebDriver driver;
    private static final String userName = "poiuy4";
    private static final String userPassword = "1234509876qwer";
    private static final String userMail = "dy7@gmail.com";
    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        //заходим на сайт
        driver.get(SITE_URL);
        //тут я не помню =) создаём переменную ожидания с определённым нами временем?
        WebDriverWait waitFiveSeconds = new WebDriverWait(driver, 5);
        //ждём видимости крестика модального окна
        waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("premium_information_close"))));
        //забираем крестик в переменную
        WebElement closeModalWindow = driver.findElement(By.id("premium_information_close"));
        //кликаем по крестику
        closeModalWindow.click();
        //забираем в переменную кнопку регистрации
        WebElement clickRegistrationButton = driver.findElement(By.id("elRegisterButton"));
        //кликаем кнопку регистрации
        clickRegistrationButton.click();
        //забираем в переменную поле ввода имени
        WebElement inputUserName = driver.findElement(By.id("elInput_username"));
        //вносим в поле имя пользователя
        inputUserName.sendKeys(userName);
        //забираем в переменную поле ввода почты
        WebElement inputUserMail = driver.findElement(By.id("elInput_email_address"));
        //вносим в поле почту
        inputUserMail.sendKeys(userMail);
        //забираем в переменную поле ввода пароля
        WebElement inputUserPassword = driver.findElement(By.id("elInput_password"));
        //вносим в поле пароль
        inputUserPassword.sendKeys(userPassword);
        //забираем в переменную поле подтверждения пароля
        WebElement confirmUserPassword = driver.findElement(By.id("elInput_password_confirm"));
        //вносим в поле пароль
        confirmUserPassword.sendKeys(userPassword);
        //забираем в переменную чекбокс приваси
        WebElement privacyCheckBox = driver.findElement(By.id("check_b464c43ac63629a39e2eff12af3e1089"));
        //отмечаем чекбокс приваси
        privacyCheckBox.click();
        //забираем в переменную кнопку создать аккаунт
        WebElement clickButtonCreateMyAccount = driver.findElement(By.xpath("//*[@class = \"ipsButton ipsButton_primary\"]"));
        //нажимаем на кнопку
        clickButtonCreateMyAccount.click();
        //ждём видимость ссылки на профиль пользователя
        waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("elUserLink"))));
        //закрываем браузер и завершаем работу драйвера
        driver.quit();
    }
}
