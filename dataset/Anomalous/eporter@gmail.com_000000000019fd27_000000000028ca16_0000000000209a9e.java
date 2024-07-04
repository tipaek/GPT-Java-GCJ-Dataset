import java.io.IOException;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner;
    private static int bitLength;
    private boolean[] bitsArray;
    private int knownBits = 0;
    private boolean isValid = false;

    public static void main(String[] args) throws IOException {
        Scanner inputScanner = new Scanner(System.in);
        run(inputScanner);
        inputScanner.close();
    }

    public static void run(Scanner inputScanner) {
        int testCases = inputScanner.nextInt();
        bitLength = inputScanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            new Solution(inputScanner).executeTestCase(testCase);
        }
    }

    public Solution(Scanner scanner) {
        this.scanner = scanner;
    }

    private void executeTestCase(int testCaseNumber) {
        bitsArray = new boolean[bitLength];
        readBits(10);

        while (knownBits < bitLength || !isValid) {
            if (!isValid) {
                validateBits();
            } else {
                int bitsToRead = Math.min(8, bitLength - knownBits);
                readBits(bitsToRead);
                if (bitsToRead == 8) {
                    isValid = false;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (boolean bit : bitsArray) {
            result.append(bit ? "1" : "0");
        }
        println(result.toString());
        String judgeResponse = scanner.next();
        if (!judgeResponse.equals("Y")) {
            System.exit(-1);
        }
    }

    private void validateBits() {
        int halfLength = knownBits / 2;
        boolean complementChecked = false, reverseChecked = false;

        for (int i = 0; i < halfLength; i++) {
            boolean lowBit = bitsArray[i];
            boolean highBit = bitsArray[bitLength - 1 - i];
            if (lowBit == highBit) {
                boolean result = checkBit(i);
                if (result != lowBit) {
                    for (int j = 0; j < bitLength; j++) {
                        bitsArray[j] = !bitsArray[j];
                    }
                }
                complementChecked = true;
                break;
            }
        }
        if (!complementChecked) {
            checkBit(1);
        }

        for (int i = 0; i < halfLength; i++) {
            boolean lowBit = bitsArray[i];
            boolean highBit = bitsArray[bitLength - 1 - i];
            if (lowBit != highBit) {
                boolean result = checkBit(i);
                if (result != lowBit) {
                    for (int j = 0; j < bitLength / 2; j++) {
                        boolean temp = bitsArray[j];
                        bitsArray[j] = bitsArray[bitLength - 1 - j];
                        bitsArray[bitLength - 1 - j] = temp;
                    }
                }
                reverseChecked = true;
                break;
            }
        }
        if (!reverseChecked) {
            checkBit(1);
        }
        isValid = true;
    }

    private boolean checkBit(int index) {
        println(String.valueOf(index + 1));
        String bit = scanner.next();
        return bit.equals("1");
    }

    private void readBits(int bitsToRead) {
        int halfBits = bitsToRead / 2;
        int startIndex = knownBits / 2;
        for (int i = startIndex; i < startIndex + halfBits; i++) {
            assignBit(i);
        }
        startIndex = bitLength - 1 - knownBits / 2;
        for (int i = startIndex - halfBits + 1; i <= startIndex; i++) {
            assignBit(i);
        }
        knownBits += bitsToRead;
    }

    private void assignBit(int index) {
        println(String.valueOf(index + 1));
        String bit = scanner.next();
        bitsArray[index] = bit.equals("1");
    }

    private static void println(String message) {
        System.out.println(message);
        System.out.flush();
    }
}