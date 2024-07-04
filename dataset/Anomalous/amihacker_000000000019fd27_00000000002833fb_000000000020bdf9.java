import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input
        
        for (int i = 1; i <= t; ++i) {
            String s = scanner.nextLine();
            StringBuilder sNew = new StringBuilder();
            
            int[] iNum = new int[s.length() + 2];
            iNum[0] = 0;
            iNum[s.length() + 1] = 0;
            
            for (int j = 1; j <= s.length(); j++) {
                iNum[j] = s.charAt(j - 1) - '0';
            }
            
            for (int j = 0; j < s.length() + 1; j++) {
                if (iNum[j] < iNum[j + 1]) {
                    int openBrackets = iNum[j + 1] - iNum[j];
                    for (int k = 0; k < openBrackets; k++) {
                        sNew.append("(");
                    }
                } else if (iNum[j] > iNum[j + 1]) {
                    int closeBrackets = iNum[j] - iNum[j + 1];
                    for (int k = 0; k < closeBrackets; k++) {
                        sNew.append(")");
                    }
                }
                sNew.append(iNum[j + 1]);
            }
            
            sNew.setLength(sNew.length() - 1); // Remove the last appended digit
            System.out.println(sNew.toString());
        }
        
        scanner.close();
    }
}