import java.util.Scanner;

public class Solution {

    private static final int OFF = 0;
    private static final int ON = 1;
    private static final int UNKNOWN = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        int numberOfBits = scanner.nextInt();

        for (int test = 1; test <= numberOfTests; test++) {
            int[] bits = new int[numberOfBits + 1];
            initializeBits(bits);

            int sameIndex = -1;
            int differentIndex = -1;
            int currentIndex = 1;
            boolean needSpecialOperation = false;

            for (int query = 0; query < 150; query++) {
                System.out.println("query: " + query);
                printArray(bits);

                if (query == 0) {
                    System.out.println("1");
                    scanner.nextInt();
                    continue;
                }

                if (!needSpecialOperation) {
                    if (bits[currentIndex] == UNKNOWN || currentIndex > numberOfBits / 2) {
                        System.out.println(currentIndex);
                        bits[currentIndex] = scanner.nextInt();
                    } else {
                        System.out.println(numberOfBits - currentIndex + 1);
                        bits[numberOfBits - currentIndex + 1] = scanner.nextInt();

                        if (bits[currentIndex] == bits[numberOfBits - currentIndex + 1]) {
                            sameIndex = currentIndex;
                        } else {
                            differentIndex = currentIndex;
                        }

                        currentIndex++;
                    }
                } else {
                    handleSpecialOperation(scanner, bits, sameIndex, differentIndex);
                    needSpecialOperation = false;
                }

                if (query % 10 == 0) {
                    needSpecialOperation = true;
                }
            }

            printArray(bits);
            if (!scanner.next().equals("J")) {
                return;
            }
        }
    }

    private static void initializeBits(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = UNKNOWN;
        }
    }

    private static void printArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    private static void handleSpecialOperation(Scanner scanner, int[] bits, int sameIndex, int differentIndex) {
        if (differentIndex == UNKNOWN || sameIndex == UNKNOWN) {
            System.out.println("1");
            int result = scanner.nextInt();
            if (result != bits[1]) {
                complementArray(bits);
            }
        } else {
            System.out.println(sameIndex);
            int result1 = scanner.nextInt();
            System.out.println(differentIndex);
            int result2 = scanner.nextInt();

            if (result1 != bits[sameIndex]) {
                if (result2 == bits[differentIndex]) {
                    reverseArray(bits);
                }
                complementArray(bits);
            } else {
                if (result2 != bits[differentIndex]) {
                    reverseArray(bits);
                }
            }
        }
    }

    private static void reverseArray(int[] array) {
        int length = array.length;
        for (int i = 1; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - i];
            array[length - i] = temp;
        }
    }

    private static void complementArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] = (array[i] == OFF) ? ON : OFF;
        }
    }
}