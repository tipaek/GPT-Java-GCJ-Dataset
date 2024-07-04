import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < cases; i++) {
            String[] input = scanner.nextLine().split(" ", 2);
            processCase(i + 1, Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
    }

    private static void processCase(int caseNumber, int x, int y) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);

        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            return;
        }

        int maxPowerX = (int) Math.ceil(Math.log(absX) / Math.log(2));
        int maxPowerY = (int) Math.ceil(Math.log(absY) / Math.log(2));
        int maxPower = Math.max(maxPowerX, maxPowerY);

        List<Integer> path = findPath(new ArrayList<>(), 0, 0, absX, absY, -1, (int) Math.pow(2, maxPower));
        if (path == null) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            return;
        }

        boolean positiveX = x > 0;
        boolean positiveY = y > 0;

        StringBuilder pathString = new StringBuilder();
        for (int move : path) {
            switch (move) {
                case 0:
                    pathString.append(positiveX ? "E" : "W");
                    break;
                case 1:
                    pathString.append(positiveX ? "W" : "E");
                    break;
                case 2:
                    pathString.append(positiveY ? "N" : "S");
                    break;
                case 3:
                    pathString.append(positiveY ? "S" : "N");
                    break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + pathString);
    }

    private static List<Integer> findPath(List<Integer> moves, int currentX, int currentY, int targetX, int targetY, int step, int maxSteps) {
        if (step > maxSteps) return null;
        if (currentX == targetX && currentY == targetY) return moves;
        if (currentX > targetX || currentY > targetY) return null;

        int nextStep = step * 2;
        if (nextStep == -2) nextStep = 1;

        List<List<Integer>> possiblePaths = new ArrayList<>();

        possiblePaths.add(findPath(addMove(moves, 0), currentX + nextStep, currentY, targetX, targetY, nextStep, maxSteps));
        possiblePaths.add(findPath(addMove(moves, 1), currentX - nextStep, currentY, targetX, targetY, nextStep, maxSteps));
        possiblePaths.add(findPath(addMove(moves, 2), currentX, currentY + nextStep, targetX, targetY, nextStep, maxSteps));
        possiblePaths.add(findPath(addMove(moves, 3), currentX, currentY - nextStep, targetX, targetY, nextStep, maxSteps));

        List<Integer> shortestPath = null;
        int shortestSize = Integer.MAX_VALUE;
        for (List<Integer> path : possiblePaths) {
            if (path != null && path.size() < shortestSize) {
                shortestPath = path;
                shortestSize = path.size();
            }
        }

        return shortestPath;
    }

    private static List<Integer> addMove(List<Integer> list, int move) {
        List<Integer> newList = new ArrayList<>(list);
        newList.add(move);
        return newList;
    }
}