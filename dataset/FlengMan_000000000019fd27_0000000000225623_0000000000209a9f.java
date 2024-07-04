import java.util.*;
import java.io.*;
import java.lang.StringBuilder;
public class Solution {
    public static void main (String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // numebr as
        int prev = 0;
        StringBuilder sb = null;
        ArrayList<String> results = new ArrayList<String>();
        for (int i = 0; i < T; i++) {
            sb = new StringBuilder();
            
            String digit = in.next(); // numebr as a string
            int numArr[] = new int[digit.length()];
            for (int p = 0; p < digit.length(); p++) {
                numArr[p] = Integer.parseInt(digit.charAt(p) + "");
            }
            for (int l = 0; l < digit.length(); l++) {
            
                
                // All digits are nested due to their nesting
                if (prev != 0);
                if (numArr[l] != 0);
                for (int j = prev; j < numArr[l]; j++) {
                    sb.append("(");
                }
                //System.out.println(numArr[l]);
                
                if (((l) <= digit.length()))
                if (prev > numArr[l] || prev == 0) {
                    int temp = prev;
                    while (temp > numArr[l]) {
                        sb.append(")");
                        //System.out.println("Prev: " + prev);
                        temp--;
                    }
                }
                sb.append(numArr[l] +"");
                //System.out.println("Here" + numArr[l]);
                if ((l + 1) == digit.length() && numArr[l] != 0) {
                while (numArr[l] > 0) {
                    sb.append(")");
                        //System.out.println("Prev: " + prev);
                        numArr[l]--;
                }
            }
                prev = numArr[l];
            }
            results.add("Case #" + (i + 1) +": " + sb.toString());
            //System.out.println(sb.toString());
        }
        
        
     for (String s : results) {
         System.out.println(s);
     }   
    }
}