import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            String S = sc.next();
            int[] array = new int[S.length()];
            for (int j = 0; j < S.length(); j++) {
                array[j] = Character.getNumericValue(S.charAt(j));
            }
            
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;
            
            for (int j = 0; j < S.length(); j++) {
                while (openBrackets < array[j]) {
                    result.append("(");
                    openBrackets++;
                }
                while (openBrackets > array[j]) {
                    result.append(")");
                    openBrackets--;
                }
                result.append(array[j]);
            }
            
            while (openBrackets > 0) {
                result.append(")");
                openBrackets--;
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}