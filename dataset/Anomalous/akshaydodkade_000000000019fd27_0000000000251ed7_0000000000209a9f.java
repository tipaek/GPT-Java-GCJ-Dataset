import java.util.Scanner;

public class Solution {
    private String digitString, resultString;

    private String getParaString(String digit) {
        int num = Integer.parseInt(digit);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            result.append("(");
        }
        result.append(digit);
        for (int i = 0; i < num; i++) {
            result.append(")");
        }
        return result.toString();
    }

    private void calculateSolution() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digitString.length(); i++) {
            result.append(getParaString(digitString.substring(i, i + 1)));
        }
        resultString = result.toString();

        for (int i = 2; i < resultString.length() - 2; i++) {
            if (resultString.charAt(i) == ')' && resultString.charAt(i + 1) == '(') {
                resultString = resultString.substring(0, i) + resultString.substring(i + 2);
                int key = i, counter = 0;
                while (resultString.charAt(key) == '(') {
                    counter++;
                    key++;
                }
                i = i - counter - 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            Solution obj = new Solution();
            obj.digitString = sc.next();
            obj.calculateSolution();
            System.out.println("Case #" + t + ": " + obj.resultString);
        }
        sc.close();
    }
}