import java.util.*;

public class Solution {
    static HashMap<Integer, ArrayList<Integer>> map;
    static int n, trace;
    static int[] permutation;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            map = new HashMap<>();
            n = scanner.nextInt();
            trace = scanner.nextInt();

            // Initialize the matrix with the given pattern
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add((i + j) % n);
                }
                map.put(i, row);
            }

            // Initialize the permutation array
            permutation = new int[n];
            for (int i = 0; i < n; i++) {
                permutation[i] = i;
            }

            // Check if a valid permutation exists
            if (findPermutation(0) == -1) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                printMatrix();
            }
            caseNumber++;
        }
    }

    static int findPermutation(int k) {
        if (k == n) {
            // Check if the current permutation gives the required trace
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += map.get(permutation[i]).get(i) + 1;
            }
            return sum == trace ? 1 : -1;
        } else {
            for (int i = k; i < n; i++) {
                swap(k, i);
                if (findPermutation(k + 1) == 1) {
                    return 1;
                }
                swap(k, i); // backtrack
            }
        }
        return -1;
    }

    static void swap(int i, int j) {
        int temp = permutation[i];
        permutation[i] = permutation[j];
        permutation[j] = temp;
    }

    static void printMatrix() {
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = map.get(permutation[i]);
            for (int val : row) {
                System.out.print(val + 1 + " ");
            }
            System.out.println();
        }
    }
}