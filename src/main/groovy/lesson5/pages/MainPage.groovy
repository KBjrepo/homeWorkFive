package lesson5.pages

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$

class MainPage {
    static SelenideElement getProduct() {
        $(".product")
    }

    static SelenideElement getCartButton() {
        $("#cart")
    }
}
