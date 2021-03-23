package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class testConfig {
    public String SITE_URL1 = "https://postnauka.ru/";
    public String SITE_URL2 = "https://www.boredpanda.com/";
    public String SITE_URL3 = "https://www.ifitshipitshere.com/";
    public String SITE_URL4 = "https://www.kinopoisk.ru";
    public WebDriver driver;
    public WebDriverWait waitFiveSeconds;

    //данные для сайта номер 2 ,акк тестовый, так что - это безопасно
    public String Email = "test.01.01.02@mail.ru";
    public String Password = "IPMR3p1apu=x";
    //данные для сайта номер 4
    public String searchItem = "Интерстеллар";

    @BeforeEach

    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        waitFiveSeconds = new WebDriverWait(driver, 5);
    }

    @AfterEach
    public void finish() {
        driver.close();
        driver.quit();
    }

    //методы сайта номер 1
    //находим и нажимаем кнопку "Курсы"
    public void pressButtonCourse() {
        WebElement enterButton = waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@href=\"/courses\"]"))));
        enterButton.click();
    }

    //находим и нажимаем карточку "Интегральный мир"
    public void pressCardIntegralWorld() {
        WebElement integralWorldCard = waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div/div/div/div[1]/app-view-theme/div/div[2]/grid/div/div[2]/app-grid-card/app-course-card/div/div/a[2]"))));
        integralWorldCard.click();
    }

    //методы сайта номер 2
    //нажать кнопку "Login/Register"
    public void pressButtonLoginRegister() {
        WebElement clickLoginRegisterButton = waitFiveSeconds
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class=\"login-url visible-downto-xs\"]"))));
        clickLoginRegisterButton.click();
    }

    //ввести почту
    public void enterMail() {
        WebElement enterUserMail = waitFiveSeconds
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-bind=\"value: email, css:{ elementErrorMode: email().length < 1 && $parent.fieldErrors }\"]"))));
        enterUserMail.clear();
        enterUserMail.sendKeys(Email);
    }

    //ввести пароль
    public void enterPassword() {
        WebElement enterUserPassword = waitFiveSeconds
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"auth-form\"]/div/div/div/div[2]/form/input[2]"))));
        enterUserPassword.clear();
        enterUserPassword.sendKeys(Password);
    }

    //нажать кнопку "Log in"
    public void pressButtonLogIn() {
        WebElement clickLogInButton = waitFiveSeconds
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"auth-form\"]/div/div/div/div[2]/form/div/button"))));
        clickLogInButton.click();
    }

    //открыть меню пользователя
    public void openUserMenu() {
        WebElement clickUserMenu = waitFiveSeconds
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class=\"user-menu\"]"))));
        clickUserMenu.click();
    }

    //нажать пункт меню "My Profile"
    public void pressMyProfileInMenu() {
        WebElement clickMyProfile = waitFiveSeconds
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"header-variation-new\"]/nav[2]/ul/li[4]/nav/ul/li[2]/a"))));
        clickMyProfile.click();
    }

    //проверка правильно ли отображается имя пользователя
    public void userNameIsCorrect() {
        waitFiveSeconds.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("/html/body/main/div[1]/div/div[2]/h2")), "orangeviyAvokado"));
    }

    //методы сайта номер 3
    //кликнуть по выпадающему меню
    public void clickDropdownMenu() {
        WebElement dropDownMenu = waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("cat"))));
        dropDownMenu.click();
    }

    //в выпадающем меню открыть категорию "digital art"
    public void clickOnDigitalArtInMenu() {
        WebElement digitalArt = waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@value=\"690\"]"))));
        digitalArt.click();
    }

    //проверяем адрес текущей страницы
    public void checkUrl() {
        String url = driver.getCurrentUrl();
        Assertions.assertEquals(url, "https://www.ifitshipitshere.com/category/art/digital-art/");
    }


    //методы сайта номер 4
    //вводим в поле поиска "Интерстеллар"
    public void enterTextInSearch() {
        WebElement search = driver.findElement(By.xpath("//*[@name = \"kp_query\"]"));
        search.sendKeys(searchItem);
    }

    //нажимаем кнопку поиска
    public void pressSearchButton() {
        WebElement searchButton = driver.findElement(By.xpath("//*[@class = \"_2k4Wh6C4VbCSwM4zwFJOWa _3p61ht_a0h1BAaDpHKIJE0\"]"));
        searchButton.click();
    }

    //нажимаем на ссылку
    public void pressLink() {
        WebElement filmLink = driver.findElement(By.cssSelector("#block_left_pad > div > div:nth-child(3) > div > div.info > p > a"));
        filmLink.click();
    }
    //нажимаем на ссылку Награды (не смог зацепиться меньшим путём)
    public void pressButtonAwards(){
        WebElement awardsLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div/div[1]/div[2]/div/a"));
        awardsLink.click();}
    //проверяем видимость элемента
        public void elementIsVisible(){
            waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@src = \"https://st.kp.yandex.net/images/award-oscar-small.jpg\"]"))));
            System.out.println("Элемент найден!");}
}
