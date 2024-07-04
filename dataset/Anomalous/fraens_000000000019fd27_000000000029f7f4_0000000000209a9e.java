import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void complementArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
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
        int[] answer = new int[10];
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            System.out.flush();
            answer[i - 1] = scanner.nextInt();
        }
        StringBuilder output = new StringBuilder();
        for (int value : answer) {
            output.append(value);
        }
        System.out.println(output);
        scanner.nextLine();
        scanner.nextLine();
    }

    public static int[] handleTeilbaumA(int[] arr, Scanner scanner) {
        int[] answer = arr.clone();
        if (isSymmetric(answer, 0, 19, 5)) {
            complementArray(answer);
        } else {
            for (int i = 0; i < 4; i++) {
                if (answer[1 + i] != answer[18 - i]) {
                    System.out.println(1 + i);
                    System.out.flush();
                    int newValue = scanner.nextInt();
                    if (newValue == answer[1 + i]) {
                        answer = complementAndReverseArray(answer);
                    } else {
                        answer = reverseArray(answer);
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static int[] handleTeilbaumB(int[] arr, Scanner scanner) {
        int[] answer = arr.clone();
        if (!isSymmetric(answer, 0, 19, 5)) {
            for (int i = 0; i < 4; i++) {
                if (answer[1 + i] != answer[18 - i]) {
                    System.out.println(1 + i);
                    System.out.flush();
                    int newValue = scanner.nextInt();
                    if (newValue != answer[1 + i]) {
                        answer = reverseArray(answer);
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static int[] handleTeilbaumC(int[] arr, Scanner scanner) {
        int[] answer = arr.clone();
        if (!isSymmetric(answer, 0, 19, 5)) {
            complementArray(answer);
        } else {
            for (int i = 0; i < 4; i++) {
                if (answer[1 + i] == answer[18 - i]) {
                    System.out.println(1 + i);
                    System.out.flush();
                    int newValue = scanner.nextInt();
                    if (newValue == answer[1 + i]) {
                        answer = reverseArray(answer);
                    } else {
                        complementArray(answer);
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static int[] handleTeilbaumD(int[] arr, Scanner scanner) {
        int[] answer = arr.clone();
        if (!isSymmetric(answer, 0, 19, 5)) {
            answer = complementAndReverseArray(answer);
        } else {
            for (int i = 0; i < 4; i++) {
                if (answer[1 + i] == answer[18 - i]) {
                    System.out.println(1 + i);
                    System.out.flush();
                    int newValue = scanner.nextInt();
                    if (newValue != answer[1 + i]) {
                        answer = complementAndReverseArray(answer);
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static void handleGuessingFor20Bits(Scanner scanner) {
        int[] answer = new int[20];
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            System.out.flush();
            answer[i - 1] = scanner.nextInt();
        }
        for (int i = 16; i <= 20; i++) {
            System.out.println(i);
            System.out.flush();
            answer[i - 1] = scanner.nextInt();
        }
        System.out.println(1);
        int newValue = scanner.nextInt();

        if (answer[0] == answer[19]) {
            answer = (newValue != answer[0]) ? handleTeilbaumA(answer, scanner) : handleTeilbaumB(answer, scanner);
        } else {
            answer = (newValue != answer[0]) ? handleTeilbaumC(answer, scanner) : handleTeilbaumD(answer, scanner);
        }

        for (int i = 6; i <= 15; i++) {
            System.out.println(i);
            System.out.flush();
            answer[i - 1] = scanner.nextInt();
        }

        StringBuilder output = new StringBuilder();
        for (int value : answer) {
            output.append(value);
        }
        System.out.println(output);
    }

    public static boolean isSymmetric(int[] arr, int start, int end, int length) {
        for (int i = 0; i < length; i++) {
            if (arr[start + i] != arr[end - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bits = scanner.nextInt();

        if (bits == 10) {
            for (int i = 0; i < testCases; i++) {
                handleGuessingFor10Bits(scanner);
            }
        } else if (bits == 20) {
            for (int i = 0; i < testCases; i++) {
                handleGuessingFor20Bits(scanner);
            }
        }
    }
}