import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int arraySize = scanner.nextInt();
            int target = scanner.nextInt();
            int[] array = new int[arraySize];
            
            for (int i = 0; i < arraySize; i++) {
                array[i] = scanner.nextInt();
            }
            
            Arrays.sort(array);
            int duplicateCount = 0;
            int result = 0;
            
            for (int i = 0; i < arraySize; i++) {
                for (int j = i + 1; j < arraySize; j++) {
                    if (array[i] == array[j]) {
                        duplicateCount++;
                    }
                }
            }
            
            if (duplicateCount == target) {
                result = 0;
            } else {
                if (array[0] < target) {
                    result = target - array[0];
                } else {
                    result = array[0] - target;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result);
        }
        
        scanner.close();
    }
}