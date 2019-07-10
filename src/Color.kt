package dsdf.sd

enum class Color(
        val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165,0),
    GREEN(0, 255, 0);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color): String {
    val mnemonic: String = when (color) {
        Color.GREEN, Color.ORANGE -> "gr"
        else -> "---"
    }
    return mnemonic
}

fun main(args: Array<String>){
    println(Color.GREEN.rgb())
}