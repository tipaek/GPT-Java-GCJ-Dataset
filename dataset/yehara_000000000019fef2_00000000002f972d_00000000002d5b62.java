import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    
    static PrintWriter out;

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        out = new PrintWriter(System.out);
        for (int t = 1; t <= count; t++) {
            out.print("Case #" + t + ": ");
            solve(s, out);
        }
        out.close();
    }

    static void solve(Scanner sc, PrintWriter out) {

        long x = sc.nextInt();
        long y = sc.nextInt();

        if(Math.abs(x-y) %2 == 0) {
            out.println("IMPOSSIBLE");
            return;
        }

        long a = Math.max(Math.abs(x), Math.abs(y));

        int i = 0;
        while(1L << i < a) i++;
        i--;
        int si = i;
        char[] res = new char[i+1];
        long xx = x;
        long yy = y;
        for(i = si;i>=0; i--) {
            long d = 1L<<i;
            long ax = Math.abs(xx);
            long ay = Math.abs(yy);
            if(ax > ay) {
                if(xx > 0) {
                    xx-=d;
                    res[i] = 'E';
                } else {
                    xx+=d;
                    res[i] = 'W';
                }
            } else {
                if(yy > 0) {
                    yy-=d;
                    res[i] = 'N';
                } else {
                    yy+=d;
                    res[i] = 'S';
                }
            }
        }
        if(xx == 0 && yy == 0) {
            out.println(new String(res));
            return;
        }
        xx = x;
        yy = y;
        res = new char[si+2];
        for(i = si+1;i>=0; i--) {
            long d = 1L<<i;
            long ax = Math.abs(xx);
            long ay = Math.abs(yy);
            if(ax > ay) {
                if(xx > 0) {
                    xx-=d;
                    res[i] = 'E';
                } else {
                    xx+=d;
                    res[i] = 'W';
                }
            } else {
                if(yy > 0) {
                    yy-=d;
                    res[i] = 'N';
                } else {
                    yy+=d;
                    res[i] = 'S';
                }
            }
        }

        if(xx == 0 && yy == 0) {
            out.println(new String(res));
        } else {
            out.println("IMPOSSIBLE");
        }
    }

}
