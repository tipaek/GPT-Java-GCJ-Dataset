import java.io.*;
import java.util.*;

public class Main {
    private BufferedReader in;
    private StringTokenizer tokenizer;
    private int[][] nums;
    private boolean[] nums2;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            int testCases = nextInt();
            for (int i = 0; i < testCases; i++) {
                int size = nextInt();
                nums = new int[size][size];
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        nums[row][col] = nextInt();
                    }
                }
                int sum = calculateDiagonalSum(size);
                int duplicateRows = countDuplicateRows(size);
                int duplicateCols = countDuplicateCols(size);
                System.out.println("Case #" + (i + 1) + ": " + sum + " " + duplicateRows + " " + duplicateCols);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private int calculateDiagonalSum(int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i][i];
        }
        return sum;
    }

    private int countDuplicateRows(int size) {
        int duplicateRows = 0;
        for (int row = 0; row < size; row++) {
            nums2 = new boolean[1000];
            for (int col = 0; col < size; col++) {
                if (nums2[nums[row][col]]) {
                    duplicateRows++;
                    break;
                }
                nums2[nums[row][col]] = true;
            }
        }
        return duplicateRows;
    }

    private int countDuplicateCols(int size) {
        int duplicateCols = 0;
        for (int col = 0; col < size; col++) {
            nums2 = new boolean[1000];
            for (int row = 0; row < size; row++) {
                if (nums2[nums[row][col]]) {
                    duplicateCols++;
                    break;
                }
                nums2[nums[row][col]] = true;
            }
        }
        return duplicateCols;
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

    private long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private String nextLine() throws IOException {
        return in.readLine().trim();
    }
}