fun main() {
    val arr = arrayOf(
        0, 8, 2, 34, 432, 0, 0, 329, 93, 48, 2329,
        19, 30, 46, 28, 454, 909, 1009, 1024, 2048
    )

    val s = 1024
    val foundIdx: Int = linearSearch(arr, s)

    if (foundIdx != -1) {
        println("found $s at index $foundIdx in ${arr.pretty()}")
    } else {
        println("$s not found")
    }
}

fun linearSearch(arr: Array<Int>, search: Int): Int {
    var i = 0
    while (i < arr.size) {
        if (arr[i] == search)
            return i

        i++
    }

    return -1
}
