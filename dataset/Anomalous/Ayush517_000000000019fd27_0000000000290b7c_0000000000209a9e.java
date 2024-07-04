import java.util.*;

public class Solution {
    static char[] answer;
    static int index, pairIndex, samePairIndex, diffPairIndex, length, testCases;
    static char tempChar;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        testCases = scanner.nextInt();
        length = scanner.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            answer = new char[length];
            Arrays.fill(answer, '1');
            for (index = 1, pairIndex = 0, samePairIndex = -1, diffPairIndex = -1; pairIndex < (length + 1) / 2; index += 2) {
                if (index > 10 && index % 10 == 1) {
                    handleSpecialCase();
                } else {
                    handleNormalCase();
                }
            }
            System.out.println(String.valueOf(answer));
            System.out.flush();
            char result = scanner.next().charAt(0);
            if (result == 'N') {
                return;
            }
        }
    }

    static void complementArray(char[] array) {
        for (int i = 0; i < length; i++) {
            array[i] = (array[i] == '0') ? '1' : '0';
        }
    }

    static void reverseArray(char[] array) {
        for (int i = 0; i < length / 2; i++) {
            char temp = array[i];
            array[i] = array[length - 1 - i];
            array[length - 1 - i] = temp;
        }
    }

    static void handleNormalCase() {
        System.out.println(pairIndex + 1);
        System.out.flush();
        answer[pairIndex] = scanner.next().charAt(0);
        System.out.println(length - pairIndex);
        System.out.flush();
        answer[length - 1 - pairIndex] = scanner.next().charAt(0);
        if (answer[pairIndex] == answer[length - 1 - pairIndex]) {
            samePairIndex = pairIndex;
        } else {
            diffPairIndex = pairIndex;
        }
        pairIndex++;
    }

    static void handleSpecialCase() {
        if (samePairIndex != -1) {
            System.out.println(samePairIndex + 1);
            tempChar = scanner.next().charAt(0);
            if (answer[samePairIndex] != tempChar) {
                complementArray(answer);
            }
        } else {
            System.out.println(1);
            tempChar = scanner.next().charAt(0);
        }
        if (diffPairIndex != -1) {
            System.out.println(diffPairIndex + 1);
            tempChar = scanner.next().charAt(0);
            if (answer[diffPairIndex] != tempChar) {
                reverseArray(answer);
            }
        } else {
            System.out.println(1);
            tempChar = scanner.next().charAt(0);
        }
        System.out.flush();
    }
}