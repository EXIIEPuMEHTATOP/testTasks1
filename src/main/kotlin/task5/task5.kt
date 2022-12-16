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

//  ������� ���������� Vehicle, ����������� ��������� ������ ������������� ��������.
//  � ������ Vehicle ������� ��� �������� (� �������������� �������� �� ���������)
// ��� ��������������� � ������� �����������: �������� � ��������.
//  � ������ Vehicle ������� ��� ������ start() � stop() (� ��������� �� ���������)
// ��� ��������������� � ������� �����������, ������� ����� �������� �� ����� ������ �������� � ���������.
//  ������: ����������� ����� �������� �� ��������� 50 ��/��
//  ������� ��� ������ ����������  �� Vehicle ����������� ��� ���� ������������ �������: �����, ������� � ����.

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