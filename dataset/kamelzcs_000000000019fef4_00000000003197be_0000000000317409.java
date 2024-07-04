package codejam.qualification1C.overexcited;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    final static String PROBLEM_NAME = "test";
    final static String WORK_DIR = "/home/kamel/Code/java/LeetCode/data/gcj2020/" + PROBLEM_NAME + "/";
    final static String INPUT_FILE_NAME = "input.txt";
    final static String OUTPUT_FILE_NAME = "output.txt";

    void solve(Scanner sc, PrintWriter pw) {
        int X = sc.nextInt();
        int Y = sc.nextInt();
        String dir = sc.next();
        for (int i = 0; i < dir.length(); i++) {
            char c = dir.charAt(i);
            if (c == 'N') {
                Y++;
            } else if (c == 'S') {
                Y--;
            } else if (c == 'E') {
                X++;
            } else {
                X--;
            }

            int t = i + 1;
            if (Math.abs(X) + Math.abs(Y) <= t) {
                pw.println(t);
                return;
            }
        }
        pw.println("IMPOSSIBLE");
    }

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
//        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
//                + OUTPUT_FILE_NAME));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(System.out);
        int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum + 1) + ": ");
            new Solution().solve(sc, pw);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
