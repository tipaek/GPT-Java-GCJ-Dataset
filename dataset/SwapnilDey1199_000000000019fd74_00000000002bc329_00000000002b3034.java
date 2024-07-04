import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int t = sc.nextInt();
        int z = 1;
        while(t-->0){
            int n = sc.nextInt();
            String[]arr = new String[n];
            for(int i = 0;i<n;i++){
                arr[i]=sc.next();
            }
            String temp="";
            String left = "",right ="";
            for(String s:arr){
                int i = s.indexOf("*");
                String ls = s.substring(0,i);
                String rs = s.substring(i+1,s.length());
                if(ls.length()>left.length()) left = ls;
                if(rs.length()>right.length()) right = rs;
            }
            //System.out.println(left+"  "+right);
            boolean b = true;
            for(String s:arr){
                int i = s.indexOf("*");
                String ls = s.substring(0,i);
                String rs = s.substring(i+1,s.length());
                if(!left.startsWith(ls)){
                    b = false;
                    break;
                }
                if(!right.endsWith(rs)){
                    b=false;
                    break;
                }
            }
            if(!b) sb.append("Case #"+z+": "+"*"+"\n");
            else sb.append("Case #"+z+": "+combine(left,right)+"\n");
            z++;
        }
        System.out.print(sb);
    }
    
    public static String combine(String a, String b){
        int i = 0;
        while(!b.startsWith(a.substring(i))){
            i++;
            if(i==a.length()) return a+b;
        }
        return a.substring(0,i)+b;
    }
}