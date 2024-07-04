import java.util.*;
import java.io.*;

public class Solution {
    // Function to calculate binomial coefficient
    static int binomialCoefficient(int n, int k) {
        int res = 1;
        if (k > n - k) {
            k = n - k;
        }
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    // Function to build Pascal's Triangle up to row n
    public static ArrayList<ArrayList<Integer>> buildTriangle(int n) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
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
        ArrayList<ArrayList<Integer>> triangle = buildTriangle(20);

        for (int e = 0; e < testCases; e++) {
            System.out.println("Case #" + caseID + ": ");
            int requiredNumber = scanner.nextInt();
            int remaining = requiredNumber;
            int row = 0;
            float column = 0;

            while (remaining > 0) {
                remaining -= triangle.get(row).get((int) column);
                System.out.println((row + 1) + " " + ((int) column + 1));
                if (remaining == 0) break;
                
                column += 0.5;
                row += 1;
                int tempValue = triangle.get(row).get((int) column);
                
                while (tempValue > remaining) {
                    column--;
                    tempValue = triangle.get(row).get((int) column);
                }
            }
            caseID++;
        }
    }
}