import java.util.*;
import java.io.*;

public class Solution {

    private static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        String[] tokens = in.nextLine().split(" ");
        int t = Integer.parseInt(tokens[0]);
        int a = Integer.parseInt(tokens[1]);
        int b = Integer.parseInt(tokens[2]);
        
        for (int i = 0; i < t; i++) {
            solve(a, b);
        }
    }

    private static void solve(int a, int b) {
        String query = "0 0";
        System.out.println(query);
        String reply = in.nextLine();
        
        if ("CENTER".equals(reply)) return;

        if ("HIT".equals(reply)) {
            long lBound = binarySearchLeft(-1_000_000_000L, 0, 0);
            long rBound = binarySearchRight(0, 1_000_000_000L, 0);
            long dBound = binarySearchDown(-1_000_000_000L, 0, 0);
            long uBound = binarySearchUp(0, 1_000_000_000L, 0);
            query = (lBound + rBound) / 2 + " " + (dBound + uBound) / 2;
            System.out.println(query);
            reply = in.nextLine();
            
            if ("CENTER".equals(reply)) return;
            System.exit(0);
        } else {
            long x = 0, y = 0;
            query = (-1_000_000_000L / 2) + " 0";
            System.out.println(query);
            reply = in.nextLine();
            
            if ("CENTER".equals(reply)) return;
            
            if ("HIT".equals(reply)) {
                long lBound = binarySearchLeft(-1_000_000_000L, -1_000_000_000L / 2, 0);
                long rBound = binarySearchRight(-1_000_000_000L / 2, 0, 0);
                x = (lBound + rBound) / 2;
            } else {
                long lBound = binarySearchLeft(0, 1_000_000_000L / 2, 0);
                long rBound = binarySearchRight(1_000_000_000L / 2, 1_000_000_000L, 0);
                x = (lBound + rBound) / 2;
            }

            query = "0 " + (-1_000_000_000L / 2);
            System.out.println(query);
            reply = in.nextLine();
            
            if ("CENTER".equals(reply)) return;
            
            if ("HIT".equals(reply)) {
                long dBound = binarySearchDown(-1_000_000_000L, -1_000_000_000L / 2, 0);
                long uBound = binarySearchUp(-1_000_000_000L / 2, 0, 0);
                y = (dBound + uBound) / 2;
            } else {
                long dBound = binarySearchDown(0, 1_000_000_000L / 2, 0);
                long uBound = binarySearchUp(1_000_000_000L / 2, 1_000_000_000L, 0);
                y = (dBound + uBound) / 2;
            }

            query = x + " " + y;
            System.out.println(query);
            reply = in.nextLine();
            
            if ("CENTER".equals(reply)) return;
            System.exit(0);
        }
    }

    private static long binarySearchLeft(long l, long r, long y) {
        while (l < r) {
            long mid = l + (r - l) / 2;
            String query = mid + " " + y;
            System.out.println(query);
            String reply = in.nextLine();
            
            if ("CENTER".equals(reply)) return -1;
            if ("WRONG".equals(reply)) System.exit(0);
            if ("HIT".equals(reply)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private static long binarySearchRight(long l, long r, long y) {
        while (l < r) {
            long mid = r - (r - l) / 2;
            String query = mid + " " + y;
            System.out.println(query);
            String reply = in.nextLine();
            
            if ("CENTER".equals(reply)) return -1;
            if ("WRONG".equals(reply)) System.exit(0);
            if ("HIT".equals(reply)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    private static long binarySearchDown(long l, long r, long x) {
        while (l < r) {
            long mid = l + (r - l) / 2;
            String query = x + " " + mid;
            System.out.println(query);
            String reply = in.nextLine();
            
            if ("CENTER".equals(reply)) return -1;
            if ("WRONG".equals(reply)) System.exit(0);
            if ("HIT".equals(reply)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private static long binarySearchUp(long l, long r, long x) {
        while (l < r) {
            long mid = r - (r - l) / 2;
            String query = x + " " + mid;
            System.out.println(query);
            String reply = in.nextLine();
            
            if ("CENTER".equals(reply)) return -1;
            if ("WRONG".equals(reply)) System.exit(0);
            if ("HIT".equals(reply)) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}