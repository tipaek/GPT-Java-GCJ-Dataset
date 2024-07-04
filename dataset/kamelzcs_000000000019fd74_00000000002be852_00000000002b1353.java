import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    final static String PROBLEM_NAME = "test";
    final static String WORK_DIR = "/home/kamel/Code/java/LeetCode/data/gcj2020/" + PROBLEM_NAME + "/";
    final static String INPUT_FILE_NAME = "input.txt";
    final static String OUTPUT_FILE_NAME = "output.txt";
    String[] data;
    String[][] parts;
    long N;

    void solve(Scanner sc, PrintWriter pw) {
        N  = sc.nextLong();
        StringBuilder result = new StringBuilder();
        long currentSum = 0;
        long nextValue = 1;
        int row = 2;
        while (currentSum + nextValue <= N) {
            currentSum += nextValue;
            String pos = String.format("%d %d\n", row, 2);
            result.append(pos);
            nextValue++;
            row++;
        }

        nextValue = 1;
        row--;
        while (currentSum + nextValue <= N) {
            currentSum += nextValue;
            String pos = String.format("%d %d\n", row, 1);
            result.append(pos);
            row--;
        }

        pw.println(String.format("%s", result.toString()));
    }

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
//        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
//                + OUTPUT_FILE_NAME));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(System.out);
        int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            pw.println("Case #" + (caseNum + 1) + ":");
            new Solution().solve(sc, pw);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
