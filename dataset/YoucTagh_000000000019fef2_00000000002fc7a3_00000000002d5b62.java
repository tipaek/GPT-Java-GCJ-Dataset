import java.util.Scanner;

class Solution {

    static Scanner sc = new Scanner(System.in);
    static int X, Y;

    public static void main(String[] args) {
        int testCase = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCase; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve();
        }

    }

    private static void solve() {
        X = sc.nextInt();
        Y = sc.nextInt();
        String bestPath = pathToFollow(0, 0, "", 1);
        System.out.println(bestPath);
    }

    private static String pathToFollow(int x, int y, String pathSoFar, int nextStep) {
        if (X == x && Y == y) {
            return pathSoFar;
        } else {
            if (pathSoFar.length() > Math.abs(X)+Math.abs(Y) ) {
                return "IMPOSSIBLE";
            } else {
                String best = "IMPOSSIBLE";
                best = best(best, pathToFollow(x, y + nextStep, (pathSoFar + "N"), nextStep * 2));
                best = best(best, pathToFollow(x, y - nextStep, (pathSoFar + "S"), nextStep * 2));
                best = best(best, pathToFollow(x - nextStep, y, (pathSoFar + "W"), nextStep * 2));
                best = best(best, pathToFollow(x + nextStep, y, (pathSoFar + "E"), nextStep * 2));
                return best;
            }
        }
    }

    private static String best(String best, String newOne) {
        if (best.equals("IMPOSSIBLE")) {
            return newOne;
        } else if (newOne.equals("IMPOSSIBLE")) {
            return best;
        } else if (newOne.length() < best.length()) {
            return newOne;
        } else
            return best;


    }

}