import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {

    public void processRawInput(InputStream is) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        int caseNumber = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= caseNumber; i++) {
            String target = reader.readLine();
            String[] parts = target.split(" ");
            long l = Long.parseLong(parts[0]);
            long r = Long.parseLong(parts[1]);
            System.out.println("Case #" + i + ": " + process(l, r));
        }

    }

    public String process(long l, long r) {
        long c = 1L;
        long d = Math.abs(l - r);
        if (d >= 10L) {
            String ds = "" + d;
            long n = ds.length() / 2;
            long res = p(n);
            if (res > d)
                res = p(--n);
            if (l > r) {
                l -= res;
            } else {
                r -= res;
            }
            c = (long) Math.pow(10L, n) + 1;
        } else {
            while (Math.abs(l - r) > c) {
                if (l >= r) {
                    if (l >= c) {
                        l -= c;
                    } else {
                        break;
                    }
                } else {
                    if (r >= c) {
                        r -= c;
                    } else {
                        break;
                    }
                }
                c+=1;
            }
        }
        /*if (Math.min(l, r) >= 2550L) {
            String ds = "" + Math.min(l, r);
            long n = (ds.length()/2)*2 - 2;

            long pow = (long) Math.pow(10L, n);
            long left = 25 * pow;
            long right = 25 * pow + 50 * (long) Math.pow(10L, n / 2);
            if (Math.min(l, r) < left || Math.max(l, r) < right) {
                n-=2;
                pow = (long) Math.pow(10L, n);
                left = 25 * pow;
                right = 25 * pow + (long) Math.pow(10L, n / 2);
            }

            if (l >= r) {
                l -= right;
                r -= left;
            } else {
                l -= left;
                r -= right;
            }
            c = c + (long) Math.pow(10L, n / 2 + 1);
        }*/

        while (true) {
            if (l >= r) {
                if (l >= c) {
                    l -= c;
                } else {
                    break;
                }
            } else {
                if (r >= c) {
                    r -= c;
                } else {
                    break;
                }
            }
            c+=1;
        }

        return (c-1) + " " + l + " " + r;
    }

    public static long p(long n) {
        String re = "5";
        for (int z = 0; z < n-1; z++) {
            re += "0";
        }
        re += re;
        return Long.parseLong(re);
    }

    public int test(int x, int y, int step) {
        return Math.max(Math.abs(x) + Math.abs(y), step);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput(System.in);
    }
}
