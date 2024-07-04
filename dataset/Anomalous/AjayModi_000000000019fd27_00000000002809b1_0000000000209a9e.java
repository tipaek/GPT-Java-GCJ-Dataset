import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        outerLoop:
        for (int it = 1; it <= t; it++) {
            int[] arr1 = new int[b];
            int[] arr2 = new int[b];
            int[] arr3 = new int[b];
            int[] arr4 = new int[b];
            Arrays.fill(arr1, -1);
            Arrays.fill(arr2, -1);
            Arrays.fill(arr3, -1);
            Arrays.fill(arr4, -1);

            for (int ch = 1; ch <= 150; ch += 5) {
                int[] temp = new int[5];
                for (int inp = 0; inp < 5; inp++) {
                    System.out.println((inp + 1));
                    temp[inp] = scanner.nextInt();
                }

                for (int chearr = 1; chearr <= 4; chearr++) {
                    int[] currentArray = null;
                    switch (chearr) {
                        case 1:
                            currentArray = arr1;
                            break;
                        case 2:
                            currentArray = arr2;
                            break;
                        case 3:
                            currentArray = arr3;
                            break;
                        case 4:
                            currentArray = arr4;
                            break;
                    }

                    int ind = filled(currentArray);
                    if (ind == 0) {
                        System.arraycopy(temp, 0, currentArray, 0, 5);
                        for (int inp = 5; inp < 10; inp++) {
                            currentArray[inp] = scanner.nextInt();
                        }
                        ch += 5;
                        if (filled(currentArray) == b - 1) {
                            printArray(currentArray);
                            if (scanner.next().equals("N")) {
                                break outerLoop;
                            }
                            break;
                        }
                    } else if (ind == b - 1) {
                        printArray(currentArray);
                        if (scanner.next().equals("N")) {
                            break outerLoop;
                        }
                        break;
                    } else {
                        if (match(currentArray, temp)) {
                            for (int inp = ind; inp < ind + 5; inp++) {
                                currentArray[inp] = scanner.nextInt();
                            }
                            ch += 5;
                            break;
                        }
                    }
                }
            }
        }
    }

    public static boolean match(int[] arr, int[] temp) {
        for (int i = 0; i < 5; i++) {
            if (arr[i] != temp[i]) {
                return false;
            }
        }
        return true;
    }

    public static int filled(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return arr.length - 1;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value);
        }
        System.out.println();
    }
}