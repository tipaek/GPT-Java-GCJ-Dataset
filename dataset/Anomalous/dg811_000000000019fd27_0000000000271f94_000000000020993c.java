import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int z = 0; z < t; z++) {
            int n = sc.nextInt();
            int sum = 0;
            int rmax = 0;
            int cmax = 0;
            int[][] arr = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // Check rows for duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(arr[i][j])) {
                        rmax++;
                        break;
                    }
                }
            }

            // Check columns for duplicates
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(arr[i][j])) {
                        cmax++;
                        break;
                    }
                }
            }

            // Calculate sum of the main diagonal
            for (int i = 0; i < n; i++) {
                sum += arr[i][i];
            }

            System.out.println(sum + " " + rmax + " " + cmax);
        }
        sc.close();
    }
}