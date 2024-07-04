import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int t = 1; t <= testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentLevel = 0;

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                while (currentLevel < digit) {
                    result.append('(');
                    currentLevel++;
                }
                while (currentLevel > digit) {
                    result.append(')');
                    currentLevel--;
                }
                result.append(ch);
            }

            while (currentLevel > 0) {
                result.append(')');
                currentLevel--;
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}