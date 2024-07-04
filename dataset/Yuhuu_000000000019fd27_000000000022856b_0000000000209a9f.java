import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
        String S = in.next(); 
        StringBuffer Sx = new StringBuffer(S);
        for (int j = 0; j < Sx.length(); j++){
            if ( Sx.charAt(j) == '1'){
                int last = Sx.lastIndexOf(")", j);
                if ( last > 0){
                    Sx.delete(j, j+1);
                    Sx.insert(last, "1");
                }
                else{
                    Sx.insert(j+1, ")");
                    Sx.insert(j, "(");
                    j+=2;
                }
            }
        }
        System.out.println("Case #" + i + ": " + Sx.toString());
    }
  }
}