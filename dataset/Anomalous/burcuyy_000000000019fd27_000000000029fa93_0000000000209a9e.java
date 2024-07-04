import java.io.*;
import java.util.Scanner;

class Solution {

    public static int[] reverse(int[] arr, int n) {
        for (int i = 0; i < n / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = tmp;
        }
        return arr;
    }

    public static int[] complete(int[] arr, int n) {
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
        int testCases = scanner.nextInt();
        int b = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int[] arr = new int[b];
            int last = -1;
            int recent = b;
            int differentIndex = -1;
            int sameIndex = -1;
            int sameValue = -1;
            int differentValue = -1;
            boolean continueLoop = true;
            boolean differentChecked = true;
            boolean sameChecked = true;
            boolean differentChanged = false;
            boolean sameChanged = false;

            for (int i = 1; i <= 150; i++) {
                if (i % 10 == 3) {
                    continueLoop = false;
                    if (differentIndex != -1) differentChecked = false;
                    if (sameIndex != -1) sameChecked = false;
                    differentChanged = false;
                    sameChanged = false;
                }

                if (!continueLoop) {
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
                            arr = complete(arr, b);
                            arr = reverse(arr, b);
                        } else if (differentChanged && !sameChanged) {
                            arr = reverse(arr, b);
                        } else if (differentChanged && sameChanged) {
                            arr = complete(arr, b);
                        }
                        continueLoop = true;
                    }
                }

                if (continueLoop) {
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
                    }
                }

                if (continueLoop && recent == b / 2) {
                    printArray(arr);
                    break;
                }
            }

            String result = scanner.next();
            if (result.equals("N")) break;
        }
    }
}