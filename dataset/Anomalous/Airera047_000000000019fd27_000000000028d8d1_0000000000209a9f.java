import java.util.Scanner;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int testN = input.nextInt();
        
        for (int i = 0; i < testN; i++) {
            String input1 = input.next();
            StringBuilder str = new StringBuilder();
            int depth = 0;

            for (int j = 0; j < input1.length(); j++) {
                int currentDigit = input1.charAt(j) - '0';
                
                while (depth < currentDigit) {
                    str.append("(");
                    depth++;
                }
                
                while (depth > currentDigit) {
                    str.append(")");
                    depth--;
                }
                
                str.append(input1.charAt(j));
            }
            
            while (depth > 0) {
                str.append(")");
                depth--;
            }

            System.out.println("Case #" + (i + 1) + ": " + str.toString());
        }
    }
}