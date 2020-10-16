fun main() {
    val arr = arrayOf(0, 9, 8, 7, 3, 2, 1, -232, -23231, 12, 11)
    val arr2 = arrayOf(9, -1)

    println("Before bubble sort: ${arr.pretty()}")

    bubbleSort(arr)

    println("After bubble sort: ${arr.pretty()}")

    println("Before bubble sort: ${arr2.pretty()}")

    bubbleSort(arr2)

    println("After bubble sort: ${arr2.pretty()}")
}

fun bubbleSort(arr: Array<Int>) {
    var currentIdx = 0
    var nextIdx = 1

    while (nextIdx < arr.size) {
        //compare elements
        if (arr[currentIdx] <= arr[nextIdx]) {
            //move on to next pair (bubble)
            currentIdx++
            nextIdx++
        } else {
            //swap the elements
            val swap = arr[currentIdx]
            arr[currentIdx] = arr[nextIdx]
            arr[nextIdx] = swap

            //start another pass
            currentIdx = 0
            nextIdx = 1
        }
    }
}
