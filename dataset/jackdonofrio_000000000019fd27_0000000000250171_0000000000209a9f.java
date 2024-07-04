import java.util.Scanner;

public class Solution{

     public static void main(String []args){
         Scanner s = new Scanner(System.in);
         int cases = s.nextInt();
         for (int q = 0; q < cases; q++) {
            String number = s.next();
            int depth = 0;
            String result = "";
            char[] digits = number.toCharArray();
            for (char digit : digits) {
                int newDepth = Integer.parseInt(String.valueOf(digit));
                while (newDepth > depth) {
                    depth++; 
                    result += "(";
                }
                while (newDepth < depth) {
                    depth--;
                    result += ")";
                }
                result += digit;
                
            }
            while (depth > 0) {
                depth--;
                result += ")";
            }
            
         System.out.println("Case #" + (q + 1) + ": " + result);
         
         
         
         }
         
         
     }
}