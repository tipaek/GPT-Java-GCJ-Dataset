import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            processTestCase(scanner, bitLength);
            System.out.flush();
            if (scanner.next().equals("N")) break;
        }
    }
    
    public static void processTestCase(Scanner scanner, int bitLength) {
        int[] bits = new int[bitLength + 1];
        int samePairIndex = -1;
        int diffPairIndex = -1;
        int diffValue = -1;
        int queryCount = 5;
        
        // Initialize bits array
        for (int i = 0; i <= bitLength; i++) {
            bits[i] = -1;
        }
        
        // First 10 bits
        for (int i = 1; i <= 5; i++) {
            bits[i] = queryBit(scanner, i);
            bits[bitLength - i + 1] = queryBit(scanner, bitLength - i + 1);
            
            if (bits[i] == bits[bitLength - i + 1]) {
                samePairIndex = i;
            } else {
                diffPairIndex = i;
                diffValue = bits[i];
            }
        }
        
        while (!isComplete(bits)) {
            applyTransformations(bits, determineTransformation(bits, samePairIndex, diffPairIndex, diffValue, scanner));
            
            for (int i = queryCount + 1; !isComplete(bits) && i < queryCount + 5; i++) {
                bits[i] = queryBit(scanner, i);
                bits[bitLength - i + 1] = queryBit(scanner, bitLength - i + 1);
                
                if (samePairIndex == -1 && bits[i] == bits[bitLength - i + 1]) {
                    samePairIndex = i;
                }
                if (diffPairIndex == -1 && bits[i] != bits[bitLength - i + 1]) {
                    diffPairIndex = i;
                }
            }
            queryCount += 4;
            diffValue = bits[diffPairIndex];
        }
        
        printBits(bits);
    }
    
    public static int queryBit(Scanner scanner, int position) {
        System.out.println(position);
        System.out.flush();
        return scanner.nextInt();
    }
    
    public static int determineTransformation(int[] bits, int samePairIndex, int diffPairIndex, int diffValue, Scanner scanner) {
        if (samePairIndex != -1 && diffPairIndex != -1) {
            int newSameValue = queryBit(scanner, samePairIndex);
            int newDiffValue = queryBit(scanner, diffPairIndex);
            
            if (newSameValue == bits[samePairIndex]) {
                return (newDiffValue == bits[diffPairIndex]) ? 4 : 1;
            } else {
                return (newDiffValue == diffValue) ? 3 : 2;
            }
        } else if (samePairIndex == -1) {
            return (queryBit(scanner, diffPairIndex) == bits[diffPairIndex]) ? 4 : 2;
        } else {
            return (queryBit(scanner, samePairIndex) == bits[samePairIndex]) ? 4 : 2;
        }
    }
    
    public static void applyTransformations(int[] bits, int action) {
        if (action == 4) return;
        
        if (action == 1) {
            reverseArray(bits);
        } else if (action == 2) {
            invertArray(bits);
        } else if (action == 3) {
            reverseArray(bits);
            invertArray(bits);
        }
    }
    
    public static void reverseArray(int[] bits) {
        int length = bits.length;
        for (int i = 1; i <= length / 2; i++) {
            int temp = bits[i];
            bits[i] = bits[length - i];
            bits[length - i] = temp;
        }
    }
    
    public static void invertArray(int[] bits) {
        for (int i = 1; i < bits.length; i++) {
            bits[i] = 1 - bits[i];
        }
    }
    
    public static boolean isComplete(int[] bits) {
        for (int i = 1; i < bits.length; i++) {
            if (bits[i] == -1) return false;
        }
        return true;
    }
    
    public static void printBits(int[] bits) {
        for (int i = 1; i < bits.length; i++) {
            System.out.print(bits[i]);
        }
        System.out.flush();
        System.out.println();
    }
}