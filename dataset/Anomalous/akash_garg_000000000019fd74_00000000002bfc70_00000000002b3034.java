import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.print("Case #" + testCase + ": ");
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next();
            }
            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            boolean[] visited = new boolean[n];
            int count = 0, index = 0;
            boolean isValid = true;

            // Process prefix
            while (count < n && isValid) {
                char currentChar = ' ';
                for (int i = 0; i < n; i++) {
                    if (visited[i]) continue;
                    if (patterns[i].charAt(index) == '*') {
                        visited[i] = true;
                        count++;
                    } else if (currentChar == ' ') {
                        currentChar = patterns[i].charAt(index);
                    } else if (currentChar != patterns[i].charAt(index)) {
                        isValid = false;
                        break;
                    }
                }
                if (currentChar != ' ') {
                    prefix.append(currentChar);
                }
                index++;
            }

            // Process suffix
            count = 0;
            index = 1;
            Arrays.fill(visited, false);
            while (count < n && isValid) {
                char currentChar = ' ';
                for (int i = 0; i < n; i++) {
                    if (visited[i]) continue;
                    if (patterns[i].charAt(patterns[i].length() - index) == '*') {
                        visited[i] = true;
                        count++;
                    } else if (currentChar == ' ') {
                        currentChar = patterns[i].charAt(patterns[i].length() - index);
                    } else if (currentChar != patterns[i].charAt(patterns[i].length() - index)) {
                        isValid = false;
                        break;
                    }
                }
                if (currentChar != ' ') {
                    suffix.append(currentChar);
                }
                index++;
            }

            if (isValid) {
                suffix.reverse();
                System.out.println(prefix.toString() + suffix.toString());
            } else {
                System.out.println("*");
            }
        }
    }
}