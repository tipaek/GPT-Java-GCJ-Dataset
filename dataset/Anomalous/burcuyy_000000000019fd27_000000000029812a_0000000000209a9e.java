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
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        return arr;
    }

    public static void display(int[] arr) {
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

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int[] arr = new int[b];
            int last = -1;
            int recent = -2;
            int different = -1;
            int same = -1;
            int sameValue = -1;
            int differentValue = -1;
            boolean continueQuery = true;
            boolean differentChecked = true;
            boolean sameChecked = true;
            boolean differentChanged = false;
            boolean sameChanged = false;

            for (int i = 1; i <= 150; i++) {
                if (i != 1 && i % 10 == 1) {
                    continueQuery = false;
                    if (different != -1) differentChecked = false;
                    if (same != -1) sameChecked = false;
                    differentChanged = false;
                    sameChanged = false;
                }

                if (!continueQuery) {
                    if (!differentChecked) {
                        differentChecked = true;
                        recent = different;
                        System.out.println(recent + 1);
                        System.out.flush();
                        int response = scanner.nextInt();
                        if (response != differentValue) differentChanged = true;
                    } else if (!sameChecked) {
                        sameChecked = true;
                        recent = same;
                        System.out.println(recent + 1);
                        System.out.flush();
                        int response = scanner.nextInt();
                        if (response != sameValue) sameChanged = true;
                    } else {
                        if (!differentChanged && sameChanged) {
                            arr = complete(arr, b);
                            arr = reverse(arr, b);
                        } else if (differentChanged && !sameChanged) {
                            arr = reverse(arr, b);
                        } else if (differentChanged && sameChanged) {
                            arr = complete(arr, b);
                        }
                        continueQuery = true;
                    }
                }

                if (continueQuery) {
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
                    } else {
                        last++;
                        recent = last;
                        System.out.println(recent + 1);
                        System.out.flush();
                        arr[recent] = scanner.nextInt();
                    }
                }

                if (continueQuery && recent == b / 2) {
                    display(arr);
                    break;
                }
            }
            scanner.next();
        }
    }
}