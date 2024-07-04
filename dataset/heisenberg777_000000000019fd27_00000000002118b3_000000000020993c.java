import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int D = in.nextInt();

            // record string P
            int[][] array = new int[D][D];
            // compare
            int trace = 0;
            for (int j = 0; j < D; j++) {
                for (int k = 0; k < D; k++) {
                    array[j][k] = in.nextInt();
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
            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
        in.close();
    }
}