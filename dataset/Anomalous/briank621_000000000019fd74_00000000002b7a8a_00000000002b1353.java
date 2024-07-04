import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(reader.readLine());
            StringBuilder result = new StringBuilder();
            result.append("1 1\n");
            int step = 1;
            int next = 2;

            if (n == 501) {
                result.append("2 1\n");
                result.append("3 2\n");
                step = 4;
            }

            while (step < n) {
                result.append(next).append(" ").append(next).append("\n");
                next++;
                step++;
            }

            System.out.printf("Case #%d:\n%s", caseNumber, result.toString());
        }

        reader.close();
    }
}