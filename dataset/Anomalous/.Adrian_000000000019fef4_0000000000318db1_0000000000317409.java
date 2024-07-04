import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCaseCount; i++) {
            String[] inputs = scanner.nextLine().split(" ", 3);
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            List<int[]> moves = parseMoves(inputs[2]);

            processTestCase("Case #" + (i + 1) + ": ", x, y, moves);
        }
        scanner.close();
    }

    private static void processTestCase(String testCaseLabel, int x, int y, List<int[]> moves) {
        if (x == 0 && y == 0) {
            System.out.println(testCaseLabel + "A");
            printResult(testCaseLabel, 0);
            return;
        }

        for (int i = 0; i < moves.size(); i++) {
            int steps = i + 1;
            int[] move = moves.get(i);
            x += move[0];
            y += move[1];

            if (Math.abs(x) + Math.abs(y) <= steps) {
                printResult(testCaseLabel, steps);
                return;
            }
        }
        System.out.println(testCaseLabel + "IMPOSSIBLE");
    }

    private static void printResult(String testCaseLabel, int steps) {
        System.out.println(testCaseLabel + steps);
    }

    private static List<int[]> parseMoves(String moveSequence) {
        List<int[]> moves = new ArrayList<>();
        for (char direction : moveSequence.toCharArray()) {
            switch (direction) {
                case 'E':
                    moves.add(new int[]{1, 0});
                    break;
                case 'W':
                    moves.add(new int[]{-1, 0});
                    break;
                case 'N':
                    moves.add(new int[]{0, 1});
                    break;
                case 'S':
                    moves.add(new int[]{0, -1});
                    break;
            }
        }
        return moves;
    }
}