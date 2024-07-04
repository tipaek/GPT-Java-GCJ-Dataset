import java.util.Scanner;

public class Solution {
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int queries = inp.nextInt();

        for (int i = 0; i < queries; i++) {
            String s = inp.next();
            ans.append("Case #").append(i + 1).append(": ").append(processQuery(s)).append("\n");
        }

        System.out.print(ans);
        inp.close();
    }

    private static String processQuery(String s) {
        StringBuilder result = new StringBuilder();
        int prev = 0, brac = 0;

        for (char c : s.toCharArray()) {
            int num = c - '0';
            if (num > prev) {
                result.append(repeat("(", num - prev));
            } else if (num < prev) {
                result.append(repeat(")", prev - num));
            }
            result.append(num);
            prev = num;
        }

        result.append(repeat(")", prev));
        return result.toString();
    }

    private static String repeat(String str, int count) {
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < count; i++) {
            newStr.append(str);
        }
        return newStr.toString();
    }
}