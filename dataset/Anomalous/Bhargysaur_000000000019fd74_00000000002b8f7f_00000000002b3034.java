import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character after the integer input

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sc.nextLine(); // Consume the newline character after the integer input
            String[] patterns = new String[n];

            for (int j = 0; j < n; j++) {
                patterns[j] = sc.nextLine();
            }

            boolean startsMatch = true;
            boolean endingsMatch = true;

            String start = "";
            for (int j = 0; j < n; j++) {
                String pattern = patterns[j];
                if (pattern.charAt(0) == '*') continue;

                String prefix = pattern.substring(0, pattern.indexOf('*'));
                if (start.length() < prefix.length()) {
                    if (prefix.startsWith(start)) {
                        start = prefix;
                    } else {
                        startsMatch = false;
                        break;
                    }
                } else {
                    if (start.startsWith(prefix)) {
                        patterns[j] = pattern.substring(pattern.indexOf('*'));
                    } else {
                        startsMatch = false;
                        break;
                    }
                }
            }

            String end = "";
            for (int j = 0; j < n; j++) {
                String pattern = patterns[j];
                if (pattern.charAt(pattern.length() - 1) == '*') continue;

                String suffix = "";
                if (pattern.length() > pattern.lastIndexOf('*') + 1) {
                    suffix = pattern.substring(pattern.lastIndexOf('*') + 1);
                }

                if (end.length() < suffix.length()) {
                    if (suffix.endsWith(end)) {
                        end = suffix;
                    } else {
                        endingsMatch = false;
                        break;
                    }
                } else {
                    if (end.endsWith(suffix)) {
                        patterns[j] = pattern.substring(0, pattern.lastIndexOf('*') + 1);
                    } else {
                        endingsMatch = false;
                        break;
                    }
                }
            }

            if (!startsMatch || !endingsMatch) {
                System.out.println("Case #" + (i + 1) + ": *");
                continue;
            }

            StringBuilder totalMid = new StringBuilder();
            for (String pattern : patterns) {
                totalMid.append(pattern.replace("*", ""));
            }

            System.out.println("Case #" + (i + 1) + ": " + start + totalMid + end);
        }

        sc.close();
    }
}