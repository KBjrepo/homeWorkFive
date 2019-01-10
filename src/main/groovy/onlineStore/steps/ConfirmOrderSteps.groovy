package onlineStore.steps

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import onlineStore.pages.CheckoutPage

class ConfirmOrderSteps {
    @Step
    static confirmOrder() {
        CheckoutPage.getConfirmOrderButton().shouldNotHave(Condition.disabled).scrollTo().click()
        CheckoutPage.getSuccessMessage().shouldBe(Condition.visible)
    }

    @Step
    static fillComment() {
        CheckoutPage.getCommentsField().value = "Вырази ложную мысль ясно, и она сама себя опровергнет"
    }
}
