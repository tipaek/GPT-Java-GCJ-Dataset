import java.util.Scanner;

public class Solution {
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int queries = input.nextInt();

        for (int i = 0; i < queries; i++) {
            String s = input.next();
            StringBuilder newSet = new StringBuilder();
            int prev = -1, brac = 0;

            for (int j = 0; j < s.length(); j++) {
                int num = Character.getNumericValue(s.charAt(j));
                if (j == 0) {
                    brac = num;
                    newSet.append(repeat("(", brac)).append(num);
                } else {
                    if (num > prev) {
                        newSet.append(repeat("(", num - prev)).append(num);
                        brac += num - prev;
                    } else if (num < prev) {
                        newSet.append(repeat(")", prev - num)).append(num);
                        brac -= prev - num;
                    } else {
                        newSet.append(num);
                    }
                }
                prev = num;
            }

            if (brac > 0) {
                newSet.append(repeat(")", brac));
            }

            ans.append("Case #").append(i + 1).append(": ").append(newSet).append("\n");
        }

        System.out.print(ans);
        input.close();
    }

    private static String repeat(String str, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(str);
        }
        return result.toString();
    }
}