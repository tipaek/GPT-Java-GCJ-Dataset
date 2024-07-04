import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int i=0;
        while (t-- != 0) {
            i++;
            System.out.print("Case #" + i + ": ");
            solve(sc);
        }


        sc.close();
    }

    private static void solve(Scanner sc) {
        int n = sc.nextInt();
        int k = 0, r = 0, c = 0;

        int[][] m = new int[n][];
        for(int i=0; i<n; i++) {
            m[i] = new int[n];
            boolean rowRepeat = false;
            for(int j=0; j<n; j++) {
                int num = sc.nextInt();
                m[i][j] = num;
                if (i==j) k+=num;

                // progressively check for row equality
                for(int x=(j-1); x>=0; x--) {
                    if (m[i][x] == num) {
                        // number is repeated
                        rowRepeat = true;
                    }
                }
            }
            if (rowRepeat) {r++;}
        }

        // column check
        for(int j=0; j<n; j++) {
            boolean columnRepeat = false;
            for(int i=0; i<n; i++) {
                int num = m[i][j];
                for(int x=(i-1); x>=0; x--) {
                    if (m[x][j] == num) {
                        columnRepeat = true;
                    }
                }

            }

            if (columnRepeat) {c++;}
        }

        System.out.print(k + " " + r + " " + c + "\n");
    }
}