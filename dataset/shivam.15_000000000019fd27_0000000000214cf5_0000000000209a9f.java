import java.util.*;
import java.io.*;
class Solution{  
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int t_=1;t_<=t;t_++){
            String a = br.readLine().trim();
            int n = a.length();
            
            int stack = 0;
            String s1 = "";
            for(int i=0;i<n;i++){
                int cur = Integer.parseInt(a.charAt(i)+"");
                if(stack == cur)
                    s1 += cur;
                else if(stack < cur){
                    while(stack < cur){
                        stack++;
                        s1 += "(";
                    }
                    s1 += cur;
                }
                else{
                    while(stack > cur){
                        stack--;
                        s1 += ")";
                    }
                    s1 += cur;
                }
            }
            while(stack-- > 0)
                s1 += ")";
            
            System.out.println("Case #"+t_+": "+s1);
        }
    } 
}