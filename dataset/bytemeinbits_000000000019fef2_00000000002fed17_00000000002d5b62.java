import java.io.*;
import java.util.*;

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
                } catch (IOException  e) {
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
        if(is1) {
            return val > 0 ? "W" : "E";
        }
        return val > 0 ? "E" : "W";

    }

    private static String getYDirection(long val, boolean is1) {
        if(is1) {
            return val > 0 ? "S" : "N";
        }

        return val > 0 ? "N" : "S";

    }

    static boolean isPowerOfTwo(long n)
    {
        if(n==0)
            return false;

        return (int)(Math.ceil((Math.log(n) / Math.log(2)))) ==
                (int)(Math.floor(((Math.log(n) / Math.log(2)))));
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        int test = 0;
        while(test++ < t) {
            long x = fr.nextInt();
            long y = fr.nextInt();
            if(x % 2 != 0 && y % 2 != 0) {
                System.out.println("Case #" + test + ": " + "IMPOSSIBLE");
                continue;
            }
            String res = "";
            int i = 0;
            long a = 0;
            boolean xDirection = x < 0;
            boolean yDirection = y < 0;
            if(x < 0) {
                x = -x;
            }
            if(y < 0) {
                y = -y;
            }
            if(x % 2 != 0) {
                if(y == 0) {
                    res += getXDirection(x, xDirection);
                } else {
                    res += getXDirection(x, !xDirection);
                }
                x -= 1;
                i += 1;
            } else if( y % 2 != 0) {
                if(x == 0) {
                    res += getYDirection(y, yDirection);
                } else {
                    res += getYDirection(y, !yDirection);

                }
                y -= 1;
                i += 1;
            }
            // try for x
//            System.out.println("res: " + res + " x " + x + " y " + y);
            long oldA = a = (long) Math.pow(2, i);
            boolean isPossible = isPowerOfTwo(x + a);
//            System.out.println("oldA " + a + "isPossible " + isPossible);
            if(isPossible) {
                String newRes = res;
                long tempX = x;
                boolean isDirection = x > 0;
                while(tempX > 1) {
                    newRes += getXDirection(tempX, xDirection);
                    tempX /= 2;
                }
//                System.out.println("newRes: " + newRes + "x " + x + "y " + y);
                a = x;
                isPossible = isPowerOfTwo(y + a);
                if(isPossible) {
                    while( y > 1) {
                        newRes += getYDirection(y, yDirection);
                        y /= 2;
                    }
//                    System.out.println("newRes: " + newRes + "x " + x + "y " + y);
                    System.out.println("Case #" + test + ": " + newRes);
                    continue;
                }
            }
            a = oldA;
            isPossible = isPowerOfTwo(y + a);
            if(isPossible) {

                while(y > 1) {
                    res += getYDirection(y, xDirection);
                    y /= 2;
                }
//                System.out.println("res: " + res + "x " + x + "y " + y);
                a = y;
                isPossible = isPowerOfTwo(x + a);
                if(isPossible) {
                    while( x > 1) {
                        res += getXDirection(x, yDirection);
                        x /= 2;
                    }
                    System.out.println("Case #" + test + ": " + res);
//                    System.out.println("res: " + res + "x " + x + "y " + y);
                    continue;
                }
            }
            System.out.println("Case #" + test + ": " + "IMPOSSIBLE");
        }
    }
}