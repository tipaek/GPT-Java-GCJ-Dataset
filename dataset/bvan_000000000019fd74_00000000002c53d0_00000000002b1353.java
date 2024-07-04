import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= tests; t++) { // 1..100
            int sum = Integer.parseInt(reader.readLine());
            List<Step> steps = pascalWalk(sum);
            System.out.println(String.format("Case #%d:", t));
            System.out.println(steps.stream().map(s -> s.show()).collect(Collectors.joining("\n")));
        }
    }

    private static List<Step> pascalWalk(int sum) {
        List<Step> steps = new ArrayList<>();
        steps.add(new Step(0, 0));
        if (sum > 1) {
            steps.add(new Step(1, 1));
        }
        for (int r = 1, last = sum - 2; r <= last; r++) {
            steps.add(new Step(r, 0));
        }
        return steps;
    }

    private static class Step {

        private final int r;
        private final int k;

        public Step(int r, int k) {
            this.r = r;
            this.k = k;
        }

        public String show() {
            return String.format("%s %s", r + 1, k + 1);
        }
    }
}
