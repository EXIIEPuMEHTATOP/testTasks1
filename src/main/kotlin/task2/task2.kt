package taskTwo

fun main(args: Array<String>) {

    primeNumber()

    greatThanPreviousForIn()
    greatThanPreviousWhile()
    greatThanPreviousForEach()

    minMax()
    minMaxWhile()
    println("With reduce: max = $reducedArrMax, min = $reducedArrMin, sum = $reducedArrSum")
    forEachMin()
    println("With min max: min = $min, max = $max")

}
//-------------------------------------Task 2.1-----------------------------------------
//  ¬ывести на экран n-ное число простых чисел начина€ от 2.
// ѕростое число - это натуральное (целое положительное) число, имеющее ровно два различных
// натуральных делител€ Ч единицу и самого себ€.

fun primeNumber() {

    val num = 97
    var prime = false
    for (i in 2..num / 2) {
        if (num % i == 0) {
            prime = true
            break
        }
    }

    if (!prime)
        println("$num is a prime number.")
    else
        println("$num is not a prime number.")
}




//------------------------------------Task 2.2-------------------------------------------
//  ƒан массив из целых чисел, вывести на экран элементы массива, которые больше соседних
// (предыдущего и следующего) элементов массива., ≈сли элемент первый или последний, то его не выводим.
// использу€ цикл for
// использу€ цикл while
// использу€ оператор forEach

fun greatThanPreviousForIn() {

    // использу€ цикл for
    val someArr = arrayOf(1, 4, 8, 2, 0, 5, 9, 7, 8)
    println("Elements with for in:")
    for (i in 1 until someArr.count() - 1)  {
        if (someArr[i] > someArr[i + 1] && someArr[i] > someArr[i - 1]) {
            println("${someArr[i]}")
        }
    }
}

fun  greatThanPreviousWhile() {

    // использу€ цикл while
    val someArr = arrayOf(1, 4, 8, 2, 0, 5, 9, 7, 8)
    var index = 0
    println("Elements with while:")
    while (index < someArr.size -2) {
        if (someArr[index] > someArr[index + 1] && someArr[index] > someArr[index - 1]) {
            println("${someArr[index]} ")
        }
        index++
    }
}

fun greatThanPreviousForEach() {

    // использу€ оператор forEach
    val someArr = arrayOf(1, 4, 8, 2, 0, 5, 9, 7, 8)
    println("Elements with forEach:")
    ( 1 until someArr.size - 1).forEach {
        if (someArr[it] > someArr[it + 1] && someArr[it] > someArr[it - 1]) {
            println("${someArr[it]} ")
        }
    }
}



//------------------------------------Task 2.3-------------------------------------------
//  ƒан массив с элементами. Ќайдите произведение элементов этого массива, найдите min и max элемент.
// использу€ цикл for
// использу€ цикл while
// использу€ функцию reduce()
// использу€ оператор forEach
// использу€ функции min() max()

// for in
fun minMax() {
    val arr = arrayOf(2, 1, 6, 8, 3, 9)
    var min = Int.MAX_VALUE
    var max = 0
    var sum = 1

    for (i in arr) {
        sum *= i
        if (i < min) min = i
        if (i > max) max = i
    }
    println("With for in: Min = $min, Max = $max, Sum = $sum")
}


// while
fun minMaxWhile() {
    val arr = arrayOf(1, 5, 6, 8, 4, 2, 9)
    var index = 0
    var min = Int.MAX_VALUE
    var max = 0
    var sum = 1

    while (index < arr.count()) {
        if (arr[index] < min) min = arr[index]
        if (arr[index] > max) max = arr[index]
        sum *= arr[index]
        index += 1
    }
    println("With while: Min = $min, Max = $max, Sum = $sum")
}


// reduce
val arr = arrayOf(2, 1, 6, 8, 1, 9, 3)
var reducedArrSum = arr.reduce {count, el -> count * el }
var reducedArrMax = arr.reduce {count, el -> if (count > el) count else el }
var reducedArrMin = arr.reduce {count, el -> if (count < el) count else el }


// forEach
fun forEachMin() {
    val arr = arrayOf(12, 11, 6, 8, 12, 91, 30)
    var min = Int.MAX_VALUE
    var max = 0
    var sum = 1
    arr.forEach { el -> sum *= el }
    arr.forEach {el -> if (el < min)  min = el else if (el > max) max = el }
    println("With forEach: min = $min, max = $max, sum = $sum")
}


// min() max()
val nums = arrayOf(11, 5, 8, 51, 93, 65)

val max = nums.max()
val min = nums.min()

