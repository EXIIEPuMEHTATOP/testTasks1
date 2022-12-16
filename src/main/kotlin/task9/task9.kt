package taskNine

fun main(args: Array<String>) {

    //-------------------------------- Task 9.1 ----------------------------------------------
    // Дан список с числами. Выделить все отрицательные элементы в новый список.
    // Использовать функцию filter{}

    val someListOf = listOf(1, 2, -2, 5, 9, -5)
    val newListOf = someListOf.filter { it < 0 }
    println("newListOf equals: $newListOf")

    //-------------------------------- Task 9.2 ----------------------------------------------
    // Дан список с числами. Изменить знак для всех положительных элементов списка.
    val someListOf2 = mutableListOf(2, -2, 3, -4, 6, -5)
    for (i in 0 until someListOf2.size) {
        if (someListOf2[i] > 0) {
            someListOf2[i] = -someListOf2[i]
        }
    }
    println("This list someListOf2 negative numbers: $someListOf2")
    //-------------------------------- Task 9.3 ----------------------------------------------
    // Дан список с числами. Сформировать новый список их квадратов.  Использовать функцию  map{}
    val listOfNumbers = listOf(2, 3, 7, -6, 9)
    val listOfNumbersSqr = listOfNumbers.map { it * it }
    println("List of number in a square: $listOfNumbersSqr")

    //-------------------------------- Task 9.4 ----------------------------------------------
    // Дан список с числами (1,2,3,4,5,6,7).При инициализации списка использовать IntRange.
    // Вывести на экран список по примеру “=1+2+3+4+5+6+7=”.
    // Использовать функцию joinToString().
    val someListNumbers = listOf<IntRange>(1..7)
    for (i in someListNumbers) println(i.joinToString(prefix = "\"=", postfix = "=\"", separator = "+"))

    //-------------------------------- Task 9.5 ----------------------------------------------
    // Дан набор phoneBook содержащий пары “имя”-”номер телефона”.
    // Оставить только те пары, для которых “номер телефона” начинается с заданного кода страны countryCode.
    val someSetNumber = mutableSetOf(
        "John" to "+375234444",
        "Bob" to "+375252525",
        "Mary" to "+375252526",
        "Anna" to "+358252525",
        "Boris" to "+852252525",
        "Jak" to "+352252525")
    val countryCode = "+375"

    someSetNumber.removeIf { it.second.take(4) != countryCode}
    // ConcurrentModificationException
    println("someSetNumber: $someSetNumber")


    //-------------------------------- Task 9.6 ----------------------------------------------
    // Пользователь в консоль вводит число в диапазоне 0..100, вывести число прописью.
    // Например вводим 27, вывод в консоль “двадцать семь”

    val oneToNineteen = listOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine","ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen" ,"seventeen", "eighteen", "nineteen")
    val toNinety = listOf("", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

    fun getUserChoiceRange() {
        var isValidChoice = false
        var str = ""

        while (!isValidChoice) {
            println("Enter number:")
            val num = readLine()!!.toInt()
            if (num in 0..100) {
                isValidChoice = true
                when (num) {
                    in 1..19 -> str += oneToNineteen[num]
                    in 20..99 -> str += toNinety[num / 10] +" "+ oneToNineteen[num % 10]
                    0 -> println("zero")
                    else -> println("hundred")
                }
            }
            if (!isValidChoice) println("You must enter a valid choice")
        }
        println("result: $str")
    }
    getUserChoiceRange()

    //-------------------------------- Task 9.7 ----------------------------------------------
    // Время дано строкой “01:20:12”, содержащей часы, минуты и секунды, разделенные двоеточием.
    // Разобрать строку и рассчитать количество секунд прошедших с начала дня.
    // Использовать функцию split()

    val sometime = "01:20:12"
    val splittingTime = sometime.split(":")
    val splittingHours = splittingTime[0].toInt() * 3600
    val splittingMinutes = splittingTime[1].toInt() * 60
    val splittingSeconds = splittingTime[2].toInt()
    println("All seconds: ${splittingHours + splittingMinutes + splittingSeconds}")



















}
