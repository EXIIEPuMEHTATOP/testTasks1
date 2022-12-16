package taskThree

import kotlin.math.sqrt
fun main(args: Array<String>) {

    println("sqr(n): ${sqrN(4.0)}")
    println("Discriminant: ${discriminant(2.0, 5.0, 33.0)}")
    println("Roots number: ${rootsNumber(1.0, -6.0, 9.0)}")
    println(quadraticRoot(-1.0,-2.0,15.0))


}

//---------------------------------Function sqr(n)---------------------------------------------
//  ������� ����������� ��������� ax2 + bx + c = 0.
//  �������� ������� sqr(n), ������� � �������� ��������� ��������� ����� n � ���������� ������� ����� �����.

fun sqrN(num: Double): Double {
    return num * num
}


//--------------------------------Function discriminant(a,b,c)----------------------------------------------
//  �������� ������� discriminant(a,b,c), ������� � �������� ���������� ���������
// ������������ a,b � c ��������� ���������. ���������� ������������ ������������.

fun discriminant(a: Double, b: Double, c: Double): Double {

    val sqr = sqrN(b)
    val discrim = sqr - 4 * a * c
    return discrim
}


//--------------------------------Function rootsNumber(a,b,c)----------------------------------------------
//  �������� �������  rootsNumber(a,b,c), ������� � �������� ���������� ���������
// ������������ a,b � c ��������� ���������. ������ ������� � ����������� �� ������������� ������ ����������
// � ������� ���������� ������ ��������� ����������� ���������.
//  ����������� � ������� ����������� when().

fun rootsNumber(a: Double, b: Double, c: Double): Double {

    val D = (b * b) - 4 * a * c
    when  {
        D == 0.0 -> return 1.0
        D > 0.0 -> return 2.0
        D < -0.0 -> return 0.0
        else -> println("invalid input")
    }
    return D
}


//--------------------------------Function quadraticRoot(a,b,c)----------------------------------------------
//  �������� ������� quadraticRoot(a,b,c), ������� � �������� ���������� ��������� ������������ a,b � c ��������� ���������.
//  ������ ������� ������ ������� �� ����� ����� ��������� ����������� ���������.
//  ��� ���������� ���� ������� ���������� ������������ ����� ���������� �������.

fun quadraticRoot(a: Double, b: Double, c: Double) {

    val D = discriminant(a, b, c)
    val rootsNum = rootsNumber(a, b, c)
    val  x1 = (-b + sqrt(D)) / (2 * a)
    val  x2 = (-b - sqrt(D)) / (2 * a)
    when (rootsNum) {
        0.0 ->  println("The roots of the quadratic equation are missing")
        1.0 ->  println("This equation has one square root $x1")
        2.0 ->  println("This equation has two square roots $x1 and $x2")
    }
}


