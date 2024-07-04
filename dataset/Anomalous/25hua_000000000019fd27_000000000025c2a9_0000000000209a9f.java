import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int caseCount = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
                String nums = sc.nextLine();
                StringBuilder result = new StringBuilder();
                char previousChar = ' ';
                
                for (char currentChar : nums.toCharArray()) {
                    if (currentChar == '0') {
                        if (previousChar == '1') {
                            result.append(")");
                        }
                        result.append(currentChar);
                    } else {
                        if (previousChar != '1') {
                            result.append("(");
                        }
                        result.append(currentChar);
                    }
                    previousChar = currentChar;
                }
                
                if (previousChar == '1') {
                    result.append(")");
                }
                
                System.out.printf("Case #%d: %s\n", caseIndex, result.toString());
            }
        }
    }
}