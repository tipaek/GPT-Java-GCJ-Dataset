import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for (int tc = 1; tc <= T; tc++) {
            String str = in.nextLine();
            System.out.println("Case #" + tc + ": " + solve(str, 0));
        }
    }

    static String solve(String str, int curr) {
        if (str.length() == 0) return "";
        int min = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < str.charAt(min))
                min = i;
        }
        int add = str.charAt(min) - '0' - curr;
        StringBuilder open = new StringBuilder();
        StringBuilder close = new StringBuilder();
        for (int i = 0; i < add; i++) {
            open.append("(");
            close.append(")");
        }
        return open.toString()
                + solve(str.substring(0, min), curr + add)
                + str.charAt(min)
                + solve(str.substring(min + 1), curr + add)
                + close.toString();
    }
}