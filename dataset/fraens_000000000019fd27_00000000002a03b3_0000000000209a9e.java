import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void complementArray(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == 0) {
                inputArray[i] = 1;
            } else if (inputArray[i] == 1) {
                inputArray[i] = 0;
            }
        }
    }

    public static int[] reverseArray(int[] inputArray) {
        int[] outputArray = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            outputArray[i] = inputArray[inputArray.length - 1 - i];
        }
        return outputArray;
    }

    public static int[] complementAndReverseArray(int[] inputArray) {
        int[] outputArray = reverseArray(inputArray);
        complementArray(outputArray);
        return outputArray;
    }

    public static void handleGuessingFor10Bits(Scanner in) {
        int[] answerArray = new int[10];
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            System.out.flush();
            answerArray[i - 1] = in.nextInt();
        }
        String output = "";
        for (int value : answerArray) {
            output += value;
        }
        System.out.println(output);
        in.nextLine();
        String answer = in.nextLine();
    }

    public static int[] handleTeilbaumA(int[] inputArray, Scanner in) {
        int[] answerArray = new int[20];
        int j = 0;
        for (int value : inputArray) {
            answerArray[j] = value;
        }
        if (answerArray[0] == answerArray[19] &&
                answerArray[1] == answerArray[18] &&
                answerArray[2] == answerArray[17] &&
                answerArray[3] == answerArray[16] &&
                answerArray[4] == answerArray[15]) {
            complementArray(answerArray);
        }
        else {
            for (int i = 0; i < 3; i++) {
                if (answerArray[1 + i] != answerArray[18 - i]) {
                    System.out.println(1 + i);
                    System.out.flush();
                    int newIntAtPositionIPlus1WhereNumbersAreNotEqual = in.nextInt();
                    if (newIntAtPositionIPlus1WhereNumbersAreNotEqual == answerArray[1 + i]) {
                        answerArray = complementAndReverseArray(answerArray);
                    }
                    else {
                        answerArray = reverseArray(answerArray);
                    }
                    break;
                }
            }
        }
        return answerArray;
    }


    public static int[] handleTeilbaumB(int[] inputArray, Scanner in) {
        int[] answerArray = new int[20];
        int j = 0;
        for (int value : inputArray) {
            answerArray[j] = value;
            j++;
        }
        if (!(answerArray[0] == answerArray[19] &&
                answerArray[1] == answerArray[18] &&
                answerArray[2] == answerArray[17] &&
                answerArray[3] == answerArray[16] &&
                answerArray[4] == answerArray[15])) {
            for (int i = 0; i < 3; i++) {
                if (answerArray[1 + i] != answerArray[18 - i]) {
                    System.out.println(1 + i);
                    System.out.flush();
                    int newIntAtPositionIPlus1WhereNumbersAreNotEqual = in.nextInt();
                    if (newIntAtPositionIPlus1WhereNumbersAreNotEqual != answerArray[1 + i]) {
                        answerArray = reverseArray(answerArray);
                    }
                    break;
                }
            }
        }
        return answerArray;
    }


    public static int[] handleTeilbaumC(int[] inputArray, Scanner in) {
        int[] answerArray = new int[20];
        int j = 0;
        for (int value : inputArray) {
            answerArray[j] = value;
            j++;
        }
        if (answerArray[0] != answerArray[19] &&
                answerArray[1] != answerArray[18] &&
                answerArray[2] != answerArray[17] &&
                answerArray[3] != answerArray[16] &&
                answerArray[4] != answerArray[15]) {
            complementArray(answerArray);
        } else {
            for (int i = 0; i < 3; i++) {
                if (answerArray[1 + i] == answerArray[18 - i]) {

                    System.out.println(1 + i);
                    System.out.flush();
                    int newIntAtPositionIPlus1WhereNumbersAreEqual = in.nextInt();
                    if (newIntAtPositionIPlus1WhereNumbersAreEqual == answerArray[1 + i]) {
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


    public static int[] handleTeilbaumD(int[] inputArray, Scanner in) {
        int[] answerArray = new int[20];
        int j = 0;
        for (int value : inputArray) {
            answerArray[j] = value;
            j++;
        }
        if (answerArray[0] != answerArray[19] &&
                answerArray[1] != answerArray[18] &&
                answerArray[2] != answerArray[17] &&
                answerArray[3] != answerArray[16] &&
                answerArray[4] != answerArray[15]) {
            answerArray = complementAndReverseArray(answerArray);
        } else {
            for (int i = 0; i < 3; i++) {
                if (answerArray[1 + i] == answerArray[18 - i]) {
                    System.out.println(1 + i);
                    System.out.flush();
                    int newIntAtPositionIPlus1WhereNumbersAreEqual = in.nextInt();
                    if (newIntAtPositionIPlus1WhereNumbersAreEqual != answerArray[1 + i]) {
                        answerArray = complementAndReverseArray(answerArray);
                    }
                    break;
                }
            }
        }
        return answerArray;
    }

    public static void handleGuessingFor20Bits(Scanner in) {
        int[] answerArray = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            System.out.flush();
            answerArray[i - 1] = in.nextInt();
        }
        for (int i = 16; i <= 20; i++) {
            System.out.println(i);
            System.out.flush();
            answerArray[i - 1] = in.nextInt();
        }
        System.out.println(1);
        int newIntAtPosition1 = in.nextInt();

        if (answerArray[0] == answerArray[19]) {
            if (newIntAtPosition1 != answerArray[0]) {
                answerArray = handleTeilbaumA(answerArray, in);
            }
            else {
                answerArray = handleTeilbaumB(answerArray, in);
            }
        }

        if (answerArray[0] != answerArray[19]) {
            if (newIntAtPosition1 != answerArray[0]) {
                answerArray = handleTeilbaumC(answerArray, in);
            }
            else {
                answerArray = handleTeilbaumD(answerArray, in);
            }
        }

        for (int i = 6; i <= 15; i++) {
            System.out.println(i);
            System.out.flush();
            answerArray[i - 1] = in.nextInt();
        }

        String output = "";
        for (int value : answerArray) {
            output += value;
        }
        System.out.println(output);
        in.nextLine();
        String answer = in.nextLine();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = in.nextInt();
        int numberOfBits = in.nextInt();
        if (numberOfBits == 10) {
            for (int i = 0; i < numberOfTestCases; i++) {
                handleGuessingFor10Bits(in);
            }
        }
        if (numberOfBits == 20) {
            for (int i = 0; i < numberOfTestCases; i++) {
                handleGuessingFor20Bits(in);
            }

        }
    }
}

