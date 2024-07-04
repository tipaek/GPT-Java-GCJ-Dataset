import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            solve(test);
        }
    }

    static void solve(int test) {
        char[] directions = {'N', 'S', 'E', 'W'};
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int maxSteps = (int) (Math.log(Math.max(Math.abs(X), Math.abs(Y))) / Math.log(2)) + 2;

        for (int i = maxSteps / 2; i <= maxSteps; i++) {
            list.clear();
            generateAllCombinations(directions, i);
            for (String sequence : list) {
                if (isValidMove(sequence, X, Y)) {
                    System.out.println("Case #" + test + ": " + sequence);
                    return;
                }
            }
        }

        System.out.println("Case #" + test + ": IMPOSSIBLE");
    }

    static void generateAllCombinations(char[] set, int length) {
        generateCombinationsRec(set, "", set.length, length);
    }

    static void generateCombinationsRec(char[] set, String prefix, int setLength, int remainingLength) {
        if (remainingLength == 0) {
            list.add(prefix);
            return;
        }

        for (int i = 0; i < setLength; ++i) {
            String newPrefix = prefix + set[i];
            generateCombinationsRec(set, newPrefix, setLength, remainingLength - 1);
        }
    }

    static boolean isValidMove(String sequence, int targetX, int targetY) {
        int[] position = calculatePosition(sequence);
        return position[0] == targetX && position[1] == targetY;
    }

    static int[] calculatePosition(String sequence) {
        int[] position = new int[2];
        for (int i = 0; i < sequence.length(); i++) {
            switch (sequence.charAt(i)) {
                case 'N':
                    position[1] += Math.pow(2, i);
                    break;
                case 'S':
                    position[1] -= Math.pow(2, i);
                    break;
                case 'E':
                    position[0] += Math.pow(2, i);
                    break;
                case 'W':
                    position[0] -= Math.pow(2, i);
                    break;
            }
        }
        return position;
    }
}