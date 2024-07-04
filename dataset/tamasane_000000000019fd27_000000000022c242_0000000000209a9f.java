import java.lang.*;
import java.io.*;
import java.util.*;

public class Solution{
    private static String solve(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0, c = 0;
        int n = s.length();
        while(i<n){
            int ch = s.charAt(i)-'0';
            while(c<ch){ sb.append('('); c++; }
            while(c>ch){ sb.append(')'); c--; }
            sb.append(s.charAt(i++));
        }
        while(c-->0) sb.append(')');
        return sb.toString().trim();
    }
    public static void main(String...args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        int test = 1;
        while(test <= t){
            String s = br.readLine().trim();
            sb.append("Case #").append(test++).append(": ").append(solve(s)).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}