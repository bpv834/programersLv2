fun solution(weights: IntArray): Long {
    val countMap = mutableMapOf<Int, Int>()
    var answer = 0L

    // 각 무게 빈도 세기
    for (w in weights) {
        countMap[w] = countMap.getOrDefault(w, 0) + 1
    }

    // 가능한 비율
    val ratios = listOf(
        1.0,      // 1:1
        3.0 / 2,  // 3:2
        2.0,      // 2:1
        4.0 / 3   // 4:3
    )

    for ((w, cnt) in countMap) {
        // 1:1 비율 → 같은 무게끼리 조합
        answer += cnt.toLong() * (cnt - 1) / 2

        // 다른 무게 비율
        for (r in ratios.drop(1)) { // 1:1은 위에서 처리
            val target = w * r
            // target이 정수인 경우만 처리
            if (target % 1.0 == 0.0) {
                val t = target.toInt()
                if (countMap.containsKey(t)) {
                    answer += cnt.toLong() * countMap[t]!!
                }
            }
        }
    }

    return answer
}