import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            int length = input.length();
            int[] numbers = new int[length];
            int[] originalNumbers = new int[length];
            String[] openBrackets = new String[length];
            String[] closeBrackets = new String[length];
            
            for (int j = 0; j < length; j++) {
                numbers[j] = Character.getNumericValue(input.charAt(j));
                originalNumbers[j] = numbers[j];
                openBrackets[j] = "";
                closeBrackets[j] = "";
            }
            
            processBrackets(numbers, openBrackets, closeBrackets, 0, length - 1);
            
            StringBuilder result = new StringBuilder();
            for (int k = 0; k < length; k++) {
                result.append(openBrackets[k]);
                result.append(originalNumbers[k]);
                result.append(closeBrackets[k]);
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
    
    private static void processBrackets(int[] numbers, String[] openBrackets, String[] closeBrackets, int left, int right) {
        if (left < 0 || right < 0 || right >= numbers.length || left >= numbers.length) {
            return;
        }
        
        if (areAllZeroes(numbers, left, right)) {
            return;
        }
        
        int minIndex = findLowestIndex(numbers, left, right);
        for (int i = 0; i < numbers[minIndex]; i++) {
            openBrackets[left] += "(";
            closeBrackets[right] += ")";
        }
        
        int decrementValue = numbers[minIndex];
        boolean needsRecursion = false;
        for (int i = left; i <= right; i++) {
            numbers[i] -= decrementValue;
            if (numbers[i] != 0) {
                needsRecursion = true;
            }
        }
        
        if (minIndex == left && needsRecursion) {
            processBrackets(numbers, openBrackets, closeBrackets, left + 1, right);
        } else if (minIndex == right && needsRecursion) {
            processBrackets(numbers, openBrackets, closeBrackets, left, right - 1);
        } else if (needsRecursion) {
            processBrackets(numbers, openBrackets, closeBrackets, left, minIndex - 1);
            processBrackets(numbers, openBrackets, closeBrackets, minIndex + 1, right);
        }
    }
    
    private static boolean areAllZeroes(int[] numbers, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (numbers[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    private static int findLowestIndex(int[] numbers, int left, int right) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = left; i <= right; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}