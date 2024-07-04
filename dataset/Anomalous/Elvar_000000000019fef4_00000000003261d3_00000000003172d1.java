import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int arraySize = scanner.nextInt();
            int divisor = scanner.nextInt();
            long[] array = new long[arraySize];
            
            for (int i = 0; i < arraySize; i++) {
                array[i] = scanner.nextLong();
            }
            
            int result = findResult(array, arraySize, divisor);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
    
    private static int findResult(long[] array, int arraySize, int divisor) {
        if (divisor == 2) {
            return handleDivisorTwo(array, arraySize);
        } else if (divisor == 3) {
            return handleDivisorThree(array, arraySize);
        }
        return -1;
    }
    
    private static int handleDivisorTwo(long[] array, int arraySize) {
        for (int i = 0; i < arraySize; i++) {
            for (int j = i + 1; j < arraySize; j++) {
                if (array[i] == array[j]) {
                    return 0;
                }
            }
        }
        return 1;
    }
    
    private static int handleDivisorThree(long[] array, int arraySize) {
        for (int i = 0; i < arraySize; i++) {
            for (int j = i + 1; j < arraySize; j++) {
                for (int k = j + 1; k < arraySize; k++) {
                    if (array[i] == array[j] && array[j] == array[k]) {
                        return 0;
                    }
                }
            }
        }
        
        for (int i = 0; i < arraySize; i++) {
            for (int j = i + 1; j < arraySize; j++) {
                if (array[i] == 2 * array[j] || array[j] == 2 * array[i]) {
                    return 1;
                }
                if (array[i] == array[j]) {
                    for (int k = 0; k < arraySize; k++) {
                        if (array[k] > array[i]) {
                            return 1;
                        }
                    }
                }
            }
        }
        
        return 2;
    }
}