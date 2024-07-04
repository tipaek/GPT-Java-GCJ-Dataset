import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) 
        {
            String res = "";
            String s = in.next();
            int p = 0;
            for(int j=0; j<s.length(); j++)
            {
                int n = Integer.parseInt(Character.toString(s.charAt(j)));
                if(n>p){
                    for(int k=p; k<n; k++){
                        res+="(";
                        p++;
                    }
                    res+=n;
                }
                else if(n<p){
                    for(int k=p; k>n; k--){
                        res+=")";
                        p--;
                    }
                    res+=n;
                }
                else{
                    res+=n;
                }
            }
            for(int k=p; k>0; k--){
                res+=")";
            }
            System.out.println("Case #"+i+": "+res);
        }
    }
}