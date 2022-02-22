package com.selenium.test;

import com.selenium.driver.BaseTest;
import com.selenium.page.ProductPage;
import org.junit.Test;

public class ProductTest extends BaseTest {


    @Test
    public void productTest(){
        ProductPage productPage = new ProductPage();
        productPage.loginControl();
        productPage.searchingElement();
        productPage.sepet();
    }


}
