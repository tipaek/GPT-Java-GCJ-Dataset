import java.util.Scanner;

public class Solution {

    public static void processString(String input, int caseNo) {
        String localString = input;
        String pattern = "db";

        while (localString.contains(pattern)) {
            localString = localString.replaceAll(pattern, "");
        }

        localString = localString.replaceAll("b", "(");
        localString = localString.replaceAll("d", ")");
        System.out.println("Case #" + caseNo + ": " + localString);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 1; i <= T; i++) {
            String N = in.next();
            StringBuilder input = new StringBuilder();

            for (int ii = 0; ii < N.length(); ii++) {
                int num = Character.getNumericValue(N.charAt(ii));
                input.append("b".repeat(num)).append(num).append("d".repeat(num));
            }

            processString(input.toString(), i);
        }
    }
}