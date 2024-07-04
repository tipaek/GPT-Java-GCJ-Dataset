import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        
        if (bitLength % 2 != 0 || bitLength < 10) {
            throw new IllegalArgumentException("Invalid bit length.");
        }
        
        for (int t = 0; t < testCases; t++) {
            boolean[] bits = new boolean[bitLength];
            int knownBits = 0;
            int halfBitLength = bitLength / 2;
            
            for (int guessCount = 0; ; ) {
                if (knownBits == halfBitLength) {
                    for (boolean bit : bits) {
                        System.out.print(bit ? '1' : '0');
                    }
                    System.out.println();
                    System.out.flush();
                    scanner.next();
                    break;
                }
                
                boolean check = guessCount > 0 && guessCount % 10 == 0;
                if (check) {
                    int sameIndex = findSameIndex(bits, knownBits);
                    int diffIndex = findDiffIndex(bits, knownBits);
                    
                    if (sameIndex >= 0) {
                        makeGuess(sameIndex);
                        if (bits[sameIndex] != readGuess(scanner)) {
                            toggleBits(bits);
                        }
                    } else {
                        makeGuess(0);
                        readGuess(scanner);
                    }
                    guessCount++;
                    
                    if (diffIndex >= 0) {
                        makeGuess(diffIndex);
                        if (bits[diffIndex] != readGuess(scanner)) {
                            reverseBits(bits);
                        }
                    } else {
                        makeGuess(0);
                        readGuess(scanner);
                    }
                    guessCount++;
                } else {
                    makeGuess(knownBits);
                    bits[knownBits] = readGuess(scanner);
                    guessCount++;
                    
                    makeGuess(bitLength - 1 - knownBits);
                    bits[bitLength - 1 - knownBits] = readGuess(scanner);
                    guessCount++;
                    
                    knownBits++;
                }
                
                printDebugInfo(bits, knownBits);
            }
        }
    }

    private static int findSameIndex(boolean[] bits, int knownBits) {
        for (int i = 0; i < knownBits; i++) {
            if (bits[i] == bits[bits.length - 1 - i]) {
                return i;
            }
        }
        return -1;
    }

    private static int findDiffIndex(boolean[] bits, int knownBits) {
        for (int i = 0; i < knownBits; i++) {
            if (bits[i] != bits[bits.length - 1 - i]) {
                return i;
            }
        }
        return -1;
    }

    private static void reverseBits(boolean[] bits) {
        for (int left = 0, right = bits.length - 1; left < right; left++, right--) {
            boolean temp = bits[left];
            bits[left] = bits[right];
            bits[right] = temp;
        }
    }

    private static void toggleBits(boolean[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = !bits[i];
        }
    }

    private static void makeGuess(int index) {
        System.out.println(index + 1);
        System.out.flush();
    }

    private static boolean readGuess(Scanner scanner) {
        return "1".equals(scanner.next());
    }

    private static void printDebugInfo(boolean[] bits, int knownBits) {
        StringBuilder debugInfo = new StringBuilder();
        for (int i = 0; i < bits.length; i++) {
            if (i < knownBits || i >= bits.length - knownBits) {
                debugInfo.append(bits[i] ? '1' : '0');
            } else {
                debugInfo.append('?');
            }
        }
        System.err.println(debugInfo);
    }
}