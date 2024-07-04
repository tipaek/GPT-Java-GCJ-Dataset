import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    void solve(Scanner sc, PrintWriter pw) {
        String str = sc.next();
        StringBuilder result = new StringBuilder();
        int depth = 0;
        for (int i = 0; i < str.length(); i++) {
            int expectedDepth = str.charAt(i) - '0';
            if (expectedDepth > depth) {
                result.append(String.join("", Collections.nCopies(expectedDepth - depth, "(")));
            } else if (expectedDepth < depth) {
                result.append(String.join("", Collections.nCopies(depth - expectedDepth, ")")));
            }
            result.append(str.charAt(i));
            depth = expectedDepth;
        }
        if (depth > 0) {
            result.append(String.join("", Collections.nCopies(depth, ")")));
        }
        pw.println(result.toString());
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
