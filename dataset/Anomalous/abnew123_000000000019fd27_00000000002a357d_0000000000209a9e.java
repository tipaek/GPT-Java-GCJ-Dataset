import java.util.Scanner;

public class Solution {
    public static void solve(Scanner input, int b) {
        boolean[] data = new boolean[b];
        
        if (b == 10) {
            handleCaseB10(input, data);
        } else {
            handleGeneralCase(input, data, b);
        }
    }

    private static void handleCaseB10(Scanner input, boolean[] data) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            data[i - 1] = Integer.parseInt(input.next()) == 1;
        }
        String answer = getAnswer(data);
        System.out.println(answer);
        if (input.next().equals("Y")) {
            return;
        }
    }

    private static void handleGeneralCase(Scanner input, boolean[] data, int b) {
        int counter = 0;
        int[] checkers = new int[4];
        int type = -1;
        int switchCase = 0;

        while (counter < (b / 2)) {
            if (type == -1) {
                wasteMoves(input);
            } else {
                switchCase = determineSwitchCase(input, data, checkers, type);
            }
            fixData(switchCase, data);

            if ((b / 2) - counter > 4) {
                int[] arr = runIteration(input, data, switchCase, counter);
                type = arr[4];
                System.arraycopy(arr, 0, checkers, 0, 4);
            } else {
                fillData(input, data, counter, b);
                String answer = getAnswer(data);
                System.out.println(answer);
                if (input.next().equals("Y")) {
                    return;
                }
            }
            counter += 4;
        }
    }

    private static void wasteMoves(Scanner input) {
        System.out.println(1);
        input.next();
        System.out.println(1);
        input.next();
    }

    private static int determineSwitchCase(Scanner input, boolean[] data, int[] checkers, int type) {
        int switchCase = 0;
        if (type == 0) {
            switchCase = compareData(input, data, checkers);
        } else if (type == 1 || type == 2) {
            switchCase = compareSingleData(input, data, checkers, type);
        }
        return switchCase;
    }

    private static int compareData(Scanner input, boolean[] data, int[] checkers) {
        System.out.println(checkers[0] + 1);
        boolean tmp = Integer.parseInt(input.next()) == 1;
        System.out.println(checkers[1] + 1);
        boolean tmp2 = Integer.parseInt(input.next()) == 1;

        if (tmp == data[checkers[0]] && tmp2 == data[checkers[1]]) return 0;
        if (tmp == data[checkers[0]] && tmp2 != data[checkers[1]]) return 3;
        if (tmp != data[checkers[0]] && tmp2 != data[checkers[1]]) return 2;
        return 1;
    }

    private static int compareSingleData(Scanner input, boolean[] data, int[] checkers, int type) {
        System.out.println(checkers[0] + 1);
        boolean tmp = Integer.parseInt(input.next()) == 1;

        if (data[checkers[0]] == tmp) {
            return (type == 1) ? 0 : 2;
        } else {
            return (type == 1) ? 2 : 0;
        }
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

    private static int[] runIteration(Scanner input, boolean[] data, int switchCase, int counter) {
        boolean[] set1 = new boolean[4];
        boolean[] set2 = new boolean[4];

        for (int i = 0; i < 4; i++) {
            System.out.println(data.length - i - counter);
            set2[i] = Integer.parseInt(input.next()) == 1;
            data[data.length - i - counter - 1] = set2[i];

            System.out.println(i + 1 + counter);
            set1[i] = Integer.parseInt(input.next()) == 1;
            data[i + counter] = set1[i];
        }

        return determineTypeAndCheckers(set1, set2, counter, data.length);
    }

    private static int[] determineTypeAndCheckers(boolean[] set1, boolean[] set2, int counter, int dataLength) {
        boolean allSame = true;
        boolean allDiff = true;

        for (int i = 0; i < 4; i++) {
            if (set1[i] == set2[i]) {
                allDiff = false;
            } else {
                allSame = false;
            }
        }

        int[] answer = new int[5];
        if (!allSame && !allDiff) {
            answer = setCheckers(set1, set2, counter, dataLength, 0);
        } else if (allSame) {
            answer = setCheckers(counter, dataLength, 1);
        } else {
            answer = setCheckers(counter, dataLength, 2);
        }

        return answer;
    }

    private static int[] setCheckers(boolean[] set1, boolean[] set2, int counter, int dataLength, int type) {
        int[] answer = new int[5];
        answer[4] = type;

        for (int i = 0; i < 4; i++) {
            if (set1[i] != set2[i]) {
                answer[0] = counter + i;
                answer[2] = dataLength - counter - 1 - i;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (set1[i] == set2[i]) {
                answer[1] = counter + i;
                answer[3] = dataLength - counter - 1 - i;
            }
        }

        return answer;
    }

    private static int[] setCheckers(int counter, int dataLength, int type) {
        int[] answer = new int[5];
        answer[0] = counter;
        answer[1] = 0;
        answer[2] = dataLength - counter - 1;
        answer[3] = 0;
        answer[4] = type;

        return answer;
    }

    private static void fillData(Scanner input, boolean[] data, int counter, int b) {
        for (int i = 0; i < (b / 2) - counter; i++) {
            System.out.println(data.length - i - counter);
            data[data.length - i - counter - 1] = Integer.parseInt(input.next()) == 1;

            System.out.println(i + 1 + counter);
            data[i + counter] = Integer.parseInt(input.next()) == 1;
        }
    }

    private static String getAnswer(boolean[] data) {
        StringBuilder answer = new StringBuilder();
        for (boolean datum : data) {
            answer.append(datum ? 1 : 0);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = Integer.parseInt(input.next());
        int B = Integer.parseInt(input.next());

        for (int ks = 1; ks <= T; ks++) {
            solve(input, B);
        }
    }
}