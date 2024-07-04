import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            String S = scanner.nextLine();
            String full = build(S);
            String min = min(full);
            System.out.println("Case #" + (i + 1) + ": " + min);
        }
    }

    private static String build(String S) {
        char[] charArr = S.toCharArray();
        String[] string = new String[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            string[i] = String.valueOf(charArr[i]);
        }
        for (int i = 0; i < string.length; i++) {
            int digit = Integer.valueOf(string[i]);
            String before = "";
            String after = "";
            for (int j = 0; j < digit; j++) {
                before += "(";
                after += ")";

            }
            string[i] = before + digit + after;
        }
        StringBuilder flat = new StringBuilder();
        for (String str : string) {
            flat.append(str);
        }
        return flat.toString();
    }

    private static String min(String str) {
        while (str.contains(")(")) {
            str = str.replace(")(", "");
        }
        return str;
    }
}