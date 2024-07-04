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
        long startTime = System.currentTimeMillis();
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null || judge;
        out = new PrintWriter(System.out);
        scn = new FastReader(onlineJudge);
        solve();
        out.flush();
        if (!onlineJudge) {
            System.out.println("Execution time: " + (System.currentTimeMillis() - startTime) + " ms");
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
                for (char ch : s[i].toCharArray()) {
                    uniqueChars.add(ch);
                }
            }

            if (uniqueChars.size() < 10) {
                out.println(0 / 0);
                continue;
            }

            int[] per = new int[10];
            int index = 0;
            for (char c : uniqueChars) {
                per[index++] = c - 'A';
            }

            int[] nums = new int[10];
            for (int i = 0; i < 10; i++) {
                nums[i] = i;
            }

            String result = "";
            do {
                Map<Character, Integer> codeMap = new HashMap<>();
                for (int i = 0; i < 10; i++) {
                    codeMap.put((char) (per[nums[i]] + 'A'), i);
                }

                boolean isValid = true;
                for (int i = 0; i < n; i++) {
                    if (arr[i] == -1) {
                        continue;
                    }
                    long num = 0;
                    for (char ch : s[i].toCharArray()) {
                        num = num * 10 + codeMap.get(ch);
                    }
                    if (num == 0 || num > arr[i]) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 10; i++) {
                        sb.append((char) (per[nums[i]] + 'A'));
                    }
                    result = sb.toString();
                    break;
                }
            } while (nextPermutation(nums));

            if (result.isEmpty()) {
                while (true) {
                    // Infinite loop to simulate the original behavior
                }
            }
            out.println(result);
        }
    }

    private boolean nextPermutation(int[] nums) {
        int left = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                left = i - 1;
                break;
            }
        }

        if (left == -1) {
            Arrays.sort(nums);
            return nums[0] >= nums[nums.length - 1];
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
        return nums[0] >= nums[nums.length - 1];
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
    }
}