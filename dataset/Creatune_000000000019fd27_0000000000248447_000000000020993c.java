import java.util.*;
import java.io.*;
public class vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println("");
        int T = sc.nextInt();
        int x = 0;
        while (x < T) {
            int i = 0, j = 0, k = 0, r = 0, c = 0;
            System.out.println("");
            int n = sc.nextInt();
            int M[][] = new int[n][n];
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (i == j) {
                        k += M[i][j];
                    }
                }
            }
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    int num = M[i][j];
                    for (int otherCol = j + 1; otherCol < n; otherCol++) {
                        if (num == M[i][otherCol]) {
                            System.out.print("");
                        }
                    }
                }
                r += 1;
                c += 1;
            }
            x += 1;
            System.out.println("case #" + x + ": " + k + " " + r + " " + c);
        }
    }
}