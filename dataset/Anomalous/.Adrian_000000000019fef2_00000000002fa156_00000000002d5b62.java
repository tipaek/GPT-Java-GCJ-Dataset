import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < numberOfCases; i++) {
            String[] input = scanner.nextLine().split(" ", 2);
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            processCase(i + 1, x, y);
        }
    }

    private static void processCase(int caseNumber, int x, int y) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);

        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
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

        boolean isXPositive = x > 0;
        boolean isYPositive = y > 0;

        StringBuilder pathString = new StringBuilder();
        for (int direction : path) {
            switch (direction) {
                case 0:
                    pathString.append(isXPositive ? "E" : "W");
                    break;
                case 1:
                    pathString.append(isXPositive ? "W" : "E");
                    break;
                case 2:
                    pathString.append(isYPositive ? "N" : "S");
                    break;
                case 3:
                    pathString.append(isYPositive ? "S" : "N");
                    break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + pathString);
    }

    private static List<Integer> findPath(List<Integer> moves, int currentX, int currentY, int targetX, int targetY, int step, int maxSteps) {
        if (step > maxSteps * 10) return null;
        if (currentX == targetX && currentY == targetY) return moves;
        if (currentX > targetX || currentY > targetY) return null;

        int nextStep = step * 2;
        if (nextStep == -2) nextStep = 1;

        List<Integer> result;

        result = findPath(extendList(moves, 0), currentX + nextStep, currentY, targetX, targetY, nextStep, maxSteps);
        if (result != null) return result;
        result = findPath(extendList(moves, 1), currentX - nextStep, currentY, targetX, targetY, nextStep, maxSteps);
        if (result != null) return result;
        result = findPath(extendList(moves, 2), currentX, currentY + nextStep, targetX, targetY, nextStep, maxSteps);
        if (result != null) return result;
        result = findPath(extendList(moves, 3), currentX, currentY - nextStep, targetX, targetY, nextStep, maxSteps);
        if (result != null) return result;

        return null;
    }

    private static List<Integer> extendList(List<Integer> list, int direction) {
        List<Integer> extendedList = new ArrayList<>(list);
        extendedList.add(direction);
        return extendedList;
    }
}