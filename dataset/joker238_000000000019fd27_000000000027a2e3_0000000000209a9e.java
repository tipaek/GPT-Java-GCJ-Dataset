import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int b = sc.nextInt();
        for (int test = 1; test <= t; ++test) {
            int q=1;
            int p=0;
            ArrayList<Character> l = new ArrayList<>();
            while(q<=150) {
                System.out.println(p+1);
                String s = sc.next();
                char ch = s.charAt(0);
                if(l.size()<b) {
                    if (ch == '1')
                        l.add('0');
                    else
                        l.add('1');
                }
                
                p++;
                if(l.size()==b) {
                    p=0;
                }
                q++;
            }
            for(int i=b-1;i>=0;i--)
                System.out.print(l.get(i));

            System.out.println();
            String ok = sc.next();
            if(ok.compareTo("N")==0)
                System.exit(0);


            //System.out.println("Case #" + test + ": " + dp[n-1][p]);
        }
    }
}