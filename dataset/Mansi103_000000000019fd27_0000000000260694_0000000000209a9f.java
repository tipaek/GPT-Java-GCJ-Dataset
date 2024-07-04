import java.io.*;
import java.util.*;
public class Solution {
    
    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for(int m=0;m<t;m++) {
            String s = in.readLine();
            s=s+"0";
            String res="";
            int prev = 0;
            for(int i=0;i<s.length();i++) {
                int no = s.charAt(i)-48;
                int diff = prev-no;
                if(diff<0) {
                    for(int j=0;j<Math.abs(diff);j++) 
                        res+="(";
                } else if(diff>0) {
                    for(int j=0;j<diff;j++) 
                        res+=")";
                }
                res+=no;
                prev = no;
            }
            System.out.printf("Case #%d: %s\n",m+1,res.substring(0,res.length()-1));
        }
    }
}