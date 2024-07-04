import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        InputReader in = new InputReader();
        int t = in.nextInt();
        for (int T = 1; T <= t; T++) {
            int n = in.nextInt();
            String[] arr = new String[n];
            String[] prefs = new String[n];
            String[] suffs = new String[n];
            for (int i = 0; i < n; i++) arr[i] = in.next();
            for (int i = 0; i < n; i++) {
                int x = arr[i].indexOf('*');
                int y = arr[i].lastIndexOf('*');
                prefs[i] = arr[i].substring(0, x);
                suffs[i] = arr[i].substring(y + 1);
            }
            Arrays.sort(prefs, (a, b) -> Integer.compare(b.length(), a.length()));
            Arrays.sort(suffs, (a, b) -> Integer.compare(b.length(), a.length()));
            boolean isValid = true;
            String largestPref = prefs[0];
            String largestSuff = suffs[0];
            for (int i = 1; i < n; i++) {
                isValid = isValid && largestPref.startsWith(prefs[i]);
                isValid = isValid && largestSuff.endsWith(suffs[i]);
                if (!isValid) break;
            }
            String ans = isValid ? largestPref : "*";
            if (isValid) {
                for (int i = 0; i < n; i++) {
                    arr[i] = "  " + arr[i] + "  ";
                    String[] words = arr[i].split("\\*");
                    for (int j = 1; j < words.length - 1; j++) ans += words[j];
                }
                ans += largestSuff;
            }
            System.out.println("Case #" + T + ": " + ans);
        }
    }
}

class Helper {

    static boolean[] sieve(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        for (int p = 2; p * p <= n; p++) {
            if (primes[p]) {
                for (int i = p * p; i <= n; i += p) primes[i] = false;
            }
        }
        return primes;
    }

    static long modularExp(long x, long y, long p) {
        long result = 1;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1) result = (result * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return result;
    }

    static long gcd(long a, long b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
    }
}

class InputReader {
    private BufferedReader br;
    private StringTokenizer st;

    public InputReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}