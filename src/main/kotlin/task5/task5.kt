package taskFive


fun main(args: Array<String>) {

    val boat = Boat()
    val tank = Tank()
    val airplane = Airplane()
    println(boat.stop())
    println(tank.stop())
    println(airplane.stop())
    println(boat.start())
    println(tank.start())
    println(airplane.start())

}

//  Создать суперкласс Vehicle, описывающий поведение любого транспортного средства.
//  В классе Vehicle создать два свойства (с инициализацией значений по умолчанию)
// для переопределения в классах наследниках: скорость и название.
//  В классе Vehicle создать два метода start() и stop() (с действием по умолчанию)
// для переопределения в классах наследниках, которые будут выводить на экран начало движения и остановку.
//  Пример: “Автомобиль начал движение со скоростью 50 км/ч”
//  Создать три класса наследника  от Vehicle описывающих три типа транспортных средств: лодка, самолет и танк.

open class Vehicle(open val speed: Int = 10,
                   open val name: String = "Some name") {

    open fun start() = "The object started moving"
    open fun stop() = "Object stopped moving"

}

class Boat(): Vehicle() {

    override val speed: Int = 30
    override val name: String = "Black Pearl"

    override fun start() = "Object $name started moving at a speed of $speed"
    override fun stop() = "Object $name has been stopped"

}
class Airplane(): Vehicle() {

    override val speed: Int = 500
    override val name: String = "Airbus"

    override fun start() = "Object $name started moving at a speed of $speed"
    override fun stop() = "Object $name has been stopped"

}
class Tank(): Vehicle() {

    override val speed: Int = 60
    override val name: String = "T-34"

    override fun start() = "Object $name started moving at a speed of $speed"
    override fun stop() = "Object $name has been stopped"

}