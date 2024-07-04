import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    private boolean judge = true;
    private FastReader scn;
    private PrintWriter out;
    private static final String INPUT = "";
    private static final int MAX_N = 10000;
    private static final int MAX_DIGITS = 10;

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
            System.out.println((System.currentTimeMillis() - startTime) + " ms");
        }
    }

    private void solve() {
        int T = scn.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            out.print("Case #" + tt + ": ");
            processTestCase();
        }
    }

    private void processTestCase() {
        int u = scn.nextInt();
        long maxNumber = (long) Math.pow(10, u) - 1;
        long[] numbers = new long[MAX_N];
        String[] strings = new String[MAX_N];
        Set<Character> uniqueChars = new HashSet<>();

        for (int i = 0; i < MAX_N; i++) {
            numbers[i] = scn.nextLong();
            if (numbers[i] == -1) {
                numbers[i] = maxNumber;
            }
            strings[i] = scn.next();
            for (char c : strings[i].toCharArray()) {
                uniqueChars.add(c);
            }
        }

        int[] charMapping = new int[MAX_DIGITS];
        int index = 0;
        for (char c : uniqueChars) {
            charMapping[index++] = c - 'A';
        }
        charMapping = scn.shuffle(charMapping);

        int[] numMapping = new int[MAX_DIGITS];
        for (int i = 0; i < MAX_DIGITS; i++) {
            numMapping[i] = i;
        }

        String result = findValidPermutation(charMapping, numMapping, strings, numbers);
        out.println(result);
    }

    private String findValidPermutation(int[] charMapping, int[] numMapping, String[] strings, long[] numbers) {
        HashMap<Character, Integer> codeMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        do {
            codeMap.clear();
            for (int i = 0; i < MAX_DIGITS; i++) {
                codeMap.put((char) (charMapping[numMapping[i]] + 'A'), i);
            }

            if (isValidPermutation(codeMap, strings, numbers)) {
                for (int i = 0; i < MAX_DIGITS; i++) {
                    result.append((char) (charMapping[numMapping[i]] + 'A'));
                }
                break;
            }
        } while (nextPermutation(numMapping));

        return result.toString();
    }

    private boolean isValidPermutation(HashMap<Character, Integer> codeMap, String[] strings, long[] numbers) {
        for (int i = 0; i < MAX_N; i++) {
            long num = 0;
            for (char c : strings[i].toCharArray()) {
                num = num * 10 + codeMap.get(c);
                if (num == 0 || num > numbers[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean nextPermutation(int[] nums) {
        int n = nums.length;
        int left = n - 2;

        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }

        if (left < 0) {
            Arrays.sort(nums);
            return false;
        }

        int right = n - 1;
        while (nums[right] <= nums[left]) {
            right--;
        }

        swap(nums, left, right);
        Arrays.sort(nums, left + 1, n);
        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
            while (!(isSpaceChar(b))) {
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
            for (int i = 1; i < arr.length; i++) {
                int j = r.nextInt(i + 1);
                swap(arr, i, j);
            }
            return arr;
        }
    }
}