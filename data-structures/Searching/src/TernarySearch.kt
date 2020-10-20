import java.lang.Exception
import java.util.*
import kotlin.math.floor

fun main() {
    val arr = arrayOf(
        0, 8, 2, 34, 432, 0, 0, 329, 93, 48, 2329,
        19, 30, 46, 28, 454, 909, 1009, 1024, 2048
    )

    //ternary search requires a sorted array
    Arrays.sort(arr)

    val search = 19
    val foundIdx: Int = ternarySearch(arr = arr, search = search)

    if (foundIdx != -1) {
        println("found $search at index $foundIdx in ${arr.pretty()}")
    } else {
        throw Exception("$search not found")
    }
}

fun ternarySearch(arr: Array<Int>, search: Int): Int {
    return find(arr = arr, startIdx = 0, endIdx = arr.size - 1, search = search)
}

private fun find(arr: Array<Int>, startIdx: Int, endIdx: Int, search: Int): Int {

    if (startIdx > endIdx)
        return -1

    //split into thirds
    val med1 = floor(startIdx + ((endIdx - startIdx) / 3.0)).toInt()
    val med2 = floor(endIdx - ((endIdx - startIdx) / 3.0)).toInt()

    return when {
        //in upper third
        search > arr[med2] -> find(arr = arr, startIdx = med2 + 1, endIdx = endIdx, search = search)
        //in lower third
        search < arr[med1] -> find(arr = arr, startIdx = startIdx, endIdx = med1 - 1, search = search)
        //in middle third
        search > arr[med1] -> find(arr = arr, startIdx = med1 + 1, endIdx = med2 - 1, search = search)
        //equal to med1
        search == arr[med1] -> med1
        //only possible case left, equal to med2
        else -> med2
    }
}
