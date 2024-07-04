import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.hasNext() ? sc.nextInt() : 0;

        for (int t = 0; t < T; t++) {
            String s = sc.hasNext() ? sc.next().trim() : "";

            if (s.isEmpty()) continue;

            char maxChar = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (maxChar < s.charAt(i)) {
                    maxChar = s.charAt(i);
                }
            }

            int maxCharValue = maxChar;
            ArrayList<Character> outputList = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                int value = maxCharValue + currentChar - maxChar - '0';

                if (Character.isDigit(currentChar)) {
                    if (value > 0) {
                        for (int j = 0; j < value; j++) {
                            outputList.add('(');
                        }
                        maxCharValue -= value;
                    } else if (value < 0) {
                        value = -value;
                        for (int j = 0; j < value; j++) {
                            outputList.add(')');
                        }
                        maxChar -= value;
                    }
                    outputList.add(currentChar);
                }
            }

            char lastChar = s.charAt(s.length() - 1);
            for (int i = 0; i < lastChar - '0'; i++) {
                outputList.add(')');
            }

            StringBuilder result = new StringBuilder(outputList.size());
            for (Character ch : outputList) {
                result.append(ch);
            }
            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }

        sc.close();
    }
}