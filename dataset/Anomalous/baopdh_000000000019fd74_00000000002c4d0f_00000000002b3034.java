import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int k = 1; k <= t; ++k) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            String longestString = "";

            for (int i = 0; i < n; ++i) {
                strings[i] = scanner.next();
                if (strings[i].length() > longestString.length()) {
                    longestString = strings[i];
                }
            }

            boolean isValid = true;
            for (int i = 0; i < n; ++i) {
                if (!longestString.endsWith(strings[i].substring(1))) {
                    isValid = false;
                    break;
                }
            }

            String result = isValid ? longestString.substring(1) : "*";
            System.out.println("Case #" + k + ": " + result);
        }

        scanner.close();
    }
}