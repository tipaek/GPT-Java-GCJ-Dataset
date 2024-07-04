import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final long MOD = 1000000007L;
    private static final int MAX_INT = Integer.MAX_VALUE;
    private static final int MIN_INT = Integer.MIN_VALUE;
    private static final long MAX_LONG = Long.MAX_VALUE;
    private static final long MIN_LONG = Long.MIN_VALUE;
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(BR.readLine());
        int testCases = nextInt();
        int caseNumber = 0;
        
        outerLoop:
        while (testCases-- > 0) {
            caseNumber++;
            int n = nextInt();
            List<List<Integer>> intervals = new ArrayList<>(n);
            
            for (int i = 0; i < n; i++) {
                List<Integer> interval = new ArrayList<>(3);
                interval.add(nextInt());
                interval.add(nextInt());
                interval.add(i);
                intervals.add(interval);
            }
            
            intervals.sort(Comparator.comparingInt(a -> a.get(0)));
            char[] result = new char[n];
            int cEnd = 0, jEnd = 0;
            
            for (List<Integer> interval : intervals) {
                if (interval.get(0) >= cEnd) {
                    result[interval.get(2)] = 'C';
                    cEnd = interval.get(1);
                } else if (interval.get(0) >= jEnd) {
                    result[interval.get(2)] = 'J';
                    jEnd = interval.get(1);
                } else {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    continue outerLoop;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + new String(result));
        }
    }

    private static int nextInt() throws IOException {
        if (!st.hasMoreTokens()) {
            st = new StringTokenizer(BR.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    private static long nextLong() throws IOException {
        if (!st.hasMoreTokens()) {
            st = new StringTokenizer(BR.readLine());
        }
        return Long.parseLong(st.nextToken());
    }

    private static String nextString() throws IOException {
        if (!st.hasMoreTokens()) {
            st = new StringTokenizer(BR.readLine());
        }
        return st.nextToken();
    }

    private static double nextDouble() throws IOException {
        if (!st.hasMoreTokens()) {
            st = new StringTokenizer(BR.readLine());
        }
        return Double.parseDouble(st.nextToken());
    }

    private static int[] readIntArray(int n) throws IOException {
        int[] array = new int[n];
        st = new StringTokenizer(BR.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        return array;
    }

    private static long[] readLongArray(int n) throws IOException {
        long[] array = new long[n];
        st = new StringTokenizer(BR.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }
        return array;
    }

    private static String[] readStringArray(int n) throws IOException {
        String[] array = new String[n];
        st = new StringTokenizer(BR.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = st.nextToken();
        }
        return array;
    }

    private static double[] readDoubleArray(int n) throws IOException {
        double[] array = new double[n];
        st = new StringTokenizer(BR.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Double.parseDouble(st.nextToken());
        }
        return array;
    }

    private static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int val : array) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void printArray(long[] array) {
        StringBuilder sb = new StringBuilder();
        for (long val : array) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void printArray(String[] array) {
        StringBuilder sb = new StringBuilder();
        for (String val : array) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void printArray(double[] array) {
        StringBuilder sb = new StringBuilder();
        for (double val : array) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void printArray(char[] array) {
        StringBuilder sb = new StringBuilder();
        for (char val : array) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}