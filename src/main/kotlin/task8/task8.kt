package taskEight


fun main(args: Array<String>) {

    //-------------------------------- Task 8.1 ----------------------------------------------

    //  ������������ ������ � ���������� ��� �����, ���� �������� (+,-,* ��� /)
    // � ��������� ��� ������� ��������� ��������.
    println("Enter two number and operator +-*/: ")
    val (a, b, c) = readLine()!!.split(" ")
    if (a <= "9" || b <= "9") {
        when (c) {
            "+" -> println("$a + $b = ${a.toInt() + b.toInt()}")
            "-" -> println("$a - $b = ${a.toInt() - b.toInt()}")
            "*" -> println("$a * $b = ${a.toInt() * b.toInt()}")
            "/" -> println("$a / $b = ${a.toInt() / b.toInt()}")
            else -> println("Enter correct symbol")
        }
    } else {
        println("Please enter correct number")
    }




    //-------------------------------- Task 8.2 ----------------------------------------------
//    ��� ������ words ���������� null � �������� ���� String.
//    ������� �� ����� ��������� ������ ������ �������, ������������ � ������� ������� � �������������� �������� �� null:
//    - ��������� �������� if
//    - ��������� �������� ����������� ������ ?
//    - ��������� ������� let
//    - ��������� �����-�������� ?: ������ �������� �� ��������� ��� null �������� = �empty�

    val words = listOf<String?>("One", "Two", "Three", "Four", "Five", null)

    println("\n ------------------------- with \"if\" statement-----------------------------------\n")

    for (element in words) {
        if (element != null) print("${element.uppercase()} ")
    }

    println("\n ------------------------- with \"?\" safety calls-----------------------------------\n")

    for (element in words)  print("${element?.uppercase()} ")

    println("\n ------------------------- with function \"let\"-----------------------------------\n")

    for (element in words) {
        element?.let {print("${it.uppercase()} ")}
    }

    println("\n ------------------------- with \"elvis operator\"-----------------------------------\n")

    for (element in words)  print("${element?.uppercase() ?: "empty"} ")

}



