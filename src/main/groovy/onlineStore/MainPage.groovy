package onlineStore

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$

class MainPage {
    static SelenideElement getProduct() {
        $(".product")
    }
}
