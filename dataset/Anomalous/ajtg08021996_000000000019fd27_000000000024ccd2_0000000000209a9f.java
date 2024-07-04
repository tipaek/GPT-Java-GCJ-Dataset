import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.hasNext() ? sc.nextInt() : 0;

        for (int t = 0; t < T; t++) {
            String s = sc.hasNext() ? sc.next().strip() : "";
            if (s.isEmpty()) continue;

            char maxChar = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (maxChar < s.charAt(i)) {
                    maxChar = s.charAt(i);
                }
            }

            int maxAscii = maxChar;
            ArrayList<Character> result = new ArrayList<>();
            int currentAscii = maxAscii;

            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                int value = currentAscii + currentChar - maxAscii - '0';

                if (value > 0 && Character.isDigit(currentChar)) {
                    for (int j = 0; j < value; j++) {
                        result.add('(');
                    }
                    currentAscii -= value;
                    result.add(currentChar);
                } else if (value < 0 && Character.isDigit(currentChar)) {
                    value = -value;
                    for (int j = 0; j < value; j++) {
                        result.add(')');
                    }
                    maxAscii -= value;
                    result.add(currentChar);
                } else if (value == 0 && Character.isDigit(currentChar)) {
                    result.add(currentChar);
                }
            }

            char lastChar = s.charAt(s.length() - 1);
            for (int i = 0; i < lastChar - '0'; i++) {
                result.add(')');
            }

            StringBuilder sb = new StringBuilder(result.size());
            for (Character ch : result) {
                sb.append(ch);
            }
            System.out.println("Case #" + (t + 1) + ": " + sb.toString());
        }

        sc.close();
    }
}