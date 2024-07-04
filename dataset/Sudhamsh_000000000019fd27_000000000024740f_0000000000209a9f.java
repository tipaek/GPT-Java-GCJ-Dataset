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
            int k=Integer.parseInt(s.charAt(0)+"");
            while(k-->0)
            ans+="(";
            ans=ans+s.charAt(0);
            for(int i=1;i<s.length();i++)
            {
                int q=s.charAt(i-1)-'0';
                int w=s.charAt(i)-'0';
                if(q>w)
                {
                    int p=q-w;
                    while(p-->0)
                    ans+=")";
                }
                else{
                    int p=w-q;
                    while(p-->0)
                    ans+="(";
                }
                ans=ans+s.charAt(i);
            }
            k=s.charAt(s.length()-1)-'0';
            while(k-->0)
                ans+=")";
            bw.write("Case #"+x+": "+ans+"\n");
            x++;
        
        }
        bw.flush();
    }
}
