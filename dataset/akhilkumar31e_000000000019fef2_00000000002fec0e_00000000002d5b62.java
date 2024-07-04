import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static String  ans="";
    public static void find(int x,int y,int i,int cx,int cy,String p){
         if(Math.abs(cx)>Math.abs(x)||Math.abs(cy)>Math.abs(y)){
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
       
        find(x,y,i+1,cx+((int)Math.pow(2,i-1)),cy,p+"E");
        find(x,y,i+1,cx,cy+((int)Math.pow(2,i-1)),p+"N");
        find(x,y,i+1,cx-((int)Math.pow(2,i-1)),cy,p+"W");
        find(x,y,i+1,cx,cy-((int)Math.pow(2,i-1)),p+"S");
    }

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int test=1;test<=t;test++){
            String s[]=br.readLine().split(" ");
            int x=Integer.parseInt(s[0]);
            int y=Integer.parseInt(s[1]);
            find(x,y,1,0,0,"");
            if(ans=="")
            System.out.println("Case #"+test+": IMPOSSIBLE");
            else System.out.println("Case #"+test+": "+ans);
            ans="";
        }
    }
}