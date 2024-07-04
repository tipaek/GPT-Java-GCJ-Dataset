import java.util.*;
class Solution {
    static int[][] square = new int[55][55];
    static int n, k, tim;
    static boolean[][] rsf = new boolean[55][55];
    static boolean[][] csf = new boolean[55][55];
    static boolean solved;
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        for(tim=1;tim<=t;tim++) {
            n = ob.nextInt();
            k = ob.nextInt();
            solved=false;
            func1(1,1,0);
            if(!solved)
                System.out.println("Case #"+tim+": IMPOSSIBLE");
        }
    }

    static void func1(int row, int col, int m) {
        if(!solved && row==n && col==n+1 && m==k) {
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
            func1(row+1, 1, m);
        func2(row, col, m);
    }

    static void func2(int row, int col, int m) {
        for(int i=1;i<=n && !solved;i++) {
            if (!rsf[row][i] && !csf[col][i])
            {
                rsf[row][i]=csf[col][i]=true;
                if (row==col)
                {
                    m+=i;
                }
                square[row][col]=i;

                func1(row,col+1,m);

                rsf[row][i]=csf[col][i]=false;
                if (row==col)
                {
                    m-=i;
                }
                square[row][col]=0;
            }
        }
    }
}