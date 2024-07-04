import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int noOfCases = in.nextInt();

        for (int caseNo = 1; caseNo <= noOfCases; ++caseNo) {
            int X = in.nextInt();
            int Y = in.nextInt();

            String path = in.next("[NSWE]+");
            Solution solution = new Solution();

            int steps = solution.findIntersection(X, Y, path);

            if (steps == -1) {
                System.out.println("Case #" + caseNo + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNo + ": " + steps);
            }

        }
    }

    public int findIntersection(int X, int Y, String path) {
        return calculate(X, Y, path, 0);
    }

    public int calculate(int X, int Y, String path, int index) {

        String key = String.valueOf(X) + " " + String.valueOf(Y) + " " + String.valueOf(index);

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (Math.abs(X) + Math.abs(Y) <= index) {
            cache.put(key, index);
            return index;
        }

        if (index > path.length() - 1) {
            cache.put(key, -1);
            return -1;
        }

        char c = path.charAt(index);
        int dX = 0;
        int dY = 0;

        switch (c) {
            case 'E':
                dX += 1;
                break;
            case 'W':
                dX -= 1;
                break;
            case 'N':
                dY += 1;
                break;
            case 'S':
                dY -= 1;
                break;
        }

        int steps = calculate(X + dX, Y + dY, path, index + 1);
        cache.put(key, steps);

        return steps;
    }

}