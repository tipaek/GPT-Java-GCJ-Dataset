import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next().replace("*", "");
            }
            
            String longestString = "";
            for (String str : strings) {
                if (str.length() > longestString.length()) {
                    longestString = str;
                }
            }
            
            boolean isValid = true;
            for (String str : strings) {
                if (!longestString.contains(str)) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                System.out.println("Case #" + caseNumber + ": " + longestString);
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }
        }
    }
}