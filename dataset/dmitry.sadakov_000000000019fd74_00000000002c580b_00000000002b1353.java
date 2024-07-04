
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c?show=progress
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        Solution s = new Solution();
        s.generatePascalTriangle();
        for (int i = 1; i <= t; i++) {
            int a = in.nextInt();
            in.nextLine();

            List<String> answer = s.solve(a);
            System.out.println("Case #" + i + ": ");
            for (int j = answer.size() - 1; j >= 0; j--) {
            //for (int j = 0; j < answer.size(); j++) {
                System.out.println(answer.get(j));
            }
        }
    }

    long[][] pascal = new long[500][500];

    private void generatePascalTriangle() {
        pascal[0][0] = 1;
        for(int i = 1; i < 100; i++) {
            pascal[i][0] = 1;
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
        }
    }

    List<String> solve(int n) {
        // we have a matrix we want to do
        long sum = 0;
        List<String> steps = new ArrayList<>();

        int i = 0;
        int j = 0;
        walk(i, j, sum, n, steps, false, false);
        return steps;
    }

    private boolean walk(int i, int j, long sum, long n, List<String> steps, boolean steppedLeft, boolean steppedUp) {

        sum += pascal[i][j];
        if (sum == n) {
            steps.add("       sum= " + sum);
            steps.add((i + 1) + " " + (j + 1));
            return true;
        }
        if (sum > n) {
            sum -= pascal[i][j];
            return false;
        }

        int limit = 5;

        // try down

        //System.out.println("i= " + i + "    j = " + j);
        if (!steppedUp && i < limit && pascal[i+1][j] != 0) {
            if (walk(i + 1, j, sum, n, steps, false, false))
            {
                //steps.add("       sum= " + sum);
                steps.add((i + 1) + " " + (j + 1));
                return true;
            }
        }
        // try left
        if (j < limit && pascal[i][j+1] != 0) {
            if (walk(i, j + 1, sum, n, steps, true, false)) {
                //steps.add("       sum= " + sum);
                steps.add((i + 1) + " " + (j + 1));
                return true;
            }
        }

        // try up
        if ((steppedUp || steppedLeft) && 0 < i) {
            if (walk(i - 1, j, sum, n, steps, false, true))
            {
                //steps.add("       sum= " + sum);
                steps.add((i + 1) + " " + (j + 1));
                return true;
            }
        }

        sum -= pascal[i][j];
        return false;
    }
}

