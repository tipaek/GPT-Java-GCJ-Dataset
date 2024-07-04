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
            int sameCount = 0;
            boolean isSame = true;
            int diffCount = 0;
            boolean isDiff = true;
            int checkPos = 0;

            boolean isI = true;
            boolean isS = true;
            boolean isIS = true;
            boolean isN = true;

            for (int q = 1; q <= 150; q++) {
                if (B / 2 == knownCount) break;

                if (q % 10 == 1 && q != 1) {
                    isChecking = true;
                    checkPos = sameCount > 0 ? sameCount - 1 : (diffCount > 0 ? diffCount - 1 : 0);
                    resetFlags();
                    arrayNew = new short[B];
                }

                if (isChecking) {
                    handleCheckingPhase(array, arrayNew, B, q, checkPos, knownCount);
                    if (q % 2 == 0) {
                        if (knownCount <= checkPos) knownCount++;
                        int isCount = updateFlags(array, arrayNew, B, checkPos);
                        if (isCount == 2) {
                            updateArray(array, arrayNew, B, knownCount);
                            isChecking = false;
                        }
                        checkPos++;
                    }
                } else {
                    handleNormalPhase(array, B, q, knownCount, sameCount, isSame, diffCount, isDiff);
                }
            }
            printArray(array);
            if (!in.nextLine().equals("Y")) break;
        }
    }

    private static void resetFlags() {
        isI = true;
        isS = true;
        isIS = true;
        isN = true;
    }

    private static void handleCheckingPhase(short[] array, short[] arrayNew, int B, int q, int checkPos, int knownCount) {
        int queryPos = (q % 2 == 0) ? (B - checkPos - 1) : (checkPos);
        System.out.println(queryPos + 1);
        arrayNew[queryPos] = Short.parseShort(in.nextLine());
        if (knownCount <= checkPos) {
            updateSameDiffCounts(array, B, checkPos, sameCount, isSame, diffCount, isDiff);
        }
    }

    private static void handleNormalPhase(short[] array, int B, int q, int knownCount, int sameCount, boolean isSame, int diffCount, boolean isDiff) {
        int queryPos = (q % 2 == 0) ? (B - knownCount - 1) : (knownCount);
        System.out.println(queryPos + 1);
        array[queryPos] = Short.parseShort(in.nextLine());
        if (q % 2 == 0) {
            updateSameDiffCounts(array, B, knownCount, sameCount, isSame, diffCount, isDiff);
            knownCount++;
        }
    }

    private static void updateSameDiffCounts(short[] array, int B, int pos, int sameCount, boolean isSame, int diffCount, boolean isDiff) {
        if (array[pos] == array[B - pos - 1] && isSame) {
            sameCount++;
        } else {
            isSame = false;
        }
        if (array[pos] != array[B - pos - 1] && isDiff) {
            diffCount++;
        } else {
            isDiff = false;
        }
    }

    private static int updateFlags(short[] array, short[] arrayNew, int B, int checkPos) {
        int isCount = 0;
        if (isI && (isI = isI(array[checkPos], array[B - checkPos - 1], arrayNew[checkPos], arrayNew[B - checkPos - 1]))) isCount++;
        if (isS && (isS = isS(array[checkPos], array[B - checkPos - 1], arrayNew[checkPos], arrayNew[B - checkPos - 1]))) isCount++;
        if (isIS && (isIS = isIS(array[checkPos], array[B - checkPos - 1], arrayNew[checkPos], arrayNew[B - checkPos - 1]))) isCount++;
        if (isN && (isN = isN(array[checkPos], array[B - checkPos - 1], arrayNew[checkPos], arrayNew[B - checkPos - 1]))) isCount++;
        return isCount;
    }

    private static void updateArray(short[] array, short[] arrayNew, int B, int knownCount) {
        if (isI) {
            for (int i = 0; i < knownCount; i++) {
                arrayNew[i] = (short) (array[i] == 1 ? 0 : 1);
                arrayNew[B - i - 1] = (short) (array[B - i - 1] == 1 ? 0 : 1);
            }
        } else if (isS) {
            for (int i = 0; i < knownCount; i++) {
                arrayNew[i] = array[B - i - 1];
                arrayNew[B - i - 1] = array[i];
            }
        } else if (isIS) {
            for (int i = 0; i < knownCount; i++) {
                if (array[i] == array[B - i - 1]) {
                    arrayNew[i] = (short) (array[i] == 1 ? 0 : 1);
                    arrayNew[B - i - 1] = (short) (array[i] == 1 ? 0 : 1);
                } else {
                    arrayNew[i] = array[i];
                    arrayNew[B - i - 1] = array[B - i - 1];
                }
            }
        } else {
            System.arraycopy(array, 0, arrayNew, 0, knownCount);
            System.arraycopy(array, B - knownCount, arrayNew, B - knownCount, knownCount);
        }
        array = arrayNew;
    }

    private static void printArray(short[] array) {
        StringBuilder value = new StringBuilder();
        for (short element : array) {
            value.append(element);
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
}