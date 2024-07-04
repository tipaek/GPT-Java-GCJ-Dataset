import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int x=0; x<t; x++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
//            System.out.println(Arrays.deepToString(matrix));
            int trace = 0;
            int c = 0;
            int r = 0;

            for (int i=0; i<n; i++) {
                trace += matrix[i][i];
            }
            for (int i=0; i<n; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j=0; j<n; j++) {
                    if (set.contains(matrix[i][j])) {
                        r++;
                        break;
                    }
                    set.add(matrix[i][j]);
                }
            }
            for (int j=0; j<n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int i=0; i<n; i++) {
                    if (set.contains(matrix[i][j])) {
                        c++;
                        break;
                    }
                    set.add(matrix[i][j]);
                }
            }
            int k = x+1;
            System.out.println("Case #" + k + ": " + trace + " " + r + " " + c);
        }

    }
}

/*
3
4
1 2 3 4
2 1 4 3
3 4 1 2
4 3 2 1
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
3
2 1 3
1 3 2
1 2 3

* */
