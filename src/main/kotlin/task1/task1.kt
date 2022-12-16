package taskOne

fun main(args: Array<String>) {

    someDigit()
    firstLastNum()
    untilZero()
    manyOrFew()

}


//--------------------------------task 1.1.1---------------------------------------------------
// ������������ ������ ����� ������������� �����, ������� �� ����� ����� ������ � ��������� ����� ���������� �����.
// ������������ ���� � ���������� readline().
// ������������� ������ � ����� ��������� toInt(), � �������� ����� ��������� ������� �� 10
// � �������� �%� � ��� ������� �/�

fun someDigit() {
    var falseTrue = false
    var input: Int
    var firstNum = ""
    var lastNum = ""

    while (!falseTrue) {
        print("Enter any number: ")
        val number = readLine()
        if (number != null) {
            falseTrue = true
            input = number.toInt()
            lastNum = (input % 10).toString()
            while (input >= 10) {
                input /= 10
                firstNum = input.toString()
            }
        }
    }
    println("Result: ${firstNum + lastNum}")
}



//-----------------------------------task 1.1.2------------------------------------------------
// �������� 1-� ������ ������ ��������� ������� first() � ��������� � ������� last().

fun firstLastNum() {
    var firstNum = ""
    var lastnum = ""

    println("Enter something: ")
    val number = readLine()
    firstNum = number!!.first().toString()
    lastnum = number.last().toString()
    println("Sum of the first and last digits is: ${firstNum.toInt() + lastnum.toInt()}")

}


//---------------------------------------------task 1.2--------------------------------------
//  ������������ ������ � ���������� ���������� ����� ����� (����������� ���� ������� �������� �Enter�),
// �� ��� ��� ���� �� ����� ������� ����� �0�. ����� ����� ���� ���������� ������� �� ����� ����������
// ��������� �����, �� ����� ����� � ������� ��������������.
// ������������ ���� � ���������� readline().


fun untilZero() {
    var sum = 0
    var count = 0
    var average = 0
    var number: Int

    while (true) {
        print("Enter a number: ")
        number = readLine()!!.toInt()
        if (number == 0)
            break
        sum += number
        count += 1
        average = sum / count
    }
    print("Total entered digits = $count, total amount = $sum, average = $average")
}


//-------------------------------------------------Task 1.3----------------------------------
//  ��������� ������� �����. �������� ����� ����� ������� �������� ���������. ��������� ����������
// ��������� ����� A (���������� (0..10).random()), ������������ ������ ���� �������-����� B.
// ���� ����� �>A ������� ��������� ������ � ��������� ����, ���� �<� ������� ���������
// ������ ��������� ����, ����� �������.


fun manyOrFew() {
    val randomCPU = (0..10).random()

    while (true) {
        println("Enter your number: ")
        val number = readLine()!!.toInt()
        if (number < 10) {
            if (number < randomCPU) {
                println("It's too little")
            } else if (number > randomCPU) {
                println("It's a lot")
            } else {
                println("You guessed")
                break
            }
        } else {
            println("Please enter correct number")
        }

    }
}

