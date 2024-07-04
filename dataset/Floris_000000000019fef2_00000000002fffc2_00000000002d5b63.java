import java.io.*;
import java.util.*;

public class Solution {
    static long M = 1000000000;
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);
//        sc.useDelimiter(Pattern.compile("[\n /]"));

        int cases = sc.nextInt();
        long a = sc.nextLong();
        long b = sc.nextLong();

x:        for (int cs = 1; cs <= cases; cs++) {
            try {
                long startx, starty;
                do {
                    startx= (long)(Math.random()*2*M-M);
                    starty= (long)(Math.random()*2*M-M);
                } while ("MISS".equals(q(sc, startx, starty)));
                long r = startx;
                long r2 = M;
                while (r < (r+r2)/2) {
                    if ("MISS".equals(q(sc, (r+r2)/2, starty))) {
                        r2 = (r+r2)/2;
                    } else {
                        r = (r+r2)/2;
                    }
                }
                long l = startx;
                long l2 = -M;
                while (l > (l+l2)/2) {
                    if ("MISS".equals(q(sc, (l+l2)/2, starty))) {
                        l2 = (l+l2)/2;
                    } else {
                        l = (l+l2)/2;
                    }
                }
                long d = starty;
                long d2 = M;
                while (d < (d+d2)/2) {
                    if ("MISS".equals(q(sc, startx, (d+d2)/2))) {
                        d2 = (d+d2)/2;
                    } else {
                        d = (d+d2)/2;
                    }
                }
                long u = starty;
                long u2 = -M;
                while (u > (u+u2)/2) {
                    if ("MISS".equals(q(sc, startx, (u+u2)/2))) {
                        u2 = (u+u2)/2 ;
                    } else {
                        u = (u+u2)/2;
                    }
                }
//                System.err.println(startx+ " " + starty+" " + l +" "+ r +" "+u +" " +d);
                q(sc, (l+r)/2, (u+d)/2);
                throw new RuntimeException();
            } catch (ArrayStoreException e) {}
        }
    }

    private static Object q(Scanner sc, long startx, long starty) {
        System.out.println(startx+" "+starty);
        System.out.flush();
        String r = sc.next();
//                System.err.println(startx+" "+starty + " " + r);
        if ("CENTER".equals(r)) throw new ArrayStoreException();

        return r;
    }
}
