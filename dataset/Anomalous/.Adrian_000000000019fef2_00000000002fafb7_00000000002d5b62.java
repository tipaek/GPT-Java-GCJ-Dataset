import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < amount; i++) {
            String[] info = scanner.nextLine().split(" ", 2);
            solve(i + 1, Integer.parseInt(info[0]), Integer.parseInt(info[1]));
        }
    }

    private static void solve(int test, int x, int y) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);

        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
            System.out.println("Case #" + test + ": IMPOSSIBLE");
            return;
        }

        int maxStepsX = (int) Math.ceil(Math.log(absX) / Math.log(2));
        int maxStepsY = (int) Math.ceil(Math.log(absY) / Math.log(2));
        int maxSteps = Math.max(maxStepsX, maxStepsY);

        List<Integer> path = findPath(new ArrayList<>(), 0, 0, absX, absY, -1, (int) Math.pow(2, maxSteps));
        if (path == null) {
            System.out.println("Case #" + test + ": IMPOSSIBLE");
            return;
        }

        boolean moveRight = x > 0;
        boolean moveUp = y > 0;

        StringBuilder pathString = new StringBuilder();
        for (int move : path) {
            switch (move) {
                case 0:
                    pathString.append(moveRight ? "E" : "W");
                    break;
                case 1:
                    pathString.append(moveRight ? "W" : "E");
                    break;
                case 2:
                    pathString.append(moveUp ? "N" : "S");
                    break;
                case 3:
                    pathString.append(moveUp ? "S" : "N");
                    break;
            }
        }

        System.out.println("Case #" + test + ": " + pathString);
    }

    private static List<Integer> findPath(List<Integer> moves, int x, int y, int targetX, int targetY, int stepSize, int maxStepSize) {
        if (stepSize > maxStepSize) return null;
        if (x == targetX && y == targetY) return moves;
        if (x > targetX || y > targetY || x + maxStepSize < targetX || y + maxStepSize < targetY) return null;

        int nextStepSize = stepSize * 2;
        if (nextStepSize == -2) nextStepSize = 1;

        List<List<Integer>> possiblePaths = new ArrayList<>();
        List<Integer> result;

        result = findPath(appendMove(moves, 0), x + nextStepSize, y, targetX, targetY, nextStepSize, maxStepSize);
        if (result != null) possiblePaths.add(result);
        result = findPath(appendMove(moves, 1), x - nextStepSize, y, targetX, targetY, nextStepSize, maxStepSize);
        if (result != null) possiblePaths.add(result);
        result = findPath(appendMove(moves, 2), x, y + nextStepSize, targetX, targetY, nextStepSize, maxStepSize);
        if (result != null) possiblePaths.add(result);
        result = findPath(appendMove(moves, 3), x, y - nextStepSize, targetX, targetY, nextStepSize, maxStepSize);
        if (result != null) possiblePaths.add(result);

        return possiblePaths.stream().min(Comparator.comparingInt(List::size)).orElse(null);
    }

    private static List<Integer> appendMove(List<Integer> moves, int move) {
        List<Integer> newMoves = new ArrayList<>(moves);
        newMoves.add(move);
        return newMoves;
    }
}