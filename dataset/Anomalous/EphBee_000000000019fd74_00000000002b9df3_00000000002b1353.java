import java.util.*;
import java.io.*;

public class Solution {
    
    static int binomialCoefficient(int n, int k) { 
        int result = 1; 
        if (k > n - k) 
            k = n - k; 
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
        int testCaseCount = scanner.nextInt();
        int caseID = 1;
        List<List<Integer>> triangle = buildTriangle(20);

        for (int e = 0; e < testCaseCount; e++) {
            System.out.println("Case #" + caseID + ": ");
            int requiredNumber = scanner.nextInt();
            
            int remainingNumber = requiredNumber;
            int i = 0;
            float j = 0;
            while (remainingNumber > 0) {
                remainingNumber -= triangle.get(i).get((int) j);
                System.out.println((i + 1) + " " + ((int) j + 1));
                if (remainingNumber == 0) break;
                j += 0.5;
                i += 1;
                int tempValue = triangle.get(i).get((int) j);
                while (tempValue > remainingNumber) {
                    j--;
                    tempValue = triangle.get(i).get((int) j);
                }
            }
            caseID += 1;
        }
    }
}