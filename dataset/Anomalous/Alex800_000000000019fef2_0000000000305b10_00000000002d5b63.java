import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static int A = 0;
    static int B = 0;

    public static int[] findHorizontalBounds(int x, int y, Scanner in) {
        int leftBoundary = Math.max(x - 2 * A, -1000000000);
        int rightBoundary = x;
        int left = binarySearchHorizontal(leftBoundary, rightBoundary, y, in, 1);
        
        if (left == 1000000001) {
            return new int[]{left, left};
        }

        rightBoundary = x;
        leftBoundary = Math.min(x + 2 * A, 1000000000);
        int right = binarySearchHorizontal(rightBoundary, leftBoundary, y, in, -1);
        
        if (right == 1000000001) {
            return new int[]{right, right};
        }

        return new int[]{left, right};
    }

    public static int findVerticalBound(int x, int y, Scanner in) {
        int lowerBoundary = Math.max(y - 2 * A, -1000000000);
        int upperBoundary = y;
        return binarySearchVertical(lowerBoundary, upperBoundary, x, in, 1);
    }

    public static int binarySearchVertical(int lowerBoundary, int upperBoundary, int y, Scanner in, int step) {
        if (lowerBoundary == upperBoundary) return lowerBoundary;

        int mid = (lowerBoundary + upperBoundary) / 2;
        System.out.println(y + " " + mid);
        String response = in.next();

        if (response.equals("CENTER")) return 1000000001;
        
        if (response.equals("HIT")) {
            System.out.println(y + " " + (mid - step));
            String secondResponse = in.next();
            
            if (secondResponse.equals("HIT")) {
                return binarySearchVertical(lowerBoundary, mid - step, y, in, step);
            } else if (secondResponse.equals("CENTER")) {
                return 1000000001;
            } else {
                return mid;
            }
        } else {
            System.out.println(y + " " + (mid + step));
            String secondResponse = in.next();
            
            if (secondResponse.equals("HIT")) {
                return mid + step;
            } else if (secondResponse.equals("CENTER")) {
                return 1000000001;
            } else {
                return binarySearchVertical(mid + step, upperBoundary, y, in, step);
            }
        }
    }

    public static int binarySearchHorizontal(int leftBoundary, int rightBoundary, int y, Scanner in, int step) {
        if (leftBoundary == rightBoundary) return leftBoundary;

        int mid = (leftBoundary + rightBoundary) / 2;
        System.out.println(mid + " " + y);
        String response = in.next();

        if (response.equals("CENTER")) return 1000000001;
        
        if (response.equals("HIT")) {
            System.out.println((mid - step) + " " + y);
            String secondResponse = in.next();
            
            if (secondResponse.equals("HIT")) {
                return binarySearchHorizontal(leftBoundary, mid - step, y, in, step);
            } else if (secondResponse.equals("CENTER")) {
                return 1000000001;
            } else {
                return mid;
            }
        } else {
            System.out.println((mid + step) + " " + y);
            String secondResponse = in.next();
            
            if (secondResponse.equals("HIT")) {
                return mid + step;
            } else if (secondResponse.equals("CENTER")) {
                return 1000000001;
            } else {
                return binarySearchHorizontal(mid + step, rightBoundary, y, in, step);
            }
        }
    }

    public static void solve(String guess, Scanner in) {
        String[] coordinates = guess.split(" ");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        int[] horizontalBounds = findHorizontalBounds(x, y, in);
        if (horizontalBounds[0] == 1000000001) return;

        int lowerBound = findVerticalBound(x, y, in);
        if (lowerBound == 1000000001) return;

        int upperBound = y + (x - horizontalBounds[0]) * (horizontalBounds[1] - x) / (y - lowerBound);

        int centerX = (horizontalBounds[0] + horizontalBounds[1]) / 2;
        int centerY = (lowerBound + upperBound) / 2;

        System.out.println(centerX + " " + centerY);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int T = in.nextInt();
        A = in.nextInt();
        B = in.nextInt();

        for (int t = 1; t <= T; ++t) {
            String[] initialGuesses = {
                "0 0", "1000000000 1000000000", "-1000000000 1000000000", 
                "1000000000 -1000000000", "-1000000000 -1000000000"
            };
            boolean hit = false;
            int count = 0;

            while (!hit) {
                String guess = initialGuesses[count];
                System.out.println(guess);
                String response = in.next();
                
                if (response.equals("CENTER")) return;
                if (response.equals("HIT")) hit = true;
                count++;
            }

            solve(initialGuesses[--count], in);
        }
        in.close();
    }
}