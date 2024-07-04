import java.util.*;
import java.io.*;

public class HelloWorld {

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
        int testCases = scanner.nextInt();
        int caseID = 1;
        List<List<Integer>> pascalTriangle = buildTriangle(20);

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + caseID + ":");
            int requiredNumber = scanner.nextInt();
            int remaining = requiredNumber;
            int i = 0;
            float j = 0;

            while (remaining > 0) {
                remaining -= pascalTriangle.get(i).get((int) j);
                System.out.println((i + 1) + " " + ((int) j + 1));
                if (remaining == 0) break;
                j += 0.5;
                i += 1;
                int currentValue = pascalTriangle.get(i).get((int) j);
                while (currentValue > remaining) {
                    j--;
                    currentValue = pascalTriangle.get(i).get((int) j);
                }
            }
            caseID++;
        }
        scanner.close();
    }
}