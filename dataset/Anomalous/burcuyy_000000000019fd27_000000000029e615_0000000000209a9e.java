import java.io.*;
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

    public static int[] complementArray(int[] arr, int n) {
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
            int last = -1;
            int recent = b;
            int differentIndex = -1;
            int sameIndex = -1;
            int sameValue = -1;
            int differentValue = -1;
            boolean continueProcessing = true;
            boolean differentChecked = true;
            boolean sameChecked = true;
            boolean differentChanged = false;
            boolean sameChanged = false;

            for (int i = 1; i <= 150; i++) {
                if (!continueProcessing) {
                    if (!differentChecked) {
                        differentChecked = true;
                        recent = differentIndex;
                        System.out.println(recent + 1);
                        System.out.flush();
                        int value = scanner.nextInt();
                        if (value != differentValue) {
                            differentChanged = true;
                            differentValue = value;
                        }
                    } else if (!sameChecked) {
                        sameChecked = true;
                        recent = sameIndex;
                        System.out.println(recent + 1);
                        System.out.flush();
                        int value = scanner.nextInt();
                        if (value != sameValue) {
                            sameChanged = true;
                            sameValue = value;
                        }
                    } else {
                        if (!differentChanged && sameChanged) {
                            arr = complementArray(arr, b);
                            arr = reverseArray(arr, b);
                        } else if (differentChanged && !sameChanged) {
                            arr = reverseArray(arr, b);
                        } else if (differentChanged && sameChanged) {
                            arr = complementArray(arr, b);
                        }
                        continueProcessing = true;
                    }
                }

                if (continueProcessing) {
                    if (recent == last) {
                        recent = b - 1 - last;
                        System.out.println(recent + 1);
                        System.out.flush();
                        arr[recent] = scanner.nextInt();
                        if (differentIndex == -1 && arr[last] != arr[recent]) {
                            differentIndex = last;
                            differentValue = arr[differentIndex];
                        }
                        if (sameIndex == -1 && arr[last] == arr[recent]) {
                            sameIndex = last;
                            sameValue = arr[sameIndex];
                        }
                    } else if (recent == b - 1 - last) {
                        last++;
                        recent = last;
                        System.out.println(recent + 1);
                        System.out.flush();
                        arr[recent] = scanner.nextInt();
                    } else {
                        recent = b - 1 - last;
                        System.out.println(recent + 1);
                        System.out.flush();
                        arr[recent] = scanner.nextInt();
                        if (differentIndex == -1 && arr[last] != arr[recent]) {
                            differentIndex = last;
                            differentValue = arr[differentIndex];
                        }
                        if (sameIndex == -1 && arr[last] == arr[recent]) {
                            sameIndex = last;
                            sameValue = arr[sameIndex];
                        }
                    }
                }

                if (continueProcessing && recent == b / 2) {
                    printArray(arr);
                    break;
                }

                if (i != 1 && i % 10 == 1) {
                    continueProcessing = false;
                    if (differentIndex != -1) differentChecked = false;
                    if (sameIndex != -1) sameChecked = false;
                    differentChanged = false;
                    sameChanged = false;
                }
            }

            String result = scanner.next();
            if (result.equals("N")) break;
        }
    }
}