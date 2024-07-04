import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    private static final String RESULT_PATTERN = "Case #%d: %s";

    private static List<String> answers;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int testCasesNumber = Integer.parseInt(tokenizer.nextToken());
            for (int t = 1; t <= testCasesNumber; ++t) {
                tokenizer = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                answers = new ArrayList<>();
                solve(t, x, y);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int testCaseId, int x, int y) {
        rec(x, y, 1, "");

        if (answers.isEmpty()) {
            System.out.println(String.format(RESULT_PATTERN, testCaseId, "IMPOSSIBLE"));
            return;
        }

        answers.sort(Comparator.comparingInt(String::length));
        System.out.println(String.format(RESULT_PATTERN, testCaseId, answers.get(0)));
    }

    private static void rec(int x, int y, int a, String path) {
//        System.out.println("x = " + x + ", y = " + y);
        if (a > 1000) {
            return;
        }
        if (x == 0 && y == 0) {
            answers.add(path);
            return;
        }

        rec(x, y - a, a * 2, path + "N");
        rec(x, y + a, a * 2, path + "S");
        rec(x - a, y, a * 2, path + "E");
        rec(x + a, y, a * 2, path + "W");

    }
}
