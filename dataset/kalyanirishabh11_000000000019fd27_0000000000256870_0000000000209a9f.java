import java.util.*;
import java.math.*;
import java.lang.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        String s=br.readLine();
        int t=Integer.valueOf(s.trim());
        for(int t1=1;t1<=t;t1++) {
            s=br.readLine();
            s=s.trim();
            int nest=0;
            String ans="";
            for(int i=0;i<s.length();i++) {
                int b=s.charAt(i)-'0';
                if(nest>b) {
                    while(nest!=b) {
                        ans+=")";
                        nest--;
                    }
                }
                else {
                    while(nest!=b) {
                        ans+="(";
                        nest++;
                    }
                }
                ans+=b;
            }
            while(nest!=0) {
                ans+=")";
                nest--;
            }
            pw.println("Case #"+t1+": "+ans);
        }
        pw.close();
        br.close();
    }
}