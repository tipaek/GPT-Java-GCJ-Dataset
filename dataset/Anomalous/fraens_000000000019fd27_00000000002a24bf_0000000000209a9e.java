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
        int[] answers = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            System.out.flush();
            answers[i] = scanner.nextInt();
        }
        StringBuilder output = new StringBuilder();
        for (int value : answers) {
            output.append(value);
        }
        System.out.println(output);
        scanner.nextLine();
        scanner.nextLine();
    }

    public static int[] handleTeilbaumA(int[] array, Scanner scanner) {
        int[] answers = array.clone();
        if (isSymmetric(answers)) {
            complementArray(answers);
        } else {
            handlePartialSymmetry(answers, scanner, true, false);
        }
        return answers;
    }

    public static int[] handleTeilbaumB(int[] array, Scanner scanner) {
        int[] answers = array.clone();
        if (!isSymmetric(answers)) {
            handlePartialSymmetry(answers, scanner, false, false);
        }
        return answers;
    }

    public static int[] handleTeilbaumC(int[] array, Scanner scanner) {
        int[] answers = array.clone();
        if (isAntiSymmetric(answers)) {
            complementArray(answers);
        } else {
            handlePartialSymmetry(answers, scanner, true, true);
        }
        return answers;
    }

    public static int[] handleTeilbaumD(int[] array, Scanner scanner) {
        int[] answers = array.clone();
        if (!isAntiSymmetric(answers)) {
            handlePartialSymmetry(answers, scanner, false, true);
        }
        return answers;
    }

    private static boolean isSymmetric(int[] array) {
        for (int i = 0; i < 5; i++) {
            if (array[i] != array[19 - i]) return false;
        }
        return true;
    }

    private static boolean isAntiSymmetric(int[] array) {
        for (int i = 0; i < 5; i++) {
            if (array[i] == array[19 - i]) return false;
        }
        return true;
    }

    private static void handlePartialSymmetry(int[] array, Scanner scanner, boolean complement, boolean antiSymmetric) {
        for (int i = 0; i < 3; i++) {
            if ((antiSymmetric && array[i + 1] == array[18 - i]) || (!antiSymmetric && array[i + 1] != array[18 - i])) {
                System.out.println(i + 2);
                System.out.flush();
                int newValue = scanner.nextInt();
                if ((antiSymmetric && newValue == array[i + 1]) || (!antiSymmetric && newValue != array[i + 1])) {
                    array = complement ? complementAndReverseArray(array) : reverseArray(array);
                } else if (complement) {
                    complementArray(array);
                }
                break;
            }
        }
    }

    public static void handleGuessingFor20Bits(Scanner scanner) {
        int[] answers = new int[20];
        for (int i = 0; i < 5; i++) {
            System.out.println(i + 1);
            System.out.flush();
            answers[i] = scanner.nextInt();
        }
        for (int i = 15; i < 20; i++) {
            System.out.println(i + 1);
            System.out.flush();
            answers[i] = scanner.nextInt();
        }
        System.out.println(1);
        System.out.flush();
        int newValue = scanner.nextInt();

        if (answers[0] == answers[19]) {
            answers = newValue != answers[0] ? handleTeilbaumA(answers, scanner) : handleTeilbaumB(answers, scanner);
        } else {
            answers = newValue != answers[0] ? handleTeilbaumC(answers, scanner) : handleTeilbaumD(answers, scanner);
        }

        for (int i = 5; i < 15; i++) {
            System.out.println(i + 1);
            System.out.flush();
            answers[i] = scanner.nextInt();
        }

        StringBuilder output = new StringBuilder();
        for (int value : answers) {
            output.append(value);
        }
        System.out.println(output);
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bits = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            if (bits == 10) {
                handleGuessingFor10Bits(scanner);
            } else if (bits == 20) {
                handleGuessingFor20Bits(scanner);
            }
        }
        scanner.nextLine();
    }
}