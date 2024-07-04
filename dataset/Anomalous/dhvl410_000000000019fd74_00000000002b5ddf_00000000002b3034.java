import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        while (testCases > 0) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }
            
            for (int i = 1; i < n; i++) {
                match(strings[i - 1], strings[i]);
            }
            
            testCases--;
        }
    }

    static String match(String a, String b) {
        char[] text = a.toCharArray();
        char[] pattern = b.toCharArray();
        int textLength = text.length;
        int patternLength = pattern.length;

        if (patternLength > textLength) {
            return "*";
        }

        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;
            for (j = 0; j < patternLength; j++) {
                if (pattern[j] != text[i + j]) {
                    break;
                }
            }
            if (j == patternLength) {
                return String.valueOf(i);
            }
        }

        return "*";
    }
}