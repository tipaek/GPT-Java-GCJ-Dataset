import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static String  ans="";
    public static void find(long x,long y,long i,long cx,long cy,String p){
         if(Math.abs(cx)>(Math.abs(x)*Math.abs(x))||Math.abs(cy)>(Math.abs(y)*Math.abs(y))){
            return;
        }
        if(cx==x&&cy==y){
            if(ans==""){
               ans=p;
                return;
            }
            else{
                if(ans.length()>p.length()){
                    ans=p;
                }
                return;
            }
        }
       
        find(x,y,i+1,cx+((long)Math.pow(2,i-1)),cy,p+"E");
        find(x,y,i+1,cx,cy+((long)Math.pow(2,i-1)),p+"N");
        find(x,y,i+1,cx-((long)Math.pow(2,i-1)),cy,p+"W");
        find(x,y,i+1,cx,cy-((long)Math.pow(2,i-1)),p+"S");
    }

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int test=1;test<=t;test++){
            String s[]=br.readLine().split(" ");
            long x=Long.parseLong(s[0]);
            long y=Long.parseLong(s[1]);
            find(x,y,1,0,0,"");
            if(ans=="")
            System.out.println("Case #"+test+": IMPOSSIBLE");
            else System.out.println("Case #"+test+": "+ans);
            ans="";
        }
    }
}