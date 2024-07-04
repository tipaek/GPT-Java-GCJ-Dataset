import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());

        int[][] result = new int[T][3];

        for (int i = 1; i <= T; i++) {
            int D = Integer.parseInt(in.nextLine());

            // record string P
            int[][] array = new int[D][D];

            for (int ii = 0; ii < D; ii++) {
                String[] s = in.nextLine().trim().split(" ");
                for(int iii = 0; iii < D; iii++) {
                    array[ii][iii] = Integer.parseInt(s[iii]);
                }
            }

            // compare
            int trace = 0;
            for (int j = 0; j < D; j++) {
                for (int k = 0; k < D; k++) {
                    if (j == k) {
                        trace += array[j][k];
                    }
                }
            }
            int r = 0;
            //Row COUNT
            for (int j = 0; j < D; j++) {
                for (int k = 0; k < D; k++) {
                    int c = 0;
                    for (int l = k + 1; l < D; l++)
                        if (array[j][k] == array[j][l]) {
                            r++;
                            c = 1;
                            break;
                        }
                    if (c == 1)
                        break;
                }
            }
            int c = 0;
            //Row COUNT
            for (int j = 0; j < D; j++) {
                for (int k = 0; k < D; k++) {
                    int x = 0;
                    for (int l = k + 1; l < D; l++)
                        if (array[k][j] == array[l][j]) {
                            c++;
                            x = 1;
                            break;
                        }
                    if (x == 1)
                        break;
                }
            }
            result[i-1][0] = trace;
            result[i-1][1] = r;
            result[i-1][2] = c;
        }
        for(int i = 1; i <= T; i++) {
            System.out.println("Case #" + i + ": " + result[i-1][0] + " " + result[i-1][1] + " " + result[i-1][2]);
        }
        in.close();
    }
}