package algorithms;

import java.util.*;

public class hall_of_fame_07 {
    public static void main(String[] args) {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200}; // 10, 10, 10, 20, 20, 100, 100
        int[] result = solution(k, score);
        for(int i: result){
            System.out.println(i);
        }
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> scoreStoreList = new ArrayList<Integer>();

        for(int i = 0; i < score.length; i++){
            scoreStoreList.add(score[i]);
            scoreStoreList.sort(Collections.reverseOrder());

            if(k <= scoreStoreList.size()){
                answer[i] = scoreStoreList.get(k - 1);
            }else{
                answer[i] = scoreStoreList.get(i);
            }
        }


        return answer;
    }

}
