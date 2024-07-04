import java.io.*;
import java.util.*;

public class Solution {

    static boolean done = false;
    static int bound = (int) 1e9;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for (int test = 1; test <= t; test++) {
            done = false;
            int mvert = 0;
            int mhor = 0;
            outerLoop:
            for (int i = -5; i <= 5; i++) {
                for (int j = -5; j <= 5; j++) {
                    System.out.println((mvert + i) + " " + (mhor + j));
                    String resp = sc.next();
                    if (resp.equals("CENTER")) {
                        break outerLoop;
                    }
                }
            }
        }
    }

    static int searchRight(Scanner sc) {
        int low = -bound;
        int high = bound;
        int y = 0;
        while (low != high) {
            int mid = (low + high + 1) / 2;
            System.out.println(mid + " " + y);
            String resp = sc.next();
            if (resp.equals("HIT")) {
                low = mid;
            } else if (resp.equals("MISS")) {
                high = mid - 1;
            } else if (resp.equals("CENTER")) {
                done = true;
                return mid;
            }
        }
        return low;
    }

    static int searchLeft(Scanner sc) {
        int low = -bound;
        int high = bound;
        int y = 0;
        while (low != high) {
            int mid = (low + high - 1) / 2;
            System.out.println(mid + " " + y);
            String resp = sc.next();
            if (resp.equals("HIT")) {
                high = mid;
            } else if (resp.equals("MISS")) {
                low = mid + 1;
            } else if (resp.equals("CENTER")) {
                done = true;
                return mid;
            }
        }
        return low;
    }

    static int searchTop(Scanner sc) {
        int x = 0;
        int low = -bound;
        int high = bound;
        while (low != high) {
            int mid = (low + high + 1) / 2;
            System.out.println(x + " " + mid);
            String resp = sc.next();
            if (resp.equals("HIT")) {
                low = mid;
            } else if (resp.equals("MISS")) {
                high = mid - 1;
            } else if (resp.equals("CENTER")) {
                done = true;
                return mid;
            }
        }
        return low;
    }

    static int searchBottom(Scanner sc) {
        int x = 0;
        int low = -bound;
        int high = bound;
        while (low != high) {
            int mid = (low + high - 1) / 2;
            System.out.println(x + " " + mid);
            String resp = sc.next();
            if (resp.equals("HIT")) {
                high = mid;
            } else if (resp.equals("MISS")) {
                low = mid + 1;
            } else if (resp.equals("CENTER")) {
                done = true;
                return mid;
            }
        }
        return low;
    }
}