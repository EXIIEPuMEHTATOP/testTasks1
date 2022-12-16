package taskOne

fun main(args: Array<String>) {

    someDigit()
    firstLastNum()
    untilZero()
    manyOrFew()

}


//--------------------------------task 1.1.1---------------------------------------------------
// ѕользователь вводит целое положительное число, вывести на экран сумму первой и последней цифры введенного числа.
// »спользовать ввод с клавиатуры readline().
// преобразовать строку в число использу€ toInt(), и отдел€ть цифры использу€ деление на 10
// с остатком У%Ф и без остатка У/Ф

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
// ѕолучить 1-й символ строки использу€ функцию first() и последний с помощью last().

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
//  ѕользователь вводит с клавиатуры поочередно любые числа (подтвержда€ ввод каждого нажатием УEnterФ),
// до тех пор пока не будет введено число У0Ф. ѕосле ввода нул€ необходимо вывести на экран количество
// введенных чисел, их общую сумму и среднее арифметическое.
// »спользовать ввод с клавиатуры readline().


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
//  ѕрограмма У”гадай числоФ. ќтгадать целое число которое УзагадалФ компьютер. ѕрограмма генерирует
// рандомное число A (используем (0..10).random()), пользователь вводит свой вариант-число B.
// ≈сли число ¬>A выводим сообщение УћногоФ и повтор€ем ввод, если ¬<ј выводим сообщение
// УћалоФи повтор€ем ввод, иначе У”гадалФ.


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

