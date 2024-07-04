import java.util.*;

class Solution{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int i=1; i<=t; i++){
      int N = in.nextInt();
      int K = in.nextInt();
      solve(N,K,i);
    }
  }

  private static void solve(int N, int K, int index){
    if(K%N != 0)
      System.out.println("Case #"+index+": "+"IMPOSSIBLE");
    else {
      int L = K/N;
      int[][] M = new int[N][N];
      for(int i=0; i<N; i++)
        for(int j=0; j<N; j++){
          M[i][j] = (((L-i)+j)%N+N)%N;
          if(M[i][j] == 0)
            M[i][j] = N;
        }
      System.out.println("Case #"+index+": "+"POSSIBLE");
      printMatrix(M);
    }
  }

  public static void printMatrix(int[][] M){
    for(int i=0; i<M.length; i++){
      for(int j=0; j<M.length; j++){
        System.out.print(M[i][j]+" ");
      }
      System.out.println();
    }
  }

}
