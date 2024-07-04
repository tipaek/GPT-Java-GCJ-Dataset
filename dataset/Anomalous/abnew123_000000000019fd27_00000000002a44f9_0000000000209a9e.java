import java.util.Scanner;

public class Solution {
    public static void solve(Scanner input, int B) {
        // Implementation goes here
    }

    private static void fixData(int switchCase, boolean[] data) {
        if (switchCase == 1 || switchCase == 3) {
            reverseArray(data);
        }
        if (switchCase == 2 || switchCase == 3) {
            invertArray(data);
        }
    }

    private static void reverseArray(boolean[] data) {
        int length = data.length;
        for (int i = 0; i < length / 2; i++) {
            boolean temp = data[i];
            data[i] = data[length - i - 1];
            data[length - i - 1] = temp;
        }
    }

    private static void invertArray(boolean[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = !data[i];
        }
    }

    private static int[] runIteration(Scanner input, boolean[] data, int counter) {
        boolean[] set1 = new boolean[4];
        boolean[] set2 = new boolean[4];

        for (int i = 0; i < 4; i++) {
            System.out.println(data.length - i - counter);
            data[data.length - i - counter - 1] = input.nextInt() == 1;
            set2[i] = data[data.length - i - counter - 1];

            System.out.println(i + 1 + counter);
            data[i + counter] = input.nextInt() == 1;
            set1[i] = data[i + counter];
        }

        boolean allSame = true;
        boolean allDiff = true;
        for (int i = 0; i < 4; i++) {
            if (set1[i] != set2[i]) {
                allSame = false;
            } else {
                allDiff = false;
            }
        }

        int[] result = new int[5];
        if (!allSame && !allDiff) {
            result[4] = 0;
            for (int i = 0; i < 4; i++) {
                if (set1[i] != set2[i]) {
                    result[0] = counter + i;
                    result[2] = data.length - counter - 1 - i;
                } else {
                    result[1] = counter + i;
                    result[3] = data.length - counter - 1 - i;
                }
            }
        } else if (allSame) {
            result[4] = 1;
            result[0] = counter;
            result[2] = data.length - counter - 1;
        } else if (allDiff) {
            result[4] = 2;
            result[0] = counter;
            result[2] = data.length - counter - 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();

        for (int ks = 1; ks <= T; ks++) {
            boolean[] data = new boolean[B];
            int counter = 0;
            int[] checkers = new int[4];
            int type = -1;
            int switchCase = 0;

            while (counter < B / 2) {
                if (type == -1) {
                    input.nextInt();
                    input.nextInt();
                }

                if (type == 0) {
                    System.out.println(checkers[0] + 1);
                    boolean tmp = input.nextInt() == 1;
                    System.out.println(checkers[1] + 1);
                    boolean tmp2 = input.nextInt() == 1;

                    if (tmp == data[checkers[0]] && tmp2 == data[checkers[1]]) {
                        switchCase = 0;
                    } else if (tmp == data[checkers[0]] && tmp2 != data[checkers[1]]) {
                        switchCase = 3;
                    } else if (tmp != data[checkers[0]] && tmp2 != data[checkers[1]]) {
                        switchCase = 2;
                    } else if (tmp != data[checkers[0]] && tmp2 == data[checkers[1]]) {
                        switchCase = 1;
                    }
                }

                if (type == 1) {
                    System.out.println(checkers[0] + 1);
                    if (data[checkers[0]] == (input.nextInt() == 1)) {
                        switchCase = 0;
                    } else {
                        switchCase = 2;
                    }
                    input.nextInt();
                }

                if (type == 2) {
                    System.out.println(checkers[0] + 1);
                    if (data[checkers[0]] == (input.nextInt() == 1)) {
                        switchCase = 2;
                    } else {
                        switchCase = 0;
                    }
                    input.nextInt();
                }

                fixData(switchCase, data);

                if (B / 2 - counter > 4) {
                    int[] arr = runIteration(input, data, counter);
                    type = arr[4];
                    System.arraycopy(arr, 0, checkers, 0, 4);
                } else {
                    for (int i = 0; i < B / 2 - counter; i++) {
                        System.out.println(data.length - i - counter);
                        data[data.length - i - counter - 1] = input.nextInt() == 1;
                        System.out.println(i + 1 + counter);
                        data[i + counter] = input.nextInt() == 1;
                    }
                    StringBuilder answer = new StringBuilder();
                    for (boolean datum : data) {
                        answer.append(datum ? 1 : 0);
                    }
                    System.out.println(answer);
                    if (!input.next().equals("Y")) {
                        return;
                    }
                }
                counter += 4;
            }
        }
    }
}