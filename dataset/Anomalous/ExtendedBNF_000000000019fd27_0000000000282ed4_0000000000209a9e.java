import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int B = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            processTestCase(scanner, B);
            System.out.flush();
            String response = scanner.next();
            if (response.equals("N")) break;
        }
    }

    private static void processTestCase(Scanner scanner, int B) {
        int[] array = new int[B + 1];
        int samePairIndex = -1;
        int diffPairIndex = -1;
        int lastProcessed = 5;

        // Initialize the array
        for (int i = 0; i <= B; i++) {
            array[i] = -1;
        }

        // Process the first 10 digits
        for (int i = 1; i <= 5; i++) {
            array[i] = query(scanner, i);
            array[B - i + 1] = query(scanner, B - i + 1);

            if (array[i] == array[B - i + 1]) {
                samePairIndex = i;
            } else {
                diffPairIndex = i;
            }
        }

        while (!isFinished(array)) {
            int changeType = determineChangeType(array, samePairIndex, diffPairIndex, scanner);
            updateArray(array, changeType);

            for (int i = lastProcessed + 1; !isFinished(array) && i < lastProcessed + 5; i++) {
                array[i] = query(scanner, i);
                array[B - i + 1] = query(scanner, B - i + 1);

                if (samePairIndex == -1 && array[i] == array[B - i + 1]) {
                    samePairIndex = i;
                }
                if (diffPairIndex == -1 && array[i] != array[B - i + 1]) {
                    diffPairIndex = i;
                }
            }
            lastProcessed += 4;
        }

        for (int i = 1; i <= B; i++) {
            System.out.print(array[i]);
        }
        System.out.flush();
        System.out.println();
    }

    private static int query(Scanner scanner, int index) {
        System.out.println(index);
        System.out.flush();
        return scanner.nextInt();
    }

    private static int determineChangeType(int[] array, int samePairIndex, int diffPairIndex, Scanner scanner) {
        if (samePairIndex != -1 && diffPairIndex != -1) {
            int newSamePairValue = query(scanner, samePairIndex);
            int newDiffPairValue = query(scanner, diffPairIndex);

            if (newSamePairValue == array[samePairIndex]) {
                return (newDiffPairValue == array[diffPairIndex]) ? 4 : 1;
            } else {
                return (newDiffPairValue == array[diffPairIndex]) ? 3 : 2;
            }
        } else {
            int pairIndex = (samePairIndex == -1) ? diffPairIndex : samePairIndex;
            int newPairValue = query(scanner, pairIndex);
            query(scanner, pairIndex);  // Dummy query to maintain balance

            return (newPairValue == array[pairIndex]) ? 4 : 2;
        }
    }

    private static void updateArray(int[] array, int action) {
        switch (action) {
            case 1:
                reverseArray(array);
                break;
            case 2:
                invertArray(array);
                break;
            case 3:
                reverseArray(array);
                invertArray(array);
                break;
        }
    }

    private static void reverseArray(int[] array) {
        int length = array.length;
        for (int i = 1; i <= length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - i];
            array[length - i] = temp;
        }
    }

    private static void invertArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] = (array[i] == 1) ? 0 : 1;
        }
    }

    private static boolean isFinished(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == -1) return false;
        }
        return true;
    }
}