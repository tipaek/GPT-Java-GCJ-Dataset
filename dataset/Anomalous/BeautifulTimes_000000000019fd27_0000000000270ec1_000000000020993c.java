import java.io.*;
import java.util.*;

public class Main {
    private BufferedReader in;
    private StringTokenizer tokenizer;
    private int[][] matrix;
    private boolean[] seenNumbers;
    private Map<Integer, Integer> map = new HashMap<>();
    private List<Integer> integerList = new ArrayList<>();
    private List<Long> longList = new ArrayList<>();

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            int testCaseCount = nextInt();
            for (int testCase = 0; testCase < testCaseCount; testCase++) {
                int size = nextInt();
                matrix = new int[size][size];
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = nextInt();
                    }
                }
                int diagonalSum = calculateDiagonalSum(size);
                int rowDuplicates = countRowDuplicates(size);
                int columnDuplicates = countColumnDuplicates(size);
                System.out.println("Case #" + (testCase + 1) + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private int calculateDiagonalSum(int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private int countRowDuplicates(int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            seenNumbers = new boolean[1000];
            for (int j = 0; j < size; j++) {
                if (seenNumbers[matrix[i][j]]) {
                    duplicateCount++;
                    break;
                }
                seenNumbers[matrix[i][j]] = true;
            }
        }
        return duplicateCount;
    }

    private int countColumnDuplicates(int size) {
        int duplicateCount = 0;
        for (int j = 0; j < size; j++) {
            seenNumbers = new boolean[1000];
            for (int i = 0; i < size; i++) {
                if (seenNumbers[matrix[i][j]]) {
                    duplicateCount++;
                    break;
                }
                seenNumbers[matrix[i][j]] = true;
            }
        }
        return duplicateCount;
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