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
            int recent = b;
            int different = -1;
            int same = -1;
            int sameValue = -1;
            int differentValue = -1;
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
                        if (a != differentValue) {
                            differentIsChanged = true;
                            differentValue = a;
                        }
                    } else if (!sameIsChecked) {
                        sameIsChecked = true;
                        recent = same;
                        System.out.println(recent + 1);
                        System.out.flush();
                        int a = scan.nextInt();
                        if (a != sameValue) {
                            sameIsChanged = true;
                            sameValue = a;
                        }
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
                        arr[recent] = scan.nextInt();
                    } else {
                        recent = b - 1 - last;
                        System.out.println(recent + 1);
                        System.out.flush();
                        arr[recent] = scan.nextInt();
                        if (different == -1 && arr[last] != arr[recent]) {
                            different = last;
                            differentValue = arr[different];
                        }
                        if (same == -1 && arr[last] == arr[recent]) {
                            same = last;
                            sameValue = arr[same];
                        }
                    }
                }

                if (cont && recent == b / 2) {
                    answer(arr);
                    break;
                }
            }

            String response = scan.next();
            if (response.equals("N")) break;
        }
    }
}