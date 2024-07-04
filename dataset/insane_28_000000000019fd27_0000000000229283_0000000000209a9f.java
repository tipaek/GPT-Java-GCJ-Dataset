import java.io.*;
import java.lang.*;
import java.util.*;

class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = new Integer(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int z=1;z<=t;z++){
            sb.append("Case #").append(z).append(": ");
            String s = br.readLine();
            int brackets = 0;
            for(int i=0;i<s.length();i++){
                int x = (int)(s.charAt(i)-'0');
                if(brackets<x){
                    while(brackets<x){
                        brackets++;
                        sb.append("("); 
                    }
                    sb.append(x);
                }
                else if(brackets>x){
                    while(brackets>x){
                        brackets--;
                        sb.append(")");
                    }
                    sb.append(x);
                }
                else{
                    sb.append(x);
                }
            }
            while(brackets>0){
                brackets--;
                sb.append(")");
            }
            sb.append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}
        
            