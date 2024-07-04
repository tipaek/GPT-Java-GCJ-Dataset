import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    private boolean judge = true;
    private FastReader scn;
    private PrintWriter out;
    private final String INPUT = "";

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 28).start();
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        boolean isOnlineJudge = System.getProperty("ONLINE_JUDGE") != null || judge;
        out = new PrintWriter(System.out);
        scn = new FastReader(isOnlineJudge);
        solve();
        out.flush();
        if (!isOnlineJudge) {
            System.out.println(Arrays.deepToString(new Object[]{System.currentTimeMillis() - startTime + " ms"}));
        }
    }

    private void solve() {
        int T = scn.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            out.print("Case #" + tt + ": ");
            int u = scn.nextInt();
            int n = (int) 1e4;
            long[] arr = new long[n];
            String[] s = new String[n];
            Set<Character> uniqueChars = new HashSet<>();

            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextLong();
                s[i] = scn.next();
                for (char c : s[i].toCharArray()) {
                    uniqueChars.add(c);
                }
            }

            if (uniqueChars.size() < 10) {
                out.println(0 / 0);
            }

            int[] charMapping = new int[10];
            int index = 0;
            for (char c : uniqueChars) {
                charMapping[index++] = c - 'A';
            }

            int[] permutation = new int[10];
            for (int i = 0; i < 10; i++) {
                permutation[i] = i;
            }

            String result = "";
            do {
                Map<Character, Integer> code = new HashMap<>();
                for (int i = 0; i < 10; i++) {
                    code.put((char) (charMapping[permutation[i]] + 'A'), i);
                }

                boolean isValid = true;
                for (int i = 0; i < n; i++) {
                    if (arr[i] == -1) {
                        continue;
                    }
                    long number = 0;
                    for (char c : s[i].toCharArray()) {
                        number = 10 * number + code.get(c);
                    }
                    if (number == 0 || number > arr[i]) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    StringBuilder ansBuilder = new StringBuilder();
                    for (int i = 0; i < 10; i++) {
                        ansBuilder.append((char) (charMapping[permutation[i]] + 'A'));
                    }
                    result = ansBuilder.toString();
                    break;
                }

            } while (nextPermutation(permutation));

            if (result.length() != 10) {
                while (true) {
                    // Infinite loop to simulate a crash
                }
            }
            out.println(result);
        }
    }

    private boolean nextPermutation(int[] nums) {
        int left = -1, first = nums[0];
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                left = i - 1;
                break;
            }
        }

        if (left == -1) {
            Arrays.sort(nums);
            return nums[0] >= first;
        }

        int right = -1;
        for (int i = left + 1; i < nums.length; i++) {
            if ((nums[i] > nums[left] && right == -1) || (nums[i] > nums[left] && nums[i] < nums[right])) {
                right = i;
            }
        }

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        Arrays.sort(nums, left + 1, nums.length);
        return nums[0] >= first && nums.length > 1;
    }

    class FastReader {
        private InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;

        public FastReader(boolean onlineJudge) {
            is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        }

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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char nextChar() {
            return (char) skip();
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public String nextLine() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b) || b == ' ') {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !isSpaceChar(b)) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public int nextInt() {
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

        public long nextLong() {
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

        public char[][] nextMatrix(int n, int m) {
            char[][] map = new char[n][];
            for (int i = 0; i < n; i++) {
                map[i] = next(m);
            }
            return map;
        }

        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        public int[][] next2DInt(int n, int m) {
            int[][] arr = new int[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = nextIntArray(m);
            }
            return arr;
        }

        public long[][] next2DLong(int n, int m) {
            long[][] arr = new long[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLongArray(m);
            }
            return arr;
        }

        public int[] shuffle(int[] arr) {
            Random r = new Random();
            for (int i = 1, j; i < arr.length; i++) {
                j = r.nextInt(i);
                int c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
            }
            return arr;
        }

        public long[] shuffle(long[] arr) {
            Random r = new Random();
            for (int i = 1, j; i < arr.length; i++) {
                j = r.nextInt(i);
                long c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
            }
            return arr;
        }

        public int[] uniq(int[] arr) {
            Arrays.sort(arr);
            int[] rv = new int[arr.length];
            int pos = 0;
            rv[pos++] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    rv[pos++] = arr[i];
                }
            }
            return Arrays.copyOf(rv, pos);
        }

        public long[] uniq(long[] arr) {
            Arrays.sort(arr);
            long[] rv = new long[arr.length];
            int pos = 0;
            rv[pos++] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    rv[pos++] = arr[i];
                }
            }
            return Arrays.copyOf(rv, pos);
        }

        public int[] reverse(int[] arr) {
            int l = 0, r = arr.length - 1;
            while (l < r) {
                arr[l] = arr[l] ^ arr[r];
                arr[r] = arr[l] ^ arr[r];
                arr[l] = arr[l] ^ arr[r];
                l++;
                r--;
            }
            return arr;
        }

        public long[] reverse(long[] arr) {
            int l = 0, r = arr.length - 1;
            while (l < r) {
                arr[l] = arr[l] ^ arr[r];
                arr[r] = arr[l] ^ arr[r];
                arr[l] = arr[l] ^ arr[r];
                l++;
                r--;
            }
            return arr;
        }

        public int[] compress(int[] arr) {
            int n = arr.length;
            int[] rv = Arrays.copyOf(arr, n);
            rv = uniq(rv);
            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.binarySearch(rv, arr[i]);
            }
            return arr;
        }

        public long[] compress(long[] arr) {
            int n = arr.length;
            long[] rv = Arrays.copyOf(arr, n);
            rv = uniq(rv);
            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.binarySearch(rv, arr[i]);
            }
            return arr;
        }

        public void deepFillInt(Object array, int val) {
            if (!array.getClass().isArray()) {
                throw new IllegalArgumentException();
            }
            if (array instanceof int[]) {
                Arrays.fill((int[]) array, val);
            } else {
                for (Object obj : (Object[]) array) {
                    deepFillInt(obj, val);
                }
            }
        }

        public void deepFillLong(Object array, long val) {
            if (!array.getClass().isArray()) {
                throw new IllegalArgumentException();
            }
            if (array instanceof long[]) {
                Arrays.fill((long[]) array, val);
            } else {
                for (Object obj : (Object[]) array) {
                    deepFillLong(obj, val);
                }
            }
        }
    }
}