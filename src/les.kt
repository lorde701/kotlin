package dsdf.sd

val set = hashSetOf(1, 7, 53)
val list = arrayListOf(1, 7, 53)
val map = hashMapOf(Pair(1, ""), 7 to "seven")

fun main(args: Array<String>) {
    print("""sldjlsd
        |  dsfsdkf
        |     sdlfkjdskf
    """.trimMargin())

//    val list = listOf("dczxcz^ ", *listOf(1,2,3))
//    println(list)

//    println("sdh21".getLastChar())

//    val list = listOf(1, 2, 3)
//    println(list)
//    println()
}

fun String.getLastChar() = get(length - 1)

fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
) : String {
    val result = StringBuilder(prefix)
//    this.stream().filter()
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}