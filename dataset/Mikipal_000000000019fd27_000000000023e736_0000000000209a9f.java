
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            String s1 = "";
            for(int j = 0; j<s.length(); j++){
                if(j>0){
                    if(s.charAt(j) != s.charAt(j-1)){
                       s1+= genp(s.charAt(j-1), false) + genp(s.charAt(j), true) + s.charAt(j);
                    }else{
                        s1+=s.charAt(j);
                    }
                }else{
                    s1+=genp(s.charAt(j), true) + s.charAt(j);
                }
            }
            s1+=genp(s.charAt(s.length()-1), false);
            System.out.println("Case #" + i + ": " + s1);
        }
    }
    
    public static String genp(char c, boolean open){
        int n = Integer.parseInt(c+"");
        String r = "";
        for (int i = 0; i < n; i++) {
            r+= (open ? "(" : ")");
        }
        return r;
    }
}