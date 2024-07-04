import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int arraySize = scanner.nextInt();
            int desiredCount = scanner.nextInt();
            int[] array = new int[arraySize];
            
            for (int i = 0; i < arraySize; i++) {
                array[i] = scanner.nextInt();
            }
            
            Arrays.sort(array);
            int midValue = array[arraySize / 2];
            int duplicateCount = 0;
            int result = 0;
            
            for (int i = 0; i < arraySize; i++) {
                for (int j = i + 1; j < arraySize; j++) {
                    if (array[i] == array[j]) {
                        duplicateCount++;
                    }
                }
            }
            
            if (duplicateCount == desiredCount) {
                result = 0;
            } else if (arraySize == 1) {
                result = Math.abs(desiredCount - array[0]);
            } else {
                for (int i = 0; i < arraySize && desiredCount > 0; i++) {
                    if (array[i] > midValue) {
                        array[i] = midValue;
                        desiredCount--;
                        result++;
                    } else if (array[i] < midValue) {
                        array[i] = midValue;
                        desiredCount--;
                        result++;
                    }
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
}