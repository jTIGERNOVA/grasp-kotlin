import java.lang.StringBuilder

fun Array<Int>.pretty(): String {
    val tThis = this
    return with(StringBuilder()) {
        append("{ ")
        tThis.forEachIndexed { index, v ->
            if (index < (tThis.size - 1))
                append("$v, ")
            else
                append("$v")
        }
        append(" }")
    }.toString()
}