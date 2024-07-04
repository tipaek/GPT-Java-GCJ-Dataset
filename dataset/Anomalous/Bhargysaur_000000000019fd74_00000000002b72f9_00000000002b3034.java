import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String[] patterns = new String[n];
            sc.nextLine();
            
            for (int j = 0; j < n; j++) {
                patterns[j] = sc.nextLine();
            }

            boolean isStartMatch = true;
            boolean isEndMatch = true;
            String start = "";
            String end = "";

            for (int j = 0; j < n; j++) {
                String pattern = patterns[j];
                if (pattern.charAt(0) == '*') continue;

                String prefix = pattern.substring(0, pattern.indexOf('*'));
                if (start.length() < prefix.length()) {
                    if (prefix.startsWith(start)) {
                        start = prefix;
                    } else {
                        isStartMatch = false;
                        break;
                    }
                } else {
                    if (!start.startsWith(prefix)) {
                        isStartMatch = false;
                        break;
                    }
                }
                patterns[j] = pattern.substring(pattern.indexOf('*'));
            }

            for (int j = 0; j < n; j++) {
                String pattern = patterns[j];
                if (pattern.charAt(pattern.length() - 1) == '*') continue;

                String suffix = pattern.substring(pattern.lastIndexOf('*') + 1);
                if (end.length() < suffix.length()) {
                    if (suffix.endsWith(end)) {
                        end = suffix;
                    } else {
                        isEndMatch = false;
                        break;
                    }
                } else {
                    if (!end.endsWith(suffix)) {
                        isEndMatch = false;
                        break;
                    }
                }
                patterns[j] = pattern.substring(0, pattern.lastIndexOf('*') + 1);
            }

            if (!isStartMatch || !isEndMatch) {
                System.out.println("Case #" + (i + 1) + ": *");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + start + end);
            }
        }
        sc.close();
    }
}