package taskEleven

fun main(args: Array<String>) {

//    11. Обработка кода как данных

//    1. Создать переменную fahrenheit и присвоить ей лямбда-выражение, которое в качестве параметра принимает
//    переменную типа Int (температура по Цельсию), а тело преобразовывает эту переменную в температуру по шкале Фаренгейта и возвращает ее.
//    Вывести на экран результаты конвертации.
//    Формула преобразования: (0 °C ? 9/5) + 32 = 32 °F

    val fahrenheit: (Int) -> Double = { c -> (( c.toDouble() * 9/5) + 32) }
    println("Celsius to fahrenheit equal: ${fahrenheit(11)}")

//    2. Создать переменную concat и присвоить ей лямбда-выражение, которое в качестве параметра принимает несколько переменных (не менее трех) типа String,
//    а тело преобразовывает их в одну строку, в порядке возрастания(по количеству символов в слове) и выводит на экран.

    val concat: (String, String, String) -> Unit = { a, b, c ->
        val result =  mutableListOf(a, b, c)

            .sortedBy { it.length }
            .joinToString(separator = "")
        println(result)
    }
    concat("Strike", "Hit", "Punch")

//    3. Создать функцию высшего порядка , которая в качестве параметров будет принимать строку message:String и лямбда-выражение convert:(String) ->String.
//    В теле функции выполнить конвертацию (вызов лямбды) нашей переменной message,  вывести ее на экран и вернуть как результат выполнения.
//    Вызвать нашу функцию высшего порядка и передать строку (Рыбатекст: https://fishtext.ru/index.php), а в лямбде реализовать замену всех символов “,” на слово “ блин”.

    fun fishText( message: String, convert:(String) -> String): String {
        val result = convert(message)
        println("Message: $message has bin converted to: $result")
        return result
    }

    val messageString = """
        Не следует, однако забывать, что сложившаяся структура организации позволяет выполнять важные
        задания по разработке новых предложений. Задача организации, в особенности же реализация намеченных
        плановых заданий требуют от нас анализа дальнейших направлений развития. С другой стороны консультация
        с широким активом влечет за собой процесс внедрения и модернизации новых предложений. Равным образом начало
        повседневной работы по формированию позиции способствует подготовки и реализации систем массового участия.
        """

    fishText( messageString) {
        it.replace(
            ",",
            " блин",
            ignoreCase = false
        )
    }

    // 4.
    val stringForMethodParse = "abxbbznmfkYyyxX"

    messageParse(stringForMethodParse,
        eventX = { println("обнаружен символ x") },
        eventY = { println("обнаружен символ y") },
        eventZ = { println("обнаружен символ z") }
    )

    // 5.
    val messageRick = "aWjsdhwdSdkw"
    val ufo = Ufo(0,0)
    println(ufo)

    messageParse1(messageRick,
        eventUp = {num: Int -> println("Перемещение тарелки Рика вверх $num") },
        eventDown = {num: Int -> println("Перемещение тарелки Рика вниз $num") },
        eventLeft = {num: Int -> println("Перемещение тарелки Рика влево $num") },
        eventRight = {num: Int -> println("Перемещение тарелки Рика вправо $num") })

    ufo.move2(Commands.Up(1))
    println(ufo)

}

//       4. За пределами main() описать функцию
//    messageParse(message:String, eventX:( ) -> Unit, eventY:( ) -> Unit, eventZ:( ) -> Unit)
//    который принимает в качестве параметра строку. Функция должна перебирать строку посимвольно
//    и если символ равен ‘x’,’y’ или ‘z’, то соответственно должны вызываться eventX(),eventY() или eventZ().
//    Регистр не учитывать.
//       В main() вызвать нашу функцию messageParse() передать строку “abxbbznmfkYyyxX” а в лямбдах событий сделать обработку,
//    выводить на экран сообщение “обнаружен символ x”, “y”, ”z” соответственно.


fun messageParse(message:String, eventX:( ) -> Unit, eventY:( ) -> Unit, eventZ:( ) -> Unit) {

    message.lowercase().forEach {
        when (it) {
            'x' -> eventX()
            'y' -> eventY()
            'z' -> eventZ()
        }
    }
}

//    5. Переделаем задачу с точками Point используя метод  messageParse() из предыдущего задания и немного его изменим.
//    Метод messageParse(encryptedMessage:String,
//    eventUp:( Int ) -> Unit, eventDown:( Int ) -> Unit, eventLeft:( Int ) -> Unit, eventRight:( Int ) -> Unit)
//    будет принимать зашифрованное сообщение от Рика Санчеса из измерения Дупиду,
//    и согласно расшифрованных данных передвигать летающую тарелку по оси координат.
//    Правила дешифровки сообщения:
//    - символ ‘a’- влево на 1 шаг
//    - символ ‘А’- влево на 2 шаг
//    - символы ‘d’ и ‘D’ - вправо соответственно
//    - символы ‘w’ и ‘W’ - вверх соответственно
//    - символы ‘s’ и ‘S’ - вниз соответственно

//    Создать sealed класс Command, который содержит четыре data класса: Up(), Down(), Right(), Left().
//    Эти вложенные классы содержат поле step:Int - количество шагов по оси.

//    Создать класс Ufo в котором будет два изменяемых свойства, координаты x и y.
//    В классе Ufo:
//    - переопределить метод toString(), который будет возвращать текущее положение летающей тарелки
//    - создать метод  move() который будет принимать в качестве параметра объект класса Command и
//    в зависимости от вложенного типа изменять координаты тарелки.
//    Также метод должен выводить в консоль  текст, например: “Тарелка Рика сместилась влево на 2”
//    в main():
//    - инициализировать объект Ufo с начальными координатами (0,0)
//    - запустить расшифровку сообщения, а в лямбдах событий сделать обработку - перемещение тарелки Рика.
//    После каждой операции перемещения выводить в консоль текущее положение тарелки.


fun messageParse1(encryptedMessage:String,
                  eventUp:( Int ) -> Unit,
                  eventDown:( Int ) -> Unit,
                  eventLeft:( Int ) -> Unit,
                  eventRight:( Int ) -> Unit) {

    encryptedMessage.forEach {
        when (it) {
            'a' -> { eventLeft(-1) }
            'A' -> { eventLeft(-2) }
            'd' -> { eventRight(1) }
            'D' -> { eventRight(2) }
            'w' -> { eventUp(1) }
            'W' -> { eventUp(2) }
            's' -> { eventDown(-1) }
            'S' -> { eventDown(-2) }
        }
    }
}

sealed class Commands {
    data class Up(var step: Int = 0) : Commands()
    data class Down(var step: Int = 0): Commands()
    data class Right(var step: Int = 0): Commands()
    data class Left(var step: Int = 0): Commands()
}

class Ufo(var x: Int, var y: Int) {

    override fun toString(): String {
        return "Текущее положение летающей тарелки x: $x, y: $y"
    }

    fun move2(commands: Commands) {
        when (commands) {
            is Commands.Up -> {  commands.step = x
                println("Тарелка Рика сместилась вверх на $x")}
            is Commands.Down -> { x = commands.step
                println("Тарелка Рика сместилась вниз на $x")}
            is Commands.Left -> { y = commands.step
                println("Тарелка Рика сместилась влево на $y")}
            is Commands.Right -> { y = commands.step
                println("Тарелка Рика сместилась вправо на $y")}
        }
    }

}
