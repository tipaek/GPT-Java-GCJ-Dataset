import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int q = 1; q<=t; q++) {
            char s[]=br.readLine().toCharArray();
            int n=s.length;
            int p=0;
            int d=s[0]-'0';
            int x=0;
            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < d; j++) {
                ans.append('(');
                x++;
            }
            ans.append(s[0]);
            for (int i = 1; i < n; i++) {
                d=s[i]-s[i-1];
                for (int j = 0; j < Math.abs(d); j++) {
                    if(d<0){
                        ans.append(')');x--;
                    }
                    else{
                        ans.append('(');x++;
                    }
                }
                ans.append(s[i]);
                //if(d==0)ans.append(s[i]);
            }
            
            for (int i = 0; i < Math.abs(x); i++) {
                if(x>0)ans.append(')');
                else ans.append('(');
            }
            sb.append("Case #"+q+": "+ans+"\n");
        }
        System.out.println(sb);
    }
}
