import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int T = in.nextInt();
        int caseNumber = 0;
        while (T-- > 0) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            long trace = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                    if (i == j) trace += matrix[i][j];
                }
            }

            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateColumns = countDuplicateColumns(matrix, n);

            System.out.println("Case #" + (++caseNumber) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            boolean hasDuplicate = false;
            for (int j = 0; j < n; j++) {
                if (seen[matrix[i][j]]) {
                    hasDuplicate = true;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
            if (hasDuplicate) duplicateRows++;
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int n) {
        int duplicateColumns = 0;
        for (int j = 0; j < n; j++) {
            boolean[] seen = new boolean[n + 1];
            boolean hasDuplicate = false;
            for (int i = 0; i < n; i++) {
                if (seen[matrix[i][j]]) {
                    hasDuplicate = true;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
            if (hasDuplicate) duplicateColumns++;
        }
        return duplicateColumns;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

    public static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static long fastExpWithMod(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return result % mod;
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
        return works(low) ? low : high;
    }

    private static boolean works(long test) {
        return true;
    }

    static class Fraction {
        long numerator;
        long denominator;

        Fraction(long numerator, long denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            normalize();
        }

        private void normalize() {
            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }
            long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        @Override
        public String toString() {
            if (numerator == 0) return "0";
            return numerator + "/" + denominator;
        }

        public Fraction multiply(Fraction other) {
            return new Fraction(numerator * other.numerator, denominator * other.denominator);
        }

        public Fraction multiply(int scalar) {
            return new Fraction(numerator * scalar, denominator);
        }
    }

    public static void mainMemset(int[][] arr, int val) {
        for (int[] row : arr) {
            Arrays.fill(row, val);
        }
    }

    public static void mainMemset(int[] arr, int val) {
        Arrays.fill(arr, val);
    }

    public static void mainMemset(long[][] arr, long val) {
        for (long[] row : arr) {
            Arrays.fill(row, val);
        }
    }

    public static void mainMemset(long[] arr, long val) {
        Arrays.fill(arr, val);
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

    public static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static int[] takeIntegerArrayInput(int no, FastReader in) {
        int[] arr = new int[no];
        for (int i = 0; i < no; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    public static long fastMultiply(long no, long pow) {
        long result = 1;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                result *= no;
            }
            no *= no;
            pow >>= 1;
        }
        return result;
    }

    public static long[] takeLongArrayInput(int no, FastReader in) {
        long[] arr = new long[no];
        for (int i = 0; i < no; i++) {
            arr[i] = in.nextLong();
        }
        return arr;
    }

    public static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }
}