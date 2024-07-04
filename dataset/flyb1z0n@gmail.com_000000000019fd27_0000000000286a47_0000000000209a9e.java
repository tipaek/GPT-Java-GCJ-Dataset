import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = sc.nextInt();
        int bitsCount = sc.nextInt();
        PrintWriter pr = new PrintWriter(System.out, true);
        for (int t = 1; t <= testCaseCount; t++) {
            boolean isSuccess = solve(sc, pr, bitsCount);
            if(!isSuccess)
            {
                System.exit(0);
            }
        }
    }

    private static boolean solve(Scanner sc, PrintWriter pr, int bitsCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= bitsCount; i++) {
            pr.println(i);
            pr.flush();
            final int bitVal = sc.nextInt();
            sb.append(bitVal);
        }

        pr.println(sb.toString());
        pr.flush();
        final String result = sc.next();
        return "Y".equals(result);
    }

}
