package com.selenium.page;

import com.selenium.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.selenium.driver.BaseTest.driver;

public class ProductPage {

    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);


    public ProductPage() {
        methods = new Methods();
    }

    public void loginControl() {
        methods.click(By.xpath("//div[@class='menu-top-button login']"));
        //methods.waitBySeconds(3);
        methods.sendKeys(By.id("login-email"),"talha.cavus@testinium.com");
        //methods.waitBySeconds(3);
        methods.sendKeys(By.id("login-password"),"1q2w3e4r5t");
        //methods.waitBySeconds(3);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        //methods.waitBySeconds(19);
        String text = methods.getText(By.cssSelector(".section"));
        Assert.assertEquals("Hesabım", text);
        System.out.println("Sayfa Login Kontrol Yapıldı: " + text);
        logger.info("Sayfa Login Kontrol Yapıldı: " + text);
        //methods.waitBySeconds(3);
    }

    public void searchingElement() {
        methods.sendKeys(By.id("search-input"), "oyuncak");
        methods.click(By.xpath("//span[@class='common-sprite button-search']"));
        methods.addFavorites();
        methods.favoriteCheck();
//        methods.click(By.xpath("//a[@onclick='addToFavorites(394421);' and @data-title]//i"));
//        methods.waitBySeconds(2);
//        methods.click(By.xpath("//a[@onclick='addToFavorites(341772);' and @data-title]//i"));
//        methods.waitBySeconds(2);
//        methods.click(By.xpath("//a[@onclick='addToFavorites(440988);' and @data-title]//i"));
//        methods.waitBySeconds(2);
//        methods.click(By.xpath("//a[@onclick='addToFavorites(440872);' and @data-title]//i"));
//        methods.waitBySeconds(2);
        methods.scrollWithAction(By.xpath("//a[@class='common-sprite' and @href='kampanyalar']"));
        //methods.waitBySeconds(2);
        methods.click(By.xpath("//*[@id=\"header-top\"]/div/div[2]/ul/li[1]/div/ul/li/a"));
        //methods.waitBySeconds(2);
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/favorite&selected_tags=0']"));
        //methods.waitBySeconds(2);
        methods.click(By.xpath("(//*[@data-title='Favorilerimden Sil'])[3]"));
        methods.click(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11453388/wh:44a9b399f']"));
        methods.click(By.xpath("//a[@class='common-sprite' and @href = 'puan-katalogu']"));
        methods.scrollWithAction(By.cssSelector("#point-carousel-tab-title-952"));
        methods.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.selectByText(By.xpath("//select[@onchange= 'location = this.value;']"), "Yüksek Oylama");
        //methods.waitBySeconds(5);

    }

    public void sepet(){
        methods.scrollWithAction(By.xpath("//span[@class = 'mn-strong common-sprite' and contains(text() , 'Tüm Kitaplar')]"));
        methods.click(By.xpath("//span[@class = 'mn-strong common-sprite' and contains(text() , 'Tüm Kitaplar')]"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//a[@class='mn-icon icon-angleRight' and text() = 'Hobi']"));
        methods.waitBySeconds(2);
        methods.clickRandom();
        methods.click(By.cssSelector("#button-cart > span"));
        methods.click(By.xpath("//div[@id='cart']"));
        //methods.waitBySeconds(4);
        methods.click(By.xpath("//div[@class = 'mg-b-5']//a[@id='js-cart']"));
        //methods.waitBySeconds(4);
        driver.findElement(By.xpath("//input[@name = 'quantity']")).clear();
        methods.sendKeys(By.xpath("//input[@name = 'quantity']"),"5");
        //methods.waitBySeconds(4);
        methods.click(By.xpath("//i[@onclick = 'cartProductUpdate($(this).parent())']"));
        //methods.waitBySeconds(2);
        methods.scrollWithAction(By.cssSelector(".button.red"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".button.red"));
        methods.waitBySeconds(2);
        methods.click(By.id("button-checkout-continue"));
        //methods.waitBySeconds(2);
//        methods.sendKeys(By.id("address-firstname-companyname"), "talha");
//        methods.waitBySeconds(2);
//        methods.sendKeys(By.id("address-lastname-title"), "cavus");
//        methods.waitBySeconds(2);
//        methods.selectByText(By.id("address-zone-id"),"Adana");
//        methods.waitBySeconds(2);
//        methods.selectByText(By.id("address-county-id"),"CEYHAN");
//        methods.waitBySeconds(2);
//        methods.sendKeys(By.id("address-address-text"), "abc");
//        methods.waitBySeconds(2);
//        methods.sendKeys(By.id("address-telephone"), "5533397272");
//        methods.waitBySeconds(2);
        methods.click(By.id("button-checkout-continue"));
        //methods.waitBySeconds(2);
        methods.sendKeys(By.cssSelector("#credit-card-owner"),"DenemeAd DenemeSoyad");
        //methods.waitBySeconds(1);
        methods.sendKeys(By.cssSelector("#credit_card_number_1"),"1234");
        methods.sendKeys(By.cssSelector("#credit_card_number_2"),"1234");
        methods.sendKeys(By.cssSelector("#credit_card_number_3"),"1234");
        methods.sendKeys(By.cssSelector("#credit_card_number_4"),"1234");
        //methods.waitBySeconds(1);
        methods.selectByValue(By.cssSelector("#credit-card-expire-date-month"),"01");
        methods.selectByValue(By.cssSelector("#credit-card-expire-date-year"),"2024");
        //methods.waitBySeconds(1);
        methods.sendKeys(By.cssSelector("#credit-card-security-code"),"123");
        methods.click(By.cssSelector("#button-checkout-continue"));
        //methods.waitBySeconds(1);
        String errorText = methods.getText(By.cssSelector("#form-credit-card > div.credit-card-form-content > table > tbody > tr:nth-child(5) > td > span"));
        if(errorText!=null){
            System.out.println(errorText);
            methods.click(By.cssSelector("#logo > a > img"));//Homepage
            //Logout
            methods.scrollWithAction(By.cssSelector("#header-top > div > div.welcome.fl > div.menu.top.login > ul > li > a"));
            methods.clickJS(By.cssSelector("#header-top > div > div.welcome.fl > div.menu.top.login > ul > li > div > ul > li:nth-child(4) > a"));
        } else if (errorText==null){
            System.out.println("Satın alma işlemi gerçekleşiyor.");
        }
        //methods.waitBySeconds(3);


    }

    public void favoriteDelete(){
        methods.click(By.xpath("//*[@id=\"header-top\"]/div/div[2]/ul/li[1]/div/ul/li/a"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/favorite&selected_tags=0']"));
        methods.waitBySeconds(2);

    }










}
