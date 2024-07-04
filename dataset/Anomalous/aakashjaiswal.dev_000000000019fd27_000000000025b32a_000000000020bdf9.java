import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int T = in.nextInt();
        int caseNumber = 0;
        
        while (T-- > 0) {
            int n = in.nextInt();
            List<Pair> activities = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                activities.add(new Pair(in.nextInt(), in.nextInt(), i));
            }

            Collections.sort(activities);
            char[] schedule = new char[n];
            int cEnd = 0, jEnd = 0;
            boolean impossible = false;
            StringBuilder result = new StringBuilder();
            
            for (Pair activity : activities) {
                if (cEnd <= activity.start) {
                    cEnd = activity.end;
                    schedule[activity.index] = 'C';
                } else if (jEnd <= activity.start) {
                    jEnd = activity.end;
                    schedule[activity.index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (char c : schedule) {
                    result.append(c);
                }
            }
            System.out.println("Case #" + (++caseNumber) + ": " + result);
        }
    }

    static class Pair implements Comparable<Pair> {
        int start, end, index;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.start != other.start) {
                return this.start - other.start;
            } else {
                return this.end - other.end;
            }
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
        return works(low) ? low : high;
    }

    static long fastExpWithMod(long base, long exp) {
        final long MOD = 1_000_000_007;
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return result % MOD;
    }

    public static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    static class RationalNumber {
        long numerator, denominator;

        RationalNumber(int value) {
            this.numerator = value;
            this.denominator = 1;
        }

        RationalNumber(long numerator, long denominator) {
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

        RationalNumber multiply(RationalNumber other) {
            long num = this.numerator * other.numerator;
            long denom = this.denominator * other.denominator;
            return new RationalNumber(num, denom);
        }

        RationalNumber multiply(int value) {
            long num = this.numerator * value;
            return new RationalNumber(num, this.denominator);
        }

        @Override
        public String toString() {
            if (numerator == 0) return "0";
            return numerator + "/" + denominator;
        }
    }

    static void fillArray(int[] array, int value) {
        Arrays.fill(array, value);
    }

    static void fillArray(long[] array, long value) {
        Arrays.fill(array, value);
    }

    static void fillArray(int[][] array, int value) {
        for (int[] row : array) {
            Arrays.fill(row, value);
        }
    }

    static void fillArray(long[][] array, long value) {
        for (long[] row : array) {
            Arrays.fill(row, value);
        }
    }

    static boolean works(long test) {
        return true;
    }

    public static int upperBound(int[] array, int value) {
        int low = 0, high = array.length;
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

    static void reverse(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    static int[] readIntArray(int size, FastReader in) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    static long[] readLongArray(int size, FastReader in) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextLong();
        }
        return array;
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

    static final long MOD = 1_000_000_007;

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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static void printArray(String[] array) {
        for (String s : array) {
            System.out.println(s);
        }
    }
}