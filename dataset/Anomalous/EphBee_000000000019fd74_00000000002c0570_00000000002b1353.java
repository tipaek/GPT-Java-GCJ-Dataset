import java.util.*;
import java.io.*;

public class Solution {

    // Method to calculate binomial coefficient
    static int binomialCoeff(int n, int k) {
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

    // Method to build Pascal's triangle up to n rows
    public static List<List<Integer>> buildTriangle(int n) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(binomialCoeff(i, j));
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int count = in.nextInt();
        int caseID = 1;
        List<List<Integer>> triangle = buildTriangle(20);

        // Print the triangle
        for (List<Integer> row : triangle) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Process each case
        for (int e = 0; e < count; e++) {
            System.out.println("Case #" + caseID + ": ");
            int requiredNbr = in.nextInt();
            for (int i = 0; i < requiredNbr; i++) {
                System.out.println((i + 1) + " " + 1);
            }
            caseID++;
        }
    }
}