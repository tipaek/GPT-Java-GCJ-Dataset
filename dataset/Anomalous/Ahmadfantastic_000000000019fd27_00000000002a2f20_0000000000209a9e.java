import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    
    private static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= T; t++) {
            short[] array = new short[B];
            short[] tempArray = new short[B];
            int knownCount = 0;
            boolean checking = false;
            int sameCount = 0;
            boolean sameFlag = true;
            int diffCount = 0;
            boolean diffFlag = true;
            int checkPos = 0;
            boolean isInverted = true;
            boolean isSwapped = true;
            boolean isInvertedSwapped = true;
            boolean isNormal = true;

            for (int q = 1; q <= 150; q++) {
                if (knownCount == B / 2) {
                    break;
                }
                if (q % 10 == 1 && q != 1) {
                    checking = true;
                    checkPos = (sameCount > 0) ? sameCount - 1 : (diffCount > 0 ? diffCount - 1 : 0);
                    sameCount = knownCount - 1;
                    diffCount = knownCount - 1;
                    sameFlag = true;
                    diffFlag = true;
                    isInverted = true;
                    isSwapped = true;
                    isInvertedSwapped = true;
                    isNormal = true;
                    tempArray = new short[B];
                }
                if (checking) {
                    int queryPos = (q % 2 == 0) ? (B - checkPos - 1) : checkPos;
                    System.out.println(queryPos + 1);
                    tempArray[queryPos] = Short.parseShort(scanner.nextLine());
                    if (knownCount <= checkPos) {
                        if (array[checkPos] == array[B - checkPos - 1] && sameFlag) {
                            sameCount++;
                        } else {
                            sameFlag = false;
                        }
                        if (array[checkPos] != array[B - checkPos - 1] && diffFlag) {
                            diffCount++;
                        } else {
                            diffFlag = false;
                        }
                    }
                    if (q % 2 == 0) {
                        if (knownCount <= checkPos) {
                            knownCount++;
                        }
                        int validCount = 0;
                        if (isInverted) {
                            isInverted = checkInverted(array[checkPos], array[B - checkPos - 1], tempArray[checkPos], tempArray[B - checkPos - 1]);
                            if (isInverted) {
                                validCount++;
                            }
                        }
                        if (isSwapped) {
                            isSwapped = checkSwapped(array[checkPos], array[B - checkPos - 1], tempArray[checkPos], tempArray[B - checkPos - 1]);
                            if (isSwapped) {
                                validCount++;
                            }
                        }
                        if (isInvertedSwapped) {
                            isInvertedSwapped = checkInvertedSwapped(array[checkPos], array[B - checkPos - 1], tempArray[checkPos], tempArray[B - checkPos - 1]);
                            if (isInvertedSwapped) {
                                validCount++;
                            }
                        }
                        if (isNormal) {
                            isNormal = checkNormal(array[checkPos], array[B - checkPos - 1], tempArray[checkPos], tempArray[B - checkPos - 1]);
                            if (isNormal) {
                                validCount++;
                            }
                        }
                        if (validCount == 2) {
                            if (isInverted) {
                                for (int i = 0; i < knownCount; i++) {
                                    tempArray[i] = (short) (array[i] == 1 ? 0 : 1);
                                    tempArray[B - i - 1] = (short) (array[B - i - 1] == 1 ? 0 : 1);
                                }
                            } else if (isSwapped) {
                                for (int i = 0; i < knownCount; i++) {
                                    tempArray[i] = array[B - i - 1];
                                    tempArray[B - i - 1] = array[i];
                                }
                            } else if (isInvertedSwapped) {
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
                            checking = false;
                        }
                        checkPos++;
                    }
                } else {
                    int queryPos = (q % 2 == 0) ? (B - knownCount - 1) : knownCount;
                    System.out.println(queryPos + 1);
                    array[queryPos] = Short.parseShort(scanner.nextLine());
                    if (q % 2 == 0) {
                        if (array[knownCount] == array[B - knownCount - 1] && sameFlag) {
                            sameCount++;
                        } else {
                            sameFlag = false;
                        }
                        if (array[knownCount] != array[B - knownCount - 1] && diffFlag) {
                            diffCount++;
                        } else {
                            diffFlag = false;
                        }
                        knownCount++;
                    }
                }
            }
            printArray(array);
            if (!scanner.nextLine().equals("Y")) {
                break;
            }
        }
    }

    private static void printArray(short[] array) {
        StringBuilder result = new StringBuilder();
        for (short value : array) {
            result.append(value);
        }
        System.out.println(result.toString());
    }

    private static boolean checkInverted(short x1, short y1, short x2, short y2) {
        return x1 != x2 && y1 != y2;
    }

    private static boolean checkSwapped(short x1, short y1, short x2, short y2) {
        return x1 == y2 && x2 == y1;
    }

    private static boolean checkInvertedSwapped(short x1, short y1, short x2, short y2) {
        return (x1 == y1) ? (x2 == y2 && x1 != x2) : (x1 == x2 && y1 == y2);
    }

    private static boolean checkNormal(short x1, short y1, short x2, short y2) {
        return x1 == x2 && y1 == y2;
    }
}