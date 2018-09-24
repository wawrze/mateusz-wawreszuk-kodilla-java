package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_DAY = "//span[@data-name=\"birthday_wrapper\"]/span/select[1]";
    public static final String XPATH_MONTH = "//span[@data-name=\"birthday_wrapper\"]/span/select[2]";
    public static final String XPATH_YEAR = "//span[@data-name=\"birthday_wrapper\"]/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        WebElement selectDay = driver.findElement(By.xpath(XPATH_DAY));
        WebElement selectMonth = driver.findElement(By.xpath(XPATH_MONTH));
        WebElement selectYear = driver.findElement(By.xpath(XPATH_YEAR));

        Select select = new Select(selectDay);
        select.selectByIndex(25);

        select = new Select(selectMonth);
        select.selectByIndex(8);

        select = new Select(selectYear);
        select.selectByValue("1985");

    }

}