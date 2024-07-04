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

    public static int[] toggleBits(int[] arr, int n) {
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
            int different = -1;
            int same = -1;
            int sameValue = -1;
            int differentValue = -1;
            boolean continueProcessing = true;
            boolean differentChecked = true;
            boolean sameChecked = true;
            boolean differentChanged = false;
            boolean sameChanged = false;

            for (int i = 1; i <= 150; i++) {
                if (i != 2 && i % 10 == 2) {
                    continueProcessing = false;
                    if (different != -1) differentChecked = false;
                    if (same != -1) sameChecked = false;
                    differentChanged = false;
                    sameChanged = false;
                }

                if (!continueProcessing) {
                    if (!differentChecked) {
                        differentChecked = true;
                        System.out.println(different + 1);
                        System.out.flush();
                        int response = scanner.nextInt();
                        if (response != differentValue) {
                            differentChanged = true;
                            differentValue = response;
                        }
                    } else if (!sameChecked) {
                        sameChecked = true;
                        System.out.println(same + 1);
                        System.out.flush();
                        int response = scanner.nextInt();
                        if (response != sameValue) {
                            sameChanged = true;
                            sameValue = response;
                        }
                    } else {
                        if (!differentChanged && sameChanged) {
                            arr = toggleBits(arr, b);
                            arr = reverseArray(arr, b);
                        } else if (differentChanged && !sameChanged) {
                            arr = reverseArray(arr, b);
                        } else if (differentChanged && sameChanged) {
                            arr = toggleBits(arr, b);
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
                        if (different == -1 && arr[last] != arr[recent]) {
                            different = last;
                            differentValue = arr[different];
                        }
                        if (same == -1 && arr[last] == arr[recent]) {
                            same = last;
                            sameValue = arr[same];
                        }
                    } else if (recent == b - 1 - last) {
                        last++;
                        recent = last;
                        System.out.println(recent + 1);
                        System.out.flush();
                        arr[recent] = scanner.nextInt();
                    }
                }

                if (continueProcessing && recent == b / 2) {
                    printArray(arr);
                    break;
                }
            }

            String result = scanner.next();
            if (result.equals("N")) break;
        }
    }
}