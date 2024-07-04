import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            if (!processInput(scanner, A, B)) {
                System.exit(0);
            }
        }
    }

    private static boolean processInput(Scanner scanner, int minRange, int maxRange) {
        int[] answer = new int[2];
        int left = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        int bottom = Integer.MIN_VALUE;

        int[] possibleLeft = {-1000000000, 1000000000};
        int[] possibleTop = {1000000000, -1000000000};
        int[] possibleRight = {1000000000, -1000000000};
        int[] possibleBottom = {-1000000000, 1000000000};

        for (int i = 0; i < 299; ++i) {
            if (left == Integer.MIN_VALUE) {
                String result = makeGuess(scanner, (possibleLeft[0] + possibleLeft[1]) / 2, 0);
                if (result.equals("MISS")) {
                    possibleLeft[0] = (possibleLeft[0] + possibleLeft[1]) / 2;
                } else if (result.equals("HIT")) {
                    possibleLeft[1] = (possibleLeft[0] + possibleLeft[1]) / 2;
                } else {
                    return result.equals("CENTER");
                }
                if (possibleLeft[1] - possibleLeft[0] == 1) {
                    if (possibleLeft[0] == -1000000000) {
                        ++i;
                        left = makeGuess(scanner, possibleLeft[0], 0).equals("HIT") ? possibleLeft[0] : possibleLeft[1];
                    } else {
                        left = possibleLeft[1];
                    }
                    possibleRight[1] = left;
                }
            } else if (right == Integer.MIN_VALUE) {
                String result = makeGuess(scanner, (possibleRight[0] + possibleRight[1]) / 2, 0);
                if (result.equals("MISS")) {
                    possibleRight[0] = (possibleRight[0] + possibleRight[1]) / 2;
                } else if (result.equals("HIT")) {
                    possibleRight[1] = (possibleRight[0] + possibleRight[1]) / 2;
                } else {
                    return result.equals("CENTER");
                }
                if (possibleRight[1] - possibleRight[0] == -1) {
                    if (possibleRight[0] == 1000000000) {
                        ++i;
                        right = makeGuess(scanner, possibleRight[0], 0).equals("HIT") ? possibleRight[0] : possibleRight[1];
                    } else {
                        right = possibleRight[1];
                    }
                    answer[0] = (left + right) / 2;
                }
            } else if (top == Integer.MIN_VALUE) {
                String result = makeGuess(scanner, answer[0], (possibleTop[0] + possibleTop[1]) / 2);
                if (result.equals("MISS")) {
                    possibleTop[0] = (possibleTop[0] + possibleTop[1]) / 2;
                } else if (result.equals("HIT")) {
                    possibleTop[1] = (possibleTop[0] + possibleTop[1]) / 2;
                } else {
                    return result.equals("CENTER");
                }
                if (possibleTop[1] - possibleTop[0] == -1) {
                    if (possibleTop[0] == 1000000000) {
                        ++i;
                        top = makeGuess(scanner, possibleTop[0], 0).equals("HIT") ? possibleTop[0] : possibleTop[1];
                    } else {
                        top = possibleTop[1];
                    }
                    possibleBottom[1] = top;
                }
            } else if (bottom == Integer.MIN_VALUE) {
                String result = makeGuess(scanner, answer[0], (possibleBottom[0] + possibleBottom[1]) / 2);
                if (result.equals("MISS")) {
                    possibleBottom[0] = (possibleBottom[0] + possibleBottom[1]) / 2;
                } else if (result.equals("HIT")) {
                    possibleBottom[1] = (possibleBottom[0] + possibleBottom[1]) / 2;
                } else {
                    return result.equals("CENTER");
                }
                if (possibleBottom[1] - possibleBottom[0] == 1) {
                    if (possibleBottom[0] == -1000000000) {
                        ++i;
                        bottom = makeGuess(scanner, possibleBottom[0], 0).equals("HIT") ? possibleBottom[0] : possibleBottom[1];
                    } else {
                        bottom = possibleBottom[1];
                    }
                    answer[1] = (top + bottom) / 2;
                }
            } else {
                answer[0] = (left + right) / 2;
                answer[1] = (top + bottom) / 2;
                break;
            }
        }
        return makeGuess(scanner, answer[0], answer[1]).equals("CENTER");
    }

    private static String makeGuess(Scanner scanner, int x, int y) {
        System.out.println(x + " " + y);
        System.out.flush();
        return scanner.next();
    }
}