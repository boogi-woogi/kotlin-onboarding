package onboarding

import java.lang.Math.max

fun solution1CheckException(inputList: List<Int>): Boolean {
    //문제에서 정의한 예외를 다음과 같은 상황이라고 해석했음
    if (inputList.contains(1) || inputList.contains(400)) return true
    if (inputList[1] - inputList[0] != 1) return true
    return false
}

fun solution1calcMultipleScore(inputList: List<Int>): Int {
    var multipleScore = 1

    inputList.forEach { page ->
        var tmpMultipleScore = 1
        page.toString().forEach { eachNum ->
            tmpMultipleScore *= Character.getNumericValue(eachNum)
        }
        multipleScore = multipleScore.coerceAtLeast(tmpMultipleScore)
    }

    return multipleScore
}

fun solution1calcAddScore(inputList: List<Int>): Int {
    var addScore = 0

    inputList.forEach { page ->
        var tmpAddScore = 0
        page.toString().forEach { eachNum ->
            tmpAddScore += Character.getNumericValue(eachNum)
        }
        addScore = addScore.coerceAtLeast(tmpAddScore)
    }

    return addScore
}

fun solution1whoWin(pobiScore:Int, crongScore:Int):Int{
    return if (pobiScore > crongScore) 1
    else if (pobiScore < crongScore) 2
    else 0
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (solution1CheckException(pobi) || solution1CheckException(crong))
        return -1
    var (pobiScore, crongScore) = arrayOf(0, 0);

    pobiScore = solution1calcMultipleScore(pobi).coerceAtLeast(solution1calcAddScore(pobi))
    crongScore = solution1calcMultipleScore(crong).coerceAtLeast(solution1calcAddScore(crong))

    return solution1whoWin(pobiScore, crongScore)
}
