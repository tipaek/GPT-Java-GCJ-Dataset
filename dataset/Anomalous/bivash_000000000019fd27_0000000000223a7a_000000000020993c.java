import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = input.nextInt();
        String[] answers = new String[t];

        for (int caseIndex = 0; caseIndex < t; caseIndex++) {
            int n = input.nextInt();
            int[] nums = new int[n * n];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = input.nextInt();
            }

            // Calculate the sum of the main diagonal
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i * n + i];
            }

            // Check for duplicate elements in rows
            int countRow = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    int value = nums[i * n + j];
                    if (!rowSet.add(value)) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    countRow++;
                }
            }

            // Check for duplicate elements in columns
            int countCol = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    int value = nums[j * n + i];
                    if (!colSet.add(value)) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    countCol++;
                }
            }

            // Store the result for this case
            answers[caseIndex] = String.format("Case #%d: %d %d %d", caseIndex + 1, sum, countRow, countCol);
        }

        // Print all results
        for (String answer : answers) {
            System.out.println(answer);
        }
    }
}