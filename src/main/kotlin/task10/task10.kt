package taskTen

fun main(args: Array<String>) {


    println("Start Main")
    imitationOne()
    imitationTwo()
    println("Finish Main")          // выполняется поток Thread: Main

    println("Double Thread")
    Thread {
        imitationOne()
        imitationTwo()
        println(Thread.currentThread().name)     // создан дополнительный, отдельный поток Thread: - 0
    }.start()

    println("Thread imitationOne")
    Thread {
        imitationThree()
        println(Thread.currentThread().name)
    }.start()

    println("Thread imitationTwo")
    Thread {
        imitationFour()
        println(Thread.currentThread().name)
    }.start()

}

//    Написать две функции imitationOne() и imitationTwo(). В в теле каждой функции запустить цикл for (i in 1..10).
//    В теле цикла сделать приостановку потока на 1 секунду (Thread.sleep(1000)) и вывод на экран сообщения
//    “One $i” для ф-ии  imitationOne() и  “Two $i” для ф-ии  imitationTwo(0). где i - счетчик цикла.
//    в теле main()  поочередно вызвать следующие методы:
//    - println(“Начало Main”)
//    - imitationTwo()
//    - imitationOne()
//    - println(“Конец Main”)
//    Запустить программу, проанализировать полученный результат
//    Обернуть вызов imitationTwo() и imitationOne()  в один Thread
//            Thread{
//                imitationTwo()
//                imitationOne()
//            }.start()
//    Запустить программу, проанализировать полученный результат
//    Обернуть вызов imitationTwo() и imitationOne() каждый в свой Thread.
//    В одном из методов изменить время блокировки потока на 1,5 секунды Thread.sleep(1500)
//    Запустить программу, проанализировать полученный результат


fun imitationOne() {
    for (i in 1..10) {
        Thread.sleep(1000)
        println("One $i")
    }
}
fun imitationTwo() {
    for (i in 1..10) {
        Thread.sleep(1500)
        println("Two $i")
    }
}

fun imitationThree() {
    for (i in 1..10) {
        Thread.sleep(1000)
        println("Three $i")
    }
}
fun imitationFour() {
    for (i in 1..10) {
        Thread.sleep(1500)
        println("Four $i")
    }
}