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
            for (int i = 0; i <= bitCount; i++) {
                bits[i] = UNKNOWN;
            }

            int sameIndex = -1;
            int diffIndex = -1;
            int currentIdx = 1;
            boolean searchForOperation = false;

            for (int query = 0; query < 150; query++) {
                displayArray(bits);
                if (query == 0) {
                    System.out.println("1");
                    scanner.nextInt();
                    continue;
                }

                if (!searchForOperation) {
                    if (bits[currentIdx] == UNKNOWN || currentIdx > bitCount / 2) {
                        System.out.println(currentIdx);
                        bits[currentIdx] = scanner.nextInt();
                    } else {
                        System.out.println(bitCount - currentIdx + 1);
                        bits[currentIdx] = scanner.nextInt();

                        if (bits[currentIdx] == bits[bitCount - currentIdx + 1]) {
                            sameIndex = currentIdx;
                        } else {
                            diffIndex = currentIdx;
                        }

                        currentIdx++;
                    }
                } else {
                    if (diffIndex == UNKNOWN || sameIndex == UNKNOWN) {
                        System.out.println("1");
                        int result = scanner.nextInt();

                        if (result != bits[1]) {
                            complementArray(bits);
                        }
                        searchForOperation = false;
                    } else {
                        System.out.println(sameIndex);
                        int result1 = scanner.nextInt();
                        System.out.println(diffIndex);
                        int result2 = scanner.nextInt();

                        if (result1 != bits[sameIndex]) {
                            if (result2 == bits[diffIndex]) {
                                reverseArray(bits);
                            }
                            complementArray(bits);
                        } else {
                            if (result2 != bits[diffIndex]) {
                                reverseArray(bits);
                            }
                        }
                        query++;
                    }
                }

                if (query % 10 == 0) {
                    searchForOperation = true;
                }
            }

            displayArray(bits);
            boolean isCorrect = scanner.next().equals("J");

            if (!isCorrect) {
                return;
            }
        }
    }

    private static void displayArray(int[] array) {
        for (int value : array) {
            System.out.print(value);
        }
        System.out.println();
    }

    private static void reverseArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            array[i] = array[array.length - i];
            array[array.length - i] = temp;
        }
    }

    private static void complementArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == OFF) {
                array[i] = ON;
            } else if (array[i] == ON) {
                array[i] = OFF;
            }
        }
    }
}