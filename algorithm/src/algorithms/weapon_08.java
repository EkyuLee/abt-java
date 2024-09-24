package algorithms;

//약수 구하기. - 소인수분해
public class weapon_08 {
    public static void main(String[] args) {
        weapon_08 wp = new weapon_08();
        int[] test = {10, 3, 2};
        wp.solution(test[0], test[1], test[2]);
    }


    /*
    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    *  number = find divisors by factoring.                   *
    *  limit = limit of power.                                *
    *  power = if over the 'limit' using this number.         *
    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * */
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            int divisors = getDivisor(i); // count of divisor

            if (divisors > limit){
                answer += power;
            }
            else{
                answer += divisors;
            }
        }

        return answer;
    }

    // 약수의 개수는 나오지만, 속도가 너무 느리다.
    // 그래서 Math.Sqrt를 이용하여 제곱근을 구한 뒤 대칭 값에 대한 내용은 2개를 더해준다.
    public int getDivisor(int number){
        int answer = 0;
        for(int i = 1; i<= Math.sqrt(number); i++){
            if(i*i == number){
                answer++;
            }else if(number % i == 0)
            {
                answer += 2;
            }
        }
        return answer;
    }
}
