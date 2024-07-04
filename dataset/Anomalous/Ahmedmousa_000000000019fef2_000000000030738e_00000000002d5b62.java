import java.util.Scanner;

public class Main {
    private static String solution = "";
    private static boolean isValid = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder fullAnswer = new StringBuilder();

        int totalCases = Integer.parseInt(scanner.nextLine());
        for (int caseId = 1; caseId <= totalCases; caseId++) {
            String[] coordinates = scanner.nextLine().split(" ");
            long goalX = Long.parseLong(coordinates[0]);
            long goalY = Long.parseLong(coordinates[1]);

            if ((goalX + goalY) % 2 != 0) {
                findPath(1, 'N', "", 0, 1, goalX, goalY);
                findPath(1, 'E', "", 1, 0, goalX, goalY);
                findPath(1, 'W', "", -1, 0, goalX, goalY);
                findPath(1, 'S', "", 0, -1, goalX, goalY);
            }

            fullAnswer.append("Case #").append(caseId).append(": ");
            if (isValid) {
                fullAnswer.append(solution);
            } else {
                fullAnswer.append("IMPOSSIBLE");
            }
            if (caseId != totalCases) {
                fullAnswer.append("\n");
            }
            solution = "";
            isValid = false;
        }
        System.out.println(fullAnswer.toString());
    }

    private static void findPath(long step, char direction, String path, long curX, long curY, long goalX, long goalY) {
        path += direction;

        if (curX == goalX && curY == goalY) {
            isValid = true;
            if (solution.isEmpty() || path.length() < solution.length()) {
                solution = path;
            }
            return;
        }

        if (Math.pow(2, step) > Math.abs(goalX) + Math.abs(goalY)) {
            return;
        }

        step++;
        long newStep = (long) Math.pow(2, step - 1);
        findPath(step, 'N', path, curX, curY + newStep, goalX, goalY);
        findPath(step, 'E', path, curX + newStep, curY, goalX, goalY);
        findPath(step, 'W', path, curX - newStep, curY, goalX, goalY);
        findPath(step, 'S', path, curX, curY - newStep, goalX, goalY);
    }
}