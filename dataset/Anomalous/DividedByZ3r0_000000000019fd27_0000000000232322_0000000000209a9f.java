import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    static ArrayList<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseCount = input.nextInt();
        String[][] result = new String[caseCount][2];

        for (int i = 0; i < caseCount; i++) {
            String numberString = input.next();
            result[i][0] = Integer.toString(i);
            result[i][1] = formatBrackets(numberString);
            ans.clear();
        }

        for (int i = 0; i < caseCount; i++) {
            System.out.println("Case #" + (Integer.parseInt(result[i][0]) + 1) + ": " + result[i][1]);
        }
    }

    public static String formatBrackets(String numberString) {
        int openBrackets = 0;

        for (int i = 0; i < numberString.length(); i++) {
            char currentChar = numberString.charAt(i);
            int currentDigit = Character.getNumericValue(currentChar);

            if (currentDigit == 0) {
                if (openBrackets != 0) {
                    closeBrackets(openBrackets);
                    openBrackets = 0;
                }
                ans.add("0");
            } else {
                if (openBrackets > currentDigit) {
                    closeBrackets(openBrackets - currentDigit);
                } else if (openBrackets < currentDigit) {
                    openBrackets(currentDigit - openBrackets);
                }
                openBrackets = currentDigit;
                ans.add(String.valueOf(currentDigit));
            }

            if (i == numberString.length() - 1) {
                closeBrackets(openBrackets);
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