import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    private static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            short[] bits = new short[bitLength];
            short[] newBits = new short[bitLength];

            int knownBits = 0;
            boolean checking = false;

            int sameCount = 0;
            boolean sameFlag = true;
            int diffCount = 0;
            boolean diffFlag = true;

            int checkPosition = 0;

            boolean invertFlag = true;
            boolean swapFlag = true;
            boolean invertSwapFlag = true;
            boolean noChangeFlag = true;

            for (int q = 1; q <= 150; q++) {
                if (bitLength / 2 == knownBits) {
                    break;
                }

                if (q % 10 == 1 && q != 1) {
                    checking = true;
                    checkPosition = (sameCount > 0) ? sameCount - 1 : (diffCount > 0 ? diffCount - 1 : 0);

                    sameCount = knownBits - 1;
                    diffCount = knownBits - 1;

                    invertFlag = true;
                    swapFlag = true;
                    invertSwapFlag = true;
                    noChangeFlag = true;
                    newBits = new short[bitLength];
                }

                if (checking) {
                    int queryPosition = (q % 2 == 0) ? (bitLength - checkPosition - 1) : checkPosition;
                    System.out.println(queryPosition + 1);
                    newBits[queryPosition] = Short.parseShort(scanner.nextLine());

                    if (knownBits <= checkPosition) {
                        if (bits[checkPosition] == bits[bitLength - checkPosition - 1] && sameFlag) {
                            sameCount++;
                        } else {
                            sameFlag = false;
                        }
                        if (bits[checkPosition] != bits[bitLength - checkPosition - 1] && diffFlag) {
                            diffCount++;
                        } else {
                            diffFlag = false;
                        }
                    }

                    if (q % 2 == 0) {
                        if (knownBits <= checkPosition) {
                            knownBits++;
                        }
                        int flagCount = 0;
                        if (invertFlag) {
                            invertFlag = isInversion(bits[checkPosition], bits[bitLength - checkPosition - 1], newBits[checkPosition], newBits[bitLength - checkPosition - 1]);
                            if (invertFlag) {
                                flagCount++;
                            }
                        }
                        if (swapFlag) {
                            swapFlag = isSwap(bits[checkPosition], bits[bitLength - checkPosition - 1], newBits[checkPosition], newBits[bitLength - checkPosition - 1]);
                            if (swapFlag) {
                                flagCount++;
                            }
                        }
                        if (invertSwapFlag) {
                            invertSwapFlag = isInvertSwap(bits[checkPosition], bits[bitLength - checkPosition - 1], newBits[checkPosition], newBits[bitLength - checkPosition - 1]);
                            if (invertSwapFlag) {
                                flagCount++;
                            }
                        }
                        if (noChangeFlag) {
                            noChangeFlag = isNoChange(bits[checkPosition], bits[bitLength - checkPosition - 1], newBits[checkPosition], newBits[bitLength - checkPosition - 1]);
                            if (noChangeFlag) {
                                flagCount++;
                            }
                        }
                        if (flagCount == 2) {
                            if (invertFlag) {
                                for (int i = 0; i < knownBits; i++) {
                                    newBits[i] = (short) (bits[i] == 1 ? 0 : 1);
                                    newBits[bitLength - i - 1] = (short) (bits[bitLength - i - 1] == 1 ? 0 : 1);
                                }
                            } else if (swapFlag) {
                                for (int i = 0; i < knownBits; i++) {
                                    newBits[i] = bits[bitLength - i - 1];
                                    newBits[bitLength - i - 1] = bits[i];
                                }
                            } else if (invertSwapFlag) {
                                for (int i = 0; i < knownBits; i++) {
                                    if (bits[i] == bits[bitLength - i - 1]) {
                                        newBits[i] = (short) (bits[i] == 1 ? 0 : 1);
                                        newBits[bitLength - i - 1] = (short) (bits[i] == 1 ? 0 : 1);
                                    } else {
                                        newBits[i] = bits[i];
                                        newBits[bitLength - i - 1] = bits[bitLength - i - 1];
                                    }
                                }
                            } else {
                                for (int i = 0; i < knownBits; i++) {
                                    newBits[i] = bits[i];
                                    newBits[bitLength - i - 1] = bits[bitLength - i - 1];
                                }
                            }
                            bits = newBits;
                            checking = false;
                        }
                        checkPosition++;
                    }
                } else {
                    int queryPosition = (q % 2 == 0) ? (bitLength - knownBits - 1) : knownBits;
                    System.out.println(queryPosition + 1);
                    bits[queryPosition] = Short.parseShort(scanner.nextLine());

                    if (q % 2 == 0) {
                        if (bits[knownBits] == bits[bitLength - knownBits - 1] && sameFlag) {
                            sameCount++;
                        } else {
                            sameFlag = false;
                        }
                        if (bits[knownBits] != bits[bitLength - knownBits - 1] && diffFlag) {
                            diffCount++;
                        } else {
                            diffFlag = false;
                        }
                        knownBits++;
                    }
                }
            }

            printBits(bits);
            if (!scanner.nextLine().equals("Y")) {
                break;
            }
        }
    }

    private static void printBits(short[] bits) {
        StringBuilder value = new StringBuilder();
        for (short bit : bits) {
            value.append(bit);
        }
        System.out.println(value);
    }

    private static boolean isInversion(short x1, short y1, short x2, short y2) {
        return x1 != x2 && y1 != y2;
    }

    private static boolean isSwap(short x1, short y1, short x2, short y2) {
        return x1 == y2 && x2 == y1;
    }

    private static boolean isInvertSwap(short x1, short y1, short x2, short y2) {
        return (x1 == y1) ? (x2 == y2 && x1 != x2) : (x1 == x2 && y1 == y2);
    }

    private static boolean isNoChange(short x1, short y1, short x2, short y2) {
        return x1 == x2 && y1 == y2;
    }
}