package algorithms;

import java.util.*;

public class maximum_profits_09 {
    public static void main(String[] args) {
        //int k = 4;
        //int m = 3;
        //int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};

        solution(k, m, score);
    }

    public int solution_AnswerSheet(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i = score.length; i >= m; i -= m){
            answer += score[i - m] * m;
        }
        return answer;
    }
    public static int solution(int k, int m, int[] score) {


        //minScore = 최저 사과점수
        //k = 최대 사과 점수
        //m = 박스에 들어가는 사과 개수
        //score = 사과 점수 배멸
        //중복해서 사과를 넣을 수 없음.
        int minScore = 1;
        List<Integer> scoreList = new ArrayList<>();
        Collections.addAll(scoreList, Arrays.stream(score).boxed().toArray(Integer[]::new)); // array put in list
        scoreList.sort(Comparator.reverseOrder());
        int[] minScoreArray = new int[scoreList.size() / m];
        int boxCount = 0;
        for(int i = 0; i < scoreList.size(); i = i + m) {
            int minScoreVal = k;
            if(i + m <= scoreList.size()) {
                for(int j = i; j < i+m; j++) {
                    int scoreListGet = scoreList.get(j);
                    if (minScoreVal > scoreListGet) {

                        minScoreVal = scoreListGet;
                    }
                }
                minScoreArray[boxCount] = minScoreVal;
                boxCount++;
            }
        }
        int answer = 0;
        for(int i: minScoreArray) {
            answer += i * m ;
        }
        return answer;
    }

}
//(1 x 3 x 1) + (2 x 3 x 1) + (4 x 3 x 2) = 33
//(최저 사과 점수) x (한 상자에 담긴 사과 개수) x (상자의 개수) = 2 x 4 x 1 = 8