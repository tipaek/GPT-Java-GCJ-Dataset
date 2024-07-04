import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    private boolean judge = true;
    private FastReader scn;
    private PrintWriter out;
    private String INPUT = "";

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 28).start();
    }

    @Override
    public void run() {
        long time = System.currentTimeMillis();
        boolean oj = System.getProperty("ONLINE_JUDGE") != null || judge;
        out = new PrintWriter(System.out);
        scn = new FastReader(oj);
        solve();
        out.flush();
        if (!oj) {
            System.out.println(Arrays.deepToString(new Object[]{System.currentTimeMillis() - time + " ms"}));
        }
    }

    private void solve() {
        int T = scn.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            out.print("Case #" + tt + ": ");
            processCase();
        }
    }

    private void processCase() {
        int u = scn.nextInt();
        int n = 10000;
        long[] arr = new long[n];
        String[] s = new String[n];
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextLong();
            if (arr[i] == -1) {
                arr[i] = (long) Math.pow(10, u) - 1;
            }
            s[i] = scn.next();
            for (char c : s[i].toCharArray()) {
                set.add(c);
            }
        }

        int[] per = new int[10];
        u = 0;
        for (char c : set) {
            per[u++] = c - 'A';
        }
        per = scn.shuffle(per);

        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = i;
        }

        HashMap<Character, Integer> code = new HashMap<>();
        String ans = "";
        do {
            code.clear();
            for (int i = 0; i < 10; i++) {
                code.put((char) (per[nums[i]] + 'A'), i);
            }

            if (isValidCode(code, arr, s)) {
                ans = buildAnswer(per, nums);
                break;
            }
        } while (nextPermutation(nums));

        out.println(ans);
    }

    private boolean isValidCode(HashMap<Character, Integer> code, long[] arr, String[] s) {
        for (int i = 0; i < s.length; i++) {
            long num = 0;
            for (char c : s[i].toCharArray()) {
                num = 10 * num + code.get(c);
                if (num == 0 || num > arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private String buildAnswer(int[] per, int[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i : nums) {
            ans.append((char) (per[i] + 'A'));
        }
        return ans.toString();
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

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
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
    }
}