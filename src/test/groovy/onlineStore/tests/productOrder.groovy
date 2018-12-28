package onlineStore.tests

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import org.junit.Test

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$x

class productOrder {
    @Test
    void testProductOrder() {
        Selenide.open("http://litecart.stqa.ru/en/")

        getProduct().shouldBe(Condition.visible).click()

        getProductPrice().shouldBe(Condition.visible)
        def currentPrice = getProductPrice().text

        if (getProductSize().exists()) {
            productSize.selectOptionContainingText("Small")
        }

        getAddToCartButton()
        addToCartButton.click()

        getProductQuantity().shouldHave(Condition.exactText("1"))

        getCartButton()
        cartButton.click()

        getProductPriceInCart().shouldBe(Condition.visible)
        def cartPrice = productPriceInCart.text
        assert currentPrice == cartPrice

        fillAddressForm("firstname", "1")
        fillAddressForm("lastname", "2")
        fillAddressForm("address1", "4")
        fillAddressForm("postcode", "420066")
        fillAddressForm("city", "Midnight")
        fillAddressForm("phone", "+78005556565")
        fillAddressForm("email", "xxx@xx.ru")

        getSaveChangeButton().shouldNotHave(Condition.disabled).click()

        getCommentsField().value = "Вырази ложную мысль ясно, и она сама себя опровергнет"

        getConfirmOrderButton().shouldNotHave(Condition.disabled).scrollTo().click()

        getSuccessMessage().shouldBe(Condition.visible)
    }

    public SelenideElement getSuccessMessage() {
        $("#box-order-success")
    }

    public SelenideElement getConfirmOrderButton() {
        $x("//button[@name=\"confirm_order\"]")
    }

    public SelenideElement getCommentsField() {
        $("[name='comments']")
    }

    public SelenideElement getSaveChangeButton() {
        $(".billing-address button")
    }

    SelenideElement getProductPriceInCart() {
        return $x("//div/p[last()-2]")
    }

    public SelenideElement getCartButton() {
        $("#cart")
    }

    public SelenideElement getProductQuantity() {
        $("#cart .quantity")
    }

    public SelenideElement getAddToCartButton() {
        $("[name='buy_now_form'] button")
    }

    public SelenideElement getProductSize() {
        $x("//select[@name = 'options[Size]']")
    }

    SelenideElement getProductPrice() {
        $("[itemprop='price']")
    }

    SelenideElement getProduct() {
        $(".product")
    }

    static fillAddressForm(String fieldname, fieldValue) {
        def billingAddress = $(".billing-address")
        def addressField = billingAddress.$x(".//input[@name = '$fieldname']")
        addressField.value = fieldValue

    }
}
