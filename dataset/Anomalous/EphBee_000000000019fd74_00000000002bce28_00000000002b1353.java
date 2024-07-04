import java.util.*;
import java.io.*;

public class Solution {

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
        List<List<Integer>> triangle = buildTriangle(100);

        for (int e = 0; e < count; e++) {
            System.out.println("Case #" + caseID + ":");
            int requiredNbr = in.nextInt();
            int required = requiredNbr;
            int i = 0;
            float j = 0;
            int total = 0;
            while (requiredNbr > 0) {
                requiredNbr -= triangle.get(i).get((int) j);
                total += triangle.get(i).get((int) j);
                System.out.println((i + 1) + " " + ((int) (j + 1)));
                if (requiredNbr == 0) break;
                j += 0.5;
                i += 1;
                int tempValue = triangle.get(i).get((int) j);
                while (tempValue > requiredNbr) {
                    j--;
                    tempValue = triangle.get(i).get((int) j);
                }
            }
            caseID += 1;
        }
    }
}