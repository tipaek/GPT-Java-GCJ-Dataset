import java.util.*;

public class Solution {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> solutions;
    int exponent;

    void run(){
        int tests = sc.nextInt();

        for( int t = 0; t < tests; t++){
            solve(t);
        }
    }

    void solve(int t){
        solutions = new ArrayList<>();
        int n = t + 1;
        int x = sc.nextInt();
        int y = sc.nextInt();

        int xAbs = Math.abs(x);
        int yAbs = Math.abs(y);

        if ((xAbs % 2 == 0 && yAbs % 2 == 0) || (xAbs % 2 != 0 && yAbs % 2 != 0)) {
            System.out.println("Case #" + n + ": IMPOSSIBLE");
            return;
        }

        int largest = 1;
        exponent = 0;

        while (xAbs - largest >= 0 || yAbs - largest >= 0) {
            largest *= 2;
            exponent += 1;
        }

        StringBuilder solution = new StringBuilder();
        if (xAbs % 2 != 0) {
            tryStep(x + 1, y, new StringBuilder(solution).append("W"), 1);
            tryStep(x - 1, y, new StringBuilder(solution).append("E"), 1);
        } else {
            tryStep(x, y + 1, new StringBuilder(solution).append("S"), 1);
            tryStep(x, y - 1, new StringBuilder(solution).append("N"), 1);
        }

        if (solutions.size() == 0) {
            System.out.println("Case #" + n + ": IMPOSSIBLE");
            return;
        }

        String bestSolution = solutions.get(0);
        for (int i = 1; i < solutions.size(); i++) {
            if (bestSolution.length() > solutions.get(i).length()) {
                bestSolution = solutions.get(i);
            }
        }

        System.out.println("Case #" + n + ": " + bestSolution);

    }

    void tryStep(int x, int y, StringBuilder solution, int i) {
        if (x == 0 && y == 0) {
            solutions.add(solution.toString());
            return;
        }
        //if (i > 8) {
          //  return;
        //}
        if (i > exponent) {
            return;
        }
        if (y != 0) {
            tryStep(x, y + (int) Math.pow(2, i), new StringBuilder(solution).append("S"), i+1);
            tryStep(x, y - (int) Math.pow(2, i), new StringBuilder(solution).append("N"), i+1);
        }
        if (x != 0) {
            tryStep(x + (int) Math.pow(2, i), y, new StringBuilder(solution).append("W"), i+1);
            tryStep(x - (int) Math.pow(2, i), y, new StringBuilder(solution).append("E"), i+1);
        }
    }


    public static void main(String[] args){
        (new Solution()).run();
    }
}
