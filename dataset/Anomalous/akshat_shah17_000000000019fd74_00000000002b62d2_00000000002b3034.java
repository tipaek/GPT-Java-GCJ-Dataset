import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            int maxLength = -1;
            int maxIndex = -1;

            for (int j = 0; j < n; j++) {
                strings[j] = scanner.next();
                if (strings[j].length() > maxLength) {
                    maxLength = strings[j].length();
                    maxIndex = j;
                }
            }

            for (int j = 0; j < n; j++) {
                strings[j] = strings[j].substring(1);
            }

            String longestString = strings[maxIndex];
            boolean isValid = true;

            for (String str : strings) {
                if (!longestString.contains(str)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + (i + 1) + ": " + longestString);
            } else {
                System.out.println("Case #" + (i + 1) + ": *");
            }
        }
    }
}