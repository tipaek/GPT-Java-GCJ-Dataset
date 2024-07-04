import java.io.*;
import java.lang.*;
import java.util.*;

class codejam {
   static Scanner scn= new Scanner(System.in);
    public static void main(String[] args)
    {
        int t = scn.nextInt();
        for(int count = 0 ; count < t ;count++) {
            
            String s = scn.next();
     System.out.println("Case #" + count + ": " + nesting(s));
        }
    }
    public static String nesting(String s) {
        String ans = "";
        int depth = 0;
        int num = s.charAt(0) - '0';
        for(int i = 0 ; i < num ; i++) {
            ans+="(";
        }
        ans+=num;
        depth+=num;
        for(int i = 1 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            int prev = s.charAt(i-1)- '0';
            int n = ch-'0';
            
            if(n < prev)
                {
                    for(int j = 0 ; j < prev-n;j++)
                        ans+=")";
                    depth-=(prev-n);    
                }
            else {
                for(int j = 0 ; j < n-prev;j++) {
                    ans+="(";
                depth+=(n-prev);
                }
            }
                
            ans+=ch;
        }
        while(depth!=0){
            ans+=")";
        depth--;
    }
    return ans;
    }
}