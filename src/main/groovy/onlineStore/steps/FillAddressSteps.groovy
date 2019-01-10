package onlineStore.steps

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import onlineStore.elements.AddressForm
import onlineStore.pages.CheckoutPage

class FillAddressSteps {
    @Step
    static void fillAddress() {
        AddressForm.fillAddressForm("firstname", "1")
        AddressForm.fillAddressForm("lastname", "2")
        AddressForm.fillAddressForm("address1", "4")
        AddressForm.fillAddressForm("postcode", "420066")
        AddressForm.fillAddressForm("city", "Midnight")
        AddressForm.fillAddressForm("phone", "+78005556565")
        AddressForm.fillAddressForm("email", "xxx@xx.ru")
        CheckoutPage.getSaveChangeButton().shouldNotHave(Condition.disabled).click()
    }
}