import java.util.*;
import java.io.*;

public class Solution {

    static int binomialCoefficient(int n, int k) {
        int result = 1;
        if (k > n - k) {
            k = n - k;
        }
        for (int i = 0; i < k; ++i) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    public static List<List<Integer>> buildTriangle(int n) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(binomialCoefficient(i, j));
            }
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int casesCount = scanner.nextInt();
        int caseID = 1;
        List<List<Integer>> triangle = buildTriangle(100);

        for (int e = 0; e < casesCount; e++) {
            System.out.println("Case #" + caseID + ":");
            int requiredNumber = scanner.nextInt();
            int remaining = requiredNumber;
            int row = 0;
            float col = 0;
            int total = 0;

            while (remaining > 0) {
                remaining -= triangle.get(row).get((int) col);
                total += triangle.get(row).get((int) col);
                System.out.println((row + 1) + " " + ((int) col + 1));

                if (remaining == 0) break;

                col += 0.5;
                row += 1;
                int currentValue = triangle.get(row).get((int) col);

                while (currentValue > remaining) {
                    col--;
                    currentValue = triangle.get(row).get((int) col);
                }
            }

            caseID += 1;
        }
    }
}