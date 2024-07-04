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
