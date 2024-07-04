import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println("Case #" + i + ": " + foo(x, y));
        }
    }

    private static String foo(int x, int y) {
        boolean xr, yr;
        if (x < 0) {
            xr = true;
            x = -x;
        } else {
            xr = false;
        }
        if (y < 0) {
            yr = true;
            y = -y;
        } else {
            yr = false;
        }
        List<Long> a = boo(x);
        List<Long> b = boo(y);
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                long aa = a.get(i);
                long bb = b.get(j);
                long c = Long.highestOneBit(Math.max(aa, bb));
                long s = (c << 1) - 1;
                if ((aa | bb) == s && (aa & bb) == 0) {
                    long ca = 0;
                    long cb = 0;
                    StringBuilder sb = new StringBuilder();
                    while (c != 0) {
                        if ((c & aa) != 0) {
                            if (ca > x) {
                                sb.append(xr ? 'E' : 'W');
                                ca -= c;
                            } else {
                                sb.append(xr ? 'W' : 'E');
                                ca += c;
                            }
                        } else {
                            if (cb > y) {
                                sb.append(yr ? 'N' : 'S');
                                cb -= c;
                            } else {
                                sb.append(yr ? 'S' : 'N');
                                cb += c;
                            }
                        }
                        c >>>= 1;
                    }
                    String str = sb.reverse().toString();
                    return str;

                }
            }
        }
        return "IMPOSSIBLE";
    }

    private static List<Long> boo(long a) {
        List<Long> list = new ArrayList<>();
        long mask = 0;
        while (true) {
            list.add(mask | a);
            long i = Long.highestOneBit(a) << 1;
            mask |= i;
            if (a == i - a) {
                break;
            }
            a = i - a;
        }
        return list;
    }

}
