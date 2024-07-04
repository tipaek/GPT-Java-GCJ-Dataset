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
            arr[i] = arr[i] == 0 ? 1 : 0;
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
        int numberOfTestCases = scanner.nextInt();
        int b = scanner.nextInt();

        for (int t = 1; t <= numberOfTestCases; t++) {
            int[] array = new int[b];
            int last = -1;
            int recent = b;
            int differentIndex = -1;
            int sameIndex = -1;
            int sameValue = -1;
            int differentValue = -1;
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
                        System.out.println(differentIndex + 1);
                        System.out.flush();
                        int response = scanner.nextInt();
                        if (response != differentValue) {
                            differentChanged = true;
                            differentValue = response;
                        }
                    } else if (!sameChecked) {
                        sameChecked = true;
                        System.out.println(sameIndex + 1);
                        System.out.flush();
                        int response = scanner.nextInt();
                        if (response != sameValue) {
                            sameChanged = true;
                            sameValue = response;
                        }
                    } else {
                        if (!differentChanged && sameChanged) {
                            array = complementArray(array, b);
                            array = reverseArray(array, b);
                        } else if (differentChanged && !sameChanged) {
                            array = reverseArray(array, b);
                        } else if (differentChanged && sameChanged) {
                            array = complementArray(array, b);
                        }
                        continueProcess = true;
                    }
                }

                if (continueProcess) {
                    if (recent == last) {
                        recent = b - 1 - last;
                        System.out.println(recent + 1);
                        System.out.flush();
                        array[recent] = scanner.nextInt();
                        if (differentIndex == -1 && array[last] != array[recent]) {
                            differentIndex = last;
                            differentValue = array[differentIndex];
                        }
                        if (sameIndex == -1 && array[last] == array[recent]) {
                            sameIndex = last;
                            sameValue = array[sameIndex];
                        }
                    } else if (recent == b - 1 - last) {
                        last++;
                        recent = last;
                        System.out.println(recent + 1);
                        System.out.flush();
                        array[recent] = scanner.nextInt();
                    }
                }

                if (continueProcess && recent == b / 2) {
                    printArray(array);
                    break;
                }
            }

            String result = scanner.next();
            if (result.equals("N")) break;
        }
    }
}