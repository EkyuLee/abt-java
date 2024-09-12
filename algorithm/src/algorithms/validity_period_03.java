package algorithms;

import java.util.*;

//개인정보 수집 유효기간
public class validity_period_03 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}; // small, bigger, same, bigger
        validity_period_03 vp3 = new validity_period_03();
        vp3.solution(today, terms, privacies);
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        int dayOfMonth = 28; // Assume that each month has 28 days.
        int monthOfYear = 12;

        Map<String, Integer> termsMap = new HashMap<>();
        for(String term : terms) {
            String[] termResult = term.split(" ");
            termsMap.put(termResult[0], Integer.parseInt(termResult[1]));
        }
        String[] todayYearMonthDay = today.split("\\.");
        int targetYear = Integer.parseInt(todayYearMonthDay[0]);
        int targetMonth = Integer.parseInt(todayYearMonthDay[1]);
        int targetDay = Integer.parseInt(todayYearMonthDay[2]);
        int countFor = 0;
        for(String privacy : privacies) {
            String[] privacyResult = privacy.split(" "); // 0 = year month date, 1 = terms key
            int privacyMonth = termsMap.get(privacyResult[1]); // get month movement value from terms.

            String[] regYearMonthDay = privacyResult[0].split("\\."); // split to year, month, day
            int regYear = Integer.parseInt(regYearMonthDay[0]);
            int regMonth = Integer.parseInt(regYearMonthDay[1]);
            int regDay = Integer.parseInt(regYearMonthDay[2]);

            int gabMonth = privacyMonth + regMonth;

            if(gabMonth > monthOfYear) {
                regYear += gabMonth / monthOfYear;
                regMonth = gabMonth % monthOfYear;
            }
            else{
                regMonth += privacyMonth;
            }

            if(regYear > targetYear) {
                list.add(countFor);
                countFor++;
                continue;
            }
            else if(regYear == targetYear) {
                if(regMonth > targetMonth) {
                    list.add(countFor);
                    countFor++;

                    continue;
                }
                else if (regMonth == targetMonth) {
                    if(regDay > targetDay) {
                        list.add(countFor);
                        countFor++;

                        continue;
                    }
                }
            }
            countFor++;
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

// System.out.println(String.format("targetDATE [%d, %d, %d], regDATE [%d,%d,%d]", targetYear, targetMonth, targetDay, regYear, regMonth, regDay));