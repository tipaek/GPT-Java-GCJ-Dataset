
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder op = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int t=1; t <= tc; t++) {
            char[] s = br.readLine().toCharArray();
            StringBuilder ans = new StringBuilder();
            int  in = 0; // No of starting bracket
            for(char c: s){
                int n = c-'0';
                if(in==n)ans.append(c);
                else if (in < n){
                    while(in!=n){ans.append('('); in++;}
                    ans.append(n);
                }else{
                    while(in!=n){ans.append(')'); in--;}
                    ans.append(n);
                }
            }

            while(in!=0){ans.append(')'); in--;}
           
            op.append("Case #"+t+": "+ans+"\n");
        }
        System.out.println(op);

    }

}
