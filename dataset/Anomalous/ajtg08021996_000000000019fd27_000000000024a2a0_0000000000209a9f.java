import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.hasNext() ? sc.nextInt() : 0;

        for (int t = 0; t < T; t++) {
            String s = sc.hasNext() ? sc.next() : "";
            char maxChar = findMaxChar(s);
            int maxCharValue = maxChar - '0';
            ArrayList<Character> result = new ArrayList<>();

            int currentDepth = 0;
            for (char ch : s.toCharArray()) {
                int digit = ch - '0';
                while (currentDepth < digit) {
                    result.add('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.add(')');
                    currentDepth--;
                }
                result.add(ch);
            }
            while (currentDepth > 0) {
                result.add(')');
                currentDepth--;
            }

            StringBuilder sb = new StringBuilder(result.size());
            for (char cc : result) {
                sb.append(cc);
            }
            System.out.println("Case #" + (t + 1) + ": " + sb.toString());
        }
        sc.close();
    }

    private static char findMaxChar(String s) {
        char maxChar = '0';
        for (char ch : s.toCharArray()) {
            if (ch > maxChar) {
                maxChar = ch;
            }
        }
        return maxChar;
    }
}