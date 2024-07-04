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
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
        return arr;
    }

    public static void printAnswer(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        int arraySize = scanner.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int[] arr = new int[arraySize];
            int last = -1;
            int recent = -2;
            int differentIndex = -1;
            int sameIndex = -1;
            int sameValue = -1;
            int differentValue = -1;
            boolean continueLoop = true;
            boolean checkDifferent = true;
            boolean checkSame = true;
            boolean differentChanged = false;
            boolean sameChanged = false;

            for (int i = 1; i <= 150; i++) {
                if (i != 1 && i % 10 == 1) {
                    continueLoop = false;
                    if (differentIndex != -1) checkDifferent = false;
                    if (sameIndex != -1) checkSame = false;
                    differentChanged = false;
                    sameChanged = false;
                }

                if (!continueLoop) {
                    if (!checkDifferent) {
                        checkDifferent = true;
                        recent = differentIndex;
                        System.out.println(recent + 1);
                        System.out.flush();
                        int value = scanner.nextInt();
                        if (value != differentValue) {
                            differentChanged = true;
                            differentValue = value;
                        }
                    } else if (!checkSame) {
                        checkSame = true;
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
                            arr = complete(arr, arraySize);
                            arr = reverse(arr, arraySize);
                        } else if (differentChanged && !sameChanged) {
                            arr = reverse(arr, arraySize);
                        } else if (differentChanged && sameChanged) {
                            arr = complete(arr, arraySize);
                        }
                        continueLoop = true;
                    }
                }

                if (continueLoop) {
                    if (recent == last) {
                        recent = arraySize - 1 - last;
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
                    } else {
                        last++;
                        recent = last;
                        System.out.println(recent + 1);
                        System.out.flush();
                        arr[recent] = scanner.nextInt();
                    }
                }

                if (continueLoop && recent == arraySize / 2) {
                    printAnswer(arr);
                    break;
                }
            }

            String response = scanner.next();
            if (response.equals("N")) break;
        }
    }
}