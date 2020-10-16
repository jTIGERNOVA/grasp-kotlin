import java.lang.StringBuilder

fun main() {

    val arr = arrayOf(9, 1, 0, -45, 90, 33, 34, 1023, 19, 2)

    println("Before quick sort: ${arr.pretty()}")

    quickSort(arr, 0, arr.size - 1, PivotType.FIRST)

    println("After quick sort: ${arr.pretty()}")
}

fun quickSort(arr: Array<Int>, startIdx: Int, endIdx: Int, pivotType: PivotType) {
    if (startIdx >= endIdx)
        return

    val partitionIdx = partition(
        arr = arr, startIdx = startIdx,
        endIdx = endIdx, pivotType = pivotType
    )

    quickSort(arr, startIdx, partitionIdx - 1, pivotType)
    quickSort(arr, partitionIdx + 1, endIdx, pivotType)
}

fun partition(arr: Array<Int>, startIdx: Int, endIdx: Int, pivotType: PivotType): Int {
    //to partition the array, choose the suggested pivot
    val pivotIdx = when (pivotType) {
        PivotType.FIRST -> startIdx
        PivotType.LAST -> endIdx
    }

    val pivot = arr[pivotIdx]
    var partitionIdx = startIdx - 1

    for (i in startIdx..pivotIdx) {

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
    val swap = arr[pivotIdx]//value of pivot
    arr[pivotIdx] = arr[partitionIdx]
    arr[partitionIdx] = swap

    return partitionIdx
}

sealed class PivotType {
    object LAST : PivotType()
    object FIRST : PivotType()
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