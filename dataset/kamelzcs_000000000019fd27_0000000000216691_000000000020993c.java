import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    final static String PROBLEM_NAME = "test";
    final static String WORK_DIR = "/home/kamel/Code/java/LeetCode/data/gcj2020/" + PROBLEM_NAME + "/";
    final static String INPUT_FILE_NAME = "input.txt";
    final static String OUTPUT_FILE_NAME = "output.txt";
    int[][] data;
    int N;

    void solve(Scanner sc, PrintWriter pw) {
        N  = sc.nextInt();
        data = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        pw.println(String.format("%d %d %d", trace(), duplicateRow(), duplicateColmn()));
    }

    private int trace() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += data[i][i];
        }
        return sum;
    }

    private int duplicateRow() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            List<Integer> list = Arrays.stream(data[i]).boxed().collect(Collectors.toList());
            if (new HashSet<>(list).size() < N) {
                result++;
            }
        }
        return result;
    }

    private int duplicateColmn() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                list.add(data[j][i]);
            }
            if (new HashSet<>(list).size() < N) {
                result++;
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
