import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int currentT = 1; currentT <= T; currentT++) {
            String S = sc.next();
            String result = getSDash(S);
            System.out.println("Case #" + currentT + ": " + result);
        }
    }

    private static String getSDash(String string) {
        StringBuilder result = new StringBuilder();
        int currentOpened = 0;

        for (char c : string.toCharArray()) {
            int need = c - '0';
            if (currentOpened < need) {
                result.append("(".repeat(need - currentOpened));
            } else if (currentOpened > need) {
                result.append(")".repeat(currentOpened - need));
            }
            result.append(c);
            currentOpened = need;
        }

        if (currentOpened > 0) {
            result.append(")".repeat(currentOpened));
        }

        return result.toString();
    }
}