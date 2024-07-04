import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class CodeJamQu {
    private BufferedReader in;
    private StringTokenizer tokenizer;
    private int[][] matrix;
    private boolean[] visited;
    private Map<Integer, Integer> map = new HashMap<>();
    private ArrayList<Integer> intList = new ArrayList<>();
    private ArrayList<Long> longList = new ArrayList<>();

    public static void main(String[] args) {
        new CodeJamQu();
    }

    public CodeJamQu() {
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
                int diagonalSum = 0;
                for (int i = 0; i < size; i++) {
                    diagonalSum += matrix[i][i];
                }
                int duplicateRows = 0;
                for (int i = 0; i < size; i++) {
                    visited = new boolean[1000];
                    for (int j = 0; j < size; j++) {
                        if (visited[matrix[i][j]]) {
                            duplicateRows++;
                            break;
                        }
                        visited[matrix[i][j]] = true;
                    }
                }
                int duplicateCols = 0;
                for (int j = 0; j < size; j++) {
                    visited = new boolean[1000];
                    for (int i = 0; i < size; i++) {
                        if (visited[matrix[i][j]]) {
                            duplicateCols++;
                            break;
                        }
                        visited[matrix[i][j]] = true;
                    }
                }
                System.out.println("Case #" + (testCase + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
            }
        } catch (IOException e) {
            System.out.println(e);
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