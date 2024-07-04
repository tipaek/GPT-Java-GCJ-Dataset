import java.util.Scanner;

class Solution {

    private static final int OFF = 0;
    private static final int ON = 1;
    private static final int UNKNOWN = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        int numberOfBits = scanner.nextInt();

        for (int test = 1; test <= numberOfTests; test++) {
            int[] bits = new int[numberOfBits + 1];
            initializeArray(bits);

            int sameIndex = -1;
            int differentIndex = -1;
            int currentIndex = 1;
            boolean isSearchingForOperation = false;

            for (int query = 0; query < 150; query++) {
                if (query == 0) {
                    System.out.println("1");
                    scanner.nextInt();
                    continue;
                }

                if (!isSearchingForOperation) {
                    if (bits[currentIndex] == UNKNOWN || currentIndex > numberOfBits / 2) {
                        System.out.println(currentIndex);
                        bits[currentIndex] = scanner.nextInt();
                    } else {
                        System.out.println(numberOfBits - currentIndex + 1);
                        bits[currentIndex] = scanner.nextInt();

                        if (bits[currentIndex] == bits[numberOfBits - currentIndex + 1]) {
                            sameIndex = currentIndex;
                        } else {
                            differentIndex = currentIndex;
                        }

                        currentIndex++;
                    }
                } else {
                    handleOperation(scanner, bits, sameIndex, differentIndex);
                    isSearchingForOperation = false;
                    query++;
                }

                if (query % 10 == 0) {
                    isSearchingForOperation = true;
                }
            }
        }
    }

    private static void initializeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = UNKNOWN;
        }
    }

    private static void handleOperation(Scanner scanner, int[] bits, int sameIndex, int differentIndex) {
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
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
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