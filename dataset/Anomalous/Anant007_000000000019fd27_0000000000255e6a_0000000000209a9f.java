import java.util.Scanner;

public class Solution {
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int queries = inp.nextInt();
        inp.nextLine();  // Consume the newline character

        for (int i = 0; i < queries; i++) {
            String s = inp.nextLine();
            StringBuilder newSet = new StringBuilder();
            int prev = 0, brac = 0;

            for (char c : s.toCharArray()) {
                int num = Character.getNumericValue(c);

                if (num > prev) {
                    newSet.append(repeat("(", num - prev));
                } else if (num < prev) {
                    newSet.append(repeat(")", prev - num));
                }

                newSet.append(num);
                prev = num;
            }

            if (prev > 0) {
                newSet.append(repeat(")", prev));
            }

            ans.append("Case #").append(i + 1).append(": ").append(newSet).append("\n");
        }

        System.out.print(ans);
        inp.close();
    }

    private static String repeat(String str, int count) {
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < count; i++) {
            newStr.append(str);
        }
        return newStr.toString();
    }
}