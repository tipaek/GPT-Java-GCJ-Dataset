import java.util.*;

public class P1{
  static int Num_Rows(int[][] mat,int N){
    int count = 0;
    for(int i = 0; i < N; i++){
      List<Integer> seen = new ArrayList<Integer>();
      for(int j = 0; j < N; j++){
        if(seen.indexOf(mat[i][j])==-1){
          seen.add(mat[i][j]);
        }else{
          j = N;
          count++;
        }
      }
    }
    return count;
  }

  static int Num_Cols(int[][] mat,int N){
    int count = 0;
    for(int i = 0; i < N; i++){
      List<Integer> seen = new ArrayList<Integer>();
      for(int j = 0; j < N; j++){
        if(seen.indexOf(mat[j][i])==-1){
          seen.add(mat[j][i]);
        }else{
          j = N;
          count++;
        }
      }
    }
    return count;
  }


  public static void main(String args[]){
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();

    for(int z = 0; z < T; z++){
      int N = input.nextInt();
      int[][] mat = new int[N][N];
      int trace = 0;
      for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
          mat[i][j] = input.nextInt();
          if(i==j){
            trace += mat[i][j];
          }
        }
      }


      int nu_row = Num_Rows(mat,N);
      int nu_cols = Num_Cols(mat,N);




      System.out.println("Case #"+(z+1)+": "+trace+" "+nu_row+" "+nu_cols);
    }
  }
}
