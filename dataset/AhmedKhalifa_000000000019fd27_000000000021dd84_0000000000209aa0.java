import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Inducium {

  private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  private static final PrintWriter pw = new PrintWriter(System.out);
  private static int[][] grid;
  private static int k;
  
  public static void main(String[] argv) throws IOException {
    solve();
    pw.flush();
    pw.close();
    bf.close();
  }

  private static boolean checkGridLocation(int i, int j, int n) {
    for(int x=0; x<grid.length; ++x) {
      if (grid[i][x] == n || grid[x][j] == n){
        return false;
      }
    }
    return true;
  }

  private static boolean checkSumGrid() {
    int sum = 0;
    for(int i=0; i<grid.length; ++i) {
      sum += grid[i][i];
    }
    return sum == k;
  }

  private static void printGrid(){
    for(int[] row : grid){
      for(int c : row) {
        pw.print((c)+" ");
      }
      pw.println();
    }
  }

  private static boolean genGrid(int i, int j) {
    if(i == grid.length){
      return checkSumGrid();
    }
    for(int n=1; n<=grid.length; ++n) {
      if(checkGridLocation(i, j, n)){
        grid[i][j] = n;
        if(genGrid(j == grid.length-1? i+1:i, (j+1) % grid.length)) {
          return true;
        }
        grid[i][j] = 0;
      }
    }
    return false;
  }

  private static void solve() throws IOException {
    int T = Integer.parseInt(bf.readLine());
    String[] line;
    int N;
    int maxUnique;
    boolean possible;
    for(int t=1; t <= T; ++t) {
      line = bf.readLine().split(" ");
      N = Integer.parseInt(line[0]);
      k = Integer.parseInt(line[1]);
      grid = new int[N][N];
      possible = genGrid(0, 0);
      if(possible){
        pw.println("Case #"+t+": POSSIBLE");
        printGrid();
      } else {
        pw.println("Case #"+t+": IMPOSSIBLE");
      }
    }
  }

}