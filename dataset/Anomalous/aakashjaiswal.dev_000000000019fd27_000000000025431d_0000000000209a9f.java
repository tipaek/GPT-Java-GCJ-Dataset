import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        in = new FastReader();
        int T = ni();
        int caseNumber = 0;
        while (T-- > 0) {
            String str = n();
            int[] arr = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.charAt(i) - '0';
            }
            boolean[] done = new boolean[arr.length];
            List<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                pairs.add(new Pair(arr[i], i));
            }
            pairs.sort(Collections.reverseOrder());
            
            int[] start = new int[arr.length];
            int[] end = new int[arr.length];
            for (Pair pair : pairs) {
                if (done[pair.index]) continue;
                done[pair.index] = true;
                
                processRight(arr, done, end, pair);
                processLeft(arr, done, start, pair);
            }
            
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < arr.length; k++) {
                sb.append("(".repeat(start[k]));
                sb.append(arr[k]);
                sb.append(")".repeat(end[k]));
            }
            System.out.println("Case #" + (++caseNumber) + ": " + sb);
        }
    }

    private static void processRight(int[] arr, boolean[] done, int[] end, Pair pair) {
        int max = pair.value;
        int rem = pair.value;
        int last = pair.index;
        for (int k = pair.index + 1; k < arr.length; k++) {
            if (rem == 0) break;
            if (arr[k] > max) {
                end[k - 1] += rem;
                rem = arr[k];
                max = arr[k];
                break;
            } else {
                if (arr[k] == max) {
                    last = k;
                    done[k] = true;
                    continue;
                } else {
                    end[k - 1] += rem - arr[k];
                    max = arr[k];
                    rem = arr[k];
                    done[k] = true;
                }
            }
            last = k;
        }
        if (rem > 0) {
            end[last] += rem;
        }
    }

    private static void processLeft(int[] arr, boolean[] done, int[] start, Pair pair) {
        int max = pair.value;
        int rem = pair.value;
        int last = pair.index;
        for (int k = pair.index - 1; k >= 0; k--) {
            if (rem == 0) break;
            if (arr[k] > max) {
                start[k + 1] += rem;
                rem = arr[k];
                max = arr[k];
                break;
            } else {
                if (arr[k] == max) {
                    last = k;
                    done[k] = true;
                    continue;
                } else {
                    start[k + 1] += rem - arr[k];
                    max = arr[k];
                    rem = arr[k];
                    done[k] = true;
                }
            }
            last = k;
        }
        if (rem > 0) {
            start[last] += rem;
        }
    }

    static class Pair implements Comparable<Pair> {
        int value;
        int index;
        
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static long binarySearch(long low, long high) {
        while (high - low > 1) {
            long mid = (high - low) / 2 + low;
            if (works(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return (works(low) ? low : high);
    }

    static long fastExpWithMod(long base, long exp) {
        final long MOD = 1_000_000_007;
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return result % MOD;
    }

    public static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    static class MyNumber {
        long num;
        long denom;

        MyNumber(int num) {
            this.num = num;
            this.denom = 1;
        }

        MyNumber(long num, long denom) {
            this.num = num;
            this.denom = denom;
        }

        MyNumber multiply(MyNumber other) {
            long n = this.num * other.num;
            long d = this.denom * other.denom;
            long gcd = gcd(n, d);
            return new MyNumber(n / gcd, d / gcd);
        }

        MyNumber multiply(int num) {
            long n = this.num * num;
            long d = this.denom;
            long gcd = gcd(n, d);
            return new MyNumber(n / gcd, d / gcd);
        }

        @Override
        public String toString() {
            if (denom < 0) {
                this.num = -this.num;
                this.denom = -this.denom;
            }
            if (num == 0) return "0";
            return num + "/" + denom;
        }
    }

    static void memset(int[][] arr, int val) {
        for (int[] row : arr) {
            Arrays.fill(row, val);
        }
    }

    static void memset(int[] arr, int val) {
        Arrays.fill(arr, val);
    }

    static void memset(long[][] arr, long val) {
        for (long[] row : arr) {
            Arrays.fill(row, val);
        }
    }

    static void memset(long[] arr, long val) {
        Arrays.fill(arr, val);
    }

    static boolean works(long test) {
        return true;
    }

    public static int upperBound(int[] array, int value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    static int[] takeIntegerArrayInput(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = ni();
        }
        return arr;
    }

    static long fastMultiply(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= base;
            }
            base *= base;
            exp >>= 1;
        }
        return result;
    }

    static long[] takeLongArrayInput(int size) {
        long[] arr = new long[size];
        for (int i = 0; i < size; i++) {
            arr[i] = nl();
        }
        return arr;
    }

    static final long MOD = 1_000_000_007;
    static FastReader in;

    static void print(Object o) {
        System.out.print(o);
    }

    static void println(Object o) {
        System.out.println(o);
    }

    static String n() {
        return in.next();
    }

    static String nln() {
        return in.nextLine();
    }

    static int ni() {
        return Integer.parseInt(in.next());
    }

    static int[] ia(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = ni();
        return arr;
    }

    static long[] la(int size) {
        long[] arr = new long[size];
        for (int i = 0; i < size; i++) arr[i] = nl();
        return arr;
    }

    static long nl() {
        return Long.parseLong(in.next());
    }

    static double nd() {
        return Double.parseDouble(in.next());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

    static void println(String[] arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }
}