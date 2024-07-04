import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int currentT = 1;
        while(currentT <= T) {
            String S = sc.next();
            getSDash(S);
            System.out.println("Case #" + currentT++ + ": " + getSDash(S));
        }
    }
    private static String getSDash(String string) {
        StringBuilder result = new StringBuilder("");

        int currentOpened = 0;
        for (char c : string.toCharArray()) {
            int need = c - '0';
            if (currentOpened == need) {
                result.append(c);
            } else if (currentOpened > need) {
                result.append(getClosingString(currentOpened - need)).append(c);
            } else {
                result.append(getOpeningString(need - currentOpened)).append(c);
            }
            currentOpened = need;
        }
        if (currentOpened != 0) {
            result.append(getClosingString(currentOpened));
        }
        return result.toString();
    }

    private static String getOpeningString(int n) {
        switch (n) {
            case 1:
                return "(";
            case 2:
                return "((";
            case 3:
                return "(((";
            case 4:
                return "((((";
            case 5:
                return "(((((";
            case 6:
                return "((((((";
            case 7:
                return "(((((((";
            case 8:
                return "((((((((";
            case 9:
                return "(((((((((";
            default:
                return "";
        }
    }
    private static String getClosingString(int n) {
        switch (n) {
            case 1:
                return ")";
            case 2:
                return "))";
            case 3:
                return ")))";
            case 4:
                return "))))";
            case 5:
                return ")))))";
            case 6:
                return "))))))";
            case 7:
                return ")))))))";
            case 8:
                return "))))))))";
            case 9:
                return ")))))))))";
            default:
                return "";
        }
    }
}
