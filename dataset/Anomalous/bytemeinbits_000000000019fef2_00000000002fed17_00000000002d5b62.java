import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    private static String getXDirection(long val, boolean is1) {
        return is1 ? (val > 0 ? "W" : "E") : (val > 0 ? "E" : "W");
    }

    private static String getYDirection(long val, boolean is1) {
        return is1 ? (val > 0 ? "S" : "N") : (val > 0 ? "N" : "S");
    }

    static boolean isPowerOfTwo(long n) {
        if (n == 0) return false;
        return (int) (Math.ceil(Math.log(n) / Math.log(2))) == (int) (Math.floor(Math.log(n) / Math.log(2)));
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        for (int test = 1; test <= t; test++) {
            long x = fr.nextLong();
            long y = fr.nextLong();

            if (x % 2 != 0 && y % 2 != 0) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
                continue;
            }

            StringBuilder res = new StringBuilder();
            int i = 0;
            long a = 0;
            boolean xDirection = x < 0;
            boolean yDirection = y < 0;

            x = Math.abs(x);
            y = Math.abs(y);

            if (x % 2 != 0) {
                res.append(getXDirection(x, y == 0 ? xDirection : !xDirection));
                x -= 1;
                i++;
            } else if (y % 2 != 0) {
                res.append(getYDirection(y, x == 0 ? yDirection : !yDirection));
                y -= 1;
                i++;
            }

            long oldA = a = (long) Math.pow(2, i);
            boolean isPossible = isPowerOfTwo(x + a);

            if (isPossible) {
                StringBuilder newRes = new StringBuilder(res);
                long tempX = x;
                while (tempX > 1) {
                    newRes.append(getXDirection(tempX, xDirection));
                    tempX /= 2;
                }
                a = x;
                isPossible = isPowerOfTwo(y + a);
                if (isPossible) {
                    while (y > 1) {
                        newRes.append(getYDirection(y, yDirection));
                        y /= 2;
                    }
                    System.out.println("Case #" + test + ": " + newRes);
                    continue;
                }
            }

            a = oldA;
            isPossible = isPowerOfTwo(y + a);
            if (isPossible) {
                while (y > 1) {
                    res.append(getYDirection(y, xDirection));
                    y /= 2;
                }
                a = y;
                isPossible = isPowerOfTwo(x + a);
                if (isPossible) {
                    while (x > 1) {
                        res.append(getXDirection(x, yDirection));
                        x /= 2;
                    }
                    System.out.println("Case #" + test + ": " + res);
                    continue;
                }
            }

            System.out.println("Case #" + test + ": IMPOSSIBLE");
        }
    }
}