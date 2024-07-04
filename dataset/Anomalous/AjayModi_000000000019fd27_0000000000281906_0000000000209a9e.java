import java.util.*;

public class Solution4 {
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
                for (int i = 0; i < 5; i++) {
                    System.out.println(i + 1);
                    temp[i] = scanner.nextInt();
                }

                for (int arrNum = 1; arrNum <= 4; arrNum++) {
                    int[] currentArray = null;
                    switch (arrNum) {
                        case 1: currentArray = arr1; break;
                        case 2: currentArray = arr2; break;
                        case 3: currentArray = arr3; break;
                        case 4: currentArray = arr4; break;
                    }

                    int filledIndex = findFilledIndex(currentArray);
                    if (filledIndex == 0) {
                        System.arraycopy(temp, 0, currentArray, 0, 5);
                        for (int i = 5; i < 10; i++) {
                            System.out.println(i + 1);
                            currentArray[i] = scanner.nextInt();
                        }
                        ch += 5;
                        if (findFilledIndex(currentArray) == b - 1) {
                            printArray(currentArray);
                            if (scanner.next().equals("N")) {
                                break outerLoop;
                            }
                            break;
                        }
                        break;
                    } else if (filledIndex == b - 1) {
                        printArray(currentArray);
                        if (scanner.next().equals("N")) {
                            break outerLoop;
                        }
                        break;
                    } else {
                        if (isMatch(currentArray, temp)) {
                            for (int i = filledIndex; i < filledIndex + 5; i++) {
                                System.out.println(i + 1);
                                currentArray[i] = scanner.nextInt();
                            }
                            ch += 5;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static boolean isMatch(int[] arr, int[] temp) {
        for (int i = 0; i < 5; i++) {
            if (arr[i] != temp[i]) {
                return false;
            }
        }
        return true;
    }

    private static int findFilledIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return arr.length - 1;
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value);
        }
        System.out.println();
    }
}