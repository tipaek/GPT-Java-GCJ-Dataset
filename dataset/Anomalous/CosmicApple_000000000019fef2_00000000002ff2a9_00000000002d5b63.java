import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfTests = scanner.nextInt();
        int min = scanner.nextInt();
        int max = scanner.nextInt();

        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            Solver solver = new Solver(scanner, min, max);
            solver.solve();
        }
    }
}

class Solver {
    private int min;
    private int max;
    private Scanner scanner;
    private boolean hitCenter = false;
    private int length = (int) (2 * Math.pow(10, 9));
    private int numOfTries = 0;
    private boolean foundHit = false;

    public Solver(Scanner scanner, int min, int max) {
        this.min = min;
        this.max = max;
        this.scanner = scanner;
    }

    public void solve() {
        int[] hit = findHit();
        if (hitCenter) return;

        foundHit = true;

        int leftBound = findXBound(hit[0], -length / 2, hit[1]);
        if (hitCenter) return;

        int rightBound = findXBound(hit[0], length / 2, hit[1]);
        if (hitCenter) return;

        int middleX = (leftBound + rightBound) / 2;

        int topBound = findYBound(hit[1], length / 2, middleX);
        if (hitCenter) return;

        int bottomBound = findYBound(hit[1], -length / 2, middleX);
        if (hitCenter) return;

        int middleY = (topBound + bottomBound) / 2;

        int check = checkPosition(middleX, middleY);
        if (hitCenter) return;

        System.out.println("Fatal Error");
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
                int check = checkPosition((length / 5) * i - (length / 2), (length / 5) * j - (length / 2));
                if (check == 1) {
                    return new int[]{(length / 5) * i - (length / 2), (length / 5) * j - (length / 2)};
                }
            }
        }
        return null;
    }

    private int checkPosition(int x, int y) {
        numOfTries++;
        if (numOfTries == 300) {
            throw new RuntimeException("Exceeded number of tries");
        }

        System.out.println(x + " " + y);
        String response = scanner.next();

        switch (response) {
            case "CENTER":
                hitCenter = true;
                return 1;
            case "HIT":
                return 1;
            case "MISS":
                return 0;
            case "WRONG":
                if (foundHit && (x > length / 2 || x < -length / 2 || y > length / 2 || y < -length / 2)) {
                    throw new RuntimeException("Coordinates out of bounds");
                }
                break;
            default:
                System.out.println("Error");
                return -1;
        }
        return -1;
    }
}