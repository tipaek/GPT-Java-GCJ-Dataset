import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int samePairIndex = -1;
            int diffPairIndex = -1;
            int queryCount = 0;

            for (int j = 1; j <= bitLength / 2; j++) {
                System.out.println(j);
                queryCount++;
                int a = scanner.nextInt();
                System.out.println(bitLength - (j - 1));
                queryCount++;
                int b = scanner.nextInt();

                if (a == b && samePairIndex == -1) {
                    samePairIndex = j;
                }
                if (a != b && diffPairIndex == -1) {
                    diffPairIndex = j;
                }

                if (samePairIndex != -1 && diffPairIndex != -1) break;
            }

            int remainingQueries = (150 - queryCount) % 10;
            for (int i = 0; i < remainingQueries; i++) {
                System.out.println(1);
                queryCount++;
                scanner.nextInt();
            }

            if (samePairIndex == -1 || diffPairIndex == -1) {
                int[][] result = new int[2][bitLength];
                Arrays.fill(result[0], -1);
                Arrays.fill(result[1], -1);

                int currentMode = -1;
                int fillIndex = 0;

                while (queryCount < 150) {
                    if (currentMode == -1) {
                        System.out.println(1);
                        queryCount++;
                        int a = scanner.nextInt();
                        int b = (samePairIndex == -1) ? ((a == 0) ? 1 : 0) : a;

                        if (result[0][0] == -1) {
                            updateResult(result, currentMode, 1, bitLength, a, b);
                            currentMode = 0;
                        } else {
                            if (result[0][0] == a) {
                                currentMode = 0;
                            } else {
                                currentMode = 1;
                            }
                        }
                    } else {
                        while (result[0][fillIndex] != -1 && fillIndex < bitLength / 2) {
                            fillIndex++;
                        }
                        if (fillIndex < bitLength / 2) {
                            System.out.println(fillIndex + 1);
                            queryCount++;
                            int a = scanner.nextInt();
                            int b = (samePairIndex == -1) ? ((a == 0) ? 1 : 0) : a;
                            updateResult(result, currentMode, fillIndex + 1, bitLength, a, b);
                            fillIndex++;
                        }
                    }

                    if (fillIndex >= bitLength / 2) {
                        for (int i = 0; i < bitLength; i++) {
                            System.out.print(result[currentMode][i]);
                        }
                        System.out.print("\n");

                        String response = scanner.next();
                        if (response.equals("Y")) {
                            break;
                        } else {
                            System.exit(-1);
                        }
                    }

                    if (queryCount % 10 == 0) {
                        currentMode = -1;
                    }
                }
            } else {
                int[][] result = new int[4][bitLength];
                Arrays.fill(result[0], -1);
                Arrays.fill(result[1], -1);
                Arrays.fill(result[2], -1);
                Arrays.fill(result[3], -1);

                int currentMode = -1;
                int fillIndex = 0;

                while (queryCount < 150) {
                    if (currentMode == -1) {
                        System.out.println(samePairIndex);
                        queryCount++;
                        int a1 = scanner.nextInt();
                        int b1 = a1;

                        System.out.println(diffPairIndex);
                        queryCount++;
                        int a2 = scanner.nextInt();
                        int b2 = (a2 == 0) ? 1 : 0;

                        if (result[0][samePairIndex - 1] == -1) {
                            updateResult(result, currentMode, samePairIndex, bitLength, a1, b1);
                            updateResult(result, currentMode, diffPairIndex, bitLength, a2, b2);
                            currentMode = 0;
                        } else {
                            if (result[0][samePairIndex - 1] == a1 && result[0][diffPairIndex - 1] == a2) {
                                currentMode = 0;
                            } else if (result[0][samePairIndex - 1] != a1 && result[0][diffPairIndex - 1] != a2) {
                                currentMode = 1;
                            } else if (result[0][samePairIndex - 1] == a1 && result[0][diffPairIndex - 1] != a2) {
                                currentMode = 2;
                            } else {
                                currentMode = 3;
                            }
                        }
                    } else {
                        while (result[0][fillIndex] != -1 && fillIndex < bitLength / 2) {
                            fillIndex++;
                        }
                        if (fillIndex < bitLength / 2) {
                            System.out.println(fillIndex + 1);
                            queryCount++;
                            int a1 = scanner.nextInt();
                            System.out.println(bitLength - fillIndex);
                            queryCount++;
                            int b1 = scanner.nextInt();
                            updateResult(result, currentMode, fillIndex + 1, bitLength, a1, b1);
                            fillIndex++;
                        }
                    }

                    if (fillIndex >= bitLength / 2) {
                        for (int i = 0; i < bitLength; i++) {
                            System.out.print(result[currentMode][i]);
                        }
                        System.out.print("\n");

                        String response = scanner.next();
                        if (response.equals("Y")) {
                            break;
                        } else {
                            System.exit(-1);
                        }
                    }

                    if (queryCount % 10 == 0) {
                        currentMode = -1;
                    }
                }
            }
        }
        scanner.close();
    }

    private static void updateResult(int[][] result, int currentMode, int position, int bitLength, int a, int b) {
        if (currentMode == 0) {
            result[0][position - 1] = a;
            result[1][position - 1] = (a == 0) ? 1 : 0;
            result[0][bitLength - position] = b;
            result[1][bitLength - position] = (b == 0) ? 1 : 0;
        } else if (currentMode == 1) {
            result[0][position - 1] = (a == 0) ? 1 : 0;
            result[1][position - 1] = a;
            result[0][bitLength - position] = (b == 0) ? 1 : 0;
            result[1][bitLength - position] = b;
        }
    }

    private static void updateResult(int[][] result, int currentMode, int position, int bitLength, int a1, int b1, int a2, int b2) {
        if (currentMode == 0) {
            result[0][position - 1] = a1;
            result[1][position - 1] = (a1 == 0) ? 1 : 0;
            result[2][position - 1] = b1;
            result[3][position - 1] = (b1 == 0) ? 1 : 0;

            result[0][bitLength - position] = b1;
            result[1][bitLength - position] = (b1 == 0) ? 1 : 0;
            result[2][bitLength - position] = a1;
            result[3][bitLength - position] = (a1 == 0) ? 1 : 0;
        } else if (currentMode == 1) {
            result[0][position - 1] = (a1 == 0) ? 1 : 0;
            result[1][position - 1] = a1;
            result[2][position - 1] = (b1 == 0) ? 1 : 0;
            result[3][position - 1] = b1;

            result[0][bitLength - position] = (b1 == 0) ? 1 : 0;
            result[1][bitLength - position] = b1;
            result[2][bitLength - position] = (a1 == 0) ? 1 : 0;
            result[3][bitLength - position] = a1;
        } else if (currentMode == 2) {
            result[0][position - 1] = b1;
            result[1][position - 1] = (b1 == 0) ? 1 : 0;
            result[2][position - 1] = a1;
            result[3][position - 1] = (a1 == 0) ? 1 : 0;

            result[0][bitLength - position] = a1;
            result[1][bitLength - position] = (a1 == 0) ? 1 : 0;
            result[2][bitLength - position] = b1;
            result[3][bitLength - position] = (b1 == 0) ? 1 : 0;
        } else if (currentMode == 3) {
            result[0][position - 1] = (b1 == 0) ? 1 : 0;
            result[1][position - 1] = b1;
            result[2][position - 1] = (a1 == 0) ? 1 : 0;
            result[3][position - 1] = a1;

            result[0][bitLength - position] = (a1 == 0) ? 1 : 0;
            result[1][bitLength - position] = a1;
            result[2][bitLength - position] = (b1 == 0) ? 1 : 0;
            result[3][bitLength - position] = b1;
        }
    }
}