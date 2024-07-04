import java.util.*;

public class Main {
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

            innerLoop:
            for (int ch = 1; ch <= 150; ch += 5) {
                int[] temp = new int[5];
                for (int inp = 0; inp < 5; inp++) {
                    System.out.println((inp + 1));
                    temp[inp] = scanner.nextInt();
                }

                for (int chearr = 1; chearr <= 4; chearr++) {
                    int[] currentArr = null;
                    switch (chearr) {
                        case 1:
                            currentArr = arr1;
                            break;
                        case 2:
                            currentArr = arr2;
                            break;
                        case 3:
                            currentArr = arr3;
                            break;
                        case 4:
                            currentArr = arr4;
                            break;
                    }

                    int ind = filled(currentArr);
                    if (ind == 0) {
                        System.arraycopy(temp, 0, currentArr, 0, 5);
                        for (int inp = 5; inp < 10; inp++) {
                            System.out.println((inp + 1));
                            currentArr[inp] = scanner.nextInt();
                        }
                        ch += 5;
                        if (filled(currentArr) == b) {
                            printArray(currentArr);
                            if (scanner.next().equals("N")) {
                                break outerLoop;
                            } else {
                                break innerLoop;
                            }
                        }
                        break;
                    } else if (ind == b) {
                        printArray(currentArr);
                        if (scanner.next().equals("N")) {
                            break outerLoop;
                        } else {
                            break innerLoop;
                        }
                    } else if (match(currentArr, temp)) {
                        int fillin = filled(currentArr);
                        for (int inp = fillin; inp < fillin + 5; inp++) {
                            System.out.println(inp + 1);
                            currentArr[inp] = scanner.nextInt();
                        }
                        ch += 5;
                        break;
                    }
                }
            }
        }
    }

    public static int match(int[] arr, int[] temp) {
        for (int i = 0; i < 5; i++) {
            if (arr[i] != temp[i]) {
                return 0; // not matched
            }
        }
        return 1; // matched
    }

    public static int filled(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return arr.length; // all elements filled
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }
}