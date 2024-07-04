import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = in.nextInt();

        for (int testCase = 1; testCase <= numberOfCases; testCase++) {
            int n = in.nextInt();
            int trace = in.nextInt();

            boolean possible = (trace % n == 0);

            System.out.format("Case #%d: %s%n", testCase, (possible ? "POSSIBLE" : "IMPOSSIBLE"));

            if (possible) {
                int diagonalNumber = trace / n;
                int startValue = diagonalNumber;

                for (int i=0; i<n; i++) {
                    int value = startValue--;
                    if (startValue <= 0) {
                        startValue = n;
                    }

                    for (int j=0; j<n; j++) {
                        System.out.format("%d ", value++);

                        if (value > n) {
                            value = 1;
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}