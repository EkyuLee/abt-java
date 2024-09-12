package algorithms;

public class card_01 {

    //반복해서 1개씩만 꺼낼때 : When you take out only one repeatedly
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String result = "Yes"; //Yes
        int countGoal = 1;
        int card1Count = 0;
        int card2Count = 0;

        for(String i: goal){
            if(countGoal%2 == 0){  // even
                if(!i.equals(cards2[card2Count])){
                    return "No";
                }
                card2Count++;
            }
            else{ //odd
                if(!i.equals(cards1[card1Count])){
                    return "No";
                }
                card1Count++;
            }
            countGoal++;
        }

        return "Yes";
    }


    public String solution2(String[] cards1, String[] cards2, String[] goal) {
        int countGoal = 1;
        int card1Count = 0;
        int card2Count = 0;

        for(String i: goal){
            if(card1Count < cards1.length) {
                if (cards1[card1Count].equals(i)) {

                    System.out.println(i);
                    System.out.println(card1Count);
                    card1Count++;
                    continue;
                }
            }
            if(card2Count < cards2.length) {
                if(cards2[card2Count].equals(i)){
                    card2Count++;
                    continue;
                }
            }

            return "No";
        }
        return "Yes";
    }

    public static void main(String[] args) {
        String[] card1 = {"d","e", "f"};
        String[] card2 = {"a","b","c"};
        String[] goal1 = {"d", "a", "e", "b", "f", "c"}; //true
        String[] goal2 = {"d", "a", "b", "e",  "f", "c"}; //false

        card_01 solution = new card_01();
        System.out.println(solution.solution2(card1, card2, goal1));
        System.out.println(solution.solution2(card1, card2, goal2));
    }

}
