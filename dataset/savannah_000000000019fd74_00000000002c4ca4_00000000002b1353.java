import java.util.*;
import java.io.*;
public class Solution {
    private static String output = "Case #%d: %s";
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int casee = 1; casee <= t; ++casee) {
                new Solution().getAnswer(casee, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswer(int casee, Scanner scanner) {
        int n = scanner.nextInt();
        String answer = "";
        int v = 0;
        if (n <= 500) {
            for (int i = 1 ; i <= n ; i++) {
                answer += String.format(("\n%d 1"),i);
                v++;
            }
        }
        if (n == 501) {
            answer += "\n1 1";
            answer += "\n2 1";
            answer += "\n3 2";
            answer += "\n3 1";
            v = 4;
            for (int i = 4 ; i <= 499 ; i++) {
                answer += String.format(("\n%d 1"),i);
                v++;
            }
        }
        System.out.println(String.format(output, casee, answer));
    }

}