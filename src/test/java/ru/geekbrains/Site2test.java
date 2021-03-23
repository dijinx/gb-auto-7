package ru.geekbrains;

import config.testConfig;
import org.junit.jupiter.api.Test;

public class Site2test extends testConfig {
    //проверка отображаемого имени пользователя на странице профиля
    @Test
    public void site2() {
        //заходим на сайт
        driver.get(SITE_URL2);
        //нажать кнопку "Login/Register"
        pressButtonLoginRegister();
        //ввести почту
        enterMail();
        //ввести пароль
        enterPassword();
        //нажать кнопку "Log in"
        pressButtonLogIn();
        //открыть меню пользователя
        openUserMenu();
        //нажать пункт меню "My Profile"
        pressMyProfileInMenu();
        //проверка правильно ли отображается имя пользователя
        userNameIsCorrect();
    }
}
