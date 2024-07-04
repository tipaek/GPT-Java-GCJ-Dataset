import java.util.Scanner;

public class Solution {

    private static final int OFF = 0;
    private static final int ON = 1;
    private static final int UNKNOWN = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[] bits = new int[bitCount + 1];
            for (int i = 0; i <= bitCount; i++) {
                bits[i] = UNKNOWN;
            }

            int sameIndex = -1;
            int differentIndex = -1;
            int currentIndex = 1;
            boolean checkOperation = false;

            for (int query = 0; query < 150; query++) {
                if (query == 0) {
                    System.out.println("1");
                    scanner.nextInt();
                    continue;
                }

                if (!checkOperation) {
                    if (bits[currentIndex] == UNKNOWN || currentIndex > bitCount / 2) {
                        System.out.println(currentIndex);
                        bits[currentIndex] = scanner.nextInt();
                    } else {
                        System.out.println(bitCount - currentIndex + 1);
                        bits[bitCount - currentIndex + 1] = scanner.nextInt();

                        if (bits[currentIndex] == bits[bitCount - currentIndex + 1]) {
                            sameIndex = currentIndex;
                        } else {
                            differentIndex = currentIndex;
                        }

                        currentIndex++;
                    }
                } else {
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
                        query++;
                    }
                    checkOperation = false;
                }

                if (query % 10 == 0) {
                    checkOperation = true;
                }
            }

            printArray(bits);
            boolean isCorrect = scanner.next().equals("J");
            if (!isCorrect) {
                return;
            }
        }
    }

    private static void printArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    private static void reverseArray(int[] array) {
        for (int i = 1; i <= array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i];
            array[array.length - i] = temp;
        }
    }

    private static void complementArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] = (array[i] == OFF) ? ON : OFF;
        }
    }
}