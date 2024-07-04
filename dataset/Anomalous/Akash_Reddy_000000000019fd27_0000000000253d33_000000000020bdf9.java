import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (testCases > 0) {
            int n = Integer.parseInt(reader.readLine());
            int endC = 0, endJ = 0, startC = 0, startJ = 0;
            StringBuilder order = new StringBuilder();
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                String[] times = reader.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                if (!impossible) {
                    if (start >= endC || end <= startC) {
                        startC = start;
                        endC = end;
                        order.append("C");
                    } else if (start >= endJ || end <= startJ) {
                        startJ = start;
                        endJ = end;
                        order.append("J");
                    } else {
                        impossible = true;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + order.toString());
            }

            caseNumber++;
            testCases--;
        }
    }
}