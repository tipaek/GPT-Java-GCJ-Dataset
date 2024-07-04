import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();

        outerLoop:
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[] arr1 = new int[arraySize];
            int[] arr2 = new int[arraySize];
            int[] arr3 = new int[arraySize];
            int[] arr4 = new int[arraySize];
            Arrays.fill(arr1, -1);
            Arrays.fill(arr2, -1);
            Arrays.fill(arr3, -1);
            Arrays.fill(arr4, -1);

            innerLoop:
            for (int chance = 1; chance <= 150; chance += 5) {
                int[] temp = new int[5];

                // Collect 5 inputs
                for (int i = 0; i < 5; i++) {
                    System.out.println(i + 1);
                    temp[i] = scanner.nextInt();
                }

                // Check and fill arrays
                for (int arrayIndex = 1; arrayIndex <= 4; arrayIndex++) {
                    int[] currentArray;
                    switch (arrayIndex) {
                        case 1: currentArray = arr1; break;
                        case 2: currentArray = arr2; break;
                        case 3: currentArray = arr3; break;
                        case 4: currentArray = arr4; break;
                        default: throw new IllegalStateException("Unexpected value: " + arrayIndex);
                    }

                    int filledIndex = findFilledIndex(currentArray);
                    if (filledIndex == 0) {
                        fillArray(currentArray, temp, scanner, chance);
                        if (isArrayFilled(currentArray, arraySize)) {
                            printArrayAndCheck(scanner, currentArray);
                            break innerLoop;
                        }
                        break;
                    } else if (filledIndex == arraySize) {
                        printArrayAndCheck(scanner, currentArray);
                        break innerLoop;
                    } else {
                        if (arraysMatch(currentArray, temp)) {
                            fillArrayFromIndex(currentArray, scanner, filledIndex, chance);
                        }
                    }
                }
            }
        }
    }

    private static void fillArray(int[] array, int[] temp, Scanner scanner, int chance) {
        System.arraycopy(temp, 0, array, 0, 5);
        for (int i = 5; i < 10; i++) {
            System.out.println(i + 1);
            array[i] = scanner.nextInt();
        }
        chance += 5;
    }

    private static void fillArrayFromIndex(int[] array, Scanner scanner, int startIndex, int chance) {
        for (int i = startIndex; i < startIndex + 5; i++) {
            System.out.println(i + 1);
            array[i] = scanner.nextInt();
        }
        chance += 5;
    }

    private static boolean arraysMatch(int[] array, int[] temp) {
        for (int i = 0; i < 5; i++) {
            if (array[i] != temp[i]) return false;
        }
        return true;
    }

    private static int findFilledIndex(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) return i;
        }
        return array.length - 1;
    }

    private static boolean isArrayFilled(int[] array, int size) {
        return findFilledIndex(array) == size;
    }

    private static void printArrayAndCheck(Scanner scanner, int[] array) {
        for (int value : array) {
            System.out.print(value);
        }
        System.out.println();
        if (scanner.next().equals("N")) {
            System.exit(0);
        }
    }
}