package ru.geekbrains;

import config.testConfig;
import org.junit.jupiter.api.Test;

public class Site3test extends testConfig {
    //проверка того что по нажатию пункта "digital art" происходит переход на адрес "https://www.ifitshipitshere.com/category/art/digital-art/"
    @Test
    public void site3() {
        //зайти на сайт
        driver.get(SITE_URL3);
        //кликнуть по выпадающему меню
        clickDropdownMenu();
        //в выпадающем меню открыть категорию "digital art"
        clickOnDigitalArtInMenu();
        //проверяем адрес текущей страницы
        checkUrl();
    }
}
