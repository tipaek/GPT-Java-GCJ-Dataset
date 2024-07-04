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
            String ans1="";
            for(int i=0;i<n;i++) {
                for(int j=s[i].length()-1, ind=ma-1;(j>=1) && (ind>=1);j--, ind--) {
                    if(s[i].charAt(j)!='*') {
                        if(s[i].charAt(j)!=ans.charAt(ind)) {
                            ans="*";
                            break;
                        }
                    }
                }
                if(ans.equals("*"))
                    break;
            }
            if(!ans.equals("*"))
                ans=ans.substring(1);
            System.out.println("Case #"+t1+": "+ans);
        }
        br.close();
    }
}