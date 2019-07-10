package dsdf.sd

import java.util.*

fun main(args: Array<String>) {
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello, $name!")

    val f = 9
    println("Hi, ${if (f > 0) f else 0}")

    val k = 7
    println(max(k, 2))

    val rectangle = Rectangle(12, 12)
    println(rectangle.isSquare)


//    val person = Person("Bob", true, 45)


}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}


class Person2(
        val name: String,
        var isMarried: Boolean,
        var age: Int
)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }



}

class Rectangle2(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

fun cr() : Rectangle2 {
    val random = Random()
    return Rectangle2(random.nextInt(), random.nextInt())
}