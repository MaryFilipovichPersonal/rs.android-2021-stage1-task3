package subtask2


import kotlin.math.floor
import kotlin.math.sqrt

class SquareDecomposer {

    companion object{
        var undecomposableNumbers: HashSet<Int> = hashSetOf(2,3,6,7,8,11,12,15,18,19,22,23,24,27,28,31,32,33,43,44,47,48,51,55,60,67,72,76,92,96,108)
    }

    fun decomposeNumber(n: Int): Array<Int>? {
        val result: Array<Int>?
        if (n <= 0) {
            result = null
        } else {
            val squares: ArrayList<Int> = arrayListOf()
            var sqrNumber = n * n
            var number = n - 1
            while (sqrNumber != 0 && number != 0) {
                val newSqrNumber = sqrNumber - number * number
                if (undecomposableNumbers.contains(newSqrNumber)) {
                    number--
                } else {
                    sqrNumber = newSqrNumber
                    squares.add(number)
                    number = floor(sqrt(sqrNumber.toDouble())).toInt()
                }
            }
            result = if (squares.isEmpty()) {
                null
            } else squares.reversed().toTypedArray()
        }
        return result
    }
}