package lesson5.pages

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$x

class ProductPage {
    static SelenideElement getProductSize() {
        $x("//select[@name = 'options[Size]']")
    }

    static SelenideElement getProductPrice() {
        $("[itemprop='price']")
    }

    static SelenideElement getProductQuantity() {
        $("#cart .quantity")
    }

    static SelenideElement getAddToCartButton() {
        $("[name='buy_now_form'] button")
    }
}
