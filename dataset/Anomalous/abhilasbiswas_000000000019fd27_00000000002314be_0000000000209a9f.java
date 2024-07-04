import java.util.*;
import java.io.*;

public class Solution {   
    static String[] brace = {
        ")))))))))",
        "))))))))",
        ")))))))",
        "))))))",
        ")))))",
        "))))",
        ")))",
        "))",
        ")",
        "",
        "(",
        "((",
        "(((",
        "((((",
        "(((((",
        "((((((",
        "(((((((",
        "((((((((",
        "((((((((("
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String result = test(input);
            System.out.println("Case #" + i + ": " + result);
        }
        input.close();
    }

    public static String test(Scanner input) {
        String s = input.next();
        int l = s.length();
        int[] n = new int[l + 1];
        
        for (int i = 0; i < l; i++) {
            n[i] = s.charAt(i) - '0';
        }
        
        StringBuilder result = new StringBuilder();
        result.append(brace[n[0] + 9]);
        
        for (int i = 0; i < l - 1; i++) {
            int b = (n[i + 1] - n[i]) + 9;
            result.append(brace[b]);
        }
        
        result.append(brace[9 - n[l - 1]]);
        
        return result.toString();
    }
}