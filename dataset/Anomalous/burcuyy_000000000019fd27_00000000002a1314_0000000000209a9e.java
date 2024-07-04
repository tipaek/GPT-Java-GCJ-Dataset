import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int[] arr = new int[arraySize];
            int last = -1;
            int recent = arraySize;
            int differentIndex = -1;
            int sameIndex = -1;
            int sameValue = -1;
            int differentValue = -1;
            boolean continueLoop = true;
            boolean differentChecked = true;
            boolean sameChecked = true;
            boolean differentChanged = false;
            boolean sameChanged = false;
            boolean answered = false;
            
            for (int i = 1; i <= 150; i++) {
                if (i != 1 && i % 10 == 1) {
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
                        int input = scanner.nextInt();
                        if (input != differentValue) {
                            differentChanged = true;
                            differentValue = input;
                        }
                    } else if (!sameChecked) {
                        sameChecked = true;
                        System.out.println(sameIndex + 1);
                        System.out.flush();
                        int input = scanner.nextInt();
                        if (input != sameValue) {
                            sameChanged = true;
                            sameValue = input;
                        }
                    } else {
                        if (!differentChanged && sameChanged) {
                            arr = complementArray(arr, arraySize);
                            arr = reverseArray(arr, arraySize);
                        } else if (differentChanged && !sameChanged) {
                            arr = reverseArray(arr, arraySize);
                        } else if (differentChanged && sameChanged) {
                            arr = complementArray(arr, arraySize);
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
                    } else if (recent == arraySize - 1 - last) {
                        last++;
                        recent = last;
                        System.out.println(recent + 1);
                        System.out.flush();
                        arr[recent] = scanner.nextInt();
                    }
                }
                
                if (continueLoop && recent == arraySize / 2) {
                    printArray(arr);
                    answered = true;
                    break;
                }
            }
            
            if (!answered) printArray(arr);
            String response = scanner.next();
            if (response.equals("N")) break;
        }
    }
}