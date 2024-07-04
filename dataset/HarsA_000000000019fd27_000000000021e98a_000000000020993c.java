import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] mat;

        for(int tt=1;tt<=t;tt++) {
            int n = sc.nextInt();
            mat = new int[n][n];

            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            int r=0;
            Set<Integer> set;
            for(int i=0;i<n;i++) {
                set = new HashSet<>();
                for(int j=0;j<n;j++) {
                    if(set.contains(mat[i][j])) {
                        r++;
                        break;
                    } else {
                        set.add(mat[i][j]);
                    }
                }
            }

            int c=0;
            for(int i=0;i<n;i++) {
                set = new HashSet<>();
                for(int j=0;j<n;j++) {
                    if(set.contains(mat[j][i])) {
                        c++;
                        break;
                    } else {
                        set.add(mat[j][i]);
                    }
                }
            }

            int k=0;
            for(int i=0;i<n;i++) {
                k+= mat[i][i];
            }

            System.out.println("Case #" + tt + ": " +  k + " " + r + " " + c);

        }
    }
}