package onlineStore.tests

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import onlineStore.elements.AddressForm
import onlineStore.pages.CheckoutPage
import onlineStore.steps.AddToCartSteps
import onlineStore.steps.ConfirmOrderSteps
import org.testng.annotations.Test

class ProductOrder {
    @Test(invocationCount = 5, threadPoolSize = 5)
    void testProductOrder() {
        Selenide.open("http://litecart.stqa.ru/en/")
        AddToCartSteps.addRandomProductToCart()
        AddressForm.fillAddressForm("firstname", "1")
        AddressForm.fillAddressForm("lastname", "2")
        AddressForm.fillAddressForm("address1", "4")
        AddressForm.fillAddressForm("postcode", "420066")
        AddressForm.fillAddressForm("city", "Midnight")
        AddressForm.fillAddressForm("phone", "+78005556565")
        AddressForm.fillAddressForm("email", "xxx@xx.ru")
        CheckoutPage.getSaveChangeButton().shouldNotHave(Condition.disabled).click()
        ConfirmOrderSteps.fillComment("Вырази ложную мысль ясно, и она сама себя опровергнет")
        ConfirmOrderSteps.confirmOrder()
        ConfirmOrderSteps.checkIsSuccessOrder()
    }
}

