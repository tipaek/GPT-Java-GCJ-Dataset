import java.io.*;
import java.util.Scanner;

class Solution {
    public static int[] reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = tmp;
        }
        return arr;
    }

    public static int[] complete(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
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
        int testCases = scan.nextInt();
        int b = scan.nextInt();

        for (int t = 0; t < testCases; t++) {
            int[] arr = new int[b];
            int last = -1, recent = b;
            int differentIndex = -1, sameIndex = -1;
            int differentValue = -1, sameValue = -1;
            boolean cont = true, differentChecked = true, sameChecked = true;
            boolean differentChanged = false, sameChanged = false;

            for (int i = 1; i <= 150; i++) {
                if (i != 1 && i % 10 == 1) {
                    cont = false;
                    if (differentIndex != -1) differentChecked = false;
                    if (sameIndex != -1) sameChecked = false;
                    differentChanged = false;
                    sameChanged = false;
                }

                if (!cont) {
                    if (!differentChecked) {
                        differentChecked = true;
                        System.out.println(differentIndex + 1);
                        System.out.flush();
                        int value = scan.nextInt();
                        if (value != differentValue) {
                            differentChanged = true;
                            differentValue = value;
                        }
                    } else if (!sameChecked) {
                        sameChecked = true;
                        System.out.println(sameIndex + 1);
                        System.out.flush();
                        int value = scan.nextInt();
                        if (value != sameValue) {
                            sameChanged = true;
                            sameValue = value;
                        }
                    } else {
                        if (!differentChanged && sameChanged) {
                            arr = complete(arr);
                            arr = reverse(arr);
                        } else if (differentChanged && !sameChanged) {
                            arr = reverse(arr);
                        } else if (differentChanged && sameChanged) {
                            arr = complete(arr);
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
                        arr[recent] = scan.nextInt();
                    }
                }

                if (cont && recent == b / 2) {
                    answer(arr);
                    break;
                }
            }

            String result = scan.next();
            if (result.equals("N")) break;
        }
    }
}