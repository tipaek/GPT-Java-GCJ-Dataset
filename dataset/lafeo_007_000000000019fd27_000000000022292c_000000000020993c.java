import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); //number of test cases.

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); //numbers of r and c.
            int[][] array = new int[N][N];
            String row, colum;
            row = colum = "";
            int b = 0;
            int r, c, current;
            r = c = current = 0;
            int trace = 0;
            for (int a = 0; a < N; a++) {
                //we input the matrix here
                for (b = 0; b < N; b++) {
                    array[a][b] = sc.nextInt(); //we have taken in the array.
                }
                trace += array[a][current];
                current++;
            }

            for (int a = 0; a < N; a++) {
                for (b = 0; b < N; b++) {
                    boolean BOOL = false;
                    int temp = array[a][b];
                    for (int d = 0; d < N; d++) {
                        if ((temp == array[a][d]) && b!=d) {
                            BOOL = true;
                            break;
                        }
                    }
                    if (BOOL) {
                        c++;
                        break;
                    }
                }
                //trace is completed.

            }
            for (int a = 0; a < N; a++) {
                for (b = 0; b < N; b++) {
                    boolean BOOL = false;
                    int temp = array[b][a];
                    for (int d = 0; d < N; d++) {
                        if ((temp == array[d][a]) && d!=b) {
                            BOOL = true;
                            break;
                        }
                    }
                    if (BOOL) {
                        r++;
                        break;
                    }
                }
                //trace is completed.

            }
            System.out.println("Case #"+t+":"+" "+trace+" "+c+" "+r);
        }
    }
}