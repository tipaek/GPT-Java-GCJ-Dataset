// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/0000000000209a9f
// TIME - O(n)

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args)throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(buf.readLine());

        for(int test = 1; test <= t; test++ ) {

            String s = buf.readLine();
            String ans = "";
            int open = 0; // count of open braces

            for(int i = 0; i < s.length(); i++) {

                int digit = Character.getNumericValue(s.charAt(i));
                int needed = digit  - open; 

                if(needed == 0) { 
                    ans += digit;
                }
                else if(needed > 0) {
                    for(int j = 1; j <= needed; j++) ans += "(";
                    ans += digit;
                    open += needed;                 
                }
                else {
                    for(int j = 1; j <= Math.abs(needed); j++) ans += ")";
                    ans += digit;
                    open -= Math.abs(needed);                       
                }
            }
            if(open > 0) for(int j = 1; j <= open; j++) ans += ")";
           
            System.out.println("Case #" + test + ": " + ans);
        }
    } 
}
