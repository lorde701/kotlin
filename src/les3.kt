package dsdf.sd

fun strLenSafe(s: String?): Int = s?.length ?: 0

class A (
    val qwe: String,
    val asd: String
)

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(50, 100)
    println(percent)
}

fun dgsh() {

}

fun main(args: Array<String>) {

    showProgress(30)
    print("12".toInt())

//    val ghdf = "dshfjsdhfks"
//    val asd = 789
//
//    val a = A("1", "2")
//    with(a) {
//        println(qwe)
//        println(asd)
//        println(ghdf)
//    }


//    println(strLenSafe("gh"))
//    println(strLenSafe(null))
}