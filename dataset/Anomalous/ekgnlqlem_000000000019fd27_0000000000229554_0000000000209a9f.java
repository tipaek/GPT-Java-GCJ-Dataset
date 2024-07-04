import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        
        for (int c = 1; c <= T; c++) {
            String S = input.next();
            int[] arr = new int[S.length()];
            
            for (int i = 0; i < S.length(); i++) {
                arr[i] = S.charAt(i) - '0';
            }
            
            StringBuilder sb = new StringBuilder();
            int currentDepth = 0;
            
            for (int i = 0; i < arr.length; i++) {
                int digit = arr[i];
                
                if (digit > currentDepth) {
                    for (int j = 0; j < digit - currentDepth; j++) {
                        sb.append('(');
                    }
                } else if (digit < currentDepth) {
                    for (int j = 0; j < currentDepth - digit; j++) {
                        sb.append(')');
                    }
                }
                
                sb.append(digit);
                currentDepth = digit;
            }
            
            for (int j = 0; j < currentDepth; j++) {
                sb.append(')');
            }
            
            System.out.println("Case #" + c + ": " + sb.toString());
        }
        
        input.close();
    }
}