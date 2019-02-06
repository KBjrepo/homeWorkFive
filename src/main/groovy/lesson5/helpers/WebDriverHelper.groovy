package lesson5.helpers

import org.awaitility.Awaitility
import org.awaitility.Duration

import java.util.concurrent.TimeUnit

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

class WebDriverHelper {
    public waitJS() {
        Awaitility.await().
                atMost(new Duration(30, TimeUnit.SECONDS)). //таймаут в 30 секунд
                pollInterval(Duration.FIVE_SECONDS). //проверяем каждые 5 секунд
                pollInSameThread(). //проверяем в том же потоке, что и вызвали Awaitility.await()
                ignoreExceptions(). //игнорируем все исключения, кроме AssertionError
                untilAsserted({ //ждем, что ассерт не выкинет исключение AssertionError
                    assertThat(
                            "Неправильный поисковый запрос", //сообщение об ошибке в случае таймаута
                            SearchSteps.getCurrentSearchRequest(), //вызов метода, который возвращает реальный результат
                            equalTo("котики"))
                    //инструкция по проверке - актуальный результат должен быть равен "котики"
                })
    }
}
