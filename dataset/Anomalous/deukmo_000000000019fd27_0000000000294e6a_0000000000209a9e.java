import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int B = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int samePairIndex = -1;
            int diffPairIndex = -1;
            int queryCount = 0;

            for (int j = 1; j <= B / 2; j++) {
                System.out.print(j);
                queryCount++;
                int a = scanner.nextInt();
                System.out.print(B - (j - 1));
                queryCount++;
                int b = scanner.nextInt();

                if (a == b && samePairIndex == -1) {
                    samePairIndex = j;
                }
                if (a != b && diffPairIndex == -1) {
                    diffPairIndex = j;
                }

                if (samePairIndex != -1 && diffPairIndex != -1) {
                    break;
                }
            }

            int remainingQueries = (150 - queryCount) % 10;
            for (int i = 0; i < remainingQueries; i++) {
                System.out.println(1);
                queryCount++;
                scanner.nextInt();
            }

            if (samePairIndex == -1 || diffPairIndex == -1) {
                int[][] results = new int[2][B];
                Arrays.fill(results[0], -1);
                Arrays.fill(results[1], -1);

                int currentMode = -1;
                int fillIndex = 0;

                while (queryCount < 150) {
                    if (currentMode == -1) {
                        System.out.println(1);
                        queryCount++;
                        int a = scanner.nextInt();
                        int b = (samePairIndex == -1) ? ((a == 0) ? 1 : 0) : a;

                        if (results[0][0] == -1) {
                            updateResults(results, currentMode, 1, B, a, b);
                            currentMode = 0;
                        } else {
                            currentMode = (results[0][0] == a) ? 0 : 1;
                        }
                    } else {
                        while (results[0][fillIndex] != -1 && fillIndex < B / 2) {
                            fillIndex++;
                        }
                        if (fillIndex < B / 2) {
                            System.out.println(fillIndex + 1);
                            queryCount++;
                            int a = scanner.nextInt();
                            int b = (samePairIndex == -1) ? ((a == 0) ? 1 : 0) : a;
                            updateResults(results, currentMode, fillIndex + 1, B, a, b);
                            fillIndex++;
                        }
                    }

                    if (fillIndex >= B / 2) {
                        StringBuilder resultString = new StringBuilder();
                        for (int i = 0; i < B; i++) {
                            resultString.append(results[currentMode][i]);
                        }
                        System.out.println(resultString);

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
                int[][] results = new int[4][B];
                Arrays.fill(results[0], -1);
                Arrays.fill(results[1], -1);
                Arrays.fill(results[2], -1);
                Arrays.fill(results[3], -1);

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

                        if (results[0][samePairIndex - 1] == -1) {
                            updateResults(results, currentMode, samePairIndex, B, a1, b1);
                            updateResults(results, currentMode, diffPairIndex, B, a2, b2);
                            currentMode = 0;
                        } else {
                            if (results[0][samePairIndex - 1] == a1 && results[0][diffPairIndex - 1] == a2) {
                                currentMode = 0;
                            } else if (results[0][samePairIndex - 1] != a1 && results[0][diffPairIndex - 1] != a2) {
                                currentMode = 1;
                            } else if (results[0][samePairIndex - 1] == a1 && results[0][diffPairIndex - 1] != a2) {
                                currentMode = 2;
                            } else if (results[0][samePairIndex - 1] != a1 && results[0][diffPairIndex - 1] == a2) {
                                currentMode = 3;
                            }
                        }
                    } else {
                        while (results[0][fillIndex] != -1 && fillIndex < B / 2) {
                            fillIndex++;
                        }
                        if (fillIndex < B / 2) {
                            System.out.println(fillIndex + 1);
                            queryCount++;
                            int a1 = scanner.nextInt();
                            System.out.println(B - fillIndex);
                            queryCount++;
                            int b1 = scanner.nextInt();
                            updateResults(results, currentMode, fillIndex + 1, B, a1, b1);
                            fillIndex++;
                        }
                    }

                    if (fillIndex >= B / 2) {
                        StringBuilder resultString = new StringBuilder();
                        for (int i = 0; i < B; i++) {
                            resultString.append(results[currentMode][i]);
                        }
                        System.out.println(resultString);

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

    private static void updateResults(int[][] results, int currentMode, int position, int B, int a, int b) {
        if (currentMode == 0) {
            results[0][position - 1] = a;
            results[1][position - 1] = (a == 0) ? 1 : 0;
            results[2][position - 1] = b;
            results[3][position - 1] = (b == 0) ? 1 : 0;

            results[0][B - position] = b;
            results[1][B - position] = (b == 0) ? 1 : 0;
            results[2][B - position] = a;
            results[3][B - position] = (a == 0) ? 1 : 0;
        } else if (currentMode == 1) {
            results[0][position - 1] = (a == 0) ? 1 : 0;
            results[1][position - 1] = a;
            results[2][position - 1] = (b == 0) ? 1 : 0;
            results[3][position - 1] = b;

            results[0][B - position] = (b == 0) ? 1 : 0;
            results[1][B - position] = b;
            results[2][B - position] = (a == 0) ? 1 : 0;
            results[3][B - position] = a;
        } else if (currentMode == 2) {
            results[0][position - 1] = b;
            results[1][position - 1] = (b == 0) ? 1 : 0;
            results[2][position - 1] = a;
            results[3][position - 1] = (a == 0) ? 1 : 0;

            results[0][B - position] = a;
            results[1][B - position] = (a == 0) ? 1 : 0;
            results[2][B - position] = b;
            results[3][B - position] = (b == 0) ? 1 : 0;
        } else if (currentMode == 3) {
            results[0][position - 1] = (b == 0) ? 1 : 0;
            results[1][position - 1] = b;
            results[2][position - 1] = (a == 0) ? 1 : 0;
            results[3][position - 1] = a;

            results[0][B - position] = (a == 0) ? 1 : 0;
            results[1][B - position] = a;
            results[2][B - position] = (b == 0) ? 1 : 0;
            results[3][B - position] = b;
        }
    }
}