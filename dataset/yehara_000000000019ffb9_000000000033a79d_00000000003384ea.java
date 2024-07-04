import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    
    static PrintWriter out;

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        out = new PrintWriter(System.out);
        for (int t = 1; t <= count; t++) {
            out.print("Case #" + t + ": ");
            solve(s, out);
        }
        out.close();
    }

    static void solve(Scanner sc, PrintWriter out) {

        long L = sc.nextInt();
        long R = sc.nextInt();
        long l = Math.max(L, R);
        long r = Math.min(L, R);
        long diff = l-r;
        long a = 0;
        long b = 2_000_000_000L;
        while(b-a>1) {
            long mid = (b+a)/2;
            if(mid * (mid+1) / 2 <= diff) {
                a = mid;
            } else {
                b = mid;
            }
        }
        long m = a;
        l = l - a * (a+1) / 2;
        a = 0;
        b = 1_100_000_000L;
        while(b-a>1) {
            long mid = (b+a)/2;
            if((m-1)*mid + mid * (mid+1) <= l) {
                a = mid;
            } else {
                b = mid;
            }
        }
        long p = a;
        a = 0;
        b = 1_100_000_000L;
        while(b-a>1) {
            long mid = (b+a)/2;
            if(m*mid + mid * (mid+1) <= r) {
                a = mid;
            } else {
                b = mid;
            }
        }
        long q = a;
        long res = Math.max(m + p*2-1, m+q*2);

        long resl = l - ((m-1)*p + p * (p+1));
        long resr = r - (m*q + q * (q+1));

        if(R>L && l>r) {
            out.println(res + " " + resr + " " + resl);
        } else {
            out.println(res + " " + resl + " " + resr);
        }

    }

}
