package rift.fizzbuzz

object PFFizzBuzz {
    // "if the number is divisible by 3, say fizz"
    // problem: 0 claims to be divisible by everything.
    fun divisorResponse(divisor: Int, response: String, n: Int): String {
        return if (n.rem(divisor) == 0) {
            response
        } else {
            ""
        }
    }

    // "say all the words relating to the number. if there are none, just say the number"
    fun arbitraryDivisorResponse(divisorResponses: List<Pair<Int, String>>, n: Int): String {
        return with(
                divisorResponses.joinToString("") {
                    divisorResponse(it.first, it.second, n)
                }
        ) {
            when {
                this == "" -> n.toString()
                else -> this
            }
        }
    }

    // the classic game of fizzbuzz
    fun fizzBuzz(n: Int): String {
        return arbitraryDivisorResponse(listOf(Pair(3, "fizz"), Pair(5, "buzz")), n)
    }

    // the classic job interview version of fizzbuzz, usually from 1 to 100.
    fun fizzBuzzStartEnd(start: Int, end: Int): String {
        return (start..end step 1).joinToString("\n") {fizzBuzz(it)}
    }

}

fun main(args: Array<String>){// : Unit
    System.out.print(PFFizzBuzz.fizzBuzzStartEnd(1, 100))
}