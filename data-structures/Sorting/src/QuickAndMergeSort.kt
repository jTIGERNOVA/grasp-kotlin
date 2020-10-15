import java.lang.StringBuilder

fun main() {

    val arr = arrayOf(9, 1, 0, -45, 90, 33, 34, 1023, 19, 2)

    println("Before quick sort: ${arr.pretty()}")

    quickSort(arr, 0, arr.size - 1)

    println("After quick sort: ${arr.pretty()}")
}

fun quickSort(arr: Array<Int>, startIdx: Int, endIdx: Int) {
    if (startIdx >= endIdx)
        return

    val partitionIdx = partition(arr, startIdx, endIdx)

    quickSort(arr, startIdx, partitionIdx - 1)
    quickSort(arr, partitionIdx + 1, endIdx)
}

fun partition(arr: Array<Int>, startIdx: Int, endIdx: Int): Int {
    //to partition the array, choose the end element
    val pivot = arr[endIdx]
    var partitionIdx = startIdx - 1

    for (i in startIdx..endIdx) {

        if (arr[i] < pivot) {
            //move partition
            partitionIdx++

            //do an element swap
            val swap = arr[i]
            arr[i] = arr[partitionIdx]
            arr[partitionIdx] = swap
        }
    }
    //need to move the pivot, since all other 'less than' elements are on the left
    partitionIdx++

    //do a pivot swap
    val swap = arr[endIdx]//value of pivot
    arr[endIdx] = arr[partitionIdx]
    arr[partitionIdx] = swap

    return partitionIdx
}

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