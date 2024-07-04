import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static String toBinaryString(long n) {
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            ans.insert(0, (n % 2));
            n = n / 2;
        }
        return ans.toString();
    }

    static boolean isPowerOfTwo(int n) {
        return (int) (Math.ceil((Math.log(n) / Math.log(2)))) == (int) (Math.floor((Math.log(n) / Math.log(2))));
    }

    static String intToBinaryString(int n) {
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            ans.append(n % 2);
            n = n / 2;
        }
        return ans.toString();
    }

    public static String answer(int x, int y) {
        int originalX = x, originalY = y;
        if (x < 0) x = -x;
        if (y < 0) y = -y;

        boolean condition1 = isPowerOfTwo(y + (~x));
        boolean condition2 = isPowerOfTwo((~y) + x);

        if (!((y & x) == 0 || (x < y && condition1) || (x > y && condition2))) {
            return "IMPOSSIBLE";
        }

        String binaryX = intToBinaryString(x);
        String binaryY = intToBinaryString(y);
        char[] ans = new char[Math.max(binaryX.length(), binaryY.length())];

        for (int i = 0; i < binaryX.length() || i < binaryY.length(); i++) {
            if ((x & y) == 0) {
                if (i < binaryY.length() && binaryY.charAt(i) == '1') {
                    ans[i] = originalY > 0 ? 'N' : 'S';
                } else if (i < binaryX.length() && binaryX.charAt(i) == '1') {
                    ans[i] = originalX > 0 ? 'E' : 'W';
                }
            } else if (x < y && condition1) {
                if (i < binaryX.length() && binaryX.charAt(i) == '1') {
                    ans[i] = originalX > 0 ? 'E' : 'W';
                } else if (i < binaryY.length() && binaryY.charAt(i) == '1') {
                    ans[i] = originalY > 0 ? 'S' : 'N';
                }
            } else if (x > y && condition2) {
                if (i < binaryY.length() && binaryY.charAt(i) == '1') {
                    ans[i] = originalY > 0 ? 'N' : 'S';
                } else if (i < binaryX.length() && binaryX.charAt(i) == '1') {
                    ans[i] = originalX > 0 ? 'W' : 'E';
                }
            }
        }

        String str = new String(ans);
        if ((x & y) == 0) return str;
        if (x < y && condition1) return str + (originalY > 0 ? 'N' : 'S');
        return str + (originalX > 0 ? 'E' : 'W');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(scan.readLine().split(" ")[0]);
        for (int p = 1; p <= t; p++) {
            String[] buff = scan.readLine().split(" ");
            int x = Integer.parseInt(buff[0]);
            int y = Integer.parseInt(buff[1]);
            String ans = answer(x, y);
            System.out.println("Case #" + p + ": " + ans);
        }
    }
}