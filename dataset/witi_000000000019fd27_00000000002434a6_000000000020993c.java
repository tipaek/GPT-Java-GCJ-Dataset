import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int t = 1; t<=T; t++) {
            int N = in.nextInt();

            int[][] m = new int[N][N];

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    m[i][j] = in.nextInt();
                }
            }

            //trace
            int k = 0;
            for (int x=0; x<N; x++)
                k += m[x][x];

            //rows
            int r = 0;
            for (int i=0; i<N; i++) {
                boolean[] arr = new boolean[N+1];
                for (int j=0; j<N; j++) {
                    int number = m[i][j];
                    if (arr[number]) {
                        r++;
                        break;
                    }
                    arr[number] = true;
                }
            }


            //columns
            int c = 0;
            for (int j=0; j<N; j++) {
                boolean[] arr = new boolean[N+1];
                for (int i=0; i<N; i++) {
                    int number = m[i][j];
                    if (arr[number]) {
                        c++;
                        break;
                    }
                    arr[number] = true;
                }
            }

            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);

        }
    }
}
