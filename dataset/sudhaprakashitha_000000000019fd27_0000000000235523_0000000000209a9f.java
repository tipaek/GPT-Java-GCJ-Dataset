import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import  java .util.*;
class Solution {
    public static void main(String[] agrs) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int x = 1;
        while (t-- > 0) {
            String s=br.readLine();
            String ans="";
            int y=s.charAt(0)-'0';
            while(y-->0)
                ans+="(";
            ans=ans+s.charAt(0);
            for(int i=1;i<s.length();i++)
            {
                y=s.charAt(i-1)-'0';
                int z=s.charAt(i)-'0';
                if(y>z)
                {
                    int k=y-z ;
                    while(k-->0)
                        ans=ans+")";
                    ans=ans+s.charAt(i);
                }
                else
                {
                    int k=z-y;
                    while(k-->0)
                        ans=ans+"(";
                    ans=ans+s.charAt(i);
                }
            }
            int k=s.charAt(s.length()-1)-'0';
            while(k-->0)
                ans=ans+")";
            bw.write("Case #"+x+": "+ans+"\n");
            x++;
        }
        bw.flush();
    }
}
