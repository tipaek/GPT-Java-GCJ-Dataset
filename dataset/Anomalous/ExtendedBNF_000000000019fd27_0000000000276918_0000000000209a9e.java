import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            processTestCase(scanner, arraySize);
            System.out.flush();
            String response = scanner.next();
            if (response.equals("N")) break;
        }
    }

    public static void processTestCase(Scanner scanner, int arraySize) {
        int[] array = new int[arraySize + 1];
        int samePairIndex = -1;
        int diffPairIndex = -1;
        int diffPairValue = -1;
        int lastIndex = 5;

        // Initialize array
        for (int i = 0; i <= arraySize; i++) {
            array[i] = -1;
        }

        // First 10 digits
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            System.out.flush();
            int value1 = scanner.nextInt();
            System.out.println(arraySize - i + 1);
            System.out.flush();
            int value2 = scanner.nextInt();
            array[i] = value1;
            array[arraySize - i + 1] = value2;

            if (value1 == value2) {
                samePairIndex = i;
            } else {
                diffPairIndex = i;
                diffPairValue = value1;
            }
        }

        while (!isArrayComplete(array)) {
            updateArray(array, determineChange(array, samePairIndex, diffPairIndex, diffPairValue, scanner));

            for (int i = lastIndex + 1; !isArrayComplete(array) && i <= lastIndex + 4; i++) {
                System.out.println(i);
                System.out.flush();
                int x = scanner.nextInt();
                System.out.println(arraySize - i + 1);
                System.out.flush();
                int y = scanner.nextInt();
                if (samePairIndex == -1 && x == y) samePairIndex = i;
                if (diffPairIndex == -1 && x != y) diffPairIndex = i;
                array[i] = x;
                array[arraySize - i + 1] = y;
            }
            lastIndex += 4;
            diffPairValue = array[diffPairIndex];
        }

        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.flush();
        System.out.println();
    }

    public static int determineChange(int[] array, int samePairIndex, int diffPairIndex, int diffPairValue, Scanner scanner) {
        if (samePairIndex != -1 && diffPairIndex != -1) {
            System.out.println(samePairIndex);
            System.out.flush();
            int newSame = scanner.nextInt();
            System.out.println(diffPairIndex);
            System.out.flush();
            int newDiff = scanner.nextInt();

            if (newSame == array[samePairIndex]) {
                return (newDiff == diffPairValue) ? 4 : 2;
            } else {
                return (newDiff == diffPairValue) ? 3 : 1;
            }
        } else if (samePairIndex == -1) {
            System.out.println(diffPairIndex);
            System.out.flush();
            int newDiff = scanner.nextInt();
            return (newDiff == array[diffPairIndex]) ? 4 : 2;
        } else {
            System.out.println(samePairIndex);
            System.out.flush();
            int newSame = scanner.nextInt();
            return (newSame == array[samePairIndex]) ? 4 : 2;
        }
    }

    public static void updateArray(int[] array, int action) {
        if (action == 4) return;

        if (action == 1) {
            for (int i = 0; i < array.length / 2; i++) {
                int temp = array[i + 1];
                array[i + 1] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
            }
        } else if (action == 2) {
            for (int i = 1; i < array.length; i++) {
                array[i] = (array[i] == 1) ? 0 : 1;
            }
        } else if (action == 3) {
            updateArray(array, 1);
            updateArray(array, 2);
        }
    }

    public static boolean isArrayComplete(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == -1) return false;
        }
        return true;
    }
}