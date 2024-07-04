import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void complementArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
    }

    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    public static int[] complementAndReverseArray(int[] array) {
        int[] reversed = reverseArray(array);
        complementArray(reversed);
        return reversed;
    }

    public static void handleGuessingFor10Bits(Scanner scanner) {
        int[] answerArray = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            System.out.flush();
            answerArray[i] = scanner.nextInt();
        }
        System.out.println(arrayToString(answerArray));
        System.out.flush();
        scanner.nextLine();
        scanner.nextLine();
    }

    public static int[] handleTeilbaumA(int[] array, Scanner scanner) {
        int[] answerArray = array.clone();
        if (isSymmetric(answerArray)) {
            complementArray(answerArray);
        } else {
            answerArray = handleAsymmetric(answerArray, scanner, true);
        }
        return answerArray;
    }

    public static int[] handleTeilbaumB(int[] array, Scanner scanner) {
        int[] answerArray = array.clone();
        if (!isSymmetric(answerArray)) {
            answerArray = handleAsymmetric(answerArray, scanner, false);
        }
        return answerArray;
    }

    public static int[] handleTeilbaumC(int[] array, Scanner scanner) {
        int[] answerArray = array.clone();
        if (isFullyAsymmetric(answerArray)) {
            complementArray(answerArray);
        } else {
            answerArray = handleSymmetric(answerArray, scanner, false);
        }
        return answerArray;
    }

    public static int[] handleTeilbaumD(int[] array, Scanner scanner) {
        int[] answerArray = array.clone();
        if (isFullyAsymmetric(answerArray)) {
            answerArray = complementAndReverseArray(answerArray);
        } else {
            answerArray = handleSymmetric(answerArray, scanner, true);
        }
        return answerArray;
    }

    public static void handleGuessingFor20Bits(Scanner scanner) {
        int[] answerArray = new int[20];
        for (int i = 0; i < 5; i++) {
            System.out.println(i + 1);
            System.out.flush();
            answerArray[i] = scanner.nextInt();
        }
        for (int i = 16; i <= 20; i++) {
            System.out.println(i);
            System.out.flush();
            answerArray[i - 1] = scanner.nextInt();
        }
        System.out.println(1);
        int newIntAtPosition1 = scanner.nextInt();

        if (answerArray[0] == answerArray[19]) {
            answerArray = newIntAtPosition1 != answerArray[0] ? handleTeilbaumA(answerArray, scanner) : handleTeilbaumB(answerArray, scanner);
        } else {
            answerArray = newIntAtPosition1 != answerArray[0] ? handleTeilbaumC(answerArray, scanner) : handleTeilbaumD(answerArray, scanner);
        }

        for (int i = 6; i <= 15; i++) {
            System.out.println(i);
            System.out.flush();
            answerArray[i - 1] = scanner.nextInt();
        }

        System.out.println(arrayToString(answerArray));
        System.out.flush();
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        int numberOfBits = scanner.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            if (numberOfBits == 10) {
                handleGuessingFor10Bits(scanner);
            } else if (numberOfBits == 20) {
                handleGuessingFor20Bits(scanner);
            }
        }
    }

    private static boolean isSymmetric(int[] array) {
        for (int i = 0; i < 5; i++) {
            if (array[i] != array[19 - i]) return false;
        }
        return true;
    }

    private static boolean isFullyAsymmetric(int[] array) {
        for (int i = 0; i < 5; i++) {
            if (array[i] == array[19 - i]) return false;
        }
        return true;
    }

    private static int[] handleAsymmetric(int[] array, Scanner scanner, boolean complementIfEqual) {
        for (int i = 0; i < 3; i++) {
            if (array[1 + i] != array[18 - i]) {
                System.out.println(1 + i);
                System.out.flush();
                int newInt = scanner.nextInt();
                if ((newInt == array[1 + i]) == complementIfEqual) {
                    return complementAndReverseArray(array);
                } else {
                    return reverseArray(array);
                }
            }
        }
        return array;
    }

    private static int[] handleSymmetric(int[] array, Scanner scanner, boolean complementIfEqual) {
        for (int i = 0; i < 3; i++) {
            if (array[1 + i] == array[18 - i]) {
                System.out.println(1 + i);
                System.out.flush();
                int newInt = scanner.nextInt();
                if ((newInt != array[1 + i]) == complementIfEqual) {
                    return complementAndReverseArray(array);
                }
            }
        }
        return array;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int value : array) {
            sb.append(value);
        }
        return sb.toString();
    }
}