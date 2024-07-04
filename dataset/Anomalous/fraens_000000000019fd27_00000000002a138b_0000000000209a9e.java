import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void complementArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

    public static int[] reverseArray(int[] array) {
        int length = array.length;
        int[] reversedArray = new int[length];
        for (int i = 0; i < length; i++) {
            reversedArray[i] = array[length - 1 - i];
        }
        return reversedArray;
    }

    public static int[] complementAndReverseArray(int[] array) {
        int[] reversedArray = reverseArray(array);
        complementArray(reversedArray);
        return reversedArray;
    }

    public static void handleGuessingFor10Bits(Scanner scanner) {
        int[] answerArray = new int[10];
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            System.out.flush();
            answerArray[i - 1] = scanner.nextInt();
        }
        StringBuilder output = new StringBuilder();
        for (int value : answerArray) {
            output.append(value);
        }
        System.out.println(output);
        scanner.nextLine();
        String answer = scanner.nextLine();
    }

    public static int[] handleTeilbaumA(int[] array, Scanner scanner) {
        int[] answerArray = array.clone();
        if (isSymmetric(answerArray)) {
            complementArray(answerArray);
        } else {
            for (int i = 0; i < 3; i++) {
                if (answerArray[1 + i] != answerArray[18 - i]) {
                    System.out.println(1 + i);
                    System.out.flush();
                    int newValue = scanner.nextInt();
                    if (newValue == answerArray[1 + i]) {
                        answerArray = complementAndReverseArray(answerArray);
                    } else {
                        answerArray = reverseArray(answerArray);
                    }
                    break;
                }
            }
        }
        return answerArray;
    }

    public static int[] handleTeilbaumB(int[] array, Scanner scanner) {
        int[] answerArray = array.clone();
        if (!isSymmetric(answerArray)) {
            for (int i = 0; i < 3; i++) {
                if (answerArray[1 + i] != answerArray[18 - i]) {
                    System.out.println(1 + i);
                    System.out.flush();
                    int newValue = scanner.nextInt();
                    if (newValue != answerArray[1 + i]) {
                        answerArray = reverseArray(answerArray);
                    }
                    break;
                }
            }
        }
        return answerArray;
    }

    public static int[] handleTeilbaumC(int[] array, Scanner scanner) {
        int[] answerArray = array.clone();
        if (!isSymmetric(answerArray)) {
            complementArray(answerArray);
        } else {
            for (int i = 0; i < 3; i++) {
                if (answerArray[1 + i] == answerArray[18 - i]) {
                    System.out.println(1 + i);
                    System.out.flush();
                    int newValue = scanner.nextInt();
                    if (newValue == answerArray[1 + i]) {
                        answerArray = reverseArray(answerArray);
                    } else {
                        complementArray(answerArray);
                    }
                    break;
                }
            }
        }
        return answerArray;
    }

    public static int[] handleTeilbaumD(int[] array, Scanner scanner) {
        int[] answerArray = array.clone();
        if (!isSymmetric(answerArray)) {
            answerArray = complementAndReverseArray(answerArray);
        } else {
            for (int i = 0; i < 3; i++) {
                if (answerArray[1 + i] == answerArray[18 - i]) {
                    System.out.println(1 + i);
                    System.out.flush();
                    int newValue = scanner.nextInt();
                    if (newValue != answerArray[1 + i]) {
                        answerArray = complementAndReverseArray(answerArray);
                    }
                    break;
                }
            }
        }
        return answerArray;
    }

    public static void handleGuessingFor20Bits(Scanner scanner) {
        int[] answerArray = new int[20];
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            System.out.flush();
            answerArray[i - 1] = scanner.nextInt();
        }
        for (int i = 16; i <= 20; i++) {
            System.out.println(i);
            System.out.flush();
            answerArray[i - 1] = scanner.nextInt();
        }
        System.out.println(1);
        System.out.flush();
        int newValue = scanner.nextInt();

        if (answerArray[0] == answerArray[19]) {
            if (newValue != answerArray[0]) {
                answerArray = handleTeilbaumA(answerArray, scanner);
            } else {
                answerArray = handleTeilbaumB(answerArray, scanner);
            }
        } else {
            if (newValue != answerArray[0]) {
                answerArray = handleTeilbaumC(answerArray, scanner);
            } else {
                answerArray = handleTeilbaumD(answerArray, scanner);
            }
        }

        for (int i = 6; i <= 15; i++) {
            System.out.println(i);
            System.out.flush();
            answerArray[i - 1] = scanner.nextInt();
        }

        StringBuilder output = new StringBuilder();
        for (int value : answerArray) {
            output.append(value);
        }
        System.out.println(output);
        scanner.nextLine();
        String answer = scanner.nextLine();
    }

    public static boolean isSymmetric(int[] array) {
        return array[0] == array[19] && array[1] == array[18] && array[2] == array[17] && array[3] == array[16] && array[4] == array[15];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        int numberOfBits = scanner.nextInt();
        if (numberOfBits == 10) {
            for (int i = 0; i < numberOfTestCases; i++) {
                handleGuessingFor10Bits(scanner);
            }
        } else if (numberOfBits == 20) {
            for (int i = 0; i < numberOfTestCases; i++) {
                handleGuessingFor20Bits(scanner);
            }
        }
    }
}