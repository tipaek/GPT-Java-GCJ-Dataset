import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int B = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            solve(scanner, B);
            System.out.flush();
        }
    }

    public static void solve(Scanner scanner, int B) {
        int[] array = new int[B + 1];
        int samePairIndex = -1;
        int diffPairIndex = -1;
        int diffValue = -1;
        int lastIndex = 5;

        // Initialize array with -1
        for (int i = 0; i <= B; i++) {
            array[i] = -1;
        }

        // First 10 digits
        for (int i = 1; i <= 5; i++) {
            array[i] = query(scanner, i);
            array[B - i + 1] = query(scanner, B - i + 1);
            if (array[i] == array[B - i + 1]) {
                samePairIndex = i;
            } else {
                diffPairIndex = i;
                diffValue = array[i];
            }
        }

        while (!isFinished(array)) {
            updateArray(array, determineChange(array, samePairIndex, diffPairIndex, diffValue, scanner));

            for (int i = lastIndex + 1; !isFinished(array) && i < lastIndex + 5; i++) {
                array[i] = query(scanner, i);
                array[B - i + 1] = query(scanner, B - i + 1);
                if (samePairIndex == -1 && array[i] == array[B - i + 1]) samePairIndex = i;
                if (diffPairIndex == -1 && array[i] != array[B - i + 1]) diffPairIndex = i;
            }
            lastIndex += 4;
            diffValue = array[diffPairIndex];
        }

        printArray(array);
    }

    public static int query(Scanner scanner, int index) {
        System.out.println(index);
        System.out.flush();
        return scanner.nextInt();
    }

    public static int determineChange(int[] array, int samePairIndex, int diffPairIndex, int diffValue, Scanner scanner) {
        if (samePairIndex != -1 && diffPairIndex != -1) {
            int newSame = query(scanner, samePairIndex);
            int newDiff = query(scanner, diffPairIndex);
            if (newSame == array[samePairIndex]) {
                return (newDiff == diffValue) ? 4 : 2;
            } else {
                return (newDiff == diffValue) ? 3 : 1;
            }
        } else {
            if (samePairIndex == -1) {
                int newDiff = query(scanner, diffPairIndex);
                return (newDiff == array[diffPairIndex]) ? 4 : 2;
            } else {
                int newSame = query(scanner, samePairIndex);
                return (newSame == array[samePairIndex]) ? 4 : 2;
            }
        }
    }

    public static void updateArray(int[] array, int action) {
        if (action == 4) return;

        if (action == 1) {
            for (int i = 1; i <= array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[array.length - i];
                array[array.length - i] = temp;
            }
        } else if (action == 2) {
            for (int i = 1; i < array.length; i++) {
                array[i] = 1 - array[i];
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

    public static void printArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.flush();
        System.out.println();
    }
}