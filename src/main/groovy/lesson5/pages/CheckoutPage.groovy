package lesson5.pages

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$x

class CheckoutPage {
    static getSuccessMessage() {
        $("#box-order-success")
    }

    static getConfirmOrderButton() {
        $x("//button[@name=\"confirm_order\"]")
    }

    static getCommentsField() {
        $("[name='comments']")
    }

    static getSaveChangeButton() {
        $(".billing-address button")
    }

    static getProductPriceInCart() {
        return $x("//div/p[last()-2]")
    }
}
