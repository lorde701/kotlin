package dsdf.sd

//countEntrance - количество подъездов, countFloors - количество этажей,
// countFlats - количество квартир, flatNum - номер квартиры
fun getFloorAndEntrance(countEntrance: Int, countFloors: Int, countFlats: Int, flatNum: Int): Pair<Int, Int> {
    //проверка на отрицательные числа
    val checkResult = checkParamsPositivity(countEntrance, countFloors, countFlats, flatNum)
    if (checkResult != "") {
        throw RuntimeException(checkResult)
    }


    //проверка на последнюю квартиру на последнем этаже
    if (flatNum % (countFlats * countFloors) == 0)
        return Pair(flatNum / (countFlats * countFloors), countFloors)

    val entrance = if (flatNum / (countFlats * countFloors) + 1 <= countEntrance) {
        flatNum / (countFlats * countFloors) + 1
    } else throw RuntimeException("В доме нет квартиры с номером $flatNum")

    val floor = if ((flatNum % (countFlats * countFloors)) % countFlats == 0) {
        flatNum % (countFlats * countFloors) / countFlats
    } else flatNum % (countFlats * countFloors) / countFlats + 1
    return Pair(entrance, floor)
}

//countEntrance - количество подъездов, countFloors - количество этажей,
// countFlats - количество квартир, flatNum - номер квартиры,
// diff - разница в количестве квартир на первом и остальных этажах
fun getFloorAndEntrance(countEntrance: Int, countFloors: Int, countFlats: Int, flatNum: Int, diff: Int): Pair<Int, Int> {
    //проверка на отрицательные числа
    val checkResult = checkParamsPositivity(countEntrance, countFloors, countFlats, flatNum)
    if (checkResult != "") {
        throw RuntimeException(checkResult)
    }

    if (flatNum > countEntrance * countFlats * countFloors) {
        throw RuntimeException("В доме нет квартиры с номером $flatNum")
    }

    //проверка на последнюю квартиру на последнем этаже
    val countFlatsInEntrance = countFlats * countFloors - diff
    if (flatNum % (countFlatsInEntrance) == 0)
        return Pair(flatNum / (countFlatsInEntrance), countFloors)

    val entrance = flatNum / (countFlatsInEntrance) + 1


    //проверка, что квартира на первом этаже
    if (flatNum % countFlatsInEntrance <= countFlats - diff)
        return Pair(entrance, 1)

    val floor = if (((flatNum % countFlatsInEntrance) - (countFlats - diff)) % countFlats == 0) {
        ((flatNum % countFlatsInEntrance) - (countFlats - diff)) / countFlats + 1
    } else {
        ((flatNum % countFlatsInEntrance) - (countFlats - diff)) / countFlats + 2
    }
    return Pair(entrance, floor)
}



fun checkParamsPositivity(countEntrance: Int, countFloors: Int, countFlats: Int, flatNum: Int): String {
    val result = mutableListOf<String>()
    if (countEntrance < 1) {
        result.add("количество подъездов")
    }
    if (countFloors < 1) {
        result.add("количество этажей")
    }
    if (countFlats < 1) {
        result.add("количество квартир")
    }
    if (flatNum < 1) {
        result.add("номер квартиры")
    }
    if (result.size == 1) {
        return "Параметр <${result.get(0)}> должен быть положительным числом"
    }
    if (result.size > 1) {
        return "Параметры <${result.joinToString(separator = ", ")}> должны быть положительными числами"
    }
    return ""
}

fun Pair<Int, Int>.printAsEntranceAndFloor() {
    println("Подъезд - ${this.first}, этаж - ${this.second}")
}

fun main(args: Array<String>) {
    val countEntrance = 6
    val countFloors = 6
    val countFlats = 6
    val flatNumber = 6
    val diff = 2

    println("Введенные значения: количество подъездов - $countEntrance, количество этажей - $countFloors, " +
            "количество квартир на этаже - $countFlats, на сколько меньше квартир на первом этаже - $diff, " +
            "номер квартиры - $flatNumber")

    getFloorAndEntrance(countEntrance, countFloors, countFlats, flatNumber, diff).printAsEntranceAndFloor()
}