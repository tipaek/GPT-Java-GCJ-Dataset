import java.io.*;
import java.util.*;

public class Solution {
    private BufferedReader in;
    private StringTokenizer tokenizer;
    private long[][] nums;
    private Map<Integer, Integer> map = new HashMap<>();
    private List<Integer> ar = new ArrayList<>();
    private List<Long> ar2 = new ArrayList<>();

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            int numCases = nextInt();
            initializeNumsArray();
            processCases(numCases);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void initializeNumsArray() {
        nums = new long[501][501];
        nums[0][0] = 1;
        for (int i = 1; i < 501; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = (nums[i - 1][j] != -1 && nums[i - 1][j - 1] != -1) ? nums[i - 1][j] + nums[i - 1][j - 1] : -1;
                    if (nums[i][j] > Math.pow(10, 9)) {
                        nums[i][j] = -1;
                    }
                }
            }
        }
    }

    private void processCases(int numCases) throws IOException {
        for (int caseNum = 0; caseNum < numCases; caseNum++) {
            System.out.println("Case #" + (caseNum + 1) + ": ");
            int a = nextInt();
            if (a < 400) {
                for (int i = 0; i < a; i++) {
                    System.out.println((i + 1) + " " + 1);
                }
            } else {
                processLargeCase(a);
            }
        }
    }

    private void processLargeCase(int a) {
        int b = a - 100;
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            bits[i] = b % 2;
            b /= 2;
        }
        long sum = 0;
        int rowsTaken = 0;
        int side = 0;

        for (int i = 0; i < 32; i++) {
            if (bits[i] == 0) {
                sum++;
                System.out.println((i + 1) + " " + (side == 0 ? 1 : (i + 1)));
            } else {
                rowsTaken++;
                if (side == 0) {
                    for (int j = 0; j <= i; j++) {
                        sum += nums[i][j];
                        System.out.println((i + 1) + " " + (j + 1));
                    }
                } else {
                    for (int j = i; j >= 0; j--) {
                        sum += nums[i][j];
                        System.out.println((i + 1) + " " + (j + 1));
                    }
                }
                side = (side + 1) % 2;
            }
        }

        for (int i = 32; i < 100 + rowsTaken; i++) {
            sum++;
            System.out.println((i + 1) + " " + (side == 0 ? 1 : (i + 1)));
        }
    }

    private String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(in.readLine().trim());
        }
        return tokenizer.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}