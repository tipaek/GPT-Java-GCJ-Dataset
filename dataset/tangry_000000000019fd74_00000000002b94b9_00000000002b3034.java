import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[n];
            for (int j = 0; j < n; j++) {
                String s = scanner.nextLine();
                patterns[j] = s.replace("*", ".*");
            }
            String result = patterns[findLongest(patterns)];
            result = result.replace(".*", "");
            if (!allMatch(patterns, result)) {
                result = "*";
            } 
            System.out.println("Case #" + i + ": " + result);
        }
    }
    
    public static boolean allMatch(String[] patterns, String test) {
        for (int i = 0; i < patterns.length; i++) {
            if (!Pattern.matches(patterns[i], test)) {
                return false;
            }
        }
        return true;
    }
    
    public static int findLongest(String[] patterns) {
        int longest = -1;
        int result = 0;
        for (int i = 0; i < patterns.length; i++) {
            if (patterns[i].length() > longest) {
                result = i;
                longest = patterns[i].length();
            }
        }
        return result;
    }
}