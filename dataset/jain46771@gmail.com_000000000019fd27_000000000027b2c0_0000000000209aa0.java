import java.io.*;
import java.util.*; 
class Solution {

    int[][] ansArray;
    public boolean fillArray(List<Integer> temp, int n, int k)
    {
        this.ansArray = new int[n][n];
        int[][] rows = new int[n+1][n+1];
        int[][] cols = new int[n+1][n+1];


        for (int i=0;i<n;i++)
        {
            this.ansArray[i][i] = temp.get(i);
            rows[i][temp.get(i)] = 1;
            cols[i][temp.get(i)] = 1;
         }
       return solve(n,rows,cols,0);
    }

    public void print( )
    {
        int n = this.ansArray.length;
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
                System.out.print(this.ansArray[i][j]+"  ");
            System.out.println();
        }

    }
    public boolean solve(int n, int[][] rows, int[][]cols, int pos )
    {

        if(pos>=n*n) return false;
        if (pos==(n*n-1)) return true;

        int i = pos/n;
        int j = pos%n;
        if (this.ansArray[i][j]!=0) return  solve(n,rows,cols,pos+1);

        for (int x = 1;x<=n;x++)
        {
            if(rows[i][x]!=0 || cols[j][x]!=0) continue;
            rows[i][x] = 1;
            cols[j][x] = 1;
            int t = this.ansArray[i][j];
            this.ansArray[i][j] = x;
            if(solve(n,rows,cols,pos+1)) return true;
            this.ansArray[i][j] = t;
            rows[i][x] = 0;
            cols[j][x] = 0;
        }

        return false;

    }

    public  boolean dfs(List<Integer> temp, int n, int k, int left) {
        if(k<0 ) return false;
        if(k==0 && temp.size()==n)
        {
            if(fillArray(temp,n,k))
                return true;
            return false;
        }

        for (int i=left;i<=n;i++)
        {
            temp.add(i);
            if(dfs(temp, n, k-i, i)) return true;
            temp.remove(temp.size()-1);
        }
        return false;

    }

    public static void main(String[] args) {
        int testCases = 0;
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        testCases = sc.nextInt();
        Solution s = new Solution();
        for (int t=0;t<testCases;t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
           
            List<Integer> temp = new ArrayList<>();
            if(s.dfs(temp,n,k,1 )){
                System.out.println("Case #"+(t+1)+": POSSIBLE");
               s.print();
            }
            else
                System.out.println("Case #"+(t+1)+": IMPOSSIBLE");



        }
    }
}
