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
                if (B / 2 == knownCount) {
                    break;
                }
                if (q % 10 == 1 && q != 1) {
                    isChecking = true;
                    checkPos = sameCount > 0 ? sameCount - 1 : (diffCount > 0 ? diffCount - 1 : 0);

                    isI = true;
                    isS = true;
                    isIS = true;
                    isN = true;
                    arrayNew = new short[B];
                }
                if (isChecking) {
                    int queryPos = (q % 2 == 0) ? (B - checkPos - 1) : checkPos;
                    System.out.println(queryPos + 1);
                    arrayNew[queryPos] = Short.parseShort(in.nextLine());

                    if (knownCount <= checkPos) {
                        if (array[checkPos] == array[B - checkPos - 1] && isSame) {
                            sameCount++;
                        } else {
                            isSame = false;
                        }
                        if (array[checkPos] != array[B - checkPos - 1] && isDiff) {
                            diffCount++;
                        } else {
                            isDiff = false;
                        }
                    }

                    if (q % 2 == 0) {
                        if (knownCount <= checkPos) {
                            knownCount++;
                        }
                        int isCount = 0;
                        if (isI) {
                            isI = isInverted(array[checkPos], array[B - checkPos - 1], arrayNew[checkPos], arrayNew[B - checkPos - 1]);
                            if (isI) {
                                isCount++;
                            }
                        }
                        if (isS) {
                            isS = isSwapped(array[checkPos], array[B - checkPos - 1], arrayNew[checkPos], arrayNew[B - checkPos - 1]);
                            if (isS) {
                                isCount++;
                            }
                        }
                        if (isIS) {
                            isIS = isInvertedSwapped(array[checkPos], array[B - checkPos - 1], arrayNew[checkPos], arrayNew[B - checkPos - 1]);
                            if (isIS) {
                                isCount++;
                            }
                        }
                        if (isN) {
                            isN = isNormal(array[checkPos], array[B - checkPos - 1], arrayNew[checkPos], arrayNew[B - checkPos - 1]);
                            if (isN) {
                                isCount++;
                            }
                        }

                        if (isCount == 2) {
                            if (isI) {
                                invertArray(array, arrayNew, knownCount, B);
                            } else if (isS) {
                                swapArray(array, arrayNew, knownCount, B);
                            } else if (isIS) {
                                invertSwapArray(array, arrayNew, knownCount, B);
                            } else {
                                copyArray(array, arrayNew, knownCount, B);
                            }
                            array = arrayNew;
                            isChecking = false;
                        }
                        checkPos++;
                    }
                } else {
                    int queryPos = (q % 2 == 0) ? (B - knownCount - 1) : knownCount;
                    System.out.println(queryPos + 1);
                    array[queryPos] = Short.parseShort(in.nextLine());

                    if (q % 2 == 0) {
                        if (array[knownCount] == array[B - knownCount - 1] && isSame) {
                            sameCount++;
                        } else {
                            isSame = false;
                        }
                        if (array[knownCount] != array[B - knownCount - 1] && isDiff) {
                            diffCount++;
                        } else {
                            isDiff = false;
                        }
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

    private static boolean isInverted(short x1, short y1, short x2, short y2) {
        return x1 != x2 && y1 != y2;
    }

    private static boolean isSwapped(short x1, short y1, short x2, short y2) {
        return x1 == y2 && x2 == y1;
    }

    private static boolean isInvertedSwapped(short x1, short y1, short x2, short y2) {
        return (x1 == y1) ? (x2 == y2 && x1 != x2) : (x1 == x2 && y1 == y2);
    }

    private static boolean isNormal(short x1, short y1, short x2, short y2) {
        return x1 == x2 && y1 == y2;
    }

    private static void invertArray(short[] array, short[] arrayNew, int knownCount, int B) {
        for (int i = 0; i < knownCount; i++) {
            arrayNew[i] = (short) (array[i] == 1 ? 0 : 1);
            arrayNew[B - i - 1] = (short) (array[B - i - 1] == 1 ? 0 : 1);
        }
    }

    private static void swapArray(short[] array, short[] arrayNew, int knownCount, int B) {
        for (int i = 0; i < knownCount; i++) {
            arrayNew[i] = array[B - i - 1];
            arrayNew[B - i - 1] = array[i];
        }
    }

    private static void invertSwapArray(short[] array, short[] arrayNew, int knownCount, int B) {
        for (int i = 0; i < knownCount; i++) {
            if (array[i] == array[B - i - 1]) {
                arrayNew[i] = (short) (array[i] == 1 ? 0 : 1);
                arrayNew[B - i - 1] = (short) (array[i] == 1 ? 0 : 1);
            } else {
                arrayNew[i] = array[i];
                arrayNew[B - i - 1] = array[B - i - 1];
            }
        }
    }

    private static void copyArray(short[] array, short[] arrayNew, int knownCount, int B) {
        for (int i = 0; i < knownCount; i++) {
            arrayNew[i] = array[i];
            arrayNew[B - i - 1] = array[B - i - 1];
        }
    }
}