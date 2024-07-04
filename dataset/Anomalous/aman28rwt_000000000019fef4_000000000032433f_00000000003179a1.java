import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    boolean judge = true;
    FastReader scn;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        int T = scn.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            out.print("Case #" + tt + ": ");

            int u = scn.nextInt();
            int n = 10000;
            long[] arr = new long[n];
            String[] s = new String[n];
            Set<Character> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextLong();
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

            Map<Character, Integer> code = new HashMap<>();
            String ans = "";
            do {
                code.clear();
                for (int i = 0; i < 10; i++) {
                    code.put((char) (per[nums[i]] + 'A'), i);
                }

                boolean valid = true;
                for (int i = 0; i < n; i++) {
                    long num = 0;
                    for (char c : s[i].toCharArray()) {
                        num = 10 * num + code.get(c);
                        if (num == 0 || num > arr[i]) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) break;
                }

                if (valid) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 10; i++) {
                        sb.append((char) (per[nums[i]] + 'A'));
                    }
                    ans = sb.toString();
                    break;
                }

            } while (nextPermutation(nums));

            out.println(ans);
        }
    }

    boolean nextPermutation(int[] nums) {
        int left = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                left = i - 1;
                break;
            }
        }

        if (left == -1) {
            Arrays.sort(nums);
            return false;
        }

        int right = left + 1;
        for (int i = left + 1; i < nums.length; i++) {
            if (nums[i] > nums[left] && nums[i] <= nums[right]) {
                right = i;
            }
        }

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        Arrays.sort(nums, left + 1, nums.length);
        return true;
    }

    public void run() {
        long time = System.currentTimeMillis();
        boolean oj = System.getProperty("ONLINE_JUDGE") != null || judge;
        out = new PrintWriter(System.out);
        scn = new FastReader(oj);
        solve();
        out.flush();
        if (!oj) {
            System.out.println(Arrays.deepToString(new Object[] { System.currentTimeMillis() - time + " ms" }));
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 28).start();
    }

    class FastReader {
        InputStream is;

        public FastReader(boolean onlineJudge) {
            is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        }

        byte[] inbuf = new byte[1024];
        int lenbuf = 0, ptrbuf = 0;

        int readByte() {
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

        boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b));
            return b;
        }

        String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
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

        long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
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

        int[] shuffle(int[] arr) {
            Random r = new Random();
            for (int i = 1; i < arr.length; i++) {
                int j = r.nextInt(i + 1);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            return arr;
        }
    }
}