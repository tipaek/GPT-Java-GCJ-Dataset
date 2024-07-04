import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; ++i) {
            String output = solve(sc);
            sb.append("Case #").append(i).append(": ").append(output).append("\n");
        }
        System.out.print(sb);
    }

    private static String solve(Scanner sc) {
        final int c = sc.nextInt();
        final int d = sc.nextInt();
        final Map<Integer, Integer> x = new HashMap<>();
        IntStream.range(0, c - 1).forEach(i -> x.put(i + 1, -sc.nextInt()));
        final int[][] uv = new int[d][2];
        IntStream.range(0, d).forEach(i -> {
            uv[i][0] = sc.nextInt();
            uv[i][1] = sc.nextInt();
        });
        if (x.values().stream().anyMatch(e -> e <= 0)) {
            return "";
        }
        final int[] y = new int[d];
        Arrays.fill(y, 1);
        final int[] time = new int[c];
        int[] current = {1000000};
        while (true) {
            int maxx = x.values().stream().max(Comparator.comparing(e -> e)).orElse(0);
            if (maxx <= 0) {
                break;
            }
            List<Integer> process = x.entrySet().stream().filter(e -> e.getValue() == maxx)
                    .map(Map.Entry::getKey).collect(Collectors.toList());
            process.forEach(i -> time[i] = current[0]);
            current[0] -= 1000;
            process.forEach(x::remove);
        }

//        System.out.println(Arrays.toString(time));

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited.add(1);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i = 0; i < d; ++i) {
                final int to;
                if (uv[i][0] == u) {
                    to = uv[i][1];
                } else if (uv[i][1] == u) {
                    to = uv[i][0];
                } else {
                    continue;
                }
                if (!visited.add(to)) {
                    continue;
                }

                y[i] += time[to - 1] - time[u - 1];
                q.add(to);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d; ++i) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(y[i]);
        }
        return sb.toString();
    }
}