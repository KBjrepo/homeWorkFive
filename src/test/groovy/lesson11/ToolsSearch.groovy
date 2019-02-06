package lesson11


import groovy.util.logging.Slf4j
import org.testng.annotations.Test
import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$$

@Slf4j
class ToolsSearch extends BaseTest {


    @Test
    void toolsSearchTest() {
        findTool("Gradle")
        findTool("Groovy")
        findTool("TestNG")
    }

    void findTool(String toolRequest) {
        log.info("Поиск" + toolRequest)
        responseUrlList(toolRequest)
    }

    static String responseUrlList(String textRequest) {
        def searchField = $("#text")
        searchField.value = textRequest
        def urlList = $$("a[href^=\"http\"]").value
        println(urlList)
    }

}
