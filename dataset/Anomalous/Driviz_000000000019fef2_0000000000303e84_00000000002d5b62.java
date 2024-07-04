import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
                continue;
            }

            ArrayList<String> results = new ArrayList<>();
            findPath(x, y, 0, 0, results, "", 0);

            Collections.sort(results, (a, b) -> a.length() - b.length());
            if (results.isEmpty() || results.get(0).isEmpty()) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": " + results.get(0));
            }
        }
    }

    static void findPath(int x, int y, int currX, int currY, ArrayList<String> results, String currentPath, int stepNumber) {
        if (x == currX && y == currY) {
            results.add(currentPath);
            return;
        }

        if (Math.abs(currX) > Math.abs(2 * x) || Math.abs(currY) > Math.abs(2 * y)) {
            return;
        }

        int step = (int) Math.pow(2, stepNumber);
        findPath(x, y, currX + step, currY, results, currentPath + 'E', stepNumber + 1);
        findPath(x, y, currX - step, currY, results, currentPath + 'W', stepNumber + 1);
        findPath(x, y, currX, currY + step, results, currentPath + 'N', stepNumber + 1);
        findPath(x, y, currX, currY - step, results, currentPath + 'S', stepNumber + 1);
    }
}