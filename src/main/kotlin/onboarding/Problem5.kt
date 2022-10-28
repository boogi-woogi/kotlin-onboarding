package onboarding

fun solution5dynamicProgramming(coinToUse:Array<Int>, coinCnt:Array<Array<Int>>, cache:Array<Int>, money:Int){
    cache[0]=0
    coinToUse.forEachIndexed { coinIndex, curCoin ->
        for(paidMoney in curCoin..money){
            if(cache[paidMoney]>cache[paidMoney-curCoin]+1){
                cache[paidMoney]=cache[paidMoney-curCoin]+1
                coinCnt[paidMoney]=coinCnt[paidMoney-curCoin].copyOf()
                coinCnt[paidMoney][coinIndex]++
            }
        }
    }
}

fun solution5(money: Int): List<Int> {
    val coinToUse=arrayOf(1, 10, 50, 100, 500, 1000, 5000, 10000, 50000)
    val coinCnt=Array(money+1){Array(9){0}}
    val cache=Array(money+1){Int.MAX_VALUE}

    solution5dynamicProgramming(coinToUse, coinCnt, cache, money)

    return coinCnt[money].reversed().toList()
}
