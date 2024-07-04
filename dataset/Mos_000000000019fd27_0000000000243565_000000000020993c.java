import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        err:
        if (t >= 1 && t < 100) {
            int[] trace = new int[t];
            int[] r = new int[t];
            int[] c = new int[t];

            // loop:
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                

                if (n >= 2 && n <= 100) {
                    int[][] m = new int[n][n];

                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            m[j][k] = in.nextInt();
                            if (m[j][k] >= 1 && m[j][k] <= n) {
                                continue;    
                            } else {
                                System.out.println(-1);
                                break err;
                            }

                        }

                    }

                    for (int j = 0; j < n; j++) {
                        r[i] += repeatedColumn(m, j);
                        c[i] += repeatedRow(m, j);
                        trace[i] = trace(m);
                    }

                } else System.out.println(-1);
                
            }

            for (int j = 0; j < t; j++) {
                System.out.println("Case #" + (j + 1) + ": " + trace[j] + " " + r[j] + " " + c[j]);
            }
            

        } else System.out.println(-1);

        in.close();
    }

    public static int repeatedColumn(int m[][], int r) {
        int count = 0;
        for (int i = 0; i < m.length - 1; i++) {
            for (int j = i + 1; j < m.length; j++) {
                if ((m[r][i] == m[r][j]) && (i != j)) {
                    count += 1;
                }
            }
        }

        return count >= 1 ? 1 : 0;
    }

    public static int repeatedRow(int m[][], int c) {
        int count = 0;
        for (int i = 0; i < m.length - 1; i++) {
            for (int j = i + 1; j < m.length; j++) {
                if ((m[i][c] == m[j][c]) && (i != j)) {
                    count += 1;
                }
            }
        }

        return count >= 1 ? 1 : 0;
    }

    public static int trace(int m[][]) {
        int k = 0;
        for (int i = 0; i < m.length; i++) {
            k += m[i][i];
        }
        return k;
    }

}