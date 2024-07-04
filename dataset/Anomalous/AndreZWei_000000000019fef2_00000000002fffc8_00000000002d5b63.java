import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] tokens = scanner.nextLine().split(" ");
        int t = Integer.parseInt(tokens[0]);
        int a = Integer.parseInt(tokens[1]);
        int b = Integer.parseInt(tokens[2]);
        
        for (int i = 1; i <= t; ++i) {
            solve(a, b);
        }
    }

    private static void solve(int a, int b) {
        String query = "0 0";
        System.out.println(query);
        String reply = scanner.nextLine();
        
        if (reply.equals("CENTER")) return;

        if (reply.equals("HIT")) {
            long lBound = binarySearch(-1_000_000_000L, 0, 0, true, true);
            long rBound = binarySearch(0, 1_000_000_000L, 0, true, false);
            long dBound = binarySearch(-1_000_000_000L, 0, 0, false, true);
            long uBound = binarySearch(0, 1_000_000_000L, 0, false, false);
            
            query = (lBound + rBound) / 2 + " " + (dBound + uBound) / 2;
            System.out.println(query);
            System.err.println(query);
            
            reply = scanner.nextLine();
            
            if (reply.equals("CENTER")) return;
            else {
                System.err.println("ERROR");
                System.exit(0);
            }
        }
    }

    private static long binarySearch(long l, long r, long fixed, boolean isHorizontal, boolean isLeftOrDown) {
        while (l < r) {
            long mid = isLeftOrDown ? l + (r - l) / 2 : r - (r - l) / 2;
            String query = isHorizontal ? mid + " " + fixed : fixed + " " + mid;
            System.out.println(query);
            System.err.println(query);
            String reply = scanner.nextLine();
            System.err.println("reply = " + reply);

            if (reply.equals("CENTER")) return -1;
            if (reply.equals("WRONG")) {
                System.err.println("ERROR");
                System.exit(0);
            }
            if (reply.equals("HIT")) {
                if (isLeftOrDown) r = mid;
                else l = mid;
            } else {
                if (isLeftOrDown) l = mid + 1;
                else r = mid - 1;
            }
        }
        return l;
    }
}