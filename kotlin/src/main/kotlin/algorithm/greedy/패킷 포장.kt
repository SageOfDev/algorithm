package algorithm.greedy

/**
 * 문제
0 과 1로 구성된 어떤 이진 문자열 penter, pexit, pescape 가 있다. 당신은 단일 문자열로 구성된 청크 데이터 data 를 패킷(Packet)으로 포장하고자 한다. penter, pexit, pescape 는 서로 길이가 같으며, data 를 구성하는 모든 원소의 길이는 pentere 의 길이와 같다. 예를 들어, penter 의 길이가 4라면 data 는 길이가 4 인 이진 원소들로 합쳐진 문자열이다.

data 를 패킷으로 포장한다는 것은 data penter 를 data 뒤에 pexit 을 붙이는 것을 말한다. data 내부 원소들 중 penter, pexit, pescape 와 동일한 원소가 있다면 컴퓨터가 패킷을 잘못 해석할 수 있으므로, 그 앞에 pescape 를 삽입해줘야 한다.

제한 사항
- penter, pexit, pescape, data 는 모두 0 과 1 로 구성된 문자열이다
- penter 의 길이는 2 이상 100 이하이다
- penter, pexit, pescape 는 서로 다르다
- data 의 길이는 2 이상 100,000 이하인 penter 의 길이의 배수이다.

입출력 예
입력: penter = "10", pexit ="11", pescape ="00", data="00011011"
출력: "100000010010001111"
 */
class Solution패킷포장 {
    fun solution(penter: String, pexit: String, pescape: String, data: String): String {
        val chunkSize = penter.length
        val sb = StringBuilder()

        // data를 chunkSize 크기만큼 분할하여 처리
        for (i in 0 until data.length step chunkSize) {
            val chunk = data.substring(i, i + chunkSize)
            // 만약 청크가 penter, pexit, pescape 중 하나라면 앞에 pescape 삽입
            if (chunk == penter || chunk == pexit || chunk == pescape) {
                sb.append(pescape)
            }
            sb.append(chunk)
        }
        // 패킷 구성: 시작에는 penter, 끝에는 pexit 삽입
        return penter + sb.toString() + pexit
    }
}
