package onlineStore.steps

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import onlineStore.helpers.WebDriverHelper
import onlineStore.pages.CheckoutPage

class ConfirmOrderSteps {
    @Step
    static confirmOrder() {
        WebDriverHelper.waitJS()
        CheckoutPage.getConfirmOrderButton().waitUntil(Condition.enabled, 60000)
        CheckoutPage.getConfirmOrderButton().scrollIntoView(true).click()
    }

    @Step
    static checkIsSuccessOrder() {
        WebDriverHelper.waitJS()
        CheckoutPage.getSuccessMessage().waitUntil(Condition.visible, 60000)
    }

    @Step
    static fillComment(String comment) {
        WebDriverHelper.waitJS()
        CheckoutPage.getCommentsField().value = comment
    }
}
