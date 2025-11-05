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
 * Complete the 'matchingStrings' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. STRING_ARRAY stringList
 *  2. STRING_ARRAY queries
 */

fun matchingStrings(stringList: Array<String>, queries: Array<String>): Array<Int> {
    // Write your code here
    var ar1=mutableMapOf<String,Int>()
    var results=mutableListOf<Int>()
    
    for(str in stringList){
        ar1[str]=ar1.getOrDefault(str, 0) + 1
    }
    
    for (query in queries){
        results.add(ar1.getOrDefault(query, 0))
    }
    return results.toTypedArray()
}

fun main(args: Array<String>) {
    val stringListCount = readLine()!!.trim().toInt()

    val stringList = Array<String>(stringListCount, { "" })
    for (i in 0 until stringListCount) {
        val stringListItem = readLine()!!
        stringList[i] = stringListItem
    }

    val queriesCount = readLine()!!.trim().toInt()

    val queries = Array<String>(queriesCount, { "" })
    for (i in 0 until queriesCount) {
        val queriesItem = readLine()!!
        queries[i] = queriesItem
    }

    val res = matchingStrings(stringList, queries)

    println(res.joinToString("\n"))
}
