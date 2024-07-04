import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k=0; k<t; k++) {
            int n = sc.nextInt();
            int [][] ary = new int[n][n];
            for(int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    ary[i][j] = sc.nextInt();
                }
            }
            System.out.println("Case #" + (k+1) + ": " + calculateTrace(ary, n) + " " + checkRepeatedRow(ary, n) + " " + checkRepeatedCol(ary, n));
        }
    }

    private static int checkRepeatedCol(int[][] ary, int n) {
        int count = 0;

        for(int i=0; i<n; i++) {
            int[] seen = new int[n];
            for(int j=0; j<n; j++) {
                int x = ary[j][i];
                if(seen[x-1] == 1) {
                    count ++;
                    break;
                } else {
                    seen[x-1] = 1;
                }
            }
        }

        return count;
    }

    private static int checkRepeatedRow(int[][] ary, int n) {
        int count = 0;

        for(int i=0; i<n; i++) {
            int[] seen = new int[n];
            for(int j=0; j<n; j++) {
                int x = ary[i][j];
                if(seen[x-1] == 1) {
                    count ++;
                    break;
                } else {
                    seen[x-1] = 1;
                }
            }
        }

        return count;
    }

    private static int calculateTrace(int[][] ary, int n) {
        int trace = 0;

        for(int i=0; i<n; i++) {
            trace+=ary[i][i];
        }

        return trace;
    }

}
