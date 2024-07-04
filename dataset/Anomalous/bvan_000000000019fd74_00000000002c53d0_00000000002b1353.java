import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int targetSum = Integer.parseInt(reader.readLine());
            List<Step> path = findPascalWalk(targetSum);
            System.out.println(String.format("Case #%d:", testCase));
            path.forEach(step -> System.out.println(step));
        }
    }

    private static List<Step> findPascalWalk(int targetSum) {
        List<Step> path = new ArrayList<>();
        path.add(new Step(1, 1));
        if (targetSum > 1) {
            path.add(new Step(2, 2));
        }
        for (int row = 2, remainingSum = targetSum - 2; row <= remainingSum; row++) {
            path.add(new Step(row + 1, 1));
        }
        return path;
    }

    private static class Step {
        private final int row;
        private final int col;

        public Step(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return row + " " + col;
        }
    }
}