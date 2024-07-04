import java.util.Scanner;

class Solution {
    public static void main(String args[]) {
        try { 
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int t = 0; t < cases; t++) {
            int n = scan.nextInt();
            int k = 0; int r = 0; int c = 0;
            int m[][] = new int[n][n];

            for(int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    m[i][j] = scan.nextInt();

            for ( int i = 0; i < n; i++) {
                boolean col[] = new boolean[n+1];
                boolean row[] = new boolean[n+1];
                boolean foundDupCol = false;
                boolean foundDupRow = false;
                for (int j = 0; j < n; j++) {
                    int num = m[i][j];
                    int numr = m[j][i];
                    if(row[numr] && !foundDupRow) {
                        foundDupRow = true;
                        c++;
                    }
                    if (col[num] && !foundDupCol){
                        foundDupCol = true;
                        r++;
                    }
                    col[num] = true;
                    row[numr] = true;
                    if(i == j) k += num;
                }
            }

            System.out.println("Case #" + (t+1) + ":" + k + " " + r + " " + c);
        }
        } catch(Exception e) { System.out.println(e.getMessage()); }
    }
}