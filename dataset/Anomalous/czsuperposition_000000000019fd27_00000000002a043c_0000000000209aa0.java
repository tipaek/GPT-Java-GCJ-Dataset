import java.util.*;

public class Solution {
    private static int N;

    public static String makeMatrix(int a, int b, int c, int d, int e) {
        int[] temp = new int[N * N];
        switch (N) {
            case 2:
                temp = new int[]{a, b, b, a};
                break;
            case 3:
                temp = new int[]{b, c, a, a, b, c, c, a, b};
                break;
            case 4:
                temp = new int[]{c, b, a, d, a, c, d, b, b, d, c, a, d, a, b, c};
                break;
            case 5:
                temp = new int[]{e, d, c, a, b, d, c, e, b, a, b, e, a, d, c, c, a, b, e, d, a, b, d, c, e};
                break;
        }
        return Arrays.toString(temp).replace(",", "").replace(" ", "").replace("[", "").replace("]", "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        ArrayList<String>[] test = new ArrayList[T];

        for (int i = 0; i < T; i++) {
            test[i] = new ArrayList<>();
            N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] possibilities = new int[N];
            for (int j = 0; j < N; j++) possibilities[j] = j + 1;

            boolean foundAnswer = false;

            outerLoop:
            for (int a = 0; a < N; a++) {
                int choiceA = possibilities[a];
                for (int b = 0; b < N; b++) {
                    if (a == b) continue;
                    int choiceB = possibilities[b];
                    if (N == 2) {
                        if (choiceA + choiceA == K || choiceB + choiceB == K) {
                            test[i].add(makeMatrix(choiceA, choiceB, 0, 0, 0));
                            foundAnswer = true;
                            break outerLoop;
                        }
                    } else {
                        for (int c = 0; c < N; c++) {
                            if (c == a || c == b) continue;
                            int choiceC = possibilities[c];
                            if (N == 3) {
                                if (choiceA + choiceB + choiceC == K || choiceA + choiceA + choiceA == K) {
                                    test[i].add(makeMatrix(choiceA, choiceB, choiceC, 0, 0));
                                    foundAnswer = true;
                                    break outerLoop;
                                }
                            } else {
                                for (int d = 0; d < N; d++) {
                                    if (d == a || d == b || d == c) continue;
                                    int choiceD = possibilities[d];
                                    if (N == 4) {
                                        if (choiceB * 4 == K || choiceC * 2 + choiceD * 2 == K) {
                                            test[i].add(makeMatrix(choiceA, choiceB, choiceC, choiceD, 0));
                                            foundAnswer = true;
                                            break outerLoop;
                                        }
                                    } else {
                                        for (int e = 0; e < N; e++) {
                                            if (e == a || e == b || e == c || e == d) continue;
                                            int choiceE = possibilities[e];
                                            if (N == 5) {
                                                if (choiceA * 2 + choiceC * 2 + choiceE == K || choiceC + choiceE + choiceA + 2 * choiceB == K) {
                                                    test[i].add(makeMatrix(choiceA, choiceB, choiceC, choiceD, choiceE));
                                                    foundAnswer = true;
                                                    break outerLoop;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (!foundAnswer) test[i].add("0");
        }

        for (int i = 0; i < T; i++) {
            if (test[i].get(0).equals("0")) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                String result = test[i].get(0);
                int length = result.length();
                int step = (int) Math.sqrt(length);
                for (int j = 0; j < length; j += step) {
                    for (int k = 0; k < step; k++) {
                        System.out.print(result.charAt(j + k));
                        if (k < step - 1) System.out.print(" ");
                    }
                    System.out.println();
                }
            }
        }
    }
}