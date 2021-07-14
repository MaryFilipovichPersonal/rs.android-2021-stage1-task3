package subtask1

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val m = array[0]
        var result:Int? = null
        var c: Long
        var top:Long = 1
        var bottom:Long = 1
        for (n in array[1] downTo 1){
            val k = array[1] - n + 1
            top *= n
            bottom *= k
            c = top/bottom
            if (c == m.toLong()){
                result = k
                break
            }
        }
        return result
    }
}
