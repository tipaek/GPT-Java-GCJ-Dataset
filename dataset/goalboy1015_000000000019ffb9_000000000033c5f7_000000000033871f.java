import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; ++tc) {
            int C = sc.nextInt();
            int D = sc.nextInt();
            int[] X = new int[C];
            for (int i = 1; i < X.length; ++i) {
                X[i] = sc.nextInt();
            }
            int[] U = new int[D];
            int[] V = new int[D];
            for (int i = 0; i < D; ++i) {
                U[i] = sc.nextInt() - 1;
                V[i] = sc.nextInt() - 1;
            }

            System.out.println(String.format("Case #%d: %s", tc, solve(X, U, V)));
        }

        sc.close();
    }

    static String solve(int[] X, int[] U, int[] V) {
        int C = X.length;
        int D = U.length;

        List<Integer>[] edgeLists = new List[C];
        for (int i = 0; i < edgeLists.length; ++i) {
            edgeLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < U.length; ++i) {
            edgeLists[U[i]].add(i);
            edgeLists[V[i]].add(i);
        }

        List<Integer>[] nodeLists = new List[C];
        for (int i = 0; i < nodeLists.length; ++i) {
            nodeLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < X.length; ++i) {
            nodeLists[-X[i]].add(i);
        }

        int[] distances = new int[C];
        Arrays.fill(distances, -1);
        distances[0] = 0;

        int[] result = new int[D];

        for (int i = 1; i < nodeLists.length; ++i) {
            for (int node : nodeLists[i]) {
                for (int edge : edgeLists[node]) {
                    int other = (U[edge] == node) ? V[edge] : U[edge];

                    if (distances[other] != -1) {
                        result[edge] = Math.max(1, i - distances[other]);
                    }
                }

                distances[node] = i;
            }
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}