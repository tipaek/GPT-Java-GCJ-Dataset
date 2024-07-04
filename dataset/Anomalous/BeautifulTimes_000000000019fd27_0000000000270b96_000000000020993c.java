import java.io.*;
import java.util.*;

public class Main {
    private BufferedReader in;
    private StringTokenizer tokenizer;
    private int[][] nums;
    private boolean[] nums2;
    private Map<Integer, Integer> map = new HashMap<>();
    private List<Integer> ar = new ArrayList<>();
    private List<Long> ar2 = new ArrayList<>();

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            int testCases = nextInt();
            for (int testCase = 0; testCase < testCases; testCase++) {
                int size = nextInt();
                nums = new int[size][size];
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        nums[i][j] = nextInt();
                    }
                }

                int sum = 0;
                for (int i = 0; i < size; i++) {
                    sum += nums[i][i];
                }

                int rowDuplicates = countRowDuplicates(size);
                int colDuplicates = countColDuplicates(size);

                System.out.println("Case #" + (testCase + 1) + ": " + sum + " " + rowDuplicates + " " + colDuplicates);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private int countRowDuplicates(int size) {
        int duplicates = 0;
        for (int i = 0; i < size; i++) {
            nums2 = new boolean[1000];
            for (int j = 0; j < size; j++) {
                if (nums2[nums[i][j]]) {
                    duplicates++;
                    break;
                }
                nums2[nums[i][j]] = true;
            }
        }
        return duplicates;
    }

    private int countColDuplicates(int size) {
        int duplicates = 0;
        for (int i = 0; i < size; i++) {
            nums2 = new boolean[1000];
            for (int j = 0; j < size; j++) {
                if (nums2[nums[j][i]]) {
                    duplicates++;
                    break;
                }
                nums2[nums[j][i]] = true;
            }
        }
        return duplicates;
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