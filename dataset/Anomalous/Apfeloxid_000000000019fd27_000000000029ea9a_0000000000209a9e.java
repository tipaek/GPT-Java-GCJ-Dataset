import java.util.Scanner;

public class Solution {

    private static final int OFF = 0;
    private static final int ON = 1;
    private static final int UNKNOWN = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        int bitCount = scanner.nextInt();

        for (int test = 1; test <= testCount; test++) {
            int[] bits = new int[bitCount + 1];
            initializeBits(bits);

            int indexSame = UNKNOWN;
            int indexDifferent = UNKNOWN;
            int currentIndex = 1;
            boolean checkForOperation = false;

            for (int query = 0; query < 150; query++) {
                if (query == 0) {
                    System.out.println("1");
                    scanner.nextInt();
                    continue;
                }

                if (!checkForOperation) {
                    if (bits[currentIndex] == UNKNOWN || currentIndex > bitCount / 2) {
                        System.out.println(currentIndex);
                        bits[currentIndex] = scanner.nextInt();
                    } else {
                        System.out.println(bitCount - currentIndex + 1);
                        bits[bitCount - currentIndex + 1] = scanner.nextInt();

                        if (bits[currentIndex] == bits[bitCount - currentIndex + 1]) {
                            indexSame = currentIndex;
                        } else {
                            indexDifferent = currentIndex;
                        }
                        currentIndex++;
                    }
                } else {
                    handleOperation(scanner, bits, indexSame, indexDifferent);
                    checkForOperation = false;
                }

                if (query % 10 == 0) {
                    checkForOperation = true;
                }
            }

            printBits(bits);
            if (!scanner.next().equals("Y")) {
                return;
            }
        }
    }

    private static void initializeBits(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = UNKNOWN;
        }
    }

    private static void handleOperation(Scanner scanner, int[] bits, int indexSame, int indexDifferent) {
        if (indexDifferent == UNKNOWN || indexSame == UNKNOWN) {
            System.out.println("1");
            int result = scanner.nextInt();
            if (result != bits[1]) {
                complementBits(bits);
            }
        } else {
            System.out.println(indexSame);
            int result1 = scanner.nextInt();
            System.out.println(indexDifferent);
            int result2 = scanner.nextInt();

            if (result1 != bits[indexSame]) {
                if (result2 == bits[indexDifferent]) {
                    reverseBits(bits);
                }
                complementBits(bits);
            } else {
                if (result2 != bits[indexDifferent]) {
                    reverseBits(bits);
                }
            }
        }
    }

    private static void printBits(int[] bits) {
        for (int i = 1; i < bits.length; i++) {
            System.out.print(bits[i]);
        }
        System.out.println();
    }

    private static void reverseBits(int[] bits) {
        for (int i = 1; i <= bits.length / 2; i++) {
            int temp = bits[i];
            bits[i] = bits[bits.length - i];
            bits[bits.length - i] = temp;
        }
    }

    private static void complementBits(int[] bits) {
        for (int i = 1; i < bits.length; i++) {
            bits[i] = (bits[i] == OFF) ? ON : OFF;
        }
    }
}