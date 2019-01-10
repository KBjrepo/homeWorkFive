package onlineStore.steps

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import onlineStore.pages.CheckoutPage
import onlineStore.pages.MainPage
import onlineStore.pages.ProductPage

class AddToCartSteps {
    @Step
    static addRandomProductToCart() {
        MainPage.getProduct().shouldBe(Condition.visible).click()

        ProductPage.getProductPrice().shouldBe(Condition.visible)
        def currentPrice = ProductPage.getProductPrice().text

        if (ProductPage.getProductSize().exists()) {
            ProductPage.productSize.selectOptionContainingText("Small")
        }

        ProductPage.getAddToCartButton()
        ProductPage.addToCartButton.click()

        ProductPage.getProductQuantity().shouldHave(Condition.exactText("1"))

        MainPage.getCartButton()
        MainPage.cartButton.click()

        CheckoutPage.getProductPriceInCart().shouldBe(Condition.visible)
        def cartPrice = CheckoutPage.productPriceInCart.text
        assert currentPrice == cartPrice
    }
}
