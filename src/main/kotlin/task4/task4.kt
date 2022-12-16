package taskFour


import kotlin.math.sqrt

fun main(args: Array<String>) {

    val a = MathClass(arrayOf(1, 2, 3, 4, 5))
    println("Sum equal: ${a.sum()}")
    println("The sum multiplication is: ${a.multi()}")
    println("Average equal: ${a.average()}")
    println("\n")


    val b = MathClass2(arrayOf(1, 2, 3, 4, 5))
    println("Double even elements and triple odd elements: ${b.sumDoubleTriple().contentToString()}")
    println("Method min classes MathClass equal: ${b.min()}")
    println("Method max classes MathClass equal: ${b.max()}")
    println("Sum element array equal: ${b.sumArr}")
    println("\n")


    // Vector modulus
    val vecMod = Vector(2.0, 3.0, 2.0)
    println("Vector modulus: ${vecMod.vectorModulus(vecMod)}")
    println("\n")


    // Dot product vector
    val dotProductAB = Vector()
    val vectorA = Vector(3.0, 5.0, -1.0)
    val vectorB = Vector(2.0, 1.0, 7.0)
    println("Dot product vector vectorA and vectorB is equal: ${dotProductAB.dotProductVector(vectorA, vectorB)}")
    println("Dot product vector vectorA and vectorB is equal: ${vectorA.dotProductVector1(vectorB)}")
    println("\n")


    // Infix fun
    val vA = Vector(1.0, 2.0, 3.0)
    val vB = Vector(3.0, 2.0, 1.0)
    println("Dot product vector vA and aB with infix is equal: ${vA dotProdInfix vB}")
    println("\n")

    // Vector(1.0, 2.0, 3.0) * Vector(3.0, 2.0, 1.0)
    println("Vector(${vA.x}, ${vA.y}, ${vA.z}) * Vector(${vB.x}, ${vB.y}, ${vB.z})")
    println("\n")

    // WithoutClass
    println("Dot product vector vectorA and vectorB is equal: ${dotProductWithoutClass(vectorA, vectorB)}")

}

//-------------------------------- Task 4.1 ----------------------------------------------
//  ������� �����, ������� �������� ���������� ������ ����� (� ����������� ���������� ������ �����).
//  � ������ ������� ������:
//  - ��� ���������� ����� ������������� ���������
//  - ��� ���������� ������������ ��������� �������
//  - ��� ���������� �������� ��������������� �������� ��������� �������
//  ������� ������ ������ � ������� �� ����� ���������� ������� ������.


class MathClass (array: Array<Int>) {

    val arr = array

    fun sum(): Int {
        var a = 0
        for (i in arr) if (i > 0) a += i else continue
        return a
    }
    fun multi(): Int {
        var a = 1
        for (i in arr)
            a *= i
        return a
    }
    fun average(): Int {
        var a = 0
        for (i in arr)
            a += i
        return a / arr.size
    }
}

//-------------------------------- Task 4.2 ----------------------------------------------
//  ������� ����� �������� ���������� ������ �����.(� ����������� ���������� ������ �����)
//  � ������ ������� ������:
//  - ���������� ������ � ���������� ������� ����������, ���������� ��������� ����������
//  - ���������� max ������� �������,
//  - ���������� min ������� �������
//  ������� �������� ������� �������� ����� ��������� �������.

class MathClass2 (array: Array<Int>) {

    val arr = array
    val sumArr = array.sum()

    fun sumDoubleTriple(): IntArray {
        var a = intArrayOf()
        for (i in arr) {
            if (i % 2 == 0) a += i * 2 else a += i * 3
        }
        return a
    }
    fun min(): Int {return arr.min()}
    fun max(): Int {return arr.max()}
}



//-------------------------------- Task 4.3 ----------------------------------------------
//  ������� ����� Vector, ������� ��������� ������ (� ���������� ������������).
//  ����������� � �������� ���������� ��������� ������ ��������� x, y, z.
//  � ������ ������� ������:
//  - ��� ���������� ����� �������
//  - ��� ���������� ���������� ������������ ��������
//. � �������� ��������� ����� ��������� ������ ������ Vector
//  - �������� � ���������� ������� � ������� �������� ����� infix
//  � ����������� ��������� ������ ����� ����� ���������.
//  - ������� ������� ���������� ������������ ��������, ����� ��������� ������� ���
//  Vector(1.0,2.0,3.0) * Vector(3.0,2.0,1.0)
//  ��� ������ ������� ������� ���������� ������������, ������� � ��������
//  ���������� ��������� ��� ������� (������� ���� Vector).


class Vector(val x: Double = 0.0, val y: Double = 0.0, val z: Double = 0.0) {

    fun vectorModulus(mod: Vector): Double {

        val vectorSum = sqrt((x * x) + (y * y) + (z * z))
        return vectorSum
    }
    fun dotProductVector(coordA: Vector, coordB: Vector): Double {

        val action = (coordA.x * coordB.x) + (coordA.y * coordB.y) + (coordA.z * coordB.z)
        return action
    }

    fun dotProductVector1(coordA: Vector): Double {

        val action = (coordA.x * x) + (coordA.y * y) + (coordA.z * z)
        return action
    }

    infix fun dotProdInfix(act: Vector): Double {

        val action = (x * act.x) + (y * act.y) + (z * act.z)
        return action
    }

}


fun dotProductWithoutClass(coordA: Vector, coordB: Vector): Double {

    val action = (coordA.x * coordB.x) + (coordA.y * coordB.y) + (coordA.z * coordB.z)
    return action
}























