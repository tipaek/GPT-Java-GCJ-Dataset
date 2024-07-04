
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        assert a == b;
        long rad = a;
        long MAX = 1000000000;
        Random r = new Random();
        //System.err.printf("t = %d, a = %d, b = %d%n", t, a, b);
        main:
        for (int i = 0; i < t; i++) {

            ArrayList<long[]> cand = new ArrayList<>();
            for (int x = -10; x <= 50; x++) {
                for (int y = -50; y <= 50; y++) {

                    if (x + rad <= MAX && y + rad <= MAX && x - rad >= -MAX && y - rad >= -MAX) {
                        cand.add(new long[]{x, y});
                    }
                }
            }

            while (true) {
                long x, y;
                long[] c = cand.get(r.nextInt(cand.size()));
                if (cand.size() == 1) {
                    x = cand.get(0)[0];
                    y = cand.get(0)[1];
                } else if (r.nextBoolean()) {
                    x = c[0];
//                    y = c[1] + (2 * r.nextInt(2) - 1) * rad + r.nextInt(2);
                    y = c[1] + rad;
                } else {
//                    x = c[0] + (2 * r.nextInt(2) - 1) * rad + r.nextInt(2);
                    x = c[0] + rad;
                    y = c[1];

                }
                if (Math.abs(x) > MAX || Math.abs(y) > MAX) {
                    continue;
                }

//                System.err.println("Trying point " + x + ", " + y);
                System.out.println(x + " " + y);
                String res = sc.next();
//                System.err.println("Received " + res);
                if (res.equals("CENTER")) {
                    break;
                }

                if (res.equals("WRONG")) {
                    //System.err.println("Candidates left: " + cand.size());
                    break main;
                }
                if (cand.size() == 1) {
                    //System.err.println("One left, but no hit!!!");
                    return;
                }
                boolean hit = res.equals("HIT");
                for (Iterator<long[]> iterator = cand.iterator(); iterator.hasNext(); ) {
                    long[] c_i = iterator.next();

                    BigInteger xb = BigInteger.valueOf(x - c_i[0]);
                    BigInteger yb = BigInteger.valueOf(y - c_i[1]);
                    BigInteger rb = BigInteger.valueOf(rad);

                    int cmp = xb.multiply(xb).add(yb.multiply(yb)).compareTo(rb.multiply(rb));
                    boolean check = cmp <= 0;
//                    boolean check = (x - c_i[0]) * (x - c_i[0]) + (y - c_i[1]) * (y - c_i[1]) <= rad * rad;
//                    System.err.printf("(%d - %d) * (%d - %d) + (%d - %d) * (%d - %d) <= %d * %d = %d%n", x, c_i[0], x, c_i[0], y, c_i[1], y, c_i[1], rad, rad,
//                            ((x - c_i[0]) * (x - c_i[0]) + (y - c_i[1]) * (y - c_i[1]) <= rad * rad) ? 1 : 0);
                    if (check != hit) {
//                        System.err.printf("Removing point %d,%d%n", c_i[0], c_i[1]);
                        iterator.remove();
                    }
                }
            }
        }

    }
}
