import java.util.*;
import java.lang.Math;

class Solution{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int i=1; i<=t; i++){
      int N = in.nextInt();
      int D = in.nextInt();
      long[] A  = new long[N];
      for(int j=0; j<N; j++)
        A[j] = in.nextLong();
      System.out.println("Case #"+i+": "+solve(N,D,A));
    }
  }

    private static String solve(int N, int D, long[] A){
      Arrays.sort(A);

      if(D == 2){
        boolean flag = false;
        for(int i=0; i<N; i++){
          for(int j=i+1; j<N; j++){
            if(A[i] == A[j])
              flag = true;
          }
        }
        if(flag) return "0";
        else return "1";
      }

      else if(D == 3){
        for (int i=0; i<N-2; i++){
          if(A[i] == A[i+1] && A[i+1] == A[i+2])
            return "0";
        }

        for (int i=0; i<N-1; i++){
          if(A[i] == A[i+1] && i < N-2)
            return "1";
        }

        for(int i=0; i<N-1; i++){
          if(A[i+1] == 2*A[i])
            return "1";
        }
        return "2";
      }

      else return "0";
    }
}
