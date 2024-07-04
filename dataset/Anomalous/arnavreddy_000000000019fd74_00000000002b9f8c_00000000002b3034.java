import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numStrings = scanner.nextInt();
            String[] strings = new String[numStrings];
            
            for (int i = 0; i < numStrings; i++) {
                strings[i] = scanner.next();
            }
            
            System.out.println("Case #" + testCase + ": " + findCommonPattern(strings));
        }
    }

    public static String findCommonPattern(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].substring(1);
        }

        String longestString = Arrays.stream(strings)
                                     .max(Comparator.comparingInt(String::length))
                                     .orElse("");

        for (String str : strings) {
            if (!longestString.contains(str)) {
                return "*";
            }
        }

        return longestString;
    }
}