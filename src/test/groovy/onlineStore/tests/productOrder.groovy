package onlineStore.tests

import com.codeborne.selenide.Selenide
import org.junit.Test
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$$
import static com.codeborne.selenide.Selenide.$$x

class productOrder {
    @Test
    public void testProductOrder() {
        Selenide.open("http://litecart.stqa.ru/en/")

        def product = $(".product")

        product.click()

        def productPrice = $$x("//span[contains(@class,'price')][contains(@itemprop,'price')]")

        def orderPrice = orderPrice + productPrice.getValue()

        
    }
}
