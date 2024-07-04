import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            solve(scanner, arraySize);
            System.out.flush();
            String response = scanner.next();
            if (response.equals("N")) break;
        }
    }

    public static void solve(Scanner scanner, int arraySize) {
        int[] array = new int[arraySize + 1];
        int equalPairIndex = -1;
        int unequalPairIndex = -1;
        int lastProcessedIndex = 5;

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
                equalPairIndex = i;
            } else {
                unequalPairIndex = i;
            }
        }

        while (!isFinished(array)) {
            updateArray(array, determineChange(array, equalPairIndex, unequalPairIndex, scanner));

            for (int i = lastProcessedIndex + 1; !isFinished(array) && i < lastProcessedIndex + 5; i++) {
                System.out.println(i);
                System.out.flush();
                int value1 = scanner.nextInt();
                System.out.println(arraySize - i + 1);
                System.out.flush();
                int value2 = scanner.nextInt();
                if (equalPairIndex == -1 && value1 == value2) equalPairIndex = i;
                if (unequalPairIndex == -1 && value1 != value2) unequalPairIndex = i;
                array[i] = value1;
                array[arraySize - i + 1] = value2;
            }
            lastProcessedIndex += 4;
        }

        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.flush();
        System.out.println();
    }

    public static int determineChange(int[] array, int equalPairIndex, int unequalPairIndex, Scanner scanner) {
        if (equalPairIndex != -1 && unequalPairIndex != -1) {
            System.out.println(equalPairIndex);
            System.out.flush();
            int newEqualValue = scanner.nextInt();
            System.out.println(unequalPairIndex);
            System.out.flush();
            int newUnequalValue = scanner.nextInt();
            if (newEqualValue == array[equalPairIndex]) {
                return (newUnequalValue == array[unequalPairIndex]) ? 4 : 1;
            } else {
                return (newUnequalValue == array[unequalPairIndex]) ? 3 : 2;
            }
        } else if (equalPairIndex == -1) {
            System.out.println(unequalPairIndex);
            System.out.flush();
            int newUnequalValue = scanner.nextInt();
            return (newUnequalValue == array[unequalPairIndex]) ? 4 : 2;
        } else {
            System.out.println(equalPairIndex);
            System.out.flush();
            int newEqualValue = scanner.nextInt();
            return (newEqualValue == array[equalPairIndex]) ? 4 : 2;
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

    public static boolean isFinished(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == -1) return false;
        }
        return true;
    }
}