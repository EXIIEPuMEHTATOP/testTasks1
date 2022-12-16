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

//  7. –абота с данными
//  —оздать класс Car с двум€ пол€ми:name и speed  и дата класс Vehicle с двум€ пол€ми:name и speed .
//  создать объекты car1 = Car(УLadaФ,100) и car2 = Car(УLadaФ,100)
//  вывести на экран сравнение двух объектов car1 и car2 с помощью операторов У==Ф и У===Ф,
//  вывести на экран hashCode этих объектов.
//  создать объект car3 = car1,
//  вывести на экран сравнение двух объектов car1 и car3 с помощью операторов У==Ф и У===Ф,
//  вывести на экран hashCode этих объектов,
//  в объекте car3 изменить свойство name = УBelazФ,
//  вывести на экран свойства name объектов car1 и car3,
//
//  ѕроанализировать поведение.
//
//  создать объекты vehicle1 = Vehicle(УUralФ,100) и vehicle2 =Vehicle(УUralФ,100)
//  провести все операции описанные выше, над объектами vehicle1 и  vehicle2
//  создать объекты vehicle3=vehicle1.copy(УZILФ) и
//  vehicle4=vehicle1.copy()
//  провести все операции сравнени€ между объектами vehicle3 и vehicle1, vehicle4 и vehicle1. ѕроанализировать полученные результаты.

//  2. —оздать класс Point в котором будет два измен€емых свойства, координаты x и y.
//  ¬ классе Point  переопределить метод toString(), который будет возвращать строку Утекущие координаты x,yФ.

//  —оздать enum класс Command содержащий перечисление
//  команд (UP, DOWN, LEFT, RIGHT).

//  —оздать класс Turtle. ¬ классе создать метод move(), который в качестве параметров будет принимать два объекта (Point и
//  Command). Ётот метод в зависимости от команды - Command (UP, DOWN, LEFT или RIGHT) должен вывести на экран сообщение например:
//  Уѕроизведено перемещение по оси ’ на -1, по оси ” на 0Ф и изменить текущие координаты в объекте Point.
//
//  ¬ теле main инициализировать объект Point и произвести несколько перемещений использу€ класс Turtle. ѕосле каждой операции перемещени€ выводить на экран объект Point.


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


