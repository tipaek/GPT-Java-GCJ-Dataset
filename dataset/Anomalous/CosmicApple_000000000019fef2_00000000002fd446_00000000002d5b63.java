import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTests = input.nextInt();
        int min = input.nextInt();
        int max = input.nextInt();

        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            Solver solver = new Solver(input, min, max);
            solver.solve();
        }
    }
}

class Solver {
    private int min;
    private int max;
    private Scanner input;
    private boolean hitCenter = false;
    private static final int LENGTH = (int) Math.pow(10, 9) * 2;
    private int numOfTries = 0;

    public Solver(Scanner input, int min, int max) {
        this.min = min;
        this.max = max;
        this.input = input;
    }

    public void solve() {
        int[] hit = findHit();
        if (hitCenter) return;

        int leftBound = findXBound(hit[0], -LENGTH / 2, hit[1]);
        if (hitCenter) return;

        int rightBound = findXBound(hit[0], LENGTH / 2, hit[1]);
        if (hitCenter) return;

        int middleX = (leftBound + rightBound) / 2;

        int topBound = findYBound(hit[1], LENGTH / 2, middleX);
        if (hitCenter) return;

        int bottomBound = findYBound(hit[1], -LENGTH / 2, middleX);
        if (hitCenter) return;

        int middleY = (topBound + bottomBound) / 2;

        int check = checkPosition(middleX, middleY);
        if (hitCenter) return;
        else System.out.println("Fatal Error");
    }

    private int findXBound(int hit, int miss, int y) {
        int check = checkPosition(miss, y);

        if (check == 1) return miss;
        if (hitCenter) return -1;

        while (Math.abs(hit - miss) != 1) {
            int test = (hit + miss) / 2;
            check = checkPosition(test, y);

            if (check == 1) hit = test;
            else miss = test;

            if (hitCenter) return -1;
        }
        return hit;
    }

    private int findYBound(int hit, int miss, int x) {
        int check = checkPosition(x, miss);

        if (check == 1) return miss;
        if (hitCenter) return -1;

        while (Math.abs(hit - miss) != 1) {
            int test = (hit + miss) / 2;
            check = checkPosition(x, test);

            if (check == 1) hit = test;
            else miss = test;

            if (hitCenter) return -1;
        }
        return hit;
    }

    private int[] findHit() {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int check = checkPosition(LENGTH / 5 * i - LENGTH / 2, LENGTH / 5 * j - LENGTH / 2);
                if (check == 1)
                    return new int[]{LENGTH / 5 * i - LENGTH / 2, LENGTH / 5 * j - LENGTH / 2};
            }
        }
        return null;
    }

    private int checkPosition(int x, int y) {
        numOfTries++;
        if (numOfTries >= 300) {
            throw new RuntimeException("Exceeded maximum number of tries");
        }

        System.out.println(x + " " + y);
        String response = input.next();
        switch (response) {
            case "CENTER":
                hitCenter = true;
                return 1;
            case "HIT":
                return 1;
            case "MISS":
                return 0;
            case "WRONG":
                throw new IllegalStateException("Received WRONG response");
            default:
                System.out.println("Error");
                return -1;
        }
    }
}