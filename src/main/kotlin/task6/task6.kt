package taskSix



fun main(args: Array<String>) {

    println("-------------------------Quadrate---------------------------------------")
    val quadrate = Quadrate(3.0)
    println(quadrate.area())
    println(quadrate.perimeter())
    println("-------------------------Circle---------------------------------------")
    val circle = Circle(5.0)
    println(circle.area())
    println(circle.perimeter())
    println("-------------------------Triangle---------------------------------------")
    val triangle = Triangle(4.0, 2.0, 2.0, 45.0)
    println(triangle.area())
    println(triangle.perimeter())
    println("-------------------Implementation of the \"Figure\" class using an interface--------------------")
    println("-------------------------QuadrateWithInterface---------------------------------------")
    val quadrateWithInterface = QuadrateWithInterface(5.0)
    println(quadrateWithInterface.area())
    println(quadrateWithInterface.perimeter())
    println("-------------------------CircleWithInterface---------------------------------------")
    val circleWithInterface = CircleWithInterface(5.0)
    println(circleWithInterface.area())
    println(circleWithInterface.perimeter())
    println("-------------------------TriangleWithInterface---------------------------------------")
    val triangleWithInterface = TriangleWithInterface(4.0, 5.0, 8.0, 10.0)
    println("Area triangle is equal: ${triangleWithInterface.area()}")
    println("Perimeter triangle is equal: ${triangleWithInterface.perimeter()}")
    println("Side A is equal: ${triangleWithInterface.sideCos()}")

}


//  Создать абстрактный класс Figure, в нем описать два абстрактных метода для вычисления площади и периметра.
//  Создать не менее трех классов различных геометрических фигур (например: квадрат, окружность, треугольник),
// которые будут наследоваться от абстрактного класса Figure,  переопределить и реализовать методы.
// создать объекты классов и вывести на экран результаты выполнения методов

//  Реализовать предыдущее задание с фигурами через interface.

abstract class Figure {

    abstract fun area(): Double
    abstract fun perimeter(): Double
}

class Quadrate(val lenght: Double): Figure() {

    override fun area(): Double {
        return lenght * lenght
    }
    override fun perimeter(): Double {
        return 4 * lenght
    }
}

class Circle(val radius: Double): Figure() {

    override fun area(): Double {
        return   Math.PI * (radius * radius)
    }
    override fun perimeter(): Double {
        return 2 * Math.PI * radius
    }
}

class Triangle(val lenghtA: Double,
               val lenghtB: Double,
               val lenghtC: Double,
               val angle: Double): Figure() {

    override fun area(): Double {
        return  Math.sin(angle) * lenghtA * lenghtB / 2
    }
    override fun perimeter(): Double {
        return lenghtA + lenghtB + lenghtC
    }
}


// ========================= Implementation of the "Figure" class using an interface ==============================

interface SidesOfTriangle {
    fun sideCos(): Double
}

interface Perimeter {
    fun perimeter(): Double
}

abstract class FigureWithInterface: Perimeter {
    abstract fun area(): Double
}

class QuadrateWithInterface(val lenght: Double): FigureWithInterface() {

    override fun area(): Double {
        return lenght * lenght
    }
    override fun perimeter(): Double {
        return 4 * lenght
    }
}

class CircleWithInterface(val radius: Double): FigureWithInterface() {

    override fun area(): Double {
        return   Math.PI * (radius * radius)
    }
    override fun perimeter(): Double {
        return 2 * Math.PI * radius
    }
}

class TriangleWithInterface(val lenghtA: Double,
                            val lenghtB: Double,
                            val lenghtC: Double,
                            val angle: Double): FigureWithInterface(), SidesOfTriangle {

    override fun area(): Double {
        val convertAngle = angle * (Math.PI / 180.0) // convert in radian
        return  Math.sin(convertAngle) * lenghtA * lenghtB / 2
    }
    override fun perimeter(): Double {
        return lenghtA + lenghtB + lenghtC
    }
    override fun sideCos(): Double {
        val convertAngle = angle * (Math.PI / 180.0)
        return Math.sqrt((lenghtB * lenghtB) + (lenghtC * lenghtC) - (2 * lenghtB * lenghtC) * Math.cos(convertAngle))
    }
}


