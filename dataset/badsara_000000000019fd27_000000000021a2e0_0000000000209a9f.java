import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        for(int t=1;t<=T;t++){
            String s=sc.next();
            String ans="";
            int indx=0;
            int open=0;
            for(int i=0;i<s.length();i++){
                int d=Integer.parseInt(s.substring(i,i+1));
                if(d==0){
                    while(open>0){
                        ans+=")";
                        open--;
                    }
                    ans+=d;
                }else{
                    if(d>open){
                        int count=d-open;
                        while(count>0){
                            ans+="(";
                            open++;
                            count--;
                        }
                        ans+=d;
                        indx=ans.length()-1;
                    }else if(d==open){
                        ans+=d;
                    }else{
                        int count=open-d;
                        while(count>0){
                            ans+=")";
                            count--;
                            open--;
                        }
                        ans+=d;
                    }
                }
            }
            while(open>0){
                ans+=")";
                open--;
            }
            sb.append("Case #").append(t).append(": ").append(ans);
            sb.append("\n");
        }
        out.println(sb);
        out.close();
    }
    public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
}