import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int K = in.nextInt();
            System.out.println("Case #" + i + ": " + determineSolution(generatePaths(N, K), generatePermutations(N), N));
        }
    }

    public static String arrayToString(int[][] array) {
        StringBuilder output = new StringBuilder();
        for (int[] row : array) {
            for (int value : row) {
                output.append(value).append(" ");
            }
            output.append("\n");
        }
        return output.toString();
    }

    public static ArrayList<int[]> filterPermutations(ArrayList<int[]> permutations, int index, int value) {
        ArrayList<int[]> validPermutations = new ArrayList<>();
        for (int[] perm : permutations) {
            if (perm[index] == value) {
                validPermutations.add(perm);
            }
        }
        return validPermutations;
    }

    public static String determineSolution(ArrayList<int[]> paths, ArrayList<int[]> permutations, int N) {
        for (int[] path : paths) {
            ArrayList<ArrayList<int[]>> combinations = new ArrayList<>();
            int product = 1;
            for (int j = 0; j < N; j++) {
                ArrayList<int[]> filteredPerms = filterPermutations(permutations, j, path[j]);
                combinations.add(filteredPerms);
                product *= filteredPerms.size();
            }
            for (int count = 0; count < product; count++) {
                int[][] matrix = new int[N][N];
                for (int k = 0; k < N; k++) {
                    matrix[k] = combinations.get(k).get(convertIndex(combinations, count, k));
                }
                if (validateColumns(matrix)) {
                    return "POSSIBLE\n" + arrayToString(matrix);
                }
            }
        }
        return "IMPOSSIBLE";
    }

    public static int convertIndex(ArrayList<ArrayList<int[]>> combinations, int count, int place) {
        for (int i = combinations.size() - 1; i >= place + 1; i--) {
            count /= combinations.get(i).size();
        }
        return count % combinations.get(place).size();
    }

    public static ArrayList<int[]> generatePermutations(int n) {
        ArrayList<int[]> permutations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] initial = new int[n];
            initial[0] = i + 1;
            permutations.add(initial);
        }

        for (int i = 1; i < n; i++) {
            ArrayList<int[]> tempPermutations = new ArrayList<>();
            for (int[] perm : permutations) {
                for (int u = 1; u <= n; u++) {
                    if (!contains(perm, u)) {
                        int[] newPerm = Arrays.copyOf(perm, n);
                        newPerm[i] = u;
                        tempPermutations.add(newPerm);
                    }
                }
            }
            permutations = tempPermutations;
        }
        return permutations;
    }

    public static boolean contains(int[] array, int value) {
        for (int elem : array) {
            if (elem == value) {
                return true;
            }
        }
        return false;
    }

    public static int sum(int[] array) {
        int total = 0;
        for (int value : array) {
            total += value;
        }
        return total;
    }

    public static ArrayList<int[]> generatePaths(int n, int k) {
        ArrayList<int[]> paths = new ArrayList<>();
        int count = 0;
        while (count < Math.pow(n, n)) {
            int[] path = new int[n];
            for (int i = 0; i < n; i++) {
                path[i] = (int) ((count / Math.pow(n, n - i - 1)) % n) + 1;
            }
            if (sum(path) == k) {
                paths.add(path);
            }
            count++;
        }
        return paths;
    }

    public static boolean validateColumns(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int[] column = new int[array.length];
            for (int j = 0; j < array.length; j++) {
                column[j] = array[j][i];
            }
            Arrays.sort(column);
            if (column[0] != 1 || column[column.length - 1] != array.length) {
                return false;
            }
        }
        return true;
    }
}