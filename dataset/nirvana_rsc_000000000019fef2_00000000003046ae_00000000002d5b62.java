import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public final class Solution {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final CurrProblem solver = new CurrProblem();
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            System.out.printf("Case #%d: %s\n", x, solver.solve(in));
        }
    }

    static class CurrProblem {
        public String solve(Scanner in) {
            int x = in.nextInt();
            int y = in.nextInt();
            in.nextLine();
            final boolean remapX = x < 0;
            final boolean remapY = y < 0;
            x = Math.abs(x);
            y = Math.abs(y);
            if ((x + y) % 2 == 0) {
                return "IMPOSSIBLE";
            }
            final long i = x + y;
            final Set<Integer> nums = new HashSet<>();
            long curr = 1;
            int sum = 0;
            for (int k = 0; curr <= i; k++) {
                sum += curr;
                nums.add((int)curr);
                curr<<=1L;
            }
            long negative = (sum - i) / 2;
            int power = 0;
            while (negative > 0) {
                if ((negative & 1) != 0) {
                    nums.remove(1 << power);
                    nums.add(-(1 << power));
                }
                ++power;
                negative >>= 1;
            }
            final List<Integer> x1 = combinationSum(new ArrayList<>(nums), x);
            for (int number : x1) {
                nums.remove(number);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> Math.abs(a[1])));
            for (int number : x1) {
                pq.add(new int[] { 0, number });
            }
            for (int number : nums) {
                pq.add(new int[] { 1, number });
            }
            final StringBuilder res = new StringBuilder();
            int xx = 0;
            int yy = 0;
            while (!pq.isEmpty()) {
                int[] c = pq.remove();
                if (c[0] == 0) {
                    xx += c[1];
                    if (remapX) {
                        if (c[1] > 0) {
                            res.append('W');
                        } else {
                            res.append('E');
                        }
                    } else {
                        if (c[1] > 0) {
                            res.append('E');
                        } else {
                            res.append('W');
                        }
                    }
                } else {
                    yy += c[1];
                    if (remapY) {
                        if (c[1] > 0) {
                            res.append('S');
                        } else {
                            res.append('N');
                        }
                    } else {
                        if (c[1] > 0) {
                            res.append('N');
                        } else {
                            res.append('S');
                        }
                    }
                }
            }
            return res.toString();
        }
    }

    public static List<Integer> combinationSum(List<Integer> candidates, int target) {
        final List<Integer> res = new ArrayList<>();
        Collections.sort(candidates);
        recurse(candidates, 0, target, res);
        return res;
    }

    private static boolean recurse(List<Integer> candidates,
                                   int start,
                                   int target,
                                   List<Integer> curr) {
        if (target == 0) {
            return true;
        }
        for (int i = start; i < candidates.size() && target >= candidates.get(i); i++) {
            if (i > start && candidates.get(i).equals(candidates.get(i - 1))) { continue; }
            curr.add(candidates.get(i));
            if (recurse(candidates, i + 1, target - candidates.get(i), curr)) {
                return true;
            }
            curr.remove(curr.size() - 1);
        }
        return false;
    }
}
