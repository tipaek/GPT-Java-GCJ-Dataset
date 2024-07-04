import java.util.*;

public class Solution{
    public static void main (String [] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int z = 0; z < cases; z++) {
            int rc = scan.nextInt();
            int a[][] = new int[rc][rc];

            for (int i = 0; i < rc; i++) {
                for (int j = 0; j < rc; j++) {
                    a[i][j] = scan.nextInt();
                }
            }

            int trace = 0;
            int r = 0;
            int c = 0;
            for (int i = 0; i < rc; i++) {
                trace += a[i][i];
                for (int j = 0; j < rc - 1; j++) {
                    for (int k = j + 1; k < rc; k++) {
                        if (a[i][j] == a[i][k]) {
                            r++;
                            k = j = rc;
                        }
                    }
                }
                for (int j = 0; j < rc - 1; j++) {
                    for (int k = j + 1; k < rc; k++) {
                        if (a[j][i] == a[k][i]) {
                            c++;
                            k = j = rc;
                        }
                    }
                }
            }

            System.out.println("Case #" + (z+1) + ": " + trace + " " + r + " " + c);
        }
        
    }
}