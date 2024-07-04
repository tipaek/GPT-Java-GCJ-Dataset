import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int size = sc.nextInt();
        sc.nextLine();

        for (int n = 1; n <= cases; n++) {
            int[] arr = new int[size];
            int diffP = -1, eqP = -1;

            for (int j = 0; j < size / 10; j++) {
                for (int i = 1; i <= 5; i++) {
                    arr[i - 1] = queryAndRead(sc, i);
                    arr[size - i] = queryAndRead(sc, size - i + 1);

                    if (eqP == -1 && arr[i - 1] == arr[size - i]) {
                        eqP = i;
                    }
                    if (diffP == -1 && arr[i - 1] != arr[size - i]) {
                        diffP = i;
                    }
                }
                if (eqP != -1 && diffP != -1) break;
            }

            clearArray(arr, eqP, diffP);

            if (eqP != -1 && diffP != -1) {
                solveNormalCase(arr, eqP, diffP, sc);
            } else if (eqP != -1 && diffP == -1) {
                solveEqualCase(arr, eqP, sc);
            } else if (eqP == -1 && diffP != -1) {
                solveDiffCase(arr, diffP, sc);
            }

            printArray(arr);
            if (!sc.nextLine().equals("Y")) break;
        }
    }

    private static int queryAndRead(Scanner sc, int position) {
        System.out.println(position);
        return Integer.parseInt(sc.nextLine());
    }

    private static void clearArray(int[] arr, int p1, int p2) {
        for (int i = 0; i < arr.length; i++) {
            if (i == p1 - 1 || i == p2 - 1 || i == arr.length - p1 || i == arr.length - p2) continue;
            arr[i] = -1;
        }
    }

    private static void solveNormalCase(int[] arr, int eqP, int diffP, Scanner sc) {
        int counter = 1, acc = 0;
        while (counter <= arr.length / 2 && acc != 10) {
            acc = 0;
            int eqC = arr[eqP - 1];
            int diffC = arr[diffP - 1];

            int eq1 = queryAndRead(sc, eqP);
            int diff1 = queryAndRead(sc, diffP);
            acc = 2;

            if (eq1 != eqC) {
                invertArray(arr);
                if (diff1 == diffC) {
                    reverseArray(arr);
                }
            } else if (diff1 != diffC) {
                reverseArray(arr);
            }

            for (int i = 0; i < 4; i++) {
                while (counter == eqP || counter == diffP) counter++;
                if (counter > arr.length / 2) break;

                arr[counter - 1] = queryAndRead(sc, counter);
                arr[arr.length - counter] = queryAndRead(sc, arr.length - counter + 1);
                counter++;
                acc += 2;
            }
        }
    }

    private static void solveEqualCase(int[] arr, int eqP, Scanner sc) {
        int counter = 1, acc = 0;
        while (counter <= arr.length / 2 && acc != 10) {
            acc = 0;
            int eqC = arr[eqP - 1];

            int eq1 = queryAndRead(sc, eqP);
            eq1 = queryAndRead(sc, eqP);
            acc = 2;

            if (eq1 != eqC) {
                invertArray(arr);
            }

            for (int i = 0; i < 4; i++) {
                while (counter == eqP) counter++;
                if (counter > arr.length / 2) break;

                arr[counter - 1] = queryAndRead(sc, counter);
                arr[arr.length - counter] = queryAndRead(sc, arr.length - counter + 1);
                counter++;
                acc += 2;
            }
        }
    }

    private static void solveDiffCase(int[] arr, int diffP, Scanner sc) {
        int counter = 1, acc = 0;
        while (counter <= arr.length / 2 && acc != 10) {
            acc = 0;
            int diffC = arr[diffP - 1];

            int diff1 = queryAndRead(sc, diffP);
            diff1 = queryAndRead(sc, diffP);
            acc = 2;

            if (diff1 != diffC) {
                invertArray(arr);
            }

            for (int i = 0; i < 4; i++) {
                while (counter == diffP) counter++;
                if (counter > arr.length / 2) break;

                arr[counter - 1] = queryAndRead(sc, counter);
                arr[arr.length - counter] = queryAndRead(sc, arr.length - counter + 1);
                counter++;
                acc += 2;
            }
        }
    }

    private static void invertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 1 ? 0 : 1;
        }
    }

    private static void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        System.out.println(sb.toString());
    }
}