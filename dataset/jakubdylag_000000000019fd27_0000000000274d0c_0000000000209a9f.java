import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String n = in.next();

            String ans = "";
            //what to do at start
            if(n.charAt(0) != '0'){
                ans+= openBrackets(Character.getNumericValue(n.charAt(0))) ;
            }
            for (int x = 0; x < n.length() ; x++) {
                //difference between two is how many brackets
                int a = 0;
                int b = 0;
                if(x + 1 == n.length()){ //next one out of bounds
                    a = Character.getNumericValue(n.charAt(x));
                    b = 0;
                } else {
                    a = Character.getNumericValue(n.charAt(x));
                    b = Character.getNumericValue(n.charAt(x+1));
                }
                ans += a;
                if(a<b){
                    ans+= openBrackets(b-a);
                } else if(a > b){
                    ans+= closeBrackets(a - b);
                }
            }

            //int m = in.nextInt();
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    public static String openBrackets (int n){
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            s.append("(");
        }
        return s.toString();
    }

    public static String closeBrackets (int n){
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            s.append(")");
        }
        return s.toString();
    }
}