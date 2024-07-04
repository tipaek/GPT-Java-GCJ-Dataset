import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    static boolean found;
    static int[][] solution;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; ++tc) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            System.out.println(String.format("Case #%d: %s", tc, solve(N, K)));
        }

        sc.close();
    }

    static String solve(int N, int K) {
        int[] p = IntStream.rangeClosed(1, N).toArray();
        List<int[]> permutations = new ArrayList<>();
        buildPermutations(permutations, p, 0);

        @SuppressWarnings("unchecked")
        Set<Integer>[] rests = new Set[N];
        for (int i = 0; i < N; ++i) {
            rests[i] = new HashSet<>();
            for (int j = 1; j <= N; ++j) {
                rests[i].add(j);
            }
        }

        found = false;
        solution = new int[N][N];
        search(N, permutations, 0, rests, K);

        if (found) {
            return String.format("POSSIBLE\n%s",
                    Arrays.stream(solution)
                            .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                            .collect(Collectors.joining("\n")));
        } else {
            return "IMPOSSIBLE";
        }
    }

    static void search(int N, List<int[]> permutations, int r, Set<Integer>[] rests, int restSum) {
        if (r == N - 1) {
            if (rests[N - 1].iterator().next() == restSum) {
                for (int c = 0; c < N; ++c) {
                    solution[r][c] = rests[c].iterator().next();
                }

                found = true;
            }

            return;
        }

        for (int[] permutation : permutations) {
            if (restSum >= permutation[r] && check(rests, permutation)) {
                solution[r] = permutation;
                for (int i = 0; i < N; ++i) {
                    rests[i].remove(permutation[i]);
                }

                search(N, permutations, r + 1, rests, restSum - permutation[r]);
                if (found) {
                    break;
                }

                for (int i = 0; i < N; ++i) {
                    rests[i].add(permutation[i]);
                }
            }
        }
    }

    static boolean check(Set<Integer>[] rests, int[] permutation) {
        for (int i = 0; i < permutation.length; ++i) {
            if (!rests[i].contains(permutation[i])) {
                return false;
            }
        }

        return true;
    }

    static void buildPermutations(List<int[]> permutations, int[] p, int index) {
        if (index == p.length) {
            permutations.add(Arrays.copyOf(p, p.length));

            return;
        }

        for (int i = index; i < p.length; ++i) {
            swap(p, i, index);
            buildPermutations(permutations, p, index + 1);
            swap(p, i, index);
        }
    }

    static void swap(int[] p, int index1, int index2) {
        int temp = p[index1];
        p[index1] = p[index2];
        p[index2] = temp;
    }
}