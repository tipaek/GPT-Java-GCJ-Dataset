import java.util.Scanner;

public class Solution {
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
            set2[i] = input.nextInt() == 1;
            data[data.length - i - counter - 1] = set2[i];

            System.out.println(i + 1 + counter);
            set1[i] = input.nextInt() == 1;
            data[i + counter] = set1[i];
        }

        boolean allSame = true;
        boolean allDiff = true;

        for (int i = 0; i < 4; i++) {
            if (set1[i] == set2[i]) {
                allDiff = false;
            } else {
                allSame = false;
            }
        }

        int type = allSame ? 1 : allDiff ? 2 : 0;
        int[] answer = new int[5];
        if (type == 0) {
            for (int i = 0; i < 4; i++) {
                if (set1[i] != set2[i]) {
                    answer[0] = counter + i;
                    answer[2] = data.length - counter - 1 - i;
                }
                if (set1[i] == set2[i]) {
                    answer[1] = counter + i;
                    answer[3] = data.length - counter - 1 - i;
                }
            }
        } else {
            answer[0] = counter;
            answer[2] = data.length - counter - 1;
        }

        answer[4] = type;
        return answer;
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
                    System.out.println(1);
                    input.next();
                    System.out.println(1);
                    input.next();
                }

                if (type == 0) {
                    System.out.println(checkers[0] + 1);
                    boolean tmp = input.nextInt() == 1;
                    System.out.println(checkers[1] + 1);
                    boolean tmp2 = input.nextInt() == 1;
                    switchCase = (tmp == data[checkers[0]] && tmp2 == data[checkers[1]]) ? 0 :
                                 (tmp == data[checkers[0]] && tmp2 != data[checkers[1]]) ? 3 :
                                 (tmp != data[checkers[0]] && tmp2 != data[checkers[1]]) ? 2 : 1;
                }

                if (type == 1 || type == 2) {
                    System.out.println(checkers[0] + 1);
                    boolean tmp = input.nextInt() == 1;
                    switchCase = (data[checkers[0]] == tmp) ? (type == 1 ? 0 : 2) : (type == 1 ? 2 : 0);
                    System.out.println(1);
                    input.next();
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
                }
                counter += 4;
            }

            StringBuilder answer = new StringBuilder();
            for (boolean bit : data) {
                answer.append(bit ? 1 : 0);
            }
            System.out.println(answer);

            if (!input.next().equals("Y")) {
                return;
            }
        }
    }
}