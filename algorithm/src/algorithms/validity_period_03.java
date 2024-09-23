package algorithms;

import java.util.*;

//개인정보 수집 유효기간
public class validity_period_03 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}; // small, bigger, same, bigger
        validity_period_03 vp3 = new validity_period_03();
        vp3.solution2(today, terms, privacies);

        String today2 = "2020.01.01";
        String[] terms2 = {"Z 3", "D 5"};
        String[] privacies2 = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        vp3.solution2(today2, terms2, privacies2);
    }

    // privacies date + term 크거나 같은것이 볓번째인지 배열로 응답해주는 함수. 1month = 28day
    public int[] solution2(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> termsHashMap = new HashMap<>(); // terms 값을 Hashmap 형태로 분할 하기 위한 변수 선언
        for(String term : terms) {
            String[] termSplitArray = term.split(" "); // [0] = alphabet key, month
            termsHashMap.put(termSplitArray[0], Integer.parseInt(termSplitArray[1]));
        }

        String[] todaySplitArray = today.split("\\."); //today 변수를 년, 월, 일 로 구분하는 변수
        int todayYear = Integer.parseInt(todaySplitArray[0]);
        int todayMonth = Integer.parseInt(todaySplitArray[1]);
        int todayDay = Integer.parseInt(todaySplitArray[2]);
        int countPrivacies = 0;
        for(String privacy : privacies) { // privacies 정보를 반복문을 통해서 읽는다.
            String[] privacySplitArray = privacy.split(" "); // 0 = year month date, 1 = termshash key
            int additionalMonth = termsHashMap.get(privacySplitArray[1]); // get additional month value

            String[] pricaciesDateSplitArray = privacySplitArray[0].split("\\."); // split to year, month, day
            int regYear = Integer.parseInt(pricaciesDateSplitArray[0]);
            int regMonth = Integer.parseInt(pricaciesDateSplitArray[1]);
            int regDay = Integer.parseInt(pricaciesDateSplitArray[2]);

            countPrivacies++;

            //set date
            regMonth = regMonth + additionalMonth;
            regYear = regYear + (regMonth / 12);
            regMonth = regMonth % 12;
            regDay = regDay - 1;
            if(regDay < 1){
                regDay = 28 - regDay;
                regMonth = regMonth - 1;
            }
            if(regMonth < 1){
                regMonth = 12 - regMonth;
                regYear = regYear - 1;
            }

            boolean todayBiggerThanRegDay = false;
            if(todayYear > regYear){
                todayBiggerThanRegDay = true;
            }else if(todayYear == regYear){
                if(todayMonth > regMonth){
                    todayBiggerThanRegDay = true;
                }else if(todayMonth == regMonth){
                    if(todayDay > regDay){
                        todayBiggerThanRegDay = true;
                    }
                }
            }

            String todayResult = String.format("%04d%02d%02d", todayYear, todayMonth, todayDay);
            String regResult = String.format("%04d%02d%02d", regYear, regMonth, regDay);
            int todayResultInt =  Integer.parseInt(todayResult);
            int regResultInt = Integer.parseInt(regResult);

            System.out.println(String.format("[%d]", countPrivacies));
            System.out.println(String.format("%s, %d.%d.%d   [%d]", privacySplitArray[0], regYear, regMonth, regDay, additionalMonth));
            System.out.println(String.format("'%d' > '%d'", todayResultInt, regResultInt));

            if(todayBiggerThanRegDay){
                list.add(countPrivacies);
            }

        }

        int[] answer = list.stream().mapToInt(i -> i).toArray();
        for(int i: answer){
            System.out.println(i);
        }
        return answer;
    }

    public int[] solution3(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> termsHashMap = new HashMap<>(); // terms 값을 Hashmap 형태로 분할 하기 위한 변수 선언
        for(String term : terms) {
            String[] termSplitArray = term.split(" "); // [0] = alphabet key, month
            termsHashMap.put(termSplitArray[0], Integer.parseInt(termSplitArray[1]));
        }

        String[] todaySplitArray = today.split("\\."); //today 변수를 년, 월, 일 로 구분하는 변수
        int todayYear = Integer.parseInt(todaySplitArray[0]);
        int todayMonth = Integer.parseInt(todaySplitArray[1]);
        int todayDay = Integer.parseInt(todaySplitArray[2]);
        int countPrivacies = 0;
        for(String privacy : privacies) { // privacies 정보를 반복문을 통해서 읽는다.
            String[] privacySplitArray = privacy.split(" "); // 0 = year month date, 1 = termshash key
            int additionalMonth = termsHashMap.get(privacySplitArray[1]); // get additional month value

            String[] pricaciesDateSplitArray = privacySplitArray[0].split("\\."); // split to year, month, day
            int regYear = Integer.parseInt(pricaciesDateSplitArray[0]);
            int regMonth = Integer.parseInt(pricaciesDateSplitArray[1]);
            int regDay = Integer.parseInt(pricaciesDateSplitArray[2]);

            countPrivacies++;

            //set date
            regMonth = regMonth + additionalMonth;
            regYear = regYear + (regMonth / 12);
            regMonth = regMonth % 12;
            regDay = regDay - 1;
            if(regDay < 1){
                regDay = 28 - regDay;
                regMonth = regMonth - 1;
            }
            if(regMonth < 1){
                regMonth = 12 - regMonth;
                regYear = regYear - 1;
            }

            boolean todayBiggerThanRegDay = false;
            if(todayYear > regYear){
                todayBiggerThanRegDay = true;
            }else if(todayYear == regYear){
                if(todayMonth > regMonth){
                    todayBiggerThanRegDay = true;
                }else if(todayMonth == regMonth){
                    if(todayDay > regDay){
                        todayBiggerThanRegDay = true;
                    }
                }
            }

            if(todayBiggerThanRegDay){
                list.add(countPrivacies);
            }

        }

        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;

    }


    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> termsHashMap = new HashMap<>(); // terms 값을 Hashmap 형태로 분할 하기 위한 변수 선언
        for(String term : terms) {
            String[] termSplitArray = term.split(" "); // [0] = alphabet key, month
            termsHashMap.put(termSplitArray[0], Integer.parseInt(termSplitArray[1]));
        }

        String[] todaySplitArray = today.split("\\."); //today 변수를 년, 월, 일 로 구분하는 변수
        int todayYear = Integer.parseInt(todaySplitArray[0]);
        int todayMonth = Integer.parseInt(todaySplitArray[1]);
        int todayDay = Integer.parseInt(todaySplitArray[2]);
        int countPrivacies = 1;
        for(String privacy : privacies) { // privacies 정보를 반복문을 통해서 읽는다.
            String[] privacySplitArray = privacy.split(" "); // 0 = year month date, 1 = termshash key
            int additionalMonth = termsHashMap.get(privacySplitArray[1]); // get additional month value

            String[] pricaciesDateSplitArray = privacySplitArray[0].split("\\."); // split to year, month, day
            int regYear = Integer.parseInt(pricaciesDateSplitArray[0]);
            int regMonth = Integer.parseInt(pricaciesDateSplitArray[1]);
            int regDay = Integer.parseInt(pricaciesDateSplitArray[2]);

            //set date
            regDay = regDay - 1;
            if(regDay < 1){
                regDay = 28 - regDay;
                regMonth = regMonth - 1;
            }
            if(regMonth < 1){
                regMonth = 12 - regMonth;
                regYear = regYear - 1;
            }
            regMonth = regMonth + additionalMonth;
            regYear = regYear + (regMonth / 12);
            regMonth = regMonth % 12;

            String todayResult = String.format("%04d%02d%02d", todayYear, todayMonth, todayDay);
            String regResult = String.format("%04d%02d%02d", regYear, regMonth, regDay);
            int todayResultInt =  Integer.parseInt(todayResult);
            int regResultInt = Integer.parseInt(regResult);

            if(todayResultInt > regResultInt){
                list.add(countPrivacies);

            }
            countPrivacies++;

        }

        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}

// System.out.println(String.format("targetDATE [%d, %d, %d], regDATE [%d,%d,%d]", targetYear, targetMonth, targetDay, regYear, regMonth, regDay));