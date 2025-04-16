package algorithm.greedy


/**
 * 문제
입력 받은 현재 시간과 글이 게재된 시간을 가지고, 상대 시간으로 변환하여 변환하는 함수를 작성하라.

currentTimestamp: 현재 시간의 unix epoch timestamp(millisecond)
postTimestamp: 글이 게재된 시간의 unix epoch timestamp(millisecond). 항상 currentTimestamp 보다 작은 수다.

조건
- timezone은 UTC 0
- 상대 시간은 두 입력 파라미터의 차이 값 기준으로 한다
- 시간 차이는 가장 큰 단위만 표시하고 일반적으로 "n times(s) ago" 로 표현한다.
- 예시) "8 minutes ago", "8 hours ago", "8 days ago", "8 months ago", "8 years ago"
- 다음의 경우는 다르게 표현한다.
- 시간 차이가 3분 미만일 경우 "Now" 로 표시
- 글이 게재된 시각과 현재 시각 사이에 날짜가 변경된 경우는 "Yesterday" 로 표시한다.
- 달이 변경된 경우는 "Last month"  년이 변경된 경우는 "Last year" 로 표시한다.

예시
입력
- currentTimestamp = 1605163143000
- postTimestamp = 1605163133000
출력
- return = Now

입력
- currentTimestamp = 1605153160000
- postTimestamp = 1605144160000
출력
- return = 2 hours ago

입력
- currentTimestamp = 1605164160000
- postTimestamp = 1605064160000
출력
- return = Yesterday
 */
import java.time.Instant
import java.time.ZoneOffset
import java.time.temporal.ChronoUnit

class Solution {
    fun solution(currentTimestamp: Long, postTimestamp: Long): String {
        if (currentTimestamp - postTimestamp < 3 * 60 * 1000) {
            return "Now"
        }
        // 타임스탬프를 UTC 기준 LocalDate로 변환
        val currentDate = Instant.ofEpochMilli(currentTimestamp)
            .atZone(ZoneOffset.UTC)
            .toLocalDate()
        val postDate = Instant.ofEpochMilli(postTimestamp)
            .atZone(ZoneOffset.UTC)
            .toLocalDate()


        val yearsDiff = ChronoUnit.YEARS.between(postDate, currentDate).toInt()
        val monthsDiff = ChronoUnit.MONTHS.between(postDate, currentDate).toInt()
        val daysDiff = ChronoUnit.DAYS.between(postDate, currentDate).toInt()
        val hoursDiff = ChronoUnit.HOURS.between(
            Instant.ofEpochMilli(postTimestamp),
            Instant.ofEpochMilli(currentTimestamp)
        ).toInt()
        val minutesDiff = ChronoUnit.MINUTES.between(
            Instant.ofEpochMilli(postTimestamp),
            Instant.ofEpochMilli(currentTimestamp)
        ).toInt()

        if (yearsDiff > 1) {
            return "$yearsDiff years ago"
        }
        if (monthsDiff > 1) {
            return if (yearsDiff == 1)"Last year" else "$monthsDiff months ago"
        }
        if (daysDiff > 1) {
            return if (monthsDiff == 1) "Last month" else "$daysDiff days ago"
        }
        if (hoursDiff >= 1) {
            return if (daysDiff == 1) "Yesterday" else "$hoursDiff hours ago"
        }
        return "$minutesDiff minutes ago"
    }
}
