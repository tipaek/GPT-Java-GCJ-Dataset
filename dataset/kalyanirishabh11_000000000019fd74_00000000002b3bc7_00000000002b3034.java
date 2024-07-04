import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        // Scanner sc=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine();
        int t=Integer.valueOf(s1.trim());
        for(int t1=1;t1<=t;t1++) {
            s1=br.readLine();
            int n=Integer.valueOf(s1.trim());
            int ma=0;
            String ans="";
            String[] s=new String[n];
            for(int i=0;i<n;i++) {
                s[i]=br.readLine();
                s[i]=s[i].trim();
                if(ma<s[i].length()) {
                    ma=s[i].length();
                    ans=s[i];
                }
            }
            for(int i=0;i<n;i++) {
                if(ans.charAt(ans.length()-1)!='*')
                    if(s[i].charAt(s[i].length()-1)!='*')
                        if(!ans.substring(1,ans.length()).contains(s[i].substring(1,s[i].length())))
                            ans="*";
                else
                    break;
            }
            if(ans.charAt(ans.length()-1)!='*')
                ans=ans.substring(1);
            System.out.println("Case #"+t1+": "+ans);
        }
    }
}