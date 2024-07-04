import java.io.*;
import java.util.Scanner;

class Solution {

    public static int[] reverseArray(int[] arr, int length) {
        for (int i = 0; i < length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[length - i - 1];
            arr[length - i - 1] = temp;
        }
        return arr;
    }

    public static int[] complementArray(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value);
        }
        System.out.println();
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        int arrayLength = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int[] array = new int[arrayLength];
            int lastIndex = -1;
            int currentIndex = arrayLength;
            int differentIndex = -1;
            int sameIndex = -1;
            int sameValue = -1;
            int differentValue = -1;
            boolean continueProcessing = true;
            boolean differentIndexChecked = true;
            boolean sameIndexChecked = true;
            boolean differentIndexChanged = false;
            boolean sameIndexChanged = false;
            boolean hasAnswered = false;

            for (int query = 1; query <= 150; query++) {
                if (query != 1 && query % 10 == 1) {
                    continueProcessing = false;
                    if (differentIndex != -1) differentIndexChecked = false;
                    if (sameIndex != -1) sameIndexChecked = false;
                    differentIndexChanged = false;
                    sameIndexChanged = false;
                }

                if (!continueProcessing) {
                    if (!differentIndexChecked) {
                        differentIndexChecked = true;
                        System.out.println(differentIndex + 1);
                        System.out.flush();
                        int value = scanner.nextInt();
                        if (value != differentValue) {
                            differentIndexChanged = true;
                            differentValue = value;
                        }
                    } else if (!sameIndexChecked) {
                        sameIndexChecked = true;
                        System.out.println(sameIndex + 1);
                        System.out.flush();
                        int value = scanner.nextInt();
                        if (value != sameValue) {
                            sameIndexChanged = true;
                            sameValue = value;
                        }
                    } else {
                        if (!differentIndexChanged && sameIndexChanged) {
                            array = complementArray(array, arrayLength);
                            array = reverseArray(array, arrayLength);
                        } else if (differentIndexChanged && !sameIndexChanged) {
                            array = reverseArray(array, arrayLength);
                        } else if (differentIndexChanged && sameIndexChanged) {
                            array = complementArray(array, arrayLength);
                        }
                        continueProcessing = true;
                    }
                }

                if (continueProcessing) {
                    if (currentIndex == lastIndex) {
                        currentIndex = arrayLength - 1 - lastIndex;
                        System.out.println(currentIndex + 1);
                        System.out.flush();
                        array[currentIndex] = scanner.nextInt();
                        if (differentIndex == -1 && array[lastIndex] != array[currentIndex]) {
                            differentIndex = lastIndex;
                            differentValue = array[differentIndex];
                        }
                        if (sameIndex == -1 && array[lastIndex] == array[currentIndex]) {
                            sameIndex = lastIndex;
                            sameValue = array[sameIndex];
                        }
                    } else if (currentIndex == arrayLength - 1 - lastIndex) {
                        lastIndex++;
                        currentIndex = lastIndex;
                        System.out.println(currentIndex + 1);
                        System.out.flush();
                        array[currentIndex] = scanner.nextInt();
                    }
                }

                if (continueProcessing && currentIndex == arrayLength / 2) {
                    printArray(array);
                    hasAnswered = true;
                    break;
                }
            }

            if (!hasAnswered) {
                printArray(array);
            }

            String response = scanner.next();
            if (response.equals("N")) break;
        }
    }
}