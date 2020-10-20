import java.lang.Exception
import java.util.*
import kotlin.math.floor

fun main() {
    val arr = arrayOf(
        0, 8, 2, 34, 432, 0, 0, 329, 93, 48, 2329,
        19, 30, 46, 28, 454, 909, 1009, 1024, 2048
    )

    //binary search requires a sorted array
    Arrays.sort(arr)

    val search = 329
    val foundIdx: Int = binarySearch(arr = arr, search = search)

    if (foundIdx != -1) {
        println("found $search at index $foundIdx in ${arr.pretty()}")
    } else {
        throw Exception("$search not found")
    }
}

fun binarySearch(arr: Array<Int>, search: Int): Int {
    return find(arr = arr, startIdx = 0, endIdx = arr.size - 1, search = search)
}

private fun find(arr: Array<Int>, startIdx: Int, endIdx: Int, search: Int): Int {

    if (startIdx > endIdx)
        return -1

    //split in half
    val med = floor((startIdx + endIdx) / 2.0).toInt()

    return when {
        search > arr[med] -> find(arr = arr, startIdx = med + 1, endIdx = endIdx, search = search)
        search < arr[med] -> find(arr = arr, startIdx = startIdx, endIdx = med - 1, search = search)
        else -> med
    }
}
