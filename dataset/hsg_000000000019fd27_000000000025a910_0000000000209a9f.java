import java.util.*;
import java.io.*;


public class Solution {
    static Scanner in;
    
    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String line = in.next();
            String nested = transform(line);
            System.out.println(String.format(
                "Case #%d: %s",
                i, nested));
        }
    }
    
    public static String transform(String line) {
        int[] digits = line.chars().map(c -> c - '0').toArray();
        
        int[] padded = new int[line.length() + 2];
        
        System.arraycopy(digits, 0, padded, 1, digits.length);
        
        String result = "";
        
        for (int i = 1; i < padded.length; i++) {
            int diff = padded[i] - padded[i-1];
            
            if (diff < 0) {
                result += String.join("", Collections.nCopies(- diff, ")"));
            }
            if (diff > 0) {
                result += String.join("", Collections.nCopies(diff, "("));
            }
            
            result += padded[i];
        }
        
        return result.substring(0, result.length() - 1);
    }
    
  
}
  