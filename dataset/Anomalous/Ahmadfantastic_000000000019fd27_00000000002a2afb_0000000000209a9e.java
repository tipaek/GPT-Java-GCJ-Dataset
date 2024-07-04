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
            short[] tempArray = new short[B];
            int knownCount = 0;
            boolean isChecking = false;
            int checkPos = 0;

            boolean invert = true;
            boolean swap = true;
            boolean invertAndSwap = true;
            boolean noChange = true;

            for (int q = 1; q <= 150; q++) {
                if (knownCount == B / 2) {
                    break;
                }
                if (q % 10 == 1 && q != 1) {
                    isChecking = true;
                    checkPos = knownCount - 1;
                    invert = true;
                    swap = true;
                    invertAndSwap = true;
                    noChange = true;
                    tempArray = new short[B];
                }
                if (isChecking) {
                    int queryPos = (q % 2 == 0) ? (B - checkPos - 1) : checkPos;
                    System.out.println(queryPos + 1);
                    tempArray[queryPos] = Short.parseShort(in.nextLine());

                    if (q % 2 == 0) {
                        if (knownCount <= checkPos) {
                            knownCount++;
                        }
                        int matchCount = 0;
                        if (invert) {
                            invert = checkInvert(array[checkPos], array[B - checkPos - 1], tempArray[checkPos], tempArray[B - checkPos - 1]);
                            if (invert) {
                                matchCount++;
                            }
                        }
                        if (swap) {
                            swap = checkSwap(array[checkPos], array[B - checkPos - 1], tempArray[checkPos], tempArray[B - checkPos - 1]);
                            if (swap) {
                                matchCount++;
                            }
                        }
                        if (invertAndSwap) {
                            invertAndSwap = checkInvertAndSwap(array[checkPos], array[B - checkPos - 1], tempArray[checkPos], tempArray[B - checkPos - 1]);
                            if (invertAndSwap) {
                                matchCount++;
                            }
                        }
                        if (noChange) {
                            noChange = checkNoChange(array[checkPos], array[B - checkPos - 1], tempArray[checkPos], tempArray[B - checkPos - 1]);
                            if (noChange) {
                                matchCount++;
                            }
                        }
                        if (matchCount == 2) {
                            if (invert) {
                                for (int i = 0; i < knownCount; i++) {
                                    tempArray[i] = (short) (array[i] == 1 ? 0 : 1);
                                    tempArray[B - i - 1] = (short) (array[B - i - 1] == 1 ? 0 : 1);
                                }
                            } else if (swap) {
                                for (int i = 0; i < knownCount; i++) {
                                    tempArray[i] = array[B - i - 1];
                                    tempArray[B - i - 1] = array[i];
                                }
                            } else if (invertAndSwap) {
                                for (int i = 0; i < knownCount; i++) {
                                    if (array[i] == array[B - i - 1]) {
                                        tempArray[i] = (short) (array[i] == 1 ? 0 : 1);
                                        tempArray[B - i - 1] = (short) (array[i] == 1 ? 0 : 1);
                                    } else {
                                        tempArray[i] = array[i];
                                        tempArray[B - i - 1] = array[B - i - 1];
                                    }
                                }
                            } else {
                                for (int i = 0; i < knownCount; i++) {
                                    tempArray[i] = array[i];
                                    tempArray[B - i - 1] = array[B - i - 1];
                                }
                            }
                            array = tempArray;
                            isChecking = false;
                        }
                        checkPos++;
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
        for (short bit : array) {
            value.append(bit);
        }
        System.out.println(value);
    }

    private static boolean checkInvert(short x1, short y1, short x2, short y2) {
        return x1 != x2 && y1 != y2;
    }

    private static boolean checkSwap(short x1, short y1, short x2, short y2) {
        return x1 == y2 && x2 == y1;
    }

    private static boolean checkInvertAndSwap(short x1, short y1, short x2, short y2) {
        return (x1 == y1) ? (x2 == y2 && x1 != x2) : (x1 == x2 && y1 == y2);
    }

    private static boolean checkNoChange(short x1, short y1, short x2, short y2) {
        return x1 == x2 && y1 == y2;
    }
}