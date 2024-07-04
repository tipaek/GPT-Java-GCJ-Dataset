import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    private BufferedReader in;
    private StringTokenizer tokenizer;
    private int[][] tasks;
    private Map<Integer, Integer> map = new HashMap<>();
    private ArrayList<Integer> integerList = new ArrayList<>();
    private ArrayList<Long> longList = new ArrayList<>();

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            int testCases = nextInt();

            for (int testCase = 0; testCase < testCases; testCase++) {
                String result = "";
                int taskCount = nextInt();
                tasks = new int[taskCount][2];

                for (int i = 0; i < taskCount; i++) {
                    tasks[i][0] = nextInt();
                    tasks[i][1] = nextInt();
                }

                Arrays.sort(tasks, (a, b) -> Integer.compare(a[0], b[0]));

                int cameronEndTime = 0;
                int jamieEndTime = 0;
                boolean possible = true;

                for (int i = 0; i < taskCount; i++) {
                    if (cameronEndTime <= tasks[i][0]) {
                        result += "C";
                        cameronEndTime = tasks[i][1];
                    } else if (jamieEndTime <= tasks[i][0]) {
                        result += "J";
                        jamieEndTime = tasks[i][1];
                    } else {
                        result = "IMPOSSIBLE";
                        possible = false;
                        break;
                    }
                }

                System.out.println("Case #" + (testCase + 1) + ": " + result);
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