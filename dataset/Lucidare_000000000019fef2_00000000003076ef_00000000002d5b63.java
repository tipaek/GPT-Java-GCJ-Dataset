import java.util.*;

public class Solution {
    public static void solve(Scanner scanner, int a, int b) {
        int r = -1;
        int maxWall = 1000000000;
        int x = 0;
        int y = 0;
        int maxX = Integer.MAX_VALUE;
        int minX = Integer.MIN_VALUE;
        int numThrows = 0;
        int mid;
        String res = "";
        if (a == b) r = a;
        
        if (r == 999999995) {
            x = -10;
            y = -10;
            while (res != "CORRECT") {
                res = throwDart(x, y, scanner);
                x++;
                if (x > 10) {
                    x = -10;
                    y++;
                }
            }
            return;
        }
        res = throwDart(1234567890, 1234567890, scanner);
        //     if (res == "WRONG" || (res != "CORRECT" && numThrows == 300)) return;
        return;
        // if (r != -1) {
        //     x = maxWall;
        //     y = maxWall;
        //     int lo = maxWall - 100;
        //     int hi = maxWall;
        //     while (lo <= hi) {
        //         mid = (lo + hi)/2;
        //         res = throwDart(mid, 0, scanner);
        //         if (res == "HIT") hi = mid + 1;
        //         if (res == "MISS") lo = mid;
        //         numThrows++;
        //         if (res == "WRONG" || (res != "CORRECT" && numThrows == 300)) return;
        //     }
        //     if (lo == hi) maxX = lo;

        //     lo = -maxWall;
        //     hi = -maxWall + 100;

        //     while (lo <= hi) {
        //         mid = (lo + hi)/2;
        //         res = throwDart(mid, 0, scanner);
        //         if (res == "HIT") hi = mid + 1;
        //         if (res == "MISS") lo = mid;
        //         numThrows++;
        //         if (res == "WRONG" || (res != "CORRECT" && numThrows == 300)) return;
        //     }
        //     if (lo == hi) minX = lo;
        //     int centerX = (minX + maxX)/2;

        //     lo = maxWall - 100;
        //     hi = maxWall;

        //     while (lo <= hi) {
        //         mid = (lo + hi)/2;
        //         res = throwDart(centerX, mid, scanner);
        //         if (res == "HIT") hi = mid + 1;
        //         if (res == "MISS") lo = mid;
        //         numThrows++;
        //         if (res == "WRONG" || (res != "CORRECT" && numThrows == 300)) return;
        //     }
            
        //     if (lo == hi) {
        //         res = throwDart(centerX, lo, scanner);
        //         if (res == "WRONG" || (res != "CORRECT" && numThrows == 300)) return;
        //     }
        //     res = throwDart(1234567890, 1234567890, scanner);
        //     if (res == "WRONG" || (res != "CORRECT" && numThrows == 300)) return;

        // } else {
        //     res = throwDart(1234567890, 1234567890, scanner);
        //     if (res == "WRONG" || (res != "CORRECT" && numThrows == 300)) return;
        //     // x = maxWall;
        //     // y = maxWall;
        //     // int lo = maxWall/2;
        //     // int hi = maxWall;
        //     // while (lo <= hi) {
        //     //     mid = (lo + hi)/2;
        //     //     res = throwDart(mid, 0, scanner);
        //     //     if (res == "HIT") hi = mid + 1;
        //     //     if (res == "MISS") lo = mid;
        //     //     numThrows++;
        //     //     if (res == "WRONG" || (res != "CORRECT" && numThrows == 300)) return;
        //     // }
        //     // if (lo == hi) maxX = lo;

        //     // lo = -maxWall;
        //     // hi = -maxWall/2;

        //     // while (lo <= hi) {
        //     //     mid = (lo + hi)/2;
        //     //     res = throwDart(mid, 0, scanner);
        //     //     if (res == "HIT") hi = mid + 1;
        //     //     if (res == "MISS") lo = mid;
        //     //     numThrows++;
        //     //     if (res == "WRONG" || (res != "CORRECT" && numThrows == 300)) return;
        //     // }
        //     // if (lo == hi) minX = lo;
        //     // int centerX = (minX + maxX)/2;

        //     // lo = maxWall/2;
        //     // hi = maxWall;

        //     // while (lo <= hi) {
        //     //     mid = (lo + hi)/2;
        //     //     res = throwDart(centerX, mid, scanner);
        //     //     if (res == "HIT") hi = mid + 1;
        //     //     if (res == "MISS") lo = mid;
        //     //     numThrows++;
        //     //     if (res == "WRONG" || (res != "CORRECT" && numThrows == 300)) return;
        //     // }
            
        //     // if (lo == hi) {
        //     //     throwDart(centerX, lo, scanner);
        //     // }
            
        // }
        // return;
    }

    public static String throwDart(int x, int y, Scanner scanner) {
        System.out.println(x + " " + y);
        System.out.flush();
        return scanner.next();
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println(caseNum);
        System.out.println(a);
        System.out.println(b);
        for (int ks = 1; ks <= caseNum; ks++) {
            solve(input, a, b);
            // System.out.println(String.format("Case #%d: %s", ks, solve(input)));
        }
    }
}