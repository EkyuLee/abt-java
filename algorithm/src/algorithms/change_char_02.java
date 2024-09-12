package algorithms;

import java.util.HashSet;
import java.util.Set;
/**
 * 해당 알고리즘은, 초반에 ASCII CODE변환에만 너무 집중을 많이 했다. 좋은 방법을 배울 수 있었다.
 * I was focusing of ASCII CODE and number for this algorithm, It was time to learn good method.
 * */
public class change_char_02 {

    public static void main(String[] args) {
        change_char_02 ca = new change_char_02();
        String result = ca.solution3("aukks", "wbqd", 5); //happy
        String result2 = ca.solution2("ukska", "wbqd", 5); //

        System.out.println(result);
        System.out.println(result2);
    }

    public String solution3(String s, String skip, int index) {
        // 소문자 알파벳의 범위
        int minimum = 97;
        int maximum = 122;
        int alphabetLength = maximum - minimum + 1;  // 소문자 a~z의 범위

        // skip 문자열을 Set으로 변환하여 효율적으로 검색
        Set<Integer> skipSet = new HashSet<>();
        for (char skipChar : skip.toCharArray()) {
            skipSet.add((int) skipChar);
        }

        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            int currentAscii = (int) c;  // 현재 문자 아스키 코드
            int newAscii = currentAscii;

            int steps = 0;  // 이동해야 할 실제 칸 수 (skip을 고려)
            while (steps < index) {
                newAscii++;  // 오른쪽으로 한 칸 이동
                if (newAscii > maximum) {
                    newAscii = minimum;  // 알파벳 순환
                }
                if (!skipSet.contains(newAscii)) {
                    steps++;  // skip에 포함되지 않으면 실제 이동
                }
            }
            result.append((char) newAscii);  // 최종 계산된 문자 추가
        }
        return result.toString();
    }

    public String solution2(String s, String skip, int index) {

        //65 ~ 90 - capital - A to Z
        //97 ~ 122 - lowercase - a to z
        int minimum = 97;
        int maximum = 122;
        int minMaxGab = maximum - minimum;
        System.out.println((char) (minimum + minMaxGab));
        int yourInt = 33;
        char ch = (char) yourInt;

        //skip내부에 있는 char int 가져오기.
        char[] skipCharArray = skip.toCharArray();
        int[] skipIntArray = new int[skipCharArray.length];
        for (var i = 0; i < skipCharArray.length; i++) {
            skipIntArray[i] = (int) skipCharArray[i];
        }

        char[] sCharArray = s.toCharArray();
        String result = "";

        for (char i : sCharArray) {
            int charAscii = (int) i; //s에 포함된 char을 int로 형변환.
            int charAsciiLocation = charAscii - minimum; // 위치 정보 확인을 위한 값 정리

            int charSMin = charAscii; // skip char의 범위를 계산하기 위한 최소 값
            int charSMax = charAscii + index; // skip char의 범위를 계산하기 위한 최대 값
            for (int j : skipIntArray) { // skip char int array를 반복해서 범위에 대한 상태를 파악.
                if (charSMin <= j && j <= charSMax) {
                    charAsciiLocation++;
                }
            }

            charAsciiLocation += index; // edit ascii location
            //System.out.println(String.format("location = %d, minMaxGab = %d, charAscii = %d, result = %c", charAsciiLocation, minMaxGab, charAscii, (char)charAscii));
            if (charAsciiLocation > minMaxGab) { // if over the minMaxGab that value needs to be subtracted
                charAsciiLocation -= (minMaxGab + 1); // edit ascii location (why add 1? because of 'a', 'a' location is zero so need to subtract from charAsciiLocation)
            }


            charAscii = minimum + charAsciiLocation; // Adds the translation value to the original position value
            result += (char) charAscii; // Convert from number to character.
            //System.out.println(String.format("[result] charAsciiLocation = %d, minMaxGab = %d, charAscii = %d, result = %c \n === ", charAsciiLocation, minMaxGab, charAscii, (char)charAscii));
        }

        return result;
    }

    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder(); //string 값 응답을 위한 StringBuilder 작성.

        for (char letter : s.toCharArray()) {
            char temp = letter; // temperate 에 char 담기
            int idx = 0; // idx 의 시작점
            while (idx < index) { //idx 를 index 만큼 loop
                temp = temp == 'z' ? 'a' : (char) (temp + 1); //if temp is 'z' that need to make to 'a' because z is last Alphabet, else is just add number.
                if (!skip.contains(String.valueOf(temp))) { // skip String is a condition that the values are not duplicated.
                    idx += 1;
                }
            }
            answer.append(temp);
        }
        return answer.toString();
    }
}
