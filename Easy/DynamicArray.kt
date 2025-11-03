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
 * Complete the 'dynamicArray' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

fun dynamicArray(n: Int, queries: Array<Array<Int>>): Array<Int> {
    // Write your code here
    var arr=Array(n) { mutableListOf<Int>() }
    var lastAnswer=0
    var answers=mutableListOf<Int>()
    
    for(query in queries){
        val type=query[0]
        val x=query[1]
        val y=query[2]
        
        val idx=(x xor lastAnswer) % n
        
        if (type==1){
            arr[idx].add(y)
        }
        else if (type==2){
            val value=arr[idx][y%arr[idx].size]
            lastAnswer=value
            answers.add(lastAnswer)
        }
    }
    return answers.toTypedArray()
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val q = first_multiple_input[1].toInt()

    val queries = Array<Array<Int>>(q, { Array<Int>(3, { 0 }) })

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = dynamicArray(n, queries)

    println(result.joinToString("\n"))
}
