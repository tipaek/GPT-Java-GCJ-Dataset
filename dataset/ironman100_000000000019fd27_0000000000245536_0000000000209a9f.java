import java.io.*;
import java.util.*;
public class Solution{

     public static void main(String []args)throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int t = Integer.parseInt(line);
        for(int T=1;T<=t;T++){
        
           String x = br.readLine();
           int n = x.length();
         StringBuilder sb = new StringBuilder(x);
            
            int u=0;
            int count = 0;
            for(int i=0;i<n;i++){
                int bh=0;
                int val = (int)x.charAt(i) - 48;
                for(int j=0;j<val-count;j++){
                    sb.insert(u,'('); u++;
                    bh++;
                }
                count += bh;
                u++;
            }
            int yy = u-1;
            int cl = 0;
            while(yy>=0){
                char g = sb.charAt(yy);
                if(g=='('||g==')'){ if(g=='(') cl--; else cl++; yy--; continue;}
                int val = (int)g - 48;
                int bh = 0;
                for(int j=0;j<val-cl;j++){
                    sb.insert(yy+1,')'); 
                    bh++;
                }
                cl+=bh;
                if(cl>val){
                    for(int jj=0;jj<cl-val;jj++) sb.insert(yy+1,'(');
                    cl=val;
                }
                yy--;
            }
            
            
        System.out.println("Case #"+T+": "+ sb);
        }
     }
}