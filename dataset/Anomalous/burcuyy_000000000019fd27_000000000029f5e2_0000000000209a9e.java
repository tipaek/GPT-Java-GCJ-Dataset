import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scan.nextInt();
        int b = scan.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int[] arr = new int[b];
            int left = -1, right = b;
            int diffIdx = -1, sameIdx = -1;
            int diffVal = -1, sameVal = -1;
            boolean continueQuery = true;
            boolean diffChecked = true, sameChecked = true;
            boolean diffChanged = false, sameChanged = false;

            for (int i = 1; i <= 150; i++) {
                if (i != 1 && i % 10 == 0) {
                    continueQuery = false;
                    diffChecked = diffIdx == -1;
                    sameChecked = sameIdx == -1;
                    diffChanged = false;
                    sameChanged = false;
                }

                if (!continueQuery) {
                    if (!diffChecked) {
                        diffChecked = true;
                        System.out.println(diffIdx + 1);
                        System.out.flush();
                        int val = scan.nextInt();
                        if (val != diffVal) {
                            diffChanged = true;
                            diffVal = val;
                        }
                    } else if (!sameChecked) {
                        sameChecked = true;
                        System.out.println(sameIdx + 1);
                        System.out.flush();
                        int val = scan.nextInt();
                        if (val != sameVal) {
                            sameChanged = true;
                            sameVal = val;
                        }
                    } else {
                        if (!diffChanged && sameChanged) {
                            arr = complete(arr, b);
                            arr = reverse(arr, b);
                        } else if (diffChanged && !sameChanged) {
                            arr = reverse(arr, b);
                        } else if (diffChanged && sameChanged) {
                            arr = complete(arr, b);
                        }
                        continueQuery = true;
                    }
                }

                if (continueQuery) {
                    if (right == left) {
                        right = b - 1 - left;
                        System.out.println(right + 1);
                        System.out.flush();
                        arr[right] = scan.nextInt();
                        if (diffIdx == -1 && arr[left] != arr[right]) {
                            diffIdx = left;
                            diffVal = arr[diffIdx];
                        }
                        if (sameIdx == -1 && arr[left] == arr[right]) {
                            sameIdx = left;
                            sameVal = arr[sameIdx];
                        }
                    } else if (right == b - 1 - left) {
                        left++;
                        right = left;
                        System.out.println(right + 1);
                        System.out.flush();
                        arr[right] = scan.nextInt();
                    }
                }

                if (continueQuery && right == b / 2) {
                    printArray(arr);
                    break;
                }
            }
            String result = scan.next();
            if (result.equals("N")) break;
        }
    }
}