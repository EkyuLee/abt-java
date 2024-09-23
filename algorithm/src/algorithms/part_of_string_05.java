package algorithms;

public class part_of_string_05 {
    public static void main(String[] args) {
        String t = "1234";
        String p = "9999";
        solution(t, p);
    }

    public static int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        int tMaxLength = t.length() - pLength;
        float pFloatVal = Float.parseFloat(p);
        for(int i = 0; i <= tMaxLength; i++) {
            String tSplit = t.substring(i, i + pLength);
            float tSplitFloatVal = Float.parseFloat(tSplit);

            if(tSplitFloatVal <= pFloatVal) {
                answer++;
                System.out.println(String.format(" %f < %f", tSplitFloatVal, pFloatVal));
            }
        }

        System.out.println(answer);
        return answer;
    }

}
