import java.io.*;
import java.util.*;
public class Solution {
    
    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(in.readLine());
        //input form user
        for(int k=0;k<test; k++) {
            String str = in.readLine();
            str=str+"0";
            String r="";
            int prev = 0;
            //find length
            for(int i=0;i<str.length();i++) {
                int num = str.charAt(i)-48;
                int d = prev-num;
                if(d<0) {
                    for(int j=0;j<Math.abs(d);j++) 
                        r+="(";
                } else if(d>0) {
                    for(int j=0;j<d;j++) 
                        r+=")";
                }
                r+=num;
                prev = num;
            }
            System.out.printf("Case #%d: %s\n",k+1,r.substring(0,r.length()-1));
        }
    }
}