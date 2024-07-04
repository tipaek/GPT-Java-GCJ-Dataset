import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            String sIn = sc.next();
            StringBuilder sOut = new StringBuilder();
            int openBrackets = 0;

            for (int j = 0; j < sIn.length(); j++) {
                int num = Character.getNumericValue(sIn.charAt(j));
                
                while (openBrackets < num) {
                    sOut.append("(");
                    openBrackets++;
                }
                
                while (openBrackets > num) {
                    sOut.append(")");
                    openBrackets--;
                }
                
                sOut.append(num);
            }
            
            while (openBrackets > 0) {
                sOut.append(")");
                openBrackets--;
            }

            System.out.println("Case #" + i + ": " + sOut.toString());
        }
    }
}