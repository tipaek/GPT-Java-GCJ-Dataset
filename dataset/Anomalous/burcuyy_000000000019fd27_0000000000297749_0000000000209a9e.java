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
            int last = -1;
            int recent = -2;
            int different = -1;
            int same = -1;
            boolean cont = true;
            boolean differentIsChecked = true;
            boolean sameIsChecked = true;
            boolean differentIsChanged = false;
            boolean sameIsChanged = false;

            for (int i = 1; i <= 150; i++) {
                if (i != 1 && i % 10 == 1) {
                    cont = false;
                    if (different != -1) differentIsChecked = false;
                    if (same != -1) sameIsChecked = false;
                    differentIsChanged = false;
                    sameIsChanged = false;
                }

                if (!cont) {
                    if (!differentIsChecked) {
                        differentIsChecked = true;
                        recent = different;
                        System.out.println(recent + 1);
                        System.out.flush();
                        int a = scan.nextInt();
                        if (a != arr[recent]) differentIsChanged = true;
                    } else if (!sameIsChecked) {
                        sameIsChecked = true;
                        recent = same;
                        System.out.println(recent + 1);
                        System.out.flush();
                        int a = scan.nextInt();
                        if (a != arr[recent]) sameIsChanged = true;
                    } else {
                        if (!differentIsChanged && sameIsChanged) {
                            arr = complete(arr, b);
                            arr = reverse(arr, b);
                        } else if (differentIsChanged && !sameIsChanged) {
                            arr = reverse(arr, b);
                        } else if (differentIsChanged && sameIsChanged) {
                            arr = complete(arr, b);
                        }
                        cont = true;
                    }
                }

                if (cont) {
                    if (recent == last) {
                        recent = b - 1 - last;
                        System.out.println(recent + 1);
                        System.out.flush();
                        arr[recent] = scan.nextInt();
                        if (different == -1 && arr[last] != arr[recent]) {
                            different = last;
                        }
                        if (same == -1 && arr[last] == arr[recent]) {
                            same = last;
                        }
                    } else {
                        last++;
                        recent = last;
                        System.out.println(recent + 1);
                        System.out.flush();
                        arr[recent] = scan.nextInt();
                    }
                }

                if (cont && recent == b / 2) {
                    answer(arr);
                    break;
                }
            }
            scan.next(); // Consume the remaining input
        }
    }
}