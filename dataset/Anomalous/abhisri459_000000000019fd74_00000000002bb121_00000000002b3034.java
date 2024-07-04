import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Patterns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            String longestString = "";
            int maxLength = 0;

            for (int j = 0; j < n; j++) {
                strings[j] = scanner.next();
                if (strings[j].length() > maxLength) {
                    maxLength = strings[j].length();
                    longestString = strings[j];
                }
            }

            int matchCount = 0;
            for (String s : strings) {
                for (int k = 1; k < longestString.length(); k++) {
                    if (longestString.substring(k).equals(s.substring(1))) {
                        matchCount++;
                        break;
                    }
                }
            }

            if (matchCount == n) {
                System.out.println(longestString.substring(1));
            } else {
                System.out.println("*");
            }
        }
    }
}