import java.util.Scanner;

public class Solution {

    private void solve(Scanner scan) {
        long l = scan.nextLong();
        long r = scan.nextLong();

        long diff = Math.abs(l - r);

        long a = search(diff);

        boolean swap = r > l;

        if (swap) {
            long t = l;
            l = r;
            r = t;
        }

        l -= calc(a);

        if (l == r && swap) {
            swap = false;
        }

        long b = search2(a+1, l);
        long c = search2(a+2, r);

//        System.out.println(a + " " + b + " " + c);

        long result = a + b + c;

        long lResult = l - calc2(a + 1, b);
        long rResult = r - calc2(a + 2, c);
        if (swap) {
            System.out.println(result + " " + rResult + " " + lResult);
        } else {
            System.out.println(result + " " + lResult + " " + rResult);

        }
    }

    long calc(long a) {
        return a * (a + 1) / 2;
    }

    long search(long n) {
        if (n == 0) {
            return 0;
        }
        long low = 0;
        long high = 1000 * 1000 * 1000;
        while (low + 1 < high) {
//            System.out.println(low + " " + high);
            long m = (low + high) / 2;
            long value = calc(m);
            if (value > n) {
                high = m;
            } else if (value < n) {
                low = m;
            } else {
                return m;
            }
        }
        return low;
    }

    long search2(long k, long n) {
        if (n == 0) {
            return 0;
        }
        long low = 0;
        long high = 1000 * 1000 * 1000;
        while (low + 1 < high) {
//            System.out.println(low + " " + high);
            long m = (low + high) / 2;
            long value = calc2(k, m);
//            System.out.println(k + " " + m + " " + value);
            if (value > n) {
                high = m;
            } else if (value < n) {
                low = m;
            } else {
                return m;
            }
        }
        return low;
    }

    private long calc2(long k, long m) {
        return m*k + calc(m-1) * 2;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count+1) + ": ");
            new Solution().solve(scan);
        }
        scan.close();
    }
}
