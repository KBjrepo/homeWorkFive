package onlineStore.tests


import com.codeborne.selenide.Selenide
import org.junit.Test

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$x

class productOrder {
    @Test
    public void testProductOrder() {
        Selenide.open("http://litecart.stqa.ru/en/")


        def product = $(".product")
        product.shouldBe(com.codeborne.selenide.Condition.visible)
        product.click()

        $("[itemprop='price']").shouldBe(com.codeborne.selenide.Condition.visible)
        def currentPrice = $("[itemprop='price']").text

        if ($x("//select[@name = 'options[Size]']").exists()) {
            def productSize = $x("//select[@name = 'options[Size]']")
            productSize.selectOptionContainingText("Small")
        }

        def addToCartButton = $("[name='buy_now_form'] button")
        addToCartButton.click()

        $("#cart .quantity").shouldHave(com.codeborne.selenide.Condition.exactText("1"))

        def cart = $("#cart")
        cart.click()

        def cartPrice = $("[name='cart_form'] div p:nth-of-type(2)")
        cartPrice.shouldBe(com.codeborne.selenide.Condition.visible)
        assert currentPrice == cartPrice.text

        fillAddressForm("firstname", "1")
        fillAddressForm("lastname", "2")
        fillAddressForm("address1", "4")
        fillAddressForm("postcode", "420066")
        fillAddressForm("city", "Midnight")
        fillAddressForm("phone", "88005556565")

        def confirmButton = $x("//button[@name='confirm_order']")
        confirmButton.shouldBe(com.codeborne.selenide.Condition.visible)
        confirmButton.click()

        def successMessage = $("#box-order-success")
        successMessage.shouldBe(com.codeborne.selenide.Condition.visible)
    }

    static fillAddressForm(String fieldname, fieldValue) {
        def billingAddress = $(".billing-address")
        def addressField = billingAddress.$x(".//input[@name = '$fieldname']")
        addressField.value = fieldValue
    }
}
