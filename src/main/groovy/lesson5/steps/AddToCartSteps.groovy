package lesson5.steps

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import lesson5.pages.CheckoutPage
import lesson5.pages.MainPage
import lesson5.pages.ProductPage

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
