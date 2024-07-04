import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int test = 1; test <= tests; test++) {
            String result = "";
            int n = sc.nextInt();

            int[][] graph = new int[n][n];
            for (int[] row : graph) {
                Arrays.fill(row, 0);
            }

            List<Integer> colours = new ArrayList<>(Collections.nCopies(n, -1));
            List<Integer> testnums = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                testnums.add(sc.nextInt());
                testnums.add(sc.nextInt());
            }

            List<List<Integer>> jobs = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<Integer> currjob = Arrays.asList(testnums.get(2 * i), testnums.get(2 * i + 1));
                for (int l = 0; l < jobs.size(); l++) {
                    if (collision(currjob.get(0), currjob.get(1), jobs.get(l).get(0), jobs.get(l).get(1))) {
                        graph[i][l] = 1;
                        graph[l][i] = 1;
                    }
                }
                jobs.add(currjob);
            }

            Queue<Integer> q = new LinkedList<>();
            Set<Integer> red = new HashSet<>();
            Set<Integer> blue = new HashSet<>();
            Set<Integer> seen = new HashSet<>();

            boolean broken = false;

            for (int indx = 0; indx < n; indx++) {
                if (colours.get(indx) == -1) {
                    if (broken) break;

                    q.add(indx);
                    int colour = 0;

                    while (!q.isEmpty()) {
                        int curr = q.remove();

                        if (colours.get(curr) == -1) {
                            colours.set(curr, colour);
                            if (colour == 0) red.add(curr);
                            else blue.add(curr);
                            seen.add(curr);
                        }

                        colour = (colours.get(curr) == 0) ? 1 : 0;

                        for (int i2 = 0; i2 < n; i2++) {
                            if (i2 == curr) continue;

                            if (graph[curr][i2] == 1) {
                                if (colours.get(i2) == colours.get(curr)) {
                                    result = "IMPOSSIBLE";
                                    broken = true;
                                    break;
                                }
                                if (!seen.contains(i2)) {
                                    colours.set(i2, colour);
                                    if (colour == 0) red.add(i2);
                                    else blue.add(i2);
                                    seen.add(i2);
                                    q.add(i2);
                                }
                            }
                        }
                    }
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                for (int f = 0; f < n; f++) {
                    result += red.contains(f) ? 'J' : 'C';
                }
            }

            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static boolean collision(int a1, int b1, int a2, int b2) {
        return !(b1 <= a2 || b2 <= a1);
    }
}