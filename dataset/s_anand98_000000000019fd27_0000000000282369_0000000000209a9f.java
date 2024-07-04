import java.io.*;
import java.util.*;
class Solution{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuffer sb = new StringBuffer();
        for(int test = 1; test<=t; test++){
            String s = br.readLine().trim();
            int n = s.length();
            String str = "";
            int cur = 0;
            for(int i=0;i<n;i++){
                
                int x = s.charAt(i)-'0';
                if(x>cur){
                    while(cur<x){
                        str+='(';
                        cur++;
                    }
                }
                else{
                   while(cur>x){
                        str+=')';
                        cur--;
                    } 
                }
                str+=x;
            }
            
            while(cur>0){
                str+=')';
                cur--;
            }
            
            sb.append(str+"\n");
        }
        
        System.out.print(sb);
    }
}
        
    