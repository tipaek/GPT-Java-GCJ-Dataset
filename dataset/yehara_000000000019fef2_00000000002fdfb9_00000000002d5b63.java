import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    
    static PrintWriter out;
    static final String HIT = "HIT";
    static final String CENTER = "CENTER";


    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        out = new PrintWriter(System.out);
        int x = s.nextInt();
        int y = s.nextInt();
        for (int t = 1; t <= count; t++) {
            //out.print("Case #" + t + ": ");
            solve(s, out);
        }
        out.close();
    }

    static void solve(Scanner sc, PrintWriter out) {

        try {

            int[] g = new int[]{-500000000, 0, 500000000};

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (test(sc, out, g[i], g[j])) {
                        find(sc, out, g[i], g[j]);
                        return;
                    }

                }
            }
        } catch (CenterException ignore){}

    }

    static void find(Scanner sc, PrintWriter out, long x, long y) {

        long l = x;
        long r = 1000000000;
        while(r-l > 1) {
            long mid = (l+r)/2;
            if(test(sc, out, mid, y)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        long ux = l;

        l = x;
        r = -1000000000;
        while(l-r > 1) {
            long mid = (l+r)/2;
            if(test(sc, out, mid, y)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        long lx = l;

        l = y;
        r = 1000000000;
        while(r-l > 1) {
            long mid = (l+r)/2;
            if(test(sc, out, x, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        long uy = l;
        l = y;
        r = -1000000000;
        while(l-r > 1) {
            long mid = (l+r)/2;
            if(test(sc, out, x, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        long ly = l;

        long mx = (ux+lx)/2;
        long my = (uy+ly)/2;
        for(long ax = mx-1; ax<=mx+1; ax++) {
            for(long ay = my-1; ay<=my+1; ay++) {
                test(sc, out, ax, ay);
            }
        }


    }

    static boolean test(Scanner sc, PrintWriter out, long x, long y) {
        out.println(x + " " + y);
        out.flush();
        String res = sc.next();
        if(res.equals(CENTER)) {
            throw new CenterException();
        }
        return res.equals(HIT);
    }
    static class CenterException extends RuntimeException {
    }

}
