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
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        return arr;
    }

    public static void answer(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scan.nextInt();
        int b = scan.nextInt();

        for (int n = 1; n <= numberOfTestCases; n++) {
            int[] arr = new int[b];
            int lastIndex = -1;
            int recentIndex = -2;
            int differentIndex = -1;
            int sameIndex = -1;
            int sameValue = -1;
            int differentValue = -1;
            boolean continueFlag = true;
            boolean differentChecked = true;
            boolean sameChecked = true;
            boolean differentChanged = false;
            boolean sameChanged = false;

            for (int i = 1; i <= 150; i++) {
                if (i != 1 && i % 10 == 1) {
                    continueFlag = false;
                    if (differentIndex != -1) differentChecked = false;
                    if (sameIndex != -1) sameChecked = false;
                    differentChanged = false;
                    sameChanged = false;
                }

                if (!continueFlag) {
                    if (!differentChecked) {
                        differentChecked = true;
                        recentIndex = differentIndex;
                        System.out.println(recentIndex + 1);
                        System.out.flush();
                        int a = scan.nextInt();
                        if (a != differentValue) {
                            differentChanged = true;
                            differentValue = a;
                            arr[differentIndex] = differentValue;
                        }
                    } else if (!sameChecked) {
                        sameChecked = true;
                        recentIndex = sameIndex;
                        System.out.println(recentIndex + 1);
                        System.out.flush();
                        int a = scan.nextInt();
                        if (a != sameValue) {
                            sameChanged = true;
                            sameValue = a;
                            arr[sameIndex] = sameValue;
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
                        continueFlag = true;
                    }
                }

                if (continueFlag) {
                    if (recentIndex == lastIndex) {
                        recentIndex = b - 1 - lastIndex;
                        System.out.println(recentIndex + 1);
                        System.out.flush();
                        arr[recentIndex] = scan.nextInt();
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
                        arr[recentIndex] = scan.nextInt();
                    }
                }

                if (continueFlag && recentIndex == b / 2) {
                    answer(arr);
                    break;
                }
            }

            String response = scan.next();
            if (response.equals("N")) break;
        }
    }
}