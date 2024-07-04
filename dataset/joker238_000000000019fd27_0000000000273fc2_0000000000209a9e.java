import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int b = sc.nextInt();
        for (int test = 1; test <= t; ++test) {
            int q=1;
            while(q<=150) {
                Random rand = new Random();
                int p = rand.nextInt(b);
                System.out.println(p+1);
                String s = sc.next();
                char ch = s.charAt(0);
                if(q%10==1) {

                }
                q++;
            }
            String s="";
            for(int i=0;i<b;i++) s += "0";
            System.out.println(s);

            //System.out.println("Case #" + test + ": " + dp[n-1][p]);
        }
    }
}