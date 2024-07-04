import java.io.*;
import java.util.*;
public class Solution {
    
    public static void solve(int x, String s){
        s=s+"0";
        String ss="";
        int prev = 0;
        for(int i=0;i<s.length();i++) {
            int no = s.charAt(i)-48;
            int diff = prev-no;
            if(diff<0) {
                for(int j=0;j<Math.abs(diff);j++) {
                    ss+="(";
                }
            } else if(diff>0) {
                for(int j=0;j<diff;j++) {
                    ss+=")";
                }
            }
            ss+=no;
            prev = no;
        }
        System.out.printf("Case #%d: %s\n",x+1,ss.substring(0,ss.length()-1));
    }
    
    public static void main(String[] args)throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        int t = Integer.parseInt(br.readLine());
        for(int m=0;m<t;m++) {
            String s = br.readLine();
            solve(m,s);
        }
    }
}