package taskSeven

fun main(args: Array<String>) {
    val car1 = Car("Lada", 100)
    val car2 = Car("Lada", 100)
    println(car1 == car2)
    println(car1 === car2)
    println("HashCode car1: ${car1.hashCode()}")
    println("HashCode car2: ${car2.hashCode()}")

    val car3: Car = car1
    println("car1 == car3  ${car1 == car3}")
    println("car1 === car3 ${car1 === car3}")
    println("HashCode car1: ${car1.hashCode()}")
    println("HashCode car3: ${car3.hashCode()}")
    car3.name = "Belaz"
    println(car1.name)
    println(car3.name)

    println("\n-----------------------------------data class-------------------------------------------\n")

    val vehicle1 = Vehicle1("Ural", 100)
    val vehicle2 = Vehicle1("Ural", 100)
    println("vehicle1 == vehicle2 is:  ${vehicle1 == vehicle2}")
    println("vehicle1 === vehicle2 is: ${vehicle1 === vehicle2}")
    println("HashCode vehicle1: ${vehicle1.hashCode()}")
    println("HashCode vehicle2: ${vehicle2.hashCode()}")

    val vehicle3 = vehicle1.copy("ZIL")
    val vehicle4 = vehicle1.copy()

    println("HashCode vehicle3: ${vehicle3.hashCode()}")
    println("HashCode vehicle4: ${vehicle4.hashCode()}")
    println("vehicle1 == vehicle3 is:  ${vehicle1 == vehicle3}")
    println("vehicle1 === vehicle3 is: ${vehicle1 === vehicle3}")
    println("vehicle1 == vehicle4 is:  ${vehicle1 == vehicle4}")
    println("vehicle1 === vehicle4 is: ${vehicle1 === vehicle4}")

    println("\n----------------------------------class Point-------------------------------------------\n")

    val point = Point(0, 0)
    println(point.toString())
    val turtle = Turtle()
    turtle.move(point, Command.LEFT)
    println(point.toString())
    turtle.move(point, Command.RIGHT)
    println(point.toString())
    turtle.move(point, Command.UP)
    println(point.toString())
    turtle.move(point, Command.DOWN)
    println(point.toString())
}

//  7. ������ � �������
//  ������� ����� Car � ����� ������:name � speed  � ���� ����� Vehicle � ����� ������:name � speed .
//  ������� ������� car1 = Car(�Lada�,100) � car2 = Car(�Lada�,100)
//  ������� �� ����� ��������� ���� �������� car1 � car2 � ������� ���������� �==� � �===�,
//  ������� �� ����� hashCode ���� ��������.
//  ������� ������ car3 = car1,
//  ������� �� ����� ��������� ���� �������� car1 � car3 � ������� ���������� �==� � �===�,
//  ������� �� ����� hashCode ���� ��������,
//  � ������� car3 �������� �������� name = �Belaz�,
//  ������� �� ����� �������� name �������� car1 � car3,
//
//  ���������������� ���������.
//
//  ������� ������� vehicle1 = Vehicle(�Ural�,100) � vehicle2 =Vehicle(�Ural�,100)
//  �������� ��� �������� ��������� ����, ��� ��������� vehicle1 �  vehicle2
//  ������� ������� vehicle3=vehicle1.copy(�ZIL�) �
//  vehicle4=vehicle1.copy()
//  �������� ��� �������� ��������� ����� ��������� vehicle3 � vehicle1, vehicle4 � vehicle1. ���������������� ���������� ����������.

//  2. ������� ����� Point � ������� ����� ��� ���������� ��������, ���������� x � y.
//  � ������ Point  �������������� ����� toString(), ������� ����� ���������� ������ �������� ���������� x,y�.

//  ������� enum ����� Command ���������� ������������
//  ������ (UP, DOWN, LEFT, RIGHT).

//  ������� ����� Turtle. � ������ ������� ����� move(), ������� � �������� ���������� ����� ��������� ��� ������� (Point �
//  Command). ���� ����� � ����������� �� ������� - Command (UP, DOWN, LEFT ��� RIGHT) ������ ������� �� ����� ��������� ��������:
//  ������������ ����������� �� ��� � �� -1, �� ��� � �� 0� � �������� ������� ���������� � ������� Point.
//
//  � ���� main ���������������� ������ Point � ���������� ��������� ����������� ��������� ����� Turtle. ����� ������ �������� ����������� �������� �� ����� ������ Point.


class Car (var name: String, val speed: Int )

data class Vehicle1 (var name: String, val speed: Int)

// ----------------------------------class Point-------------------------------------------


open class Point (var x: Int, var y: Int ) {

    override fun toString(): String {
        return "Current coordinates x:$x and y:$y"
    }
}

enum class Command {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

open class Turtle {

    fun move(point: Point, command: Command) {
        when (command) {
            Command.LEFT-> { point.x = 2; point.y = 2;
                println("Moved along the X axis ${point.x} and axis y by ${point.y}") }
            Command.RIGHT ->  { point.x = 22; point.y = 11;
                println("Moved along the X axis ${point.x} and axis y by ${point.y}")}
            Command.DOWN -> { point.x = 5; point.y = 6;
                println("Moved along the X axis ${point.x} and axis y by ${point.y}") }
            Command.UP -> { point.x = 7; point.y = 8;
                println("Moved along the X axis ${point.x} and axis y by ${point.y}") }
        }
    }
}


