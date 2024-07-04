import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    private static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = in.nextInt();
        int B = in.nextInt();
        in.nextLine();

        for (int t = 1; t <= T; t++) {
            short[] array = new short[B];
            short[] arrayNew = new short[B];
            int knownCount = 0;
            boolean isChecking = false;
            int checkPos = 0;
            boolean isI = true, isS = true, isIS = true, isN = true;

            for (int q = 1; q <= 150; q++) {
                if (B / 2 == knownCount && (B % 2 == 0 || q % 2 != 0)) {
                    break;
                }

                if (q % 10 == 1 && q != 1) {
                    isChecking = true;
                    checkPos = 0;
                    isI = isS = isIS = isN = true;
                    arrayNew = new short[B];
                }

                if (isChecking) {
                    int queryPos = (q % 2 == 0) ? (B - checkPos - 1) : checkPos;
                    System.out.println(queryPos + 1);
                    arrayNew[queryPos] = Short.parseShort(in.nextLine());

                    if (q % 2 == 0) {
                        int isCount = 0;
                        if (isI && (isI = isI(array[checkPos], array[B - checkPos - 1], arrayNew[checkPos], arrayNew[B - checkPos - 1]))) isCount++;
                        if (isS && (isS = isS(array[checkPos], array[B - checkPos - 1], arrayNew[checkPos], arrayNew[B - checkPos - 1]))) isCount++;
                        if (isIS && (isIS = isIS(array[checkPos], array[B - checkPos - 1], arrayNew[checkPos], arrayNew[B - checkPos - 1]))) isCount++;
                        if (isN && (isN = isN(array[checkPos], array[B - checkPos - 1], arrayNew[checkPos], arrayNew[B - checkPos - 1]))) isCount++;

                        if (isCount == 2) {
                            checkPos++;
                        } else {
                            updateArray(array, arrayNew, knownCount, checkPos, isI, isS, isIS);
                            array = arrayNew;
                            isChecking = false;
                        }
                    }
                } else {
                    int queryPos = (q % 2 == 0) ? (B - knownCount - 1) : knownCount;
                    System.out.println(queryPos + 1);
                    array[queryPos] = Short.parseShort(in.nextLine());
                    if (q % 2 == 0) {
                        knownCount++;
                    }
                }
            }

            printArray(array);
            if (!in.nextLine().equals("Y")) {
                break;
            }
        }
    }

    private static void printArray(short[] array) {
        StringBuilder value = new StringBuilder();
        for (short s : array) {
            value.append(s);
        }
        System.out.println(value);
    }

    private static boolean isI(short x1, short y1, short x2, short y2) {
        return x1 != x2 && y1 != y2;
    }

    private static boolean isS(short x1, short y1, short x2, short y2) {
        return x1 == y2 && x2 == y1;
    }

    private static boolean isIS(short x1, short y1, short x2, short y2) {
        return (x1 == y1) ? (x2 == y2 && x1 != x2) : (x1 == x2 && y1 == y2);
    }

    private static boolean isN(short x1, short y1, short x2, short y2) {
        return x1 == x2 && y1 == y2;
    }

    private static void updateArray(short[] array, short[] arrayNew, int knownCount, int checkPos, boolean isI, boolean isS, boolean isIS) {
        for (int i = checkPos + 1; i < knownCount; i++) {
            if (isI) {
                arrayNew[i] = (short) (array[i] == 1 ? 0 : 1);
                arrayNew[B - i - 1] = (short) (array[B - i - 1] == 1 ? 0 : 1);
            } else if (isS) {
                arrayNew[i] = array[B - i - 1];
                arrayNew[B - i - 1] = array[i];
            } else if (isIS) {
                if (array[i] == array[B - i - 1]) {
                    arrayNew[i] = (short) (array[i] == 1 ? 0 : 1);
                    arrayNew[B - i - 1] = (short) (array[i] == 1 ? 0 : 1);
                } else {
                    arrayNew[i] = array[i];
                    arrayNew[B - i - 1] = array[B - i - 1];
                }
            } else {
                arrayNew[i] = array[i];
                arrayNew[B - i - 1] = array[B - i - 1];
            }
        }
    }
}