import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);
    static int left, right;

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        int b = scanner.nextInt();
        
        for (int i = 0; i < numberOfCases; i++) {
            processCase(i, b);
            String response = scanner.next();
            if (response.equals("N")) {
                return;
            }
        }
    }

    static void processCase(int caseNumber, int size) {
        int[] answer = new int[size];
        Integer[] equalIndices = new Integer[2];
        Integer[] differentIndices = new Integer[2];
        left = 0;
        right = size - 1;

        for (int i = 0; i < 5; i++) {
            answer[left] = query(left);
            left++;
        }

        for (int i = 0; i < 5; i++) {
            answer[right] = query(right);
            if (answer[size - 1 - right] == answer[right]) {
                equalIndices[0] = size - 1 - right;
                equalIndices[1] = right;
            } else {
                differentIndices[0] = size - 1 - right;
                differentIndices[1] = right;
            }
            right--;
        }

        while (right >= left) {
            if (equalIndices[0] != null && differentIndices[0] != null) {
                handleBothEqualAndDifferent(answer, equalIndices, differentIndices);
            } else if (equalIndices[0] != null) {
                handleEqualIndices(answer, equalIndices, differentIndices);
            } else {
                handleDifferentIndices(answer, equalIndices, differentIndices);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int value : answer) {
            result.append(value);
        }
        System.out.println(result.toString());
    }

    static int query(int position) {
        System.out.println(position + 1);
        return scanner.nextInt();
    }

    static void handleBothEqualAndDifferent(int[] answer, Integer[] equalIndices, Integer[] differentIndices) {
        int equalQuery = query(equalIndices[0]);
        int differentQuery = query(differentIndices[0]);

        if (equalQuery == answer[equalIndices[0]] && differentQuery != answer[differentIndices[0]]) {
            reverseArray(answer);
        } else if (equalQuery != answer[equalIndices[0]] && differentQuery == answer[differentIndices[0]]) {
            reverseArray(answer);
            invertArray(answer);
        } else if (equalQuery != answer[equalIndices[0]]) {
            invertArray(answer);
        }

        for (int i = 0; i < 4; i++) {
            answer[left + i] = query(left + i);
            answer[right - i] = query(right - i);
        }
        left += 4;
        right -= 4;
    }

    static void handleEqualIndices(int[] answer, Integer[] equalIndices, Integer[] differentIndices) {
        if (query(equalIndices[0]) != answer[equalIndices[0]]) {
            invertArray(answer);
        }
        query(equalIndices[0]);

        for (int i = 0; i < 4; i++) {
            answer[left + i] = query(left + i);
            answer[right - i] = query(right - i);
            if (answer[left + i] != answer[right - i]) {
                differentIndices[0] = left + i;
                differentIndices[1] = right - i;
            }
        }
        left += 4;
        right -= 4;
    }

    static void handleDifferentIndices(int[] answer, Integer[] equalIndices, Integer[] differentIndices) {
        if (query(differentIndices[0]) != answer[differentIndices[0]]) {
            reverseArray(answer);
        }
        query(differentIndices[0]);

        for (int i = 0; i < 4; i++) {
            answer[left + i] = query(left + i);
            answer[right - i] = query(right - i);
            if (answer[left + i] == answer[right - i]) {
                equalIndices[0] = left + i;
                equalIndices[1] = right - i;
            }
        }
        left += 4;
        right -= 4;
    }

    static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            swap(array, i, array.length - 1 - i);
        }
        int temp = left;
        left = array.length - 1 - right;
        right = array.length - 1 - temp;
    }

    static void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] + 1) % 2;
        }
    }
}