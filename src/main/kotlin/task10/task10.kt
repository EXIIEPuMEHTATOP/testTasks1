package taskTen

fun main(args: Array<String>) {


    println("Start Main")
    imitationOne()
    imitationTwo()
    println("Finish Main")          // ����������� ����� Thread: Main

    println("Double Thread")
    Thread {
        imitationOne()
        imitationTwo()
        println(Thread.currentThread().name)     // ������ ��������������, ��������� ����� Thread: - 0
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

//    �������� ��� ������� imitationOne() � imitationTwo(). � � ���� ������ ������� ��������� ���� for (i in 1..10).
//    � ���� ����� ������� ������������ ������ �� 1 ������� (Thread.sleep(1000)) � ����� �� ����� ���������
//    �One $i� ��� �-��  imitationOne() �  �Two $i� ��� �-��  imitationTwo(0). ��� i - ������� �����.
//    � ���� main()  ���������� ������� ��������� ������:
//    - println(������� Main�)
//    - imitationTwo()
//    - imitationOne()
//    - println(������ Main�)
//    ��������� ���������, ���������������� ���������� ���������
//    �������� ����� imitationTwo() � imitationOne()  � ���� Thread
//            Thread{
//                imitationTwo()
//                imitationOne()
//            }.start()
//    ��������� ���������, ���������������� ���������� ���������
//    �������� ����� imitationTwo() � imitationOne() ������ � ���� Thread.
//    � ����� �� ������� �������� ����� ���������� ������ �� 1,5 ������� Thread.sleep(1500)
//    ��������� ���������, ���������������� ���������� ���������


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