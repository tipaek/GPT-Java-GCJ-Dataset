import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            String[] row = br.readLine().split("");
            int nestingLevel = 0;
            StringBuilder resultRow = new StringBuilder();

            for (int j = 0; j < row.length; j++) {
                int cur = Integer.parseInt(row[j]);
                int next = 0;
                if (j + 1 < row.length) {
                    next = Integer.parseInt(row[j + 1]);
                }

                if (cur > nestingLevel) {
                    for (int nesting = 0; nesting < cur - nestingLevel; nesting++) {
                        resultRow.append("(");
                    }

                    nestingLevel = cur;
                    resultRow.append(cur);

                } else if (cur < nestingLevel) {
                    for (int nesting = 0; nesting < nestingLevel - cur; nesting++) {
                        resultRow.append(")");
                    }

                    nestingLevel = cur;
                    resultRow.append(cur);
                } else {
                    resultRow.append(cur);
                }
            }
            for (int nesting = 0; nesting < nestingLevel; nesting ++) {
                resultRow.append(")");
            }
            System.out.println("Case #" + (testCase + 1) + ": " + resultRow);

        }
    }
}