package lesson5.elements


import static com.codeborne.selenide.Selenide.$

class AddressForm {
    static fillAddressForm(String fieldName, fieldValue) {
        def billingAddress = $(".billing-address")
        def addressField = billingAddress.$x(".//input[@name = '$fieldName']")
        addressField.value = fieldValue
    }
}
