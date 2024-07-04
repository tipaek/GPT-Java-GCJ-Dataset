import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static final int MAXN = 100005;
    static int[] spf = new int[MAXN];
    static int[] ans = new int[MAXN];
    static TreeSet<Integer> s = new TreeSet<>();
    static int[] tree = new int[4 * MAXN];

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

    static void sieves() {
        spf[1] = 1;
        for (int i = 2; i < MAXN; i++)
            spf[i] = i;
        for (int i = 4; i < MAXN; i += 2)
            spf[i] = 2;
        for (long i = 3; i * i < MAXN; i++) {
            if (spf[(int) i] == i) {
                for (long j = i * i; j < MAXN; j += i)
                    if (spf[(int) j] == j)
                        spf[(int) j] = (int) i;
            }
        }
    }

    static void getFactorizations(int x) {
        Set<Integer> factors = new HashSet<>();
        while (x != 1 && spf[x] != 1) {
            if (!factors.contains(spf[x]) && spf[x] != 1) {
                factors.add(spf[x]);
                ans[spf[x]]++;
            }
            x = x / spf[x];
        }
    }

    static void build(int node, int start, int end, int[] arr, int k) {
        if (start == end) {
            tree[node] = arr[start] % k;
            return;
        }
        int mid = (start + end) >> 1;
        build(2 * node, start, mid, arr, k);
        build(2 * node + 1, mid + 1, end, arr, k);
        tree[node] = (tree[2 * node] * tree[2 * node + 1]) % k;
    }

    static long query(int node, int start, int end, int l, int r, int k) {
        if (start > end || start > r || end < l)
            return 1;
        if (start >= l && end <= r)
            return tree[node] % k;
        int mid = (start + end) >> 1;
        long q1 = query(2 * node, start, mid, l, r, k);
        long q2 = query(2 * node + 1, mid + 1, end, l, r, k);
        return (q1 * q2) % k;
    }

    static long countSubarrays(int[] arr, int n, int k) {
        long result = 0;
        for (int i = 0; i < n; i++) {
            int low = i, high = n - 1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (query(1, 0, n - 1, i, mid, k) == 0)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            result += n - low;
        }
        return result;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();
        int caseNum = 1;
        while (T-- > 0) {
            StringBuffer sb = new StringBuffer();
            int N = sc.nextInt();
            List<Pair> ar = new ArrayList<>();
            List<Pair> arr = new ArrayList<>();
            char[] ch = new char[N];
            for (int i = 0; i < N; i++) {
                int st = sc.nextInt();
                int fn = sc.nextInt();
                ar.add(new Pair(fn, st, i));
            }
            Collections.sort(ar);
            Set<Integer> set = new HashSet<>();
            assignTasks(ar, ch, 'C', set);
            for (Pair p : ar) {
                if (!set.contains(p.z)) {
                    arr.add(new Pair(p.x, p.y, p.z));
                }
            }
            Collections.sort(arr);
            assignTasks(arr, ch, 'J', set);
            if (set.size() == N) {
                for (char c : ch) {
                    sb.append(c);
                }
                System.out.println("Case #" + caseNum + ": " + sb);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
            caseNum++;
        }
    }

    public static void assignTasks(List<Pair> ar, char[] ch, char p, Set<Integer> set) {
        if (ar.isEmpty()) return;
        int i = 0;
        set.add(ar.get(i).z);
        ch[ar.get(i).z] = p;
        for (int j = 1; j < ar.size(); j++) {
            if (ar.get(j).y >= ar.get(i).x) {
                set.add(ar.get(j).z);
                ch[ar.get(j).z] = p;
                i = j;
            }
        }
    }

    public static int check(int mid, int X, int K) {
        int temp = mid;
        Map<Integer, Integer> map = new HashMap<>();
        while (mid % 2 == 0) {
            mid /= 2;
            map.put(2, map.getOrDefault(2, 0) + 1);
        }
        for (int i = 3; i <= Math.sqrt(mid); i += 2) {
            while (mid % i == 0) {
                mid /= i;
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        int numOfFactors = 1;
        for (int count : map.values()) {
            numOfFactors *= (count + 1);
        }
        return (map.size() == K && numOfFactors == X) ? 0 : 1;
    }

    public static void sieven(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }
        for (int p = 2; p <= n; p++) {
            if (prime[p]) s.add(p);
        }
    }

    public static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static long power(long x, long y, int p) {
        long res = 1;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;
            y >>= 1;
            x = (x * x) % p;
        }
        return res;
    }

    static class Pair implements Comparable<Pair> {
        int x, y, z;

        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Pair p) {
            if (this.x != p.x) return Integer.compare(this.x, p.x);
            return Integer.compare(this.y, p.y);
        }
    }

    static class Compare {
        static void compare(Pair[] arr, int n) {
            Arrays.sort(arr, (p1, p2) -> {
                if (p1.x != p2.x) return Integer.compare(p1.x, p2.x);
                return Integer.compare(p1.y, p2.y);
            });
        }
    }
}