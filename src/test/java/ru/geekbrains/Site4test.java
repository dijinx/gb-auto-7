package ru.geekbrains;

import config.testConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Site4test extends testConfig {

    @Test
    public void site4(){
        //заходим на сайт
        driver.get(SITE_URL4);
        //вводим в поле поиска "Интерстеллар"
        enterTextInSearch();
        //нажимаем кнопку поиска
        pressSearchButton();
        //нажимаем на ссылку
        pressLink();
        //нажимаем на ссылку Награды (не смог зацепиться меньшим путём)
        pressButtonAwards();
        //проверяем видимость элемента
        elementIsVisible();
    }
}
