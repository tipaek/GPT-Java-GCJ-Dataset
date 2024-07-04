import java.io.*;
import java.util.*;

public class Solution {
    private BufferedReader in;
    private StringTokenizer tokenizer;
    private long[][] nums;
    private long[] nums2;
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
            for (int caseNum = 0; caseNum < numCases; caseNum++) {
                System.out.println("Case #" + (caseNum + 1) + ": ");
                int a = nextInt();
                if (a < 400) {
                    for (int x = 0; x < a; x++) {
                        System.out.println((x + 1) + " " + 1);
                    }
                } else {
                    int b = a - 100;
                    int[] bits = new int[32];
                    for (int x = 0; x < 32; x++) {
                        bits[x] = b % 2;
                        b /= 2;
                    }
                    int rowsTaken = 0;
                    int side = 0;
                    for (int x = 0; x < 32; x++) {
                        if (bits[x] == 0) {
                            System.out.println((x + 1) + " " + (side == 0 ? 1 : (x + 1)));
                        } else {
                            rowsTaken++;
                            if (side == 0) {
                                for (int x1 = 0; x1 <= x; x1++) {
                                    System.out.println((x + 1) + " " + (x1 + 1));
                                }
                            } else {
                                for (int x1 = x; x1 >= 0; x1--) {
                                    System.out.println((x + 1) + " " + (x1 + 1));
                                }
                            }
                            side = 1 - side;
                        }
                    }
                    for (int x = 32; x < 100 - rowsTaken; x++) {
                        System.out.println((x + 1) + " " + (side == 0 ? 1 : (x + 1)));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(in.readLine().trim());
        }
        return tokenizer.nextToken();
    }

    private long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private String nextLine() throws IOException {
        return in.readLine().trim();
    }
}