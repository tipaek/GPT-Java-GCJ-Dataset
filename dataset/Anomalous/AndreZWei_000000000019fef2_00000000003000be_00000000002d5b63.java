import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        String[] tokens = in.nextLine().split(" ");
        int t = Integer.parseInt(tokens[0]);
        int a = Integer.parseInt(tokens[1]);
        int b = Integer.parseInt(tokens[2]);

        for (int i = 1; i <= t; ++i) {
            solve(a, b);
        }
    }

    private static void solve(int a, int b) {
        System.out.println("0 0");
        String reply = in.nextLine();

        if (reply.equals("CENTER")) return;

        if (reply.equals("HIT")) {
            long lBound = binarySearchLeft((long) -1e9, 0, 0);
            long rBound = binarySearchRight(0, (long) 1e9, 0);
            long dBound = binarySearchDown((long) -1e9, 0, 0);
            long uBound = binarySearchUp(0, (long) 1e9, 0);

            String query = (lBound + rBound) / 2 + " " + (dBound + uBound) / 2;
            System.out.println(query);
            reply = in.nextLine();

            if (reply.equals("CENTER")) return;
            else System.exit(0);
        }
    }

    private static long binarySearchLeft(long l, long r, long y) {
        while (l < r) {
            long mid = l + (r - l) / 2;
            System.out.println(mid + " " + y);
            String reply = in.nextLine();

            if (reply.equals("CENTER")) return -1;
            if (reply.equals("WRONG")) System.exit(0);
            if (reply.equals("HIT")) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private static long binarySearchRight(long l, long r, long y) {
        while (l < r) {
            long mid = r - (r - l) / 2;
            System.out.println(mid + " " + y);
            String reply = in.nextLine();

            if (reply.equals("CENTER")) return -1;
            if (reply.equals("WRONG")) System.exit(0);
            if (reply.equals("HIT")) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    private static long binarySearchDown(long l, long r, long x) {
        while (l < r) {
            long mid = l + (r - l) / 2;
            System.out.println(x + " " + mid);
            String reply = in.nextLine();

            if (reply.equals("CENTER")) return -1;
            if (reply.equals("WRONG")) System.exit(0);
            if (reply.equals("HIT")) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private static long binarySearchUp(long l, long r, long x) {
        while (l < r) {
            long mid = r - (r - l) / 2;
            System.out.println(x + " " + mid);
            String reply = in.nextLine();

            if (reply.equals("CENTER")) return -1;
            if (reply.equals("WRONG")) System.exit(0);
            if (reply.equals("HIT")) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}