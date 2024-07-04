import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            String longestString = "";
            int maxLength = 0;

            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
                if (strings[i].length() > maxLength) {
                    longestString = strings[i];
                    maxLength = strings[i].length();
                }
            }

            boolean isValid = true;
            for (int i = 0; i < n; i++) {
                String substring = strings[i].substring(1);
                if (substring.indexOf(longestString.substring(1)) != 0 || 
                    strings[i].charAt(strings[i].length() - 1) != longestString.charAt(longestString.length() - 1)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + t + ": " + longestString.substring(1));
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
    }
}