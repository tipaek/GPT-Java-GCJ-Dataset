import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

class FastScanner {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
        if (ptr < buflen) {
            return true;
        } else {
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (buflen <= 0) {
                return false;
            }
        }
        return true;
    }

    private int readByte() {
        if (hasNextByte())
            return buffer[ptr++];
        else
            return -1;
    }

    private static boolean isPrintableChar(int c) {
        return 33 <= c && c <= 126;
    }

    public boolean hasNext() {
        while (hasNextByte() && !isPrintableChar(buffer[ptr]))
            ptr++;
        return hasNextByte();
    }

    public String next() {
        if (!hasNext())
            throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while (isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    public long nextLong() {
        if (!hasNext())
            throw new NoSuchElementException();
        long n = 0;
        boolean minus = false;
        int b = readByte();
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        if (b < '0' || '9' < b) {
            throw new NumberFormatException();
        }
        while (true) {
            if ('0' <= b && b <= '9') {
                n *= 10;
                n += b - '0';
            } else if (b == -1 || !isPrintableChar(b)) {
                return minus ? -n : n;
            } else {
                throw new NumberFormatException();
            }
            b = readByte();
        }
    }

    public int nextInt() {
        long nl = nextLong();
        if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE)
            throw new NumberFormatException();
        return (int) nl;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}

public class Main {
    static int MOD = 1000000007;

    static int C(int n, int r) {
        int num = 1;
        for (int i = 1; i <= r; i++) {
            num = num * (n - i + 1) / i;
        }
        return num;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        long temp;
        long c = a;
        c *= b;
        while ((temp = a % b) != 0) {
            a = b;
            b = temp;
        }
        return (long) (c / b);
    }

    static long f(long n, Map<Long, Long> map) {
        if (n < 2)
            return 1;
        else if (map.containsKey(n)) {
            return map.get(n);
        } else {
            map.put(n, n * f(n - 2, map));
            return map.get(n);
        }

    }

    public static long factorial(long n) {
        return n <= 0 ? 1 : n * factorial(n - 1);
    }

    private static long calcLCM(long val1, long val2) {
        long maxValue = Math.max(val1, val2);
        long minValue = Math.min(val1, val2);
        long val3 = maxValue * minValue;

        if (minValue == 0)
            return maxValue;

        long temp;
        while ((temp = maxValue % minValue) != 0) {
            maxValue = minValue;
            minValue = temp;
        }

        return (long) (val3 / minValue);
    }

    static String nextPermutation(String s) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            list.add(s.charAt(i));

        int pivotPos = -1;
        char pivot = 0;
        for (int i = list.size() - 2; i >= 0; i--) {
            if (list.get(i) < list.get(i + 1)) {
                pivotPos = i;
                pivot = list.get(i);
                break;
            }
        }

        if (pivotPos == -1 && pivot == 0)
            return "Final";

        int L = pivotPos + 1, R = list.size() - 1;
        int minPos = -1;
        char min = Character.MAX_VALUE;
        for (int i = R; i >= L; i--) {
            if (pivot < list.get(i)) {
                if (list.get(i) < min) {
                    min = list.get(i);
                    minPos = i;
                }
            }
        }

        Collections.swap(list, pivotPos, minPos);
        Collections.sort(list.subList(L, R + 1));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
            sb.append(list.get(i));

        return sb.toString();

    }

    public List<String> permutation(List<String> list, String target, String ans) {
        if (target.length() <= 1) {
            list.add(ans + target);
        } else {
            for (int i = 0; i < target.length(); i++) {
                permutation(list, target.substring(0, i) + target.substring(i + 1), ans + target.charAt(i));
            }
        }
        return list;
    }

    public static int lowerbound(int[] a, int key) {
        if (a[a.length - 1] < key)
            return a.length;
        int lb = 0, ub = a.length - 1, mid;
        do {
            mid = (ub + lb) / 2;
            if (a[mid] < key)
                lb = mid + 1;
            else
                ub = mid;
        } while (lb < ub);
        return ub;
    }

    public static int upperbound(int[] a, int key) {
        if (a[a.length - 1] <= key)
            return a.length;
        int lb = 0, ub = a.length - 1, mid;
        do {
            mid = (ub + lb) / 2;
            if (a[mid] <= key)
                lb = mid + 1;
            else
                ub = mid;
        } while (lb < ub);
        return ub;
    }

    public static int count(int[] a, int key) {
        return upperbound(a, key) - lowerbound(a, key);
    }

    public static void quickSort(List<Long> data, int left, int right) {
        if (left >= right)
            return;

        int l = left;
        int r = right;
        long p = data.get((left + right) / 2);
        while (l <= r) {
            while (data.get(l) > p) {
                l++;
            }

            while (data.get(r) < p) {
                r--;
            }
            if (l <= r) {
                long temp = data.get(r);
                data.set(r, data.get(l));
                data.set(l, temp);
                l++;
                r--;
            }
        }

        quickSort(data, left, r);
        quickSort(data, l, right);

        return;

    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int i = 0; i < t; i++) {
            int n = fs.nextInt();
            int[][] a = new int[n][n];
            int b = 0;
            int r = 0;
            int c = 0;
            boolean[] rows = new boolean[n];
            boolean[] columns = new boolean[n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    a[j][k] = fs.nextInt();
                    if (j == k)
                        b += a[j][k];
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < k; l++) {
                        if (a[j][k] == a[j][l] && !rows[j]) {
                            r++;
                            rows[j] = true;
                            break;
                        }
                    }
                    for (int l = 0; l < j; l++) {
                        if (a[j][k] == a[l][k] && !columns[k]) {
                            c++;
                            columns[k] = true;
                            break;
                        }
                    }

                }
            }
            System.out.println("Case #" + (i + 1) + ": " + b + " " + r +" "+ c);
        }
    }

}
