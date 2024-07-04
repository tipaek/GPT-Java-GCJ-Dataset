import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    final static String PROBLEM_NAME = "test";
    final static String WORK_DIR = "/home/kamel/Code/java/LeetCode/data/gcj2020/" + PROBLEM_NAME + "/";
    final static String INPUT_FILE_NAME = "input.txt";
    final static String OUTPUT_FILE_NAME = "output.txt";
    String[] data;
    String[][] parts;
    int N;

    void solve(Scanner sc, PrintWriter pw) {
        N  = sc.nextInt();
        data = new String[N];
        parts = new String[3][N];
        for (int i = 0; i < N; i++) {
            data[i] = sc.next();
            String[] splits = data[i].split("\\*", -1);
            parts[0][i] = splits[0];
            parts[1][i] = splits[splits.length - 1];
            parts[2][i] = String.join("", Arrays.copyOfRange(splits, 1, splits.length - 1));
        }
        String result1 = solve(parts[0]);
        String result2 = solve2(parts[1]);
        String result = "*";
        StringBuilder builder = new StringBuilder();
        if ((!result1.equals("*")) && (!result2.equals("*"))) {
            for (int i = 0; i < N; i++) {
                builder.append(parts[2][i]);
            }
            result = result1 + builder.toString() + result2;
        }
        pw.println(String.format("%s", result));
    }

    private String solve(String[] data) {
        Arrays.sort(data, Comparator.comparingInt(String::length));
        String result = data[N - 1];
        for (int i = 0; i < N - 1; i++) {
            String toMatch = data[i];
            if (toMatch.length() == 0) {
                continue;
            }
            if (!result.startsWith(toMatch)) {
                result = "*";
                break;
            }
        }
        return result;
    }

    private String solve2(String[] data) {
        Arrays.sort(data, Comparator.comparingInt(String::length));
        String result = data[N - 1];
        for (int i = 0; i < N - 1; i++) {
            String toMatch = data[i];
            if (toMatch.length() == 0) {
                continue;
            }
            if (!result.endsWith(toMatch)) {
                result = "*";
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
//        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
//                + OUTPUT_FILE_NAME));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(System.out);
        int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            pw.print("Case #" + (caseNum + 1) + ": ");
            new Solution().solve(sc, pw);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
