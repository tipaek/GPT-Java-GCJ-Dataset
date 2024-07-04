import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            solve(scanner, arraySize);
        }
    }

    public static void solve(Scanner scanner, int arraySize) {
        int[] array = new int[arraySize + 1];
        int equalPairIndex = -1;
        int differentPairIndex = -1;
        int differentValue = -1;
        int lastProcessedIndex = 5;

        // Initialize array
        for (int i = 0; i <= arraySize; i++) {
            array[i] = -1;
        }

        // First 10 digits
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            int value1 = scanner.nextInt();
            System.out.println(arraySize - i + 1);
            int value2 = scanner.nextInt();
            array[i] = value1;
            array[arraySize - i + 1] = value2;
            if (value1 == value2) {
                equalPairIndex = i;
            } else {
                differentPairIndex = i;
                differentValue = value1;
            }
        }

        while (!isArrayComplete(array)) {
            updateArray(array, determineAction(array, equalPairIndex, differentPairIndex, differentValue, scanner));

            for (int i = lastProcessedIndex + 1; i <= lastProcessedIndex + 4; i++) {
                System.out.println(i);
                int x = scanner.nextInt();
                System.out.println(arraySize - i + 1);
                int y = scanner.nextInt();
                if (equalPairIndex == -1 && x == y) equalPairIndex = i;
                if (differentPairIndex == -1 && x != y) differentPairIndex = i;
                array[i] = x;
                array[arraySize - i + 1] = y;
            }
            lastProcessedIndex += 4;
            differentValue = array[differentPairIndex];
        }

        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static int determineAction(int[] array, int equalPairIndex, int differentPairIndex, int differentValue, Scanner scanner) {
        if (equalPairIndex != -1 && differentPairIndex != -1) {
            System.out.println(equalPairIndex);
            int newEqualValue = scanner.nextInt();
            System.out.println(differentPairIndex);
            int newDifferentValue = scanner.nextInt();
            if (newEqualValue == array[equalPairIndex]) {
                return (newDifferentValue == differentValue) ? 4 : 2;
            } else {
                return (newDifferentValue == differentValue) ? 3 : 1;
            }
        } else {
            if (equalPairIndex == -1) {
                System.out.println(differentPairIndex);
                int newDifferentValue = scanner.nextInt();
                return (newDifferentValue == array[differentPairIndex]) ? 4 : 2;
            } else {
                System.out.println(equalPairIndex);
                int newEqualValue = scanner.nextInt();
                return (newEqualValue == array[equalPairIndex]) ? 4 : 2;
            }
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
        }

        if (action == 2) {
            for (int i = 1; i < array.length; i++) {
                array[i] = (array[i] == 1) ? 0 : 1;
            }
        }

        if (action == 3) {
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