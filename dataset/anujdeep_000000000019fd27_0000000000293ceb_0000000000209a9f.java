import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++){
            String s=sc.next();
            StringBuffer sb=new StringBuffer();
            int n=s.length();
            int pre=0;
            for(int i=0;i<n;i++){
                int x=s.charAt(i)-'0';
                if(sb.length()==0 && x>0){
                    for(int j=0;j<x;j++)
                    sb.append('(');
                    sb.append(x);
                    pre=x;
                }
                else{
                    if(x>pre){
                        for(int j=0;j<x-pre;j++)
                        sb.append('(');
                        sb.append(x);
                        pre=x;
                    }
                    else if(x<pre){
                        for(int j=0;j<pre-x;j++)
                        sb.append(')');
                        sb.append(x);
                        pre=x;
                    }
                    else if(x==pre){
                        sb.append(x);
                        pre=x;
                    }
                }
            }
            for(int i=0;i<pre;i++)
            sb.append(')');
            System.out.println("Case #"+k+": "+sb);
            
        }
    }
}
