import java.util.Scanner;
class Solution{
  public static int findRepet(int[] a,int b){
    int[] map = new int[b];
    for(int i = 0;i < b;i++){
      map[i] = 0;
    }
    for(int j = 0;j < b;j++){
      if(map[a[j] - 1] == 0){
        map[a[j] - 1] = 1;
      }else{
        return 1;
      }
    }
    return 0;
  }
  public static void main(String[] arg){
    Scanner in = new Scanner(System.in);
    int caseNum = in.nextInt();
    int n = 0;
    int row = 0;
    int col = 0;
    int trace = 0;
    int[][] mat;
    int[] seq;
    int a = 0;
    for(int i = 0;i < caseNum;i++){
      trace = 0;
      col = 0;
      row = 0;
      n = in.nextInt();
      mat = new int[n][n];
      seq = new int[n];
      for(int j = 0; j < n;j++){
        for(int k = 0;k < n;k++){
          a = in.nextInt();
          seq[k] = a;
          mat[k][j] = a;
        }
        if(findRepet(seq,n) == 1){
          row++;
        }
      }
      for(int t = 0;t < n;t++){
        col = col + findRepet(mat[t],n);
        trace = trace + mat[t][t];
      }
      System.out.println("Case #" + (i + 1) + ": " + trace + " " + row + " " + col);
    }
    in.close();
  }
}