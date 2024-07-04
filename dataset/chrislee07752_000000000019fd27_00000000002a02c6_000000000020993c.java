
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int r = 0;
            int c = 0;
            int trace = 0;
            
            
            
            int[][] ar = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int j1 = 0; j1 < n; j1++) {
                    int check = scan.nextInt();
                    if (j == j1) {
                        trace += check;
                    }
                    ar[j][j1] = check;
                }
            }
            

            for (int j = 0; j < ar.length; j++) {
                int index = 0;
                outer: for (int k = 0; k < ar.length; k++) {
                    for (int k2 = index + 1; k2 < ar.length; k2++) {
                        if (ar[j][index] == ar[j][k2]) {
                            
                            r++;
                            break outer;
                        }

                    }
                    index++;
                }
            }

            
            for (int j = 0; j < ar.length; j++) {
                int index = 0;
                outer: for (int k = 0; k < ar.length; k++) {
                    for (int k2 = index + 1; k2 < ar.length; k2++) {
                        if (ar[index][j] == ar[k2][j]) {
                            
                            c++;
                            break outer;
                        }

                    }
                    index++;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + r + " " + c);

        }
    }
}