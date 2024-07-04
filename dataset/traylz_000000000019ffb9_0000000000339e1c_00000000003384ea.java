
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int numOfCases = Integer.parseInt(in.readLine());
        for (int i = 1; i <= numOfCases; i++) {
            final String[] setup = in.readLine().split(" ");
            final int left = Integer.parseInt(setup[0]);
            final int right = Integer.parseInt(setup[1]);
            String result = solveSimple(left, right);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String solveSimple(long left, long right) {
        long i = 1;
        while (i <= left || i <= right) {
            if (left >= right) {
                left -= i;
            } else {
                right -= i;
            }
            i++;
        }
        return (i - 1) + " " + left + " " + right;
    }
}
