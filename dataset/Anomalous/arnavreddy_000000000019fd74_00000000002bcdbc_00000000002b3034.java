import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }
            
            System.out.println("Case #" + caseNum + ": " + processStrings(strings));
        }
    }

    public static String processStrings(String[] strings) {
        String longestString = "";
        
        // Remove the first character from each string
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].substring(1);
        }
        
        // Find the longest string
        for (String str : strings) {
            if (str.length() > longestString.length()) {
                longestString = str;
            }
        }
        
        // Check if the longest string ends with all other strings
        for (String str : strings) {
            if (!longestString.equals(str) && !longestString.endsWith(str)) {
                return "*";
            }
        }
        
        return longestString;
    }
}