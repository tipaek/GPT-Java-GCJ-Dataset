import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
        String S = in.next(); 
        StringBuffer Sx = new StringBuffer(S);
        int last, last2, last0;
        for (int j = 0; j < Sx.length(); j++){
            int c = Character.getNumericValue(Sx.charAt(j));
            String a = "", p = "";
            for (int k = 0; k < c; k++){
                a+="(";
                p+=")";
            }
            Sx.insert(j+1, p);
            Sx.insert(j, a);
            j+=(c*2);
        }
        
        S = Sx.toString();
        
        while (S.indexOf(")(") > 0){
            S.replace(")(","");
        }
        
        System.out.println("Case #" + i + ": " + S);
    }
  }
}