import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T;
        T = input.nextInt();
        //start of loop T
        for (int t = 1; t <= T; ++t) {

            String s = input.next();

            int a = 0;
            String answer = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int b = c - '0';
                while (b > a) {
                    ++a;
                    answer += '(';
                }

                while (b < a) {
                    --a;
                    answer += ')';
                }
                answer += c;
            }
            while (a > 0) {
                --a;
                answer += ')';
            }

            //start output
            System.out.printf("Case #%d: %s\n", t, answer);
            //end output
        }//end of loop T

    }
}