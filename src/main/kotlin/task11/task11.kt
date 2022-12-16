package taskEleven

fun main(args: Array<String>) {

//    11. ��������� ���� ��� ������

//    1. ������� ���������� fahrenheit � ��������� �� ������-���������, ������� � �������� ��������� ���������
//    ���������� ���� Int (����������� �� �������), � ���� ��������������� ��� ���������� � ����������� �� ����� ���������� � ���������� ��.
//    ������� �� ����� ���������� �����������.
//    ������� ��������������: (0 �C ? 9/5) + 32 = 32 �F

    val fahrenheit: (Int) -> Double = { c -> (( c.toDouble() * 9/5) + 32) }
    println("Celsius to fahrenheit equal: ${fahrenheit(11)}")

//    2. ������� ���������� concat � ��������� �� ������-���������, ������� � �������� ��������� ��������� ��������� ���������� (�� ����� ����) ���� String,
//    � ���� ��������������� �� � ���� ������, � ������� �����������(�� ���������� �������� � �����) � ������� �� �����.

    val concat: (String, String, String) -> Unit = { a, b, c ->
        val result =  mutableListOf(a, b, c)

            .sortedBy { it.length }
            .joinToString(separator = "")
        println(result)
    }
    concat("Strike", "Hit", "Punch")

//    3. ������� ������� ������� ������� , ������� � �������� ���������� ����� ��������� ������ message:String � ������-��������� convert:(String) ->String.
//    � ���� ������� ��������� ����������� (����� ������) ����� ���������� message,  ������� �� �� ����� � ������� ��� ��������� ����������.
//    ������� ���� ������� ������� ������� � �������� ������ (���������: https://fishtext.ru/index.php), � � ������ ����������� ������ ���� �������� �,� �� ����� � ����.

    fun fishText( message: String, convert:(String) -> String): String {
        val result = convert(message)
        println("Message: $message has bin converted to: $result")
        return result
    }

    val messageString = """
        �� �������, ������ ��������, ��� ����������� ��������� ����������� ��������� ��������� ������
        ������� �� ���������� ����� �����������. ������ �����������, � ����������� �� ���������� ����������
        �������� ������� ������� �� ��� ������� ���������� ����������� ��������. � ������ ������� ������������
        � ������� ������� ������ �� ����� ������� ��������� � ������������ ����� �����������. ������ ������� ������
        ������������ ������ �� ������������ ������� ������������ ���������� � ���������� ������ ��������� �������.
        """

    fishText( messageString) {
        it.replace(
            ",",
            " ����",
            ignoreCase = false
        )
    }

    // 4.
    val stringForMethodParse = "abxbbznmfkYyyxX"

    messageParse(stringForMethodParse,
        eventX = { println("��������� ������ x") },
        eventY = { println("��������� ������ y") },
        eventZ = { println("��������� ������ z") }
    )

    // 5.
    val messageRick = "aWjsdhwdSdkw"
    val ufo = Ufo(0,0)
    println(ufo)

    messageParse1(messageRick,
        eventUp = {num: Int -> println("����������� ������� ���� ����� $num") },
        eventDown = {num: Int -> println("����������� ������� ���� ���� $num") },
        eventLeft = {num: Int -> println("����������� ������� ���� ����� $num") },
        eventRight = {num: Int -> println("����������� ������� ���� ������ $num") })

    ufo.move2(Commands.Up(1))
    println(ufo)

}

//       4. �� ��������� main() ������� �������
//    messageParse(message:String, eventX:( ) -> Unit, eventY:( ) -> Unit, eventZ:( ) -> Unit)
//    ������� ��������� � �������� ��������� ������. ������� ������ ���������� ������ �����������
//    � ���� ������ ����� �x�,�y� ��� �z�, �� �������������� ������ ���������� eventX(),eventY() ��� eventZ().
//    ������� �� ���������.
//       � main() ������� ���� ������� messageParse() �������� ������ �abxbbznmfkYyyxX� � � ������� ������� ������� ���������,
//    �������� �� ����� ��������� ���������� ������ x�, �y�, �z� ��������������.


fun messageParse(message:String, eventX:( ) -> Unit, eventY:( ) -> Unit, eventZ:( ) -> Unit) {

    message.lowercase().forEach {
        when (it) {
            'x' -> eventX()
            'y' -> eventY()
            'z' -> eventZ()
        }
    }
}

//    5. ���������� ������ � ������� Point ��������� �����  messageParse() �� ����������� ������� � ������� ��� �������.
//    ����� messageParse(encryptedMessage:String,
//    eventUp:( Int ) -> Unit, eventDown:( Int ) -> Unit, eventLeft:( Int ) -> Unit, eventRight:( Int ) -> Unit)
//    ����� ��������� ������������� ��������� �� ���� ������� �� ��������� ������,
//    � �������� �������������� ������ ����������� �������� ������� �� ��� ���������.
//    ������� ���������� ���������:
//    - ������ �a�- ����� �� 1 ���
//    - ������ ���- ����� �� 2 ���
//    - ������� �d� � �D� - ������ ��������������
//    - ������� �w� � �W� - ����� ��������������
//    - ������� �s� � �S� - ���� ��������������

//    ������� sealed ����� Command, ������� �������� ������ data ������: Up(), Down(), Right(), Left().
//    ��� ��������� ������ �������� ���� step:Int - ���������� ����� �� ���.

//    ������� ����� Ufo � ������� ����� ��� ���������� ��������, ���������� x � y.
//    � ������ Ufo:
//    - �������������� ����� toString(), ������� ����� ���������� ������� ��������� �������� �������
//    - ������� �����  move() ������� ����� ��������� � �������� ��������� ������ ������ Command �
//    � ����������� �� ���������� ���� �������� ���������� �������.
//    ����� ����� ������ �������� � �������  �����, ��������: �������� ���� ���������� ����� �� 2�
//    � main():
//    - ���������������� ������ Ufo � ���������� ������������ (0,0)
//    - ��������� ����������� ���������, � � ������� ������� ������� ��������� - ����������� ������� ����.
//    ����� ������ �������� ����������� �������� � ������� ������� ��������� �������.


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
        return "������� ��������� �������� ������� x: $x, y: $y"
    }

    fun move2(commands: Commands) {
        when (commands) {
            is Commands.Up -> {  commands.step = x
                println("������� ���� ���������� ����� �� $x")}
            is Commands.Down -> { x = commands.step
                println("������� ���� ���������� ���� �� $x")}
            is Commands.Left -> { y = commands.step
                println("������� ���� ���������� ����� �� $y")}
            is Commands.Right -> { y = commands.step
                println("������� ���� ���������� ������ �� $y")}
        }
    }

}
