import java.util.Scanner;

import static java.lang.Math.abs;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nProblems = in.nextInt();
        for (int problemNumber = 0; problemNumber < nProblems; problemNumber++) {
            //read input for each problem
            int X = in.nextInt();
            int Y = in.nextInt();
            String path = in.nextLine();

            solveProblem(problemNumber + 1, X, Y, path.trim());
        }
    }

    private static void solveProblem(int problemNumber, int x, int y, String path) {
        int distance;

        for (int i = 0; i < path.length(); i++) {
            String step = path.substring(i, i+1);
            if ("N".equals(step)) y++;
            if ("E".equals(step)) x++;
            if ("S".equals(step)) y--;
            if ("W".equals(step)) x--;

            distance = abs(x) + abs(y);
            if (distance <= i+1) {
                int number = i+1;
                System.out.println("Case #" + problemNumber + ": " + number);
                return;
            }
        }

        System.out.println("Case #" + problemNumber + ": IMPOSSIBLE");
    }
}