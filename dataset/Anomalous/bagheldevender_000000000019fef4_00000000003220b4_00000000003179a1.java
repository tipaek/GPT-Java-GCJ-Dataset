import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            int u = scanner.nextInt();
            int[] charValues = new int[26];
            Arrays.fill(charValues, 10);
            
            for (int i = 0; i < 10000; i++) {
                int v = scanner.nextInt();
                String s = scanner.next();
                
                if (s.length() == 1) {
                    charValues[s.charAt(0) - 'A'] = Math.min(charValues[s.charAt(0) - 'A'], v);
                }
            }
            
            char[] result = new char[10];
            for (int i = 0; i < 26; i++) {
                if (charValues[i] != 10) {
                    result[charValues[i] - 1] = (char) (i + 'A');
                }
            }
            
            for (char c : result) {
                System.out.print(c);
            }
            System.out.println();
        }
        
        scanner.close();
    }
}