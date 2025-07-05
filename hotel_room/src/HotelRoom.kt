fun solution(k: Long, room_number: LongArray): LongArray {
    val answer = mutableListOf<Long>()
    val roomMap = mutableMapOf<Long, Long>()

    fun findRoom(num: Long): Long {
        // 원하는 방이 비어있으면 배정 가능
        if (!roomMap.containsKey(num)) {
            roomMap[num] = num + 1 // 다음 빈 방 번호를 등록
            return num
        }

        // 경로 압축: 이미 배정된 경우, 다음 빈 방을 찾아 재귀
        val next = findRoom(roomMap[num]!!)
        roomMap[num] = next // 경로 압축으로 속도 향상
        return next
    }

    for (num in room_number) {
        val assigned = findRoom(num)
        answer.add(assigned)
    }

    return answer.toLongArray()
}