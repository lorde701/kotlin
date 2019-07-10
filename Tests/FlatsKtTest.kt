import org.junit.Assert
import dsdf.sd.*

class FlatsKtTest {

    private val countEntrance = 6
    private val countFloor = 5
    private val countFlat = 3

    @org.junit.Test
    fun getFloorAndEntrance() {
        Assert.assertEquals(getFloorAndEntrance(countEntrance, countFloor, countFlat, 1), Pair(1, 1))
        Assert.assertEquals(getFloorAndEntrance(countEntrance, countFloor, countFlat, 3), Pair(1, 1))
        Assert.assertEquals(getFloorAndEntrance(countEntrance, countFloor, countFlat, 15), Pair(1, 5))
        Assert.assertEquals(getFloorAndEntrance(countEntrance, countFloor, countFlat, 10), Pair(1, 4))
        Assert.assertEquals(getFloorAndEntrance(countEntrance, countFloor, countFlat, 90), Pair(6, 5))
    }

    @org.junit.Test
    fun getFloorAndEntranceWithConditional() {
        Assert.assertEquals(getFloorAndEntrance(countEntrance, countFloor, countFlat, 5, 1), Pair(1, 2))
        Assert.assertEquals(getFloorAndEntrance(countEntrance, countFloor, countFlat, 6, 1), Pair(1, 3))
        Assert.assertEquals(getFloorAndEntrance(countEntrance, countFloor, countFlat, 2, 1), Pair(1, 1))
        Assert.assertEquals(getFloorAndEntrance(countEntrance, countFloor, countFlat, 1, 1), Pair(1, 1))
        Assert.assertEquals(getFloorAndEntrance(countEntrance, countFloor, countFlat, 8, 1), Pair(1, 3))
        Assert.assertEquals(getFloorAndEntrance(countEntrance, countFloor, countFlat, 22, 1), Pair(2, 3))
        Assert.assertEquals(getFloorAndEntrance(countEntrance, countFloor, countFlat, 84, 1), Pair(6, 5))
        Assert.assertEquals(getFloorAndEntrance(countEntrance, countFloor, countFlat, 28, 1), Pair(2, 5))
    }

    @org.junit.Test
    fun checkParamsPositivity() {
        Assert.assertEquals(checkParamsPositivity(1, 1, 1, 1), "")
        Assert.assertEquals(checkParamsPositivity(1, 1, 1, -1), "Параметр <номер квартиры> должен быть положительным числом")
        Assert.assertEquals(checkParamsPositivity(-1, 1, -1, 1), "Параметры <количество подъездов, количество квартир> должны быть положительными числами")
        Assert.assertEquals(checkParamsPositivity(-1, -1, -1, -1), "Параметры <количество подъездов, количество этажей, количество квартир, номер квартиры> должны быть положительными числами")
    }
}