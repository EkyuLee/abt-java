package algorithms;

public class devide_string_04 {
    public static void main(String[] args) {
        String[] testArray = {"banana", "abracadabra","aaabbaccccabba" };
        int test01 = solution2(testArray[0]);
        int test02 = solution2(testArray[1]);
        int test03 = solution2(testArray[2]);
        System.out.println(String.format("%d , %d , %d" , test01 , test02 , test03));
    }

    public static int solution2(String s){
        int answer = 0; // declare return value
        char firstPositionChar = s.charAt(0); // declare first position char
        int firstPositionCharCount = 1;
        int currentPositionCharCount = 0;

        for (int i = 1; i < s.length(); i++) {
            char currentPositionChar = s.charAt(i);
            if (firstPositionChar == currentPositionChar) {
                firstPositionCharCount++;
            }
            else {
                currentPositionCharCount++;
            }

            if(firstPositionCharCount == currentPositionCharCount){
                answer++;
                if(i+1 < s.length()){
                    firstPositionChar = s.charAt(i + 1);
                }
                firstPositionCharCount = 0;
                currentPositionCharCount = 0;
            }
        }

        if(firstPositionCharCount != 0){
            answer++;
        }

        if(currentPositionCharCount != 0){
            answer++;
        }


        return answer;
    }

//"banana"	3
//"abracadabra"	6
//"aaabbaccccabba"	3
    public static int solution(String s){
        int answer = 0;
        char firstChar = s.charAt(0);
        int sameValCount = 1;
        int differValCount = 0;
        boolean found = false;

        for(int i = 1; i < s.length(); i++){
            if(found){
                found = false;
            }
            char thisChar = s.charAt(i);
            if(firstChar == thisChar){
                sameValCount++;
            }
            else{
                differValCount++;
            }

            if (sameValCount == differValCount){
                answer++;
                sameValCount = 0;
                differValCount = 0;
                int checkIOverVal = i + 1;
                if(checkIOverVal < s.length()){
                    firstChar = s.charAt(checkIOverVal);
                }
                found = true;
            }
            else{
                if(i + 1 == s.length()){
                    answer++;
                    sameValCount = 0;
                    differValCount = 0;
                }
            }
        }
        return answer;
    }
}
