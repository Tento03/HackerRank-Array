import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'arrayManipulation' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    // Write your code here
    var longArr=LongArray(n+1) { 0 }
    
    for(query in queries){
        var a=query[0]-1
        var b=query[1]
        var k=query[2].toLong()
        
        longArr[a]+=k 
        if(b<longArr.size){
            longArr[b]-=k 
        }
    }
    
    var current=0L
    var maxResult=0L
    for(i in 0 until n){
        current+=longArr[i]
        if(current>maxResult){
            maxResult=current
        }
    }
    return maxResult
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

    for (i in 0 until m) {
        queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = arrayManipulation(n, queries)

    println(result)
}
