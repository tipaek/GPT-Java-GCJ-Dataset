import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int B = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            solve(scanner, B);
            System.out.flush();
            String response = scanner.next();
            if (response.equals("N")) break;
        }
    }

    public static void solve(Scanner scanner, int B) {
        int[] array = new int[B + 1];
        int equalPairIndex = -1;
        int unequalPairIndex = -1;
        int lastIndex = 5;

        // Initialize array
        for (int i = 0; i <= B; i++) {
            array[i] = -1;
        }

        // First 10 digits
        for (int i = 1; i <= 5; i++) {
            array[i] = query(scanner, i);
            array[B - i + 1] = query(scanner, B - i + 1);
            if (array[i] == array[B - i + 1]) {
                equalPairIndex = i;
            } else {
                unequalPairIndex = i;
            }
        }

        while (!isFinished(array)) {
            int changeType = determineChangeType(array, equalPairIndex, unequalPairIndex, scanner);
            applyChange(array, changeType);

            for (int i = lastIndex + 1; !isFinished(array) && i <= lastIndex + 4; i++) {
                array[i] = query(scanner, i);
                array[B - i + 1] = query(scanner, B - i + 1);
                if (equalPairIndex == -1 && array[i] == array[B - i + 1]) equalPairIndex = i;
                if (unequalPairIndex == -1 && array[i] != array[B - i + 1]) unequalPairIndex = i;
            }
            lastIndex += 4;
        }

        printArray(array);
    }

    public static int query(Scanner scanner, int index) {
        System.out.println(index);
        System.out.flush();
        return scanner.nextInt();
    }

    public static int determineChangeType(int[] array, int equalPairIndex, int unequalPairIndex, Scanner scanner) {
        if (equalPairIndex != -1 && unequalPairIndex != -1) {
            int newEqualValue = query(scanner, equalPairIndex);
            int newUnequalValue = query(scanner, unequalPairIndex);
            if (newEqualValue == array[equalPairIndex]) {
                return (newUnequalValue == array[unequalPairIndex]) ? 4 : 1;
            } else {
                return (newUnequalValue == array[unequalPairIndex]) ? 3 : 2;
            }
        } else {
            int index = (equalPairIndex == -1) ? unequalPairIndex : equalPairIndex;
            int newValue = query(scanner, index);
            return (newValue == array[index]) ? 4 : 2;
        }
    }

    public static void applyChange(int[] array, int changeType) {
        if (changeType == 4) return;

        if (changeType == 1) {
            reverseArray(array);
        } else if (changeType == 2) {
            invertArray(array);
        } else if (changeType == 3) {
            reverseArray(array);
            invertArray(array);
        }
    }

    public static void reverseArray(int[] array) {
        int length = array.length;
        for (int i = 1; i <= length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - i];
            array[length - i] = temp;
        }
    }

    public static void invertArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] = (array[i] == 1) ? 0 : 1;
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