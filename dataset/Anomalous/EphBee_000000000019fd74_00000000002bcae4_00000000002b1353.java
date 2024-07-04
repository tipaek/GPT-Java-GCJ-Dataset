import java.util.*;
import java.io.*;

public class Solution {

    // Function to calculate binomial coefficient
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

    // Function to build Pascal's Triangle up to row n
    public static ArrayList<ArrayList<Integer>> buildTriangle(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
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
        ArrayList<ArrayList<Integer>> triangle = buildTriangle(100);

        for (int e = 0; e < count; e++) {
            System.out.println("Case #" + caseID + ": ");
            int requiredNbr = in.nextInt();
            int i = 0;
            int j = 0;
            int total = 0;
            while (requiredNbr > 0) {
                int value = triangle.get(i).get(j);
                requiredNbr -= value;
                total += value;
                System.out.println((i + 1) + " " + (j + 1));
                if (requiredNbr == 0) break;
                j++;
                if (j > i) {
                    i++;
                    j = 0;
                }
            }
            caseID++;
        }
        in.close();
    }
}