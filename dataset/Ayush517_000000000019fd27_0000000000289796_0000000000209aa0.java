import java.util.*;
class Solution {
    static int[][] square = new int[51][51];
    static int n, k, tim;
    static boolean[][] rsf = new boolean[51][51];
    static boolean[][] csf = new boolean[51][51];
    static boolean solved;
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        for(tim=1;tim<=t;tim++) {
            n = ob.nextInt();
            k = ob.nextInt();
            solver(1,1,0);
            if(!solved)
                System.out.println("Case #"+tim+": IMPOSSIBLE");
            solved=false;
        }
    }

    static void solver(int row, int col, int m) {
        if(row==n && col==n+1 && m==k && !solved) {
            solved=true;
            System.out.println("Case #"+tim+": POSSIBLE");
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    System.out.print(square[i][j]+" ");
                }
                System.out.println();
            }
            return;
        } else if (row>n)
            return;
        else if(col>n)
            solver(row+1, 1, m);
        for(int i=1;i<=n && !solved;i++) {
            if (!rsf[row][i] && !csf[col][i]) {
                rsf[row][i]=csf[col][i]=true;
                if (row==col) {
                    m+=i;
                }
                square[row][col]=i;
                solver(row,col+1,m);
                rsf[row][i]=csf[col][i]=false;
                if (row==col) {
                    m-=i;
                }
                square[row][col]=0;
            }
        }
    }
}