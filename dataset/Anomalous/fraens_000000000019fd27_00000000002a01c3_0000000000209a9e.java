import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void complementArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
    }

    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    public static int[] complementAndReverseArray(int[] arr) {
        int[] reversed = reverseArray(arr);
        complementArray(reversed);
        return reversed;
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
        scanner.nextLine();  // Consume the answer
    }

    public static int[] handleTeilbaumA(int[] arr, Scanner scanner) {
        int[] answerArray = arr.clone();
        if (checkSymmetry(answerArray)) {
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

    public static int[] handleTeilbaumB(int[] arr, Scanner scanner) {
        int[] answerArray = arr.clone();
        if (!checkSymmetry(answerArray)) {
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

    public static int[] handleTeilbaumC(int[] arr, Scanner scanner) {
        int[] answerArray = arr.clone();
        if (checkNonSymmetry(answerArray)) {
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

    public static int[] handleTeilbaumD(int[] arr, Scanner scanner) {
        int[] answerArray = arr.clone();
        if (checkNonSymmetry(answerArray)) {
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
    }

    public static boolean checkSymmetry(int[] arr) {
        return arr[0] == arr[19] && arr[1] == arr[18] && arr[2] == arr[17] &&
               arr[3] == arr[16] && arr[4] == arr[15];
    }

    public static boolean checkNonSymmetry(int[] arr) {
        return arr[0] != arr[19] && arr[1] != arr[18] && arr[2] != arr[17] &&
               arr[3] != arr[16] && arr[4] != arr[15];
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
}