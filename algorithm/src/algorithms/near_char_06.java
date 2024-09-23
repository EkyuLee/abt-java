package algorithms;
import java.util.*;

public class near_char_06 {
    public static void main(String[] args) {
        String s = "banana";
        int[] result = solution(s);
        for(int t: result){
            System.out.println(t);
        }
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        int countForAnswer = 0;

        Map<Character, Integer> map = new HashMap<>();
        char[] sCharArray = s.toCharArray();

        for(char c : sCharArray) {
            answer[countForAnswer] = -1;

            if(map.containsKey(c)) {
                int previewLocation = map.get(c);
                answer[countForAnswer] = countForAnswer - previewLocation;

                map.put(c, countForAnswer);
            }
            else{
                map.put(c, countForAnswer);
            }

            countForAnswer++;
        }


        return answer;
    }
}
