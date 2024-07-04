import java.util.Scanner;

public class Solution {
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int queries = inp.nextInt();

        for (int i = 0; i < queries; i++) {
            String s = inp.next();
            ans.append("Case #").append(i + 1).append(": ").append(processString(s)).append("\n");
        }

        System.out.println(ans);
        inp.close();
    }

    private static String processString(String s) {
        StringBuilder newSet = new StringBuilder();
        int prev = -1;
        int brac = 0;

        for (char c : s.toCharArray()) {
            int num = Character.getNumericValue(c);

            if (num > prev) {
                newSet.append(repeat("(", num - brac)).append(num);
                brac = num;
            } else if (num < prev) {
                newSet.append(repeat(")", brac - num)).append(num);
                brac = num;
            } else {
                newSet.append(num);
            }

            prev = num;
        }

        if (brac > 0) {
            newSet.append(repeat(")", brac));
        }

        return newSet.toString();
    }

    private static String repeat(String str, int count) {
        return str.repeat(Math.max(0, count));
    }
}