import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();  // Consume the newline character

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sc.nextLine();  // Consume the newline character
            String[] patterns = new String[n];

            for (int j = 0; j < n; j++) {
                patterns[j] = sc.nextLine();
            }

            String start = "";
            String end = "";
            boolean startsMatch = true;
            boolean endingsMatch = true;

            for (String pattern : patterns) {
                if (pattern.charAt(0) != '*') {
                    String prefix = pattern.substring(0, pattern.indexOf('*'));
                    if (start.length() < prefix.length() && prefix.startsWith(start)) {
                        start = prefix;
                    } else if (start.startsWith(prefix)) {
                        // No action needed, start is already the larger matching prefix
                    } else {
                        startsMatch = false;
                        break;
                    }
                }
            }

            for (String pattern : patterns) {
                if (pattern.charAt(pattern.length() - 1) != '*') {
                    String suffix = pattern.substring(pattern.lastIndexOf('*') + 1);
                    if (end.length() < suffix.length() && suffix.endsWith(end)) {
                        end = suffix;
                    } else if (end.endsWith(suffix)) {
                        // No action needed, end is already the larger matching suffix
                    } else {
                        endingsMatch = false;
                        break;
                    }
                }
            }

            if (!startsMatch || !endingsMatch) {
                System.out.println("Case #" + (i + 1) + ": *");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + start + end);
            }
        }

        sc.close();
    }
}