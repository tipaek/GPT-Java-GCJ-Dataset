import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().processCases();
    }

    public void processCases() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= numberOfCases; i++) {
            handleCase(i, reader);
        }
    }

    public void handleCase(int caseNumber, BufferedReader reader) throws Exception {
        String[] input = reader.readLine().split(" ");
        long x = Long.parseLong(input[0]);
        long y = Long.parseLong(input[1]);

        determineSolution(caseNumber, x, y);
    }

    private boolean isSolutionFound;
    private String solution;

    public void determineSolution(int caseNumber, long x, long y) {
        isSolutionFound = false;
        solution = "";

        if (!areBothEvenOrOdd(x, y)) {
            long maxIndex = (long) (Math.log(Math.abs(x) + Math.abs(y)) / Math.log(2)) + 1;
            searchSolution(0, 0, 0, x, y, maxIndex, new StringBuilder());
        }

        if (!isSolutionFound) {
            solution = "IMPOSSIBLE";
        }
        System.out.println("Case #" + caseNumber + ": " + solution);
    }

    public void searchSolution(long index, long currentX, long currentY, long targetX, long targetY, long maxIndex, StringBuilder path) {
        if (index > maxIndex) {
            return;
        }

        if (currentX == targetX && currentY == targetY) {
            isSolutionFound = true;
            solution = path.toString();
            return;
        }

        long step = 1L << index; // Equivalent to Math.pow(2, index)

        path.append("N");
        searchSolution(index + 1, currentX, currentY + step, targetX, targetY, maxIndex, path);
        path.setLength(path.length() - 1);
        if (isSolutionFound) return;

        path.append("S");
        searchSolution(index + 1, currentX, currentY - step, targetX, targetY, maxIndex, path);
        path.setLength(path.length() - 1);
        if (isSolutionFound) return;

        path.append("E");
        searchSolution(index + 1, currentX + step, currentY, targetX, targetY, maxIndex, path);
        path.setLength(path.length() - 1);
        if (isSolutionFound) return;

        path.append("W");
        searchSolution(index + 1, currentX - step, currentY, targetX, targetY, maxIndex, path);
        path.setLength(path.length() - 1);
        if (isSolutionFound) return;
    }

    public boolean areBothEvenOrOdd(long x, long y) {
        return (x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0);
    }
}