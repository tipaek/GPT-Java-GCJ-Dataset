import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            String S = in.nextLine();
            results[i] = "Case #" + (i + 1) + ": " + processString(S);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String processString(String S) {
        StringBuilder result = new StringBuilder();
        int previous = 0;

        for (char c : S.toCharArray()) {
            int current = Character.getNumericValue(c);
            while (previous < current) {
                result.append("(");
                previous++;
            }
            while (previous > current) {
                result.append(")");
                previous--;
            }
            result.append(current);
        }

        while (previous > 0) {
            result.append(")");
            previous--;
        }

        return result.toString();
    }
}