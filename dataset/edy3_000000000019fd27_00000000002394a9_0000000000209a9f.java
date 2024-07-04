import java.util.Scanner;

public class Solution {

    private static String solve(int[] ch_arr) {
        StringBuilder result = new StringBuilder();
        int lastDepth = 0;
        for (int i = 0; i < ch_arr.length; ++i) {
            int currentDepth = ch_arr[i];
            if (currentDepth == lastDepth) {
                // pass
            } else if (currentDepth < lastDepth) {
                while (currentDepth < lastDepth) {
                    result.append(")");
                    --lastDepth;
                }
            } else { // currentDepth > lastDepth
                while (currentDepth > lastDepth) {
                    result.append("(");
                    ++lastDepth;
                }
            }
            result.append(currentDepth);
            lastDepth = currentDepth;
        }

        for (;lastDepth > 0; --lastDepth) {
            result.append(")");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; ++i) {
            String digits = in.next();
            int[] i_arr = new int[digits.length()];
            char[] ch_arr = digits.toCharArray();
            for (int j = 0; j < ch_arr.length; ++j) {
                i_arr[j] = ch_arr[j] - '0';
            }

            System.out.println("Case #" + (i + 1) + ": " + solve(i_arr));
        }
    }
}
