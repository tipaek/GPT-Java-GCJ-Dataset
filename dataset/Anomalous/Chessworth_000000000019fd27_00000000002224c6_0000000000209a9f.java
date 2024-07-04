import java.util.Scanner;

class Solution {
    public static int countBracketsDifference(String s) {
        int leftCount = 0, rightCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftCount++;
            } else if (ch == ')') {
                rightCount++;
            }
        }
        return leftCount - rightCount;
    }

    public static StringBuilder generateBrackets(int count) {
        StringBuilder output = new StringBuilder();
        if (count < 0) {
            for (int i = 0; i < -count; i++) {
                output.append(')');
            }
        } else {
            for (int i = 0; i < count; i++) {
                output.append('(');
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            String s = input.next();
            StringBuilder curString = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int value = Character.getNumericValue(s.charAt(j));
                int bracketDiff = countBracketsDifference(curString.toString());
                curString.append(generateBrackets(value - bracketDiff));
                curString.append(value);
            }
            curString.append(generateBrackets(-Character.getNumericValue(s.charAt(s.length() - 1))));
            System.out.println("Case #" + i + ": " + curString);
        }
        input.close();
    }
}