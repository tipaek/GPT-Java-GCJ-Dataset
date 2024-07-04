import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    static ArrayList<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();
        String[][] answer = new String[caseNum][2];

        for (int n = 0; n < caseNum; n++) {
            String N = input.next();
            answer[n][0] = Integer.toString(n);
            answer[n][1] = processBrackets(N);
            ans.clear();
        }

        for (int n = 0; n < caseNum; n++) {
            System.out.println("Case #" + (Integer.parseInt(answer[n][0]) + 1) + ": " + answer[n][1]);
        }
    }

    public static String processBrackets(String n) {
        int openBrackets = 0;

        for (int i = 0; i < n.length(); i++) {
            int digit = Character.getNumericValue(n.charAt(i));

            if (digit == 0) {
                if (openBrackets != 0) {
                    closeBrackets(openBrackets);
                    openBrackets = 0;
                }
                ans.add("0");
            } else {
                if (openBrackets > digit) {
                    closeBrackets(openBrackets - digit);
                } else if (openBrackets < digit) {
                    openBrackets(digit - openBrackets);
                }
                openBrackets = digit;
                ans.add(Integer.toString(digit));
                if (i == n.length() - 1) {
                    closeBrackets(openBrackets);
                }
            }
        }

        return String.join("", ans);
    }

    public static void openBrackets(int count) {
        for (int i = 0; i < count; i++) {
            ans.add("(");
        }
    }

    public static void closeBrackets(int count) {
        for (int i = 0; i < count; i++) {
            ans.add(")");
        }
    }
}