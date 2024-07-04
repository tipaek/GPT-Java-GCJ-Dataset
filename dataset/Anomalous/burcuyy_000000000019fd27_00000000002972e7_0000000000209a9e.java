import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    
    public static int[] reverseArray(int[] array, int length) {
        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
        return array;
    }

    public static int[] complementArray(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i);
        }
        System.out.println();
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int arrayLength = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int[] array = new int[arrayLength];
            int lastIndex = -1;
            int currentIndex = -2;
            int differentIndex = -1;
            int sameIndex = -1;
            boolean continueProcess = true;
            boolean differentChecked = true;
            boolean sameChecked = true;
            boolean differentChanged = false;
            boolean sameChanged = false;

            for (int i = 1; i <= 150; i++) {
                if (i != 1 && i % 10 == 1) {
                    continueProcess = false;
                    if (differentIndex != -1) differentChecked = false;
                    if (sameIndex != -1) sameChecked = false;
                    differentChanged = false;
                    sameChanged = false;
                }

                if (!continueProcess) {
                    if (!differentChecked) {
                        differentChecked = true;
                        currentIndex = differentIndex;
                        System.out.println(currentIndex + 1);
                        System.out.flush();
                        int response = scanner.nextInt();
                        if (response != array[currentIndex]) differentChanged = true;
                    } else if (!sameChecked) {
                        sameChecked = true;
                        currentIndex = sameIndex;
                        System.out.println(currentIndex + 1);
                        System.out.flush();
                        int response = scanner.nextInt();
                        if (response != array[currentIndex]) sameChanged = true;
                    } else {
                        if (!differentChanged && sameChanged) {
                            array = complementArray(array, arrayLength);
                            array = reverseArray(array, arrayLength);
                        } else if (differentChanged && !sameChanged) {
                            array = reverseArray(array, arrayLength);
                        } else if (differentChanged && sameChanged) {
                            array = complementArray(array, arrayLength);
                        }
                        continueProcess = true;
                    }
                }

                if (continueProcess) {
                    if (currentIndex == lastIndex) {
                        currentIndex = arrayLength - 1 - lastIndex;
                        System.out.println(currentIndex + 1);
                        System.out.flush();
                        array[currentIndex] = scanner.nextInt();
                        if (differentIndex == -1 && array[lastIndex] != array[currentIndex]) {
                            differentIndex = lastIndex;
                        }
                        if (sameIndex == -1 && array[lastIndex] == array[currentIndex]) {
                            sameIndex = lastIndex;
                        }
                    } else {
                        lastIndex++;
                        currentIndex = lastIndex;
                        System.out.println(currentIndex + 1);
                        System.out.flush();
                        array[currentIndex] = scanner.nextInt();
                    }
                }

                if (continueProcess && currentIndex == arrayLength / 2) {
                    printArray(array);
                    break;
                }
            }
        }
    }
}