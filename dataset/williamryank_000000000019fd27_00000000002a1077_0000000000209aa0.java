import java.util.*;
import java.lang.*;

public class Solution {
    public static boolean recursive(int matrix[][], HashMap<String, HashSet<Integer>> domains) {
        int r = -1;
        int c = -1;
        for (int a = 0; a < matrix.length; a++) {
            for (int b = 0; b < matrix.length; b++) {
                if (matrix[a][b] == 0) {
                    r = a;
                    c = b;
                }
            }
        }

        if (r == -1 && c == -1) {
            return true;
        }

        ArrayList<Integer> value_order = new ArrayList<>();
        for (int p = 1; p <= matrix.length; p++) {
            value_order.add(p);
        }

        for (Integer curr : value_order) {
            boolean isValid = true;
            for (int q : matrix[r]) {
                if (curr == q) {
                    isValid = false;
                    break;
                }
            }

            for (int d = 0; d < matrix.length; d++) {
                if (curr == matrix[d][c]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                matrix[r][c] = curr;
                HashSet<Integer> domain_before = domains.get(r + "," + c);
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(curr);
                domains.put(r + "," + c, newSet);

                boolean from_child = recursive(matrix, domains);
                if (from_child) {
                    return true;
                }

                domains.put(r + "," + c, domain_before);
                matrix[r][c] = 0;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            String result = "";

            if (((K < (N * N - 1)) && K > (N + 1)) || K % N == 0) {
                result = "POSSIBLE";
                int matrix[][] = new int[N][N];
                HashMap<String, HashSet<Integer>> domains = new HashMap<>();
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        HashSet<Integer> set = new HashSet<>();
                        for (int z = 1; z <= N; z++) {
                            set.add(z);
                        }
                        String key = "" + j + "," + k;
                        domains.put(key, set);
                    }
                }

                int curr = 0;
                if (K % N == 0) {
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            if (j == k) {
                                matrix[j][j] = K / N;
                            }
                        }
                    }
                } else {
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            if (j == k) {
                                matrix[j][j] = 1;
                                K--;
                            }
                        }
                    }
                    matrix[N - 1][N - 1] = 2;
                    K--;
                    while (K != 0) {
                        if (K >= N - 1) {
                            matrix[curr][curr] += N - 1;
                            K -= N - 1;
                            if (curr == N - 2) {
                                matrix[curr][curr] -= 1;
                                matrix[curr + 1][curr + 1] += 1;
                            }
                            curr++;
                        } else {
                            matrix[curr][curr] += K;
                            K = 0;
                        }
                }
                }


                if (recursive(matrix, domains)) {
                    System.out.printf("Case #%d: %s\n", i + 1, result);
                    for (int u = 0; u < N; u++) {
                        for (int y = 0; y < N; y++) {
                            System.out.print(matrix[u][y] + " ");
                        }

                        System.out.println("");
                    }
                } else {
                    System.out.printf("Case #%d: IMPOSSIBLE\n", i + 1);
                }

            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", i + 1);
            }

        }
    }
}