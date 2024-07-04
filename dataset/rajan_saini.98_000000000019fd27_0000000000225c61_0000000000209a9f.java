import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(in.readLine().trim());
        
        for(int i=0; i<t; i++) {
            String s = in.readLine().trim();
            int depth = 0;
            StringBuilder sb_temp = new StringBuilder();
            
            for(int j=0; j<s.length(); j++) {
                int digit = Character.getNumericValue(s.charAt(j));
                increaseDepth(digit-depth, sb_temp, digit);
                depth = digit;
            }
            while(depth-->0) {
                sb_temp.append(")");
            }
            
            sb.append("Case #"+(i+1)+": "+sb_temp.toString()+"\n");
        }
        System.out.println(sb.toString());
    }
    
    private static void increaseDepth(int i, StringBuilder sb, int digit) {
        if(i>0) {
            while(i-->0) {
                sb.append("(");
            }
        }
        else if(i<0) {
            while(i++<0) {
                sb.append(")");
            }
        }
        sb.append(digit);
    }
}