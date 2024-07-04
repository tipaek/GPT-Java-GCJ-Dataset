import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.hasNext() ? sc.nextInt() : 0;
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int X = sc.hasNext() ? sc.nextInt() : 0;
            int Y = sc.hasNext() ? sc.nextInt() : 0;

            if ((X + Y) % 2 == 0) {
                results.add("IMPOSSIBLE");
            } else {
                if (X == 0) {
                    results.add(handleZeroX(Y));
                } else if (Y == 0) {
                    results.add(handleZeroY(X));
                } else {
                    results.add(handleNonZeroXY(X, Y));
                }
            }
        }

        sc.close();
        results.forEach(System.out::println);
    }

    private static String handleZeroX(int Y) {
        if (Y < 0) {
            Y = Math.abs(Y);
        }
        int a = Y / 2;
        ArrayList<Integer> powersOfTwo = generatePowersOfTwo(a);
        return checkSum(Y, powersOfTwo) ? "POSSIBLE" : "IMPOSSIBLE";
    }

    private static String handleZeroY(int X) {
        if (X < 0) {
            X = Math.abs(X);
        }
        int a = X / 2;
        ArrayList<Integer> powersOfTwo = generatePowersOfTwo(a);
        return checkSum(X, powersOfTwo) ? "POSSIBLE" : "IMPOSSIBLE";
    }

    private static String handleNonZeroXY(int X, int Y) {
        if (X % 2 == 0) {
            return handleEvenX(X, Y);
        } else if (Y % 2 == 0) {
            return handleEvenY(X, Y);
        }
        return "IMPOSSIBLE";
    }

    private static String handleEvenX(int X, int Y) {
        if (X > Y) {
            // Implement specific logic for even X and X > Y
        } else if (Y > X) {
            // Implement specific logic for even X and Y > X
        }
        return "IMPOSSIBLE";
    }

    private static String handleEvenY(int X, int Y) {
        if (X > Y) {
            // Implement specific logic for even Y and X > Y
        } else if (Y > X) {
            // Implement specific logic for even Y and Y > X
        }
        return "IMPOSSIBLE";
    }

    private static ArrayList<Integer> generatePowersOfTwo(int limit) {
        ArrayList<Integer> powersOfTwo = new ArrayList<>();
        for (int j = 0; j <= limit; j++) {
            powersOfTwo.add((int) Math.pow(2, j));
        }
        return powersOfTwo;
    }

    private static boolean checkSum(int target, ArrayList<Integer> powersOfTwo) {
        int sum = 0;
        for (int power : powersOfTwo) {
            sum += power;
            if (sum == target) {
                return true;
            }
        }
        sum = target;
        for (int power : powersOfTwo) {
            sum -= power;
            if (sum == target) {
                return true;
            }
        }
        return false;
    }
}