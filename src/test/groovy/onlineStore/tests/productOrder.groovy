package onlineStore.tests


import com.codeborne.selenide.Selenide
import onlineStore.steps.AddToCartSteps
import onlineStore.steps.ConfirmOrderSteps
import onlineStore.steps.FillAddressSteps
import org.junit.Test

class productOrder {
    @Test
    void testProductOrder() {
        Selenide.open("http://litecart.stqa.ru/en/")
        AddToCartSteps.addRandomProductToCart()
        FillAddressSteps.fillAddress()
        ConfirmOrderSteps.fillComment()
        ConfirmOrderSteps.confirmOrder()
    }
}

