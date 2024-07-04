import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        List<String> results = new ArrayList<>();
        
        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            String digit = in.next();
            int[] numArr = new int[digit.length()];
            
            for (int p = 0; p < digit.length(); p++) {
                numArr[p] = Character.getNumericValue(digit.charAt(p));
            }
            
            int prev = 0;
            for (int l = 0; l < digit.length(); l++) {
                int current = numArr[l];
                
                if (prev < current) {
                    for (int j = prev; j < current; j++) {
                        sb.append("(");
                    }
                } else if (prev > current) {
                    for (int j = prev; j > current; j--) {
                        sb.append(")");
                    }
                }
                
                sb.append(current);
                prev = current;
            }
            
            for (int j = 0; j < prev; j++) {
                sb.append(")");
            }
            
            results.add("Case #" + (i + 1) + ": " + sb.toString());
        }
        
        for (String result : results) {
            System.out.println(result);
        }
    }
}