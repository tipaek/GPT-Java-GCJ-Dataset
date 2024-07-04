import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Solution {
    private BufferedReader in;
    private StringTokenizer tokenizer;
    private int[][] matrix;
    private boolean[] seenNumbers;
    private Map<Integer, Integer> map = new HashMap<>();
    private ArrayList<Integer> integerList = new ArrayList<>();
    private ArrayList<Long> longList = new ArrayList<>();

    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            int testCases = nextInt();
            for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
                int size = nextInt();
                matrix = new int[size][size];
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        matrix[row][col] = nextInt();
                    }
                }
                int diagonalSum = calculateDiagonalSum(size);
                int duplicateRows = countDuplicateRows(size);
                int duplicateCols = countDuplicateCols(size);
                System.out.println("Case #" + (caseIndex + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private int calculateDiagonalSum(int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private int countDuplicateRows(int size) {
        int duplicateRows = 0;
        for (int row = 0; row < size; row++) {
            seenNumbers = new boolean[1000];
            for (int col = 0; col < size; col++) {
                if (seenNumbers[matrix[row][col]]) {
                    duplicateRows++;
                    break;
                }
                seenNumbers[matrix[row][col]] = true;
            }
        }
        return duplicateRows;
    }

    private int countDuplicateCols(int size) {
        int duplicateCols = 0;
        for (int col = 0; col < size; col++) {
            seenNumbers = new boolean[1000];
            for (int row = 0; row < size; row++) {
                if (seenNumbers[matrix[row][col]]) {
                    duplicateCols++;
                    break;
                }
                seenNumbers[matrix[row][col]] = true;
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