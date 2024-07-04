import java.util.*;
import java.io.*;

public class Solution {
    
    private static int binomialCoefficient(int n, int k) {
        int result = 1;
        if (k > n - k) {
            k = n - k;
        }
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> buildPascalTriangle(int n) {
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
        int testCaseCount = scanner.nextInt();
        int caseID = 1;
        ArrayList<ArrayList<Integer>> pascalTriangle = buildPascalTriangle(20);

        for (int t = 0; t < testCaseCount; t++) {
            System.out.println("Case #" + caseID + ": ");
            int requiredSum = scanner.nextInt();
            int remainingSum = requiredSum;
            int i = 0, j = 0;

            while (remainingSum > 0) {
                int value = pascalTriangle.get(i).get(j);
                remainingSum -= value;
                System.out.println((i + 1) + " " + (j + 1));

                if (remainingSum == 0) break;

                int nextI = i, nextJ = j;
                if (i > 0 && j + 1 < pascalTriangle.get(i + 1).size() && pascalTriangle.get(i + 1).get(j + 1) <= remainingSum) {
                    nextI = i + 1;
                    nextJ = j + 1;
                } else if (i + 1 < pascalTriangle.size() && pascalTriangle.get(i + 1).get(j) <= remainingSum) {
                    nextI = i + 1;
                } else if (j > 0 && pascalTriangle.get(i).get(j - 1) <= remainingSum) {
                    nextJ = j - 1;
                } else if (j + 1 < pascalTriangle.get(i).size() && pascalTriangle.get(i).get(j + 1) <= remainingSum) {
                    nextJ = j + 1;
                } else if (i > 0 && pascalTriangle.get(i - 1).get(j) <= remainingSum) {
                    nextI = i - 1;
                } else if (i > 0 && j > 0 && pascalTriangle.get(i - 1).get(j - 1) <= remainingSum) {
                    nextI = i - 1;
                    nextJ = j - 1;
                }

                i = nextI;
                j = nextJ;
            }

            caseID++;
        }

        scanner.close();
    }
}