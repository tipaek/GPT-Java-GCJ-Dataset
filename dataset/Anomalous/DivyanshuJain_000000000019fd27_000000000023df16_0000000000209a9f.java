import java.util.Scanner;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline
        
        for (int i = 0; i < T; i++) {
            String input = sc.nextLine();
            StringBuilder result = new StringBuilder();
            char currentDepth = '0';
            
            for (char ch : input.toCharArray()) {
                if (ch > currentDepth) {
                    result.append(String.join("", Collections.nCopies(ch - currentDepth, "(")));
                } else if (ch < currentDepth) {
                    result.append(String.join("", Collections.nCopies(currentDepth - ch, ")")));
                }
                result.append(ch);
                currentDepth = ch;
            }
            
            if (currentDepth > '0') {
                result.append(String.join("", Collections.nCopies(currentDepth - '0', ")")));
            }
            
            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
        
        sc.close();
    }
}