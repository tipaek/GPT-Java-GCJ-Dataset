import java.util.Scanner;

public class Solution {
    public static String calc(String S) {
        int curDepth = 0;
        StringBuilder result = new StringBuilder();
        for (char e : S.toCharArray()) {
            int value = Character.getNumericValue(e);
            for (; curDepth < value; curDepth++) {
                result.append('(');
            }
            for (; curDepth > value; curDepth--) {
                result.append(')');
            }
            result.append(e);
        }
        for (; curDepth > 0; curDepth--) {
            result.append(')');
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for (int i = 0; i < T; i++) {
            String S = in.nextLine();
            String result = calc(S);
            System.out.printf("Case #%d: %s\n", i + 1, result);
        }

        in.close();
    }
}