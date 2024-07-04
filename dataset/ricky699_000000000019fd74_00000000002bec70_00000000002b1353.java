import java.util.*;
import java.io.*;
public class Solution {
    
  static int[][] grid = new int[1000][1000];

    private static void initGrid(){
        grid[0][0]=1;
        grid[1][0]=grid[1][1]=1;

        for(int row=2;row<1000;row++){
            grid[row][0]=grid[row][row]=1;
            for(int j=1;j<row;j++){
                grid[row][j]=grid[row-1][j]+grid[row-1][j-1];
            }
        }
    }

    static int[] dx = {-1,0,1,1,0,-1};
    static int[] dy = {0,1,1,0,-1,-1};
    static List<int[]> ans;

    private static boolean dfsUtil(int sum, int i, int j, List<int[]> path, boolean[][] v){
//        for(int row=0;row<10;row++){
//            for(int x=0;x<row;x++){
//                System.out.print(grid[row][x]+ " ");
//            }
//            System.out.println();
//        }
//        return ;
        if(sum==0){
            ans = new ArrayList<>(path);
            return true;
        }
        if(sum < 0){
            return false;
        }
        v[i][j]= true;

        for(int k=0;k<6;k++){
            int testx = i + dx[k];
            int testy = j + dy[k];

            if(testx>=0 && testy>=0 && testx<1000 && testy<=testx && !v[testx][testy]){
                path.add(new int[]{testx+1, testy+1});
                if(dfsUtil(sum-grid[testx][testy],testx, testy, path, v)){
                    return true;
                }
                path.remove(path.size()-1);
            }
        }
        return false;
    }

    private static void printPath(int n, boolean[][] v){

        List<int[]> path = new ArrayList<> ();
        path.add(new int[]{1,1});
        dfsUtil(n-1,0,0, path, v);

        //print path
        for(int i=0;i<path.size();i++){
            int[] arr = ans.get(i);
            System.out.print(arr[0] + " " + arr[1]);
            System.out.println();
        }

    }

  
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    initGrid();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      boolean[][] v = new boolean[1000][1000];
      System.out.println("Case #" + i + ": ");
      printPath(n, v);
    }
  }
}