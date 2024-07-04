import java.util.*;

class Solution {
    static char[] answerArray;
    static int index, pairIndex, sameIndex, diffIndex, totalBits, testCases;
    static char tempChar;
    static boolean terminateFlag = false;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        testCases = scanner.nextInt();
        totalBits = scanner.nextInt();

        for (int currentTestCase = 0; currentTestCase < testCases; currentTestCase++) {
            answerArray = new char[totalBits];
            Arrays.fill(answerArray, '1');

            for (index = 1, pairIndex = 0, sameIndex = -1, diffIndex = -1; pairIndex < (totalBits + 1) / 2; index += 2) {
                if (index > 10 && index % 10 == 1) {
                    handleSpecialCase();
                } else {
                    handleRegularCase();
                }
            }

            System.out.println(String.valueOf(answerArray));
            System.out.flush();
            char result = scanner.next().charAt(0);
            if (result == 'N') {
                terminateFlag = true;
                break;
            }
        }

        if (terminateFlag) {
            return;
        }
    }

    static void complementArray(char[] array) {
        for (int i = 0; i < totalBits; i++) {
            array[i] = (array[i] == '0') ? '1' : '0';
        }
    }

    static void reverseArray(char[] array) {
        for (int i = 0; i < totalBits / 2; i++) {
            char temp = array[i];
            array[i] = array[totalBits - i - 1];
            array[totalBits - i - 1] = temp;
        }
    }

    static void handleRegularCase() {
        System.out.println(pairIndex + 1);
        System.out.flush();
        answerArray[pairIndex] = scanner.next().charAt(0);

        System.out.println(totalBits - pairIndex);
        System.out.flush();
        answerArray[totalBits - 1 - pairIndex] = scanner.next().charAt(0);

        if (answerArray[pairIndex] == answerArray[totalBits - 1 - pairIndex]) {
            sameIndex = pairIndex;
        } else {
            diffIndex = pairIndex;
        }
        pairIndex++;
    }

    static void handleSpecialCase() {
        if (sameIndex != -1) {
            System.out.println(sameIndex + 1);
            tempChar = scanner.next().charAt(0);
            if (answerArray[sameIndex] != tempChar) {
                complementArray(answerArray);
            }
        } else {
            System.out.println(1);
            tempChar = scanner.next().charAt(0);
        }

        if (diffIndex != -1) {
            System.out.println(diffIndex + 1);
            tempChar = scanner.next().charAt(0);
            if (answerArray[diffIndex] != tempChar) {
                reverseArray(answerArray);
            }
        } else {
            System.out.println(1);
            tempChar = scanner.next().charAt(0);
        }
        System.out.flush();
    }
}