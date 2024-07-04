import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

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

    static int power(int x, int y) {
        int res = 1;
        while (y > 0) {
            if (y % 2 == 1) res *= x;
            y /= 2;
            x *= x;
        }
        return res;
    }

    static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    static boolean compareSeq(char[] S, int x, int y, int n) {
        for (int i = 0; i < n; i++) {
            if (S[x] < S[y]) return true;
            else if (S[x] > S[y]) return false;
            x = (x + 1) % n;
            y = (y + 1) % n;
        }
        return true;
    }

    static void build(long[] sum, int[] arr, int n) {
        for (int i = 0; i < (1 << n); i++) {
            long total = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) total += arr[j];
            }
            sum[i] = total;
        }
    }

    static int parity(int a) {
        a ^= a >> 16;
        a ^= a >> 8;
        a ^= a >> 4;
        a ^= a >> 2;
        a ^= a >> 1;
        return a & 1;
    }

    static int power(int x, int y, int m) {
        if (y == 0) return 1;
        int p = power(x, y / 2, m) % m;
        p = (p * p) % m;
        return (y % 2 == 0) ? p : (x * p) % m;
    }

    static int[] product(int[] nums) {
        int[] result = new int[nums.length];
        int[] t1 = new int[nums.length];
        int[] t2 = new int[nums.length];

        t1[0] = 1;
        t2[nums.length - 1] = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            t1[i + 1] = nums[i] * t1[i];
        }

        for (int i = nums.length - 1; i > 0; i--) {
            t2[i - 1] = t2[i] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = t1[i] * t2[i];
        }

        return result;
    }

    static int getSum(int[] bit, int ind) {
        int sum = 0;
        while (ind > 0) {
            sum += bit[ind];
            ind -= ind & (-ind);
        }
        return sum;
    }

    static void update(int[] bit, int max, int ind, int val) {
        while (ind <= max) {
            bit[ind] += val;
            ind += ind & (-ind);
        }
    }

    static boolean check(long mid, long a, long b) {
        long count = 1;
        while (count <= mid) {
            count++;
            if (a < b) a += count;
            else b += count;
            if (a == b) return true;
        }
        return false;
    }

    static class Aksh implements Comparable<Aksh> {
        int x, y, z;

        public Aksh(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int compareTo(Aksh o) {
            if (x != o.x) return x - o.x;
            else return y - o.y;
        }
    }

    static int get(int[] arr, int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            int x = (1 << i);
            for (int j = 0; j < n; j++) {
                if ((arr[j] & x) != 0) sum++;
            }
            if ((sum % 3) != 0) result |= x;
        }
        return result;
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    static int nextPrime(int N) {
        if (N <= 1) return 2 - N;
        int prime = N;
        while (!isPrime(prime)) prime++;
        return prime - N;
    }

    static long product(long x) {
        long prod = 1;
        while (x > 0) {
            prod *= (x % 10);
            x /= 10;
        }
        return prod;
    }

    static long findNumber(long l, long r) {
        String b = Long.toString(r);
        long ans = r;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '0') continue;
            char[] curr = b.toCharArray();
            curr[i] = (char) (((int) (curr[i] - '0') - 1) + '0');
            for (int j = i + 1; j < curr.length; j++) curr[j] = '9';
            int num = 0;
            for (char c : curr) num = num * 10 + (c - '0');
            if (num >= l && product(ans) < product(num)) ans = num;
        }
        return product(ans);
    }

    static long mod = 998244353;

    static long pow(long in, long pow) {
        if (pow == 0) return 1;
        long out = pow(in, pow / 2);
        out = (out * out) % mod;
        if (pow % 2 == 1) out = (out * in) % mod;
        return out;
    }

    static long inv(long in) {
        return pow(in, mod - 2);
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static int[] par;
    static int[] size;

    static int find(int i) {
        if (par[i] == i) return i;
        return par[i] = find(par[par[i]]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        if (size[x] < size[y]) swap(size, x, y);
        par[y] = x;
        size[x] += size[y];
    }

    static void multisourceBFS(long[] arr, int n, int m) {
        Map<Long, Long> dis = new HashMap<>();
        Queue<Long> q = new LinkedList<>();
        for (long value : arr) {
            dis.put(value, 0L);
            q.add(value);
        }

        long[] res = new long[m];
        long ans = 0;
        int k = 0;
        while (!q.isEmpty()) {
            if (k == m) break;
            long x = q.remove();
            if (dis.get(x) != 0) {
                ans += dis.get(x);
                res[k++] = x;
            }
            if (dis.get(x - 1) == null) {
                dis.put(x - 1, dis.get(x) + 1);
                q.add(x - 1);
            }
            if (dis.get(x + 1) == null) {
                dis.put(x + 1, dis.get(x) + 1);
                q.add(x + 1);
            }
        }

        System.out.println(ans);
        for (long re : res) System.out.print(re + " ");
    }

    static int x;
    static int maxCount = 0;

    static void dfs(int node, int par, int dist, List<Integer>[] adj) {
        if (dist >= maxCount) {
            maxCount = dist;
            x = node;
        }
        for (Integer i : adj[node]) {
            if (i != par) dfs(i, node, dist + 1, adj);
        }
    }

    static void primeFact(int n, List<Integer> cnt) {
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                cnt.add(i);
                n /= i;
            }
        }
        if (n > 1) cnt.add(n);
    }

    static boolean[] hash;

    static void sieve(int n) {
        Arrays.fill(hash, true);
        for (int p = 2; p * p < n; p++) {
            if (hash[p]) {
                for (int i = p * 2; i < n; i += p) {
                    hash[i] = false;
                }
            }
        }
    }

    static long div(long n) {
        long total = 1;
        for (int p = 2; p <= n; p++) {
            if (hash[p]) {
                int count = 0;
                while (n % p == 0) {
                    n /= p;
                    count++;
                }
                total *= (count + 1);
            }
        }
        return total;
    }

    static int upperBound(List<Integer> array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (value >= array.get(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static int[][] dp;

    static void func(int[][] a, int n, int k, int p) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= Math.min((i + 1) * k, p); j++) {
                for (int t2 = 0; t2 <= Math.min(k, Math.min(j, p)); t2++) {
                    int aksh = (t2 != 0) ? a[i][t2 - 1] : 0;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - t2] + aksh);
                }
            }
        }
    }

    static final long INF = Long.MAX_VALUE / 5;
    static List<Integer>[] adj;

    static long binpow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) res *= a;
            a *= a;
            b >>= 1;
        }
        return res;
    }

    static int upper(int[] array, int length, int value) {
        int low = 0;
        int high = length;
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

    static int ans = 0;

    static void bs(List<Integer> arr, int max, int k, int n) {
        int l = 1;
        int h = max;
        ans = h;
        while (l <= h) {
            int m = (l + h) / 2;
            int r = 0;
            for (int i = 0; i < n; i++) {
                r += (arr.get(i) + m - 1) / m - 1;
            }
            if (r <= k) {
                ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
    }

    static boolean pal(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int t1 = 1; t1 <= t; t1++) {
            int n = sc.nextInt();
            Aksh[] a = new Aksh[n];
            for (int i = 0; i < n; i++) {
                int a1 = sc.nextInt();
                int a2 = sc.nextInt();
                a[i] = new Aksh(a1, a2, i);
            }
            Arrays.sort(a);
            int e1 = a[0].y;
            int e2 = 0;
            int flag = 0;
            char[] c = new char[n];
            c[a[0].z] = 'C';
            for (int i = 1; i < n; i++) {
                if (a[i].x >= e1) {
                    c[a[i].z] = 'C';
                    e1 = a[i].y;
                } else if (a[i].x >= e2) {
                    c[a[i].z] = 'J';
                    e2 = a[i].y;
                } else {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.print("Case #" + t1 + ": ");
                for (char ch : c) System.out.print(ch);
                System.out.println();
            } else {
                System.out.println("Case #" + t1 + ": IMPOSSIBLE");
            }
        }
    }
}