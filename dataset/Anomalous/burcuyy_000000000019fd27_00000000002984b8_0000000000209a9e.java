import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    public static int[] reverseArray(int[] arr, int n) {
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        return arr;
    }

    public static int[] toggleBits(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int b = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int[] arr = new int[b];
            int lastIndex = -1;
            int recentIndex = -2;
            int differentIndex = -1;
            int sameIndex = -1;
            int sameValue = -1;
            int differentValue = -1;
            boolean continueReading = true;
            boolean differentChecked = true;
            boolean sameChecked = true;
            boolean differentChanged = false;
            boolean sameChanged = false;

            for (int i = 1; i <= 150; i++) {
                if (i != 1 && i % 10 == 1) {
                    continueReading = false;
                    if (differentIndex != -1) differentChecked = false;
                    if (sameIndex != -1) sameChecked = false;
                    differentChanged = false;
                    sameChanged = false;
                }

                if (!continueReading) {
                    if (!differentChecked) {
                        differentChecked = true;
                        recentIndex = differentIndex;
                        System.out.println(recentIndex + 1);
                        System.out.flush();
                        int response = scanner.nextInt();
                        if (response != differentValue) differentChanged = true;
                    } else if (!sameChecked) {
                        sameChecked = true;
                        recentIndex = sameIndex;
                        System.out.println(recentIndex + 1);
                        System.out.flush();
                        int response = scanner.nextInt();
                        if (response != sameValue) sameChanged = true;
                    } else {
                        if (!differentChanged && sameChanged) {
                            arr = toggleBits(arr, b);
                            arr = reverseArray(arr, b);
                        } else if (differentChanged && !sameChanged) {
                            arr = reverseArray(arr, b);
                        } else if (differentChanged && sameChanged) {
                            arr = toggleBits(arr, b);
                        }
                        continueReading = true;
                    }
                }

                if (continueReading) {
                    if (recentIndex == lastIndex) {
                        recentIndex = b - 1 - lastIndex;
                        System.out.println(recentIndex + 1);
                        System.out.flush();
                        arr[recentIndex] = scanner.nextInt();
                        if (differentIndex == -1 && arr[lastIndex] != arr[recentIndex]) {
                            differentIndex = lastIndex;
                            differentValue = arr[differentIndex];
                        }
                        if (sameIndex == -1 && arr[lastIndex] == arr[recentIndex]) {
                            sameIndex = lastIndex;
                            sameValue = arr[sameIndex];
                        }
                    } else {
                        lastIndex++;
                        recentIndex = lastIndex;
                        System.out.println(recentIndex + 1);
                        System.out.flush();
                        arr[recentIndex] = scanner.nextInt();
                    }
                }

                if (continueReading && recentIndex == b / 2) {
                    printArray(arr);
                    break;
                }
            }

            String result = scanner.next();
            if (result.equals("N")) break;
        }
    }
}