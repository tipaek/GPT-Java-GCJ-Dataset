import java.util.*;
import java.io.*;

class Solution {
    int c;
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    long mod = 1000000007L;
    BinaryTree[] ba;
    BinaryTree[] ba1;
    BinaryTree[] ba2;
    int[] array;

    void solve() throws Exception {
        int t = ni();

        for (int ca = 1; ca <= t; ca++) {
            String s = ns();
            StringBuilder answer = new StringBuilder();
            int curr = 0;

            for (int i = 0; i < s.length(); i++) {
                int digit = Character.getNumericValue(s.charAt(i));
                if (curr < digit) {
                    answer.append(openPar(digit - curr));
                    answer.append(s.charAt(i));
                    curr = digit;
                } else {
                    answer.append(closePar(curr - digit));
                    answer.append(s.charAt(i));
                    curr = digit;
                }
            }

            answer.append(closePar(curr));
            out.println("Case #" + ca + ": " + answer);
        }
    }

    String openPar(int n) {
        return "(".repeat(n);
    }

    String closePar(int n) {
        return ")".repeat(n);
    }

    void printArray(int[] a) {
        for (int value : a) out.println(value);
    }

    boolean vestigium(int[] a, int n) {
        int[] b = new int[n + 1];
        for (int value : a) {
            b[value]++;
            if (b[value] > 1) return false;
        }
        return true;
    }

    String rplc(String s, char a, char x) {
        return s.replace(a, x);
    }

    long power(long a, int x) {
        long temp = 1;
        String s = Integer.toBinaryString(x);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                temp = (temp * a) % mod;
            }
            a = (a * a) % mod;
        }
        return temp;
    }

    int treeCheckInRange(int x, int y, TreeMap<Integer, Integer>[] tm, int i) {
        if (i == tm.length) return y - x;
        if (tm[i].get(x) != null || tm[i].get(y) != null) return treeCheckInRange(x, y, tm, i + 1);
        Integer higherKey = tm[i].higherKey(x);
        if (higherKey != null && higherKey < y) return treeCheckInRange(x, y, tm, i + 1);
        Integer lowerKey = tm[i].lowerKey(x);
        Integer higherKeyY = tm[i].higherKey(y);
        if (lowerKey == null) return treeCheckInRange(x, higherKeyY, tm, i + 1);
        if (higherKeyY == null) return treeCheckInRange(lowerKey, y, tm, i + 1);
        if (x - lowerKey == higherKeyY - y) {
            int m1 = treeCheckInRange(lowerKey, y, tm, i + 1);
            int m2 = treeCheckInRange(x, higherKeyY, tm, i + 1);
            return Math.min(m1, m2);
        }
        return (x - lowerKey > higherKeyY - y) ? treeCheckInRange(x, higherKeyY, tm, i + 1) : treeCheckInRange(lowerKey, y, tm, i + 1);
    }

    void treeAdd(TreeMap<Integer, Integer> t, int a) {
        t.put(a, t.getOrDefault(a, 0) + 1);
    }

    A binary(int a, int b, int c, int less, int great, LinkedList<Integer> lg, LinkedList<Integer> ll) {
        int mid = (a + b) / 2;
        if (mid < c) {
            less++;
            ll.add(mid);
            return binary(mid + 1, b, c, less, great, lg, ll);
        }
        if (mid > c) {
            great++;
            lg.add(mid);
            return binary(a, mid - 1, c, less, great, lg, ll);
        }
        A result = new A();
        result.a = less;
        result.b = great;
        return result;
    }

    int nu(TreeMap<Integer, Integer> tm, int a, int[] b) {
        int count = tm.get(a) - b[a];
        if (b[a] == 1) tm.remove(a);
        else tm.put(a, b[a] - 1);
        b[a]--;
        return count;
    }

    int number(int a, int n) {
        double temp = (double) a / n;
        int t = (int) temp;
        if (temp - t >= .5) return a;
        int x = (int) ((temp - t) * n);
        temp = ((a + x - 1) * n) / 100.0;
        if (temp - (int) temp >= .5) return a + x - 1;
        temp = ((a + x) * n) / 100.0;
        if (temp - (int) temp >= .5) return a + x;
        return a + x + 1;
    }

    int maxSumIS(int arr[], int n) {
        int[] msis = new int[n];
        System.arraycopy(arr, 0, msis, 0, n);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
                    msis[i] = msis[j] + arr[i];
                }
            }
        }

        int max = Arrays.stream(msis).max().orElse(0);
        for (int value : msis) {
            out.println(value);
        }
        return max;
    }

    int minCoins(int coins[], int m, int V) {
        int[] table = new int[V + 1];
        Arrays.fill(table, 1, V + 1, Integer.MAX_VALUE);

        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < m; j++) {
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i]) {
                        table[i] = sub_res + 1;
                    }
                }
            }
        }
        return table[V];
    }

    long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    long term(long a, long b, int k) {
        return (b - a) / k + 1;
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !isSpaceChar(b)) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
}

class A {
    int a, b;
}

class MergeSort {
    void merge(int arr[], int[] b, int[] c, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];
        int[] l1 = new int[n1];
        int[] r1 = new int[n2];
        int[] l2 = new int[n1];
        int[] r2 = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(b, l, l1, 0, n1);
        System.arraycopy(c, l, l2, 0, n1);

        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
            r1[j] = b[m + 1 + j];
            r2[j] = c[m + 1 + j];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                b[k] = l1[i];
                c[k] = l2[i];
                i++;
            } else {
                arr[k] = R[j];
                b[k] = r1[j];
                c[k] = r2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            b[k] = l1[i];
            c[k] = l2[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            b[k] = r1[j];
            c[k] = r2[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int[] b, int[] c, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, b, c, l, m);
            sort(arr, b, c, m + 1, r);
            merge(arr, b, c, l, m, r);
        }
    }
}

class BinaryTree {
    int key;
    BinaryTree right;
    BinaryTree left;
}

class Permutation {
    int k = 0;
    String[] s = new String[1000];

    public String[] function() {
        return s;
    }

    private void permute(String str, int l, int r) {
        if (l == r) {
            s[k] = str;
            k++;
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public String swap(String a, int i, int j) {
        char[] charArray = a.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

class SegmentTree {
    int[] st;

    SegmentTree(int arr[], int n) {
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size];
        constructSTUtil(arr, 0, n - 1, 0);
    }

    int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    int getSumUtil(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se) return st[si];
        if (se < qs || ss > qe) return 0;
        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    void updateValueUtil(int ss, int se, int i, int diff, int si) {
        if (i < ss || i > se) return;
        st[si] += diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    void updateValue(int arr[], int n, int i, int new_val) {
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }
        int diff = new_val - arr[i];
        arr[i] = new_val;
        updateValueUtil(0, n - 1, i, diff, 0);
    }

    int getSum(int n, int qs, int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    int constructSTUtil(int arr[], int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
        int mid = getMid(ss, se);
        st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) + constructSTUtil(arr, mid + 1, se, si * 2 + 2);
        return st[si];
    }
}