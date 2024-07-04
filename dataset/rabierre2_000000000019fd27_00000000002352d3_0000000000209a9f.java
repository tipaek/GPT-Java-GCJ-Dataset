import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        Solution solution = new Solution();
        for (int i = 1; i <= t; ++i) {
            String line = in.next();
            System.out.println("Case #" + i + ": " + solution.test(line));
        }
    }
    
    public String test(String line) {
        int nesting = 0;
        String result = "";
        for (int i=0; i < line.length(); i++) {
            int curr  = Integer.parseInt(String.valueOf(line.charAt(i)));
            if (curr - nesting > 0) {
                for (int j=0; j<curr - nesting; j++)
                    result += "(";
            } else if (curr - nesting < 0) {
                for (int j=0; j<  Math.abs(curr - nesting); j++)
                    result += ")";
            }
            result += String.valueOf(curr);
            nesting = curr;
        }
        
        if (nesting > 0) {
            for (int i=0; i < nesting; i++)
                    result += ")";
        }
        
        return result;
    }
}