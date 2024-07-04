import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int m = in.nextInt();
            int n = in.nextInt();
            String ans=null;
            if(Integer.bitCount(Math.abs(m)+Math.abs(n))==1)
                ans = "IMPOSSIBLE";
            else {
                if(m>0 && n>0){
                    ans = "SEN";
                }
                if(m>0 && n<0){
                    ans= "NES";
                }
                if(m<0 && n>0){
                    ans = "SWN";
                }
                if(m<0 && n<0){
                    ans = "NWS";
                }
                if(m==0 && n>0){
                    ans = "NN";
                }
                if(m==0 && n<0){
                    ans = "SS";
                }
                if(m>0 && n==0){
                    ans = "EE";
                }
                if(m<0 && n==0){
                    ans = "WW";
                }
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}