package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val result: Array<String>?
        val numbersList: ArrayList<String>?
        if (number.contains("-")) {
            result = null
        } else {
            val numbers = number.map(Character::getNumericValue)
            val matrix: Array<Array<Int>> = Array(numbers.size) { i -> keyboardNeighbors[numbers[i]].clone() }
            numbersList = arrayListOf()
            for (array in matrix) {
                val startValue = array[0]
                for (i in 1..array.lastIndex) {
                    array[0] = array[i]
                    var strResult = ""
                    for (digits in matrix) {
                        strResult += digits[0]
                    }
                    numbersList.add(strResult)
                }
                array[0] = startValue
            }
            result = numbersList.toTypedArray()
        }
        return result
    }

    companion object {
        val keyboardNeighbors: Array<Array<Int>> = arrayOf(
            arrayOf(0, 8),
            arrayOf(1, 4, 2),
            arrayOf(2, 1, 5, 3),
            arrayOf(3, 2, 6),
            arrayOf(4, 1, 5, 7),
            arrayOf(5, 2, 4, 8, 6),
            arrayOf(6, 3, 5, 9),
            arrayOf(7, 4, 8),
            arrayOf(8, 7, 5, 9, 0),
            arrayOf(9, 8, 6)
        )
    }
}
