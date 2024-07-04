import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);
//        sc.useDelimiter(Pattern.compile("[\n /]"));

x:        for (int cs = 1, cases = sc.nextInt(); cs <= cases; cs++) {
            int r = sc.nextInt();
            int s = sc.nextInt();
            System.out.printf("Case #%d: %d%n", cs, (r-1)*(s-1));
            for (int a = r*(s-1), b=r-1, i=1; b!=0; i++,a--) {
                System.out.println(a+" "+b);
                if (i==s-1) {
                    i=0;
                    b--;
                }
            }
        }
    }
}
