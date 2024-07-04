import java.io.*;
import java.util.*;
import java.math.*;
import java.util.regex.*;
public class Solution{
    static Scanner sc=new Scanner(System.in);
    static String solve(int a,int b,int p){
        // int N=0,W=0,S=0,E=0;
        String s=new String (""); 
        int x=a;int y=b;
        if(x>0&&y==0){
            return s+"EE";
        }
        if(y>0&&x==0){
            return s+"WW";
        }
        if((x>0&&x<y)&&(y>0&&x<y)){
            return s+"SEN";
        }
        if((x<0&&x>y)&&(y<0&&x>y)){
            return s+"NWS";
        }
        if((Math.abs(x)==(y))){
            return s+"IMPOSIBLE";
        }
    
        return s+"IMPOSIBLE";
        // if((&&)&&(&&))
        
    }
    public static void main(String[]args){
        int t =sc.nextInt();
        for(int p=1;p<=t;p++){
            int x=sc.nextInt();
            int y=sc.nextInt();
          System.out.println( "Case #"+p+": "+solve(x,y,p));
        }
    }
}