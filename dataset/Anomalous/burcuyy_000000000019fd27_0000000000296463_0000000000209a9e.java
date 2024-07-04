import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    public static int[] reverse(int[] arr, int n) {
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        return arr;
    }

    public static int[] complete(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
        return arr;
    }

    public static void answer(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int arrayLength = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int[] array = new int[arrayLength];
            int lastIndex = -1;
            int currentIndex = -2;
            int diffIndex = -1;
            int sameIndex = -1;
            boolean continueLoop = true;
            boolean checkDiff = true;
            boolean checkSame = true;
            boolean diffChanged = false;
            boolean sameChanged = false;

            for (int i = 1; i <= 150; i++) {
                if (i != 1 && i % 10 == 1) {
                    continueLoop = false;
                    if (diffIndex != -1) checkDiff = false;
                    if (sameIndex != -1) checkSame = false;
                    diffChanged = false;
                    sameChanged = false;
                }

                if (!continueLoop) {
                    if (!checkDiff) {
                        checkDiff = true;
                        currentIndex = diffIndex;
                        System.out.println(currentIndex);
                        int value = scanner.nextInt();
                        if (value != array[currentIndex]) diffChanged = true;
                    } else if (!checkSame) {
                        checkSame = true;
                        currentIndex = sameIndex;
                        System.out.println(currentIndex);
                        int value = scanner.nextInt();
                        if (value != array[currentIndex]) sameChanged = true;
                    } else {
                        if (!diffChanged && sameChanged) {
                            array = complete(array, arrayLength);
                            array = reverse(array, arrayLength);
                        } else if (diffChanged && !sameChanged) {
                            array = reverse(array, arrayLength);
                        } else if (diffChanged && sameChanged) {
                            array = complete(array, arrayLength);
                        }
                        continueLoop = true;
                    }
                }

                if (continueLoop) {
                    if (currentIndex == lastIndex) {
                        currentIndex = arrayLength - 1 - lastIndex;
                        System.out.println(currentIndex);
                        array[currentIndex] = scanner.nextInt();
                        if (diffIndex == -1 && array[lastIndex] != array[currentIndex]) {
                            diffIndex = lastIndex;
                        }
                        if (sameIndex == -1 && array[lastIndex] == array[currentIndex]) {
                            sameIndex = lastIndex;
                        }
                    } else {
                        lastIndex++;
                        currentIndex = lastIndex;
                        System.out.println(currentIndex);
                        array[currentIndex] = scanner.nextInt();
                    }
                }

                if (continueLoop && currentIndex == arrayLength / 2) {
                    answer(array);
                    break;
                }
            }
        }
    }
}