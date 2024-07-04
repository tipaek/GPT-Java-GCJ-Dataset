import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));

        int cases = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < cases; i++) {
            int n = Integer.parseInt(reader.readLine().trim());
            StringBuilder result = new StringBuilder();

            if (n == 1) {
                result.append("1 1");
            } else if (n == 2) {
                result.append("1 1\n2 1\n");
            } else {
                result.append("1 1\n");
                int pow2 = (int) (Math.log(n - 1) / Math.log(2));
                int rem = n - (1 << pow2) - 1;

                for (int j = 0; j < pow2; j++) {
                    if (j % 2 == 0) {
                        for (int f = 0; f <= pow2; f++) {
                            result.append(j + 2).append(" ").append(f + 1).append("\n");
                        }
                    } else {
                        for (int f = pow2; f >= 0; f--) {
                            result.append(j + 2).append(" ").append(f + 1).append("\n");
                        }
                    }
                }

                int row = pow2 + 1;
                if (pow2 % 2 == 0) {
                    int col = pow2 + 1;
                    for (int j = 0; j < rem; j++) {
                        result.append(row + 1).append(" ").append(col + 1).append("\n");
                        row++;
                        col++;
                    }
                } else {
                    int col = 0;
                    for (int j = 0; j < rem; j++) {
                        result.append(row + 1).append(" ").append(col + 1).append("\n");
                        row++;
                        col++;
                    }
                }
            }
            writer.print("Case #" + (i + 1) + ":\n" + result);
        }
        writer.close();
    }
}