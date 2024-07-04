import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        int[][] inputCollector = new int[t][2];

        // Collecting input for each test case
        for (int i = 0; i < t; i++) {
            String[] lineParsed = scanner.nextLine().split(" ");
            inputCollector[i] = Arrays.stream(lineParsed).mapToInt(Integer::parseInt).toArray();
        }

        // Processing each test case
        for (int i = 0; i < t; i++) {
            int r = inputCollector[i][0];
            int s = inputCollector[i][1];
            int a = r - 1;
            int b = s - 1;

            String[] out = new String[(s - 1) * (r - 1)];
            int counter = 0;
            int rConv = r * (s - 1) - 1;

            // Generating output lines
            for (int k = a; k > 0; k--) {
                for (int p = b; p > 0; p--) {
                    out[counter++] = r + " " + rConv--;
                }
                r--;
            }

            // Printing the results
            System.out.println("Case #" + (i + 1) + ": " + counter);
            for (String str : out) {
                System.out.println(str);
            }
        }
    }
}