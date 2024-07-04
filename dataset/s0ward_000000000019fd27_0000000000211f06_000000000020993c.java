import java.util.*;

class Solution{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int i=1; i<=t; i++){
      int N = in.nextInt();
      int[][] M = new int[N][N];
      for(int j=0; j<N; j++)
        for(int k=0; k<N; k++)
            M[j][k] = in.nextInt();
      System.out.println("Case #"+i+": "+solve(M));
    }
  }

  private static String solve(int[][] M){
    int N = M.length;
    int trace = 0;
    int rows = 0;
    int cols = 0;

    for(int i=0; i<N; i++)
        trace += M[i][i];

    for(int i=0; i<N; i++){
        Set<Integer> values = new HashSet<Integer>();
        for(int j=0; j<N; j++){
            if(values.contains(M[i][j])){
              rows++;
              break;
            }
            values.add(M[i][j]);
        }
    }

    for(int i=0; i<N; i++){
        Set<Integer> values = new HashSet<Integer>();
        for(int j=0; j<N; j++){
            if(values.contains(M[j][i])){
              cols++;
              break;
            }
            values.add(M[j][i]);
        }
    }

    return ""+trace+" "+rows+" "+cols;
  }

}
