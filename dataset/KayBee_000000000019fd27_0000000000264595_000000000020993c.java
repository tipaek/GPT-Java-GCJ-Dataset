import java.util.*;
class Solution {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    int[][] op= new int[t][3];
    for(int i=0;i<t;i++){
      int n=sc.nextInt();
      int[][] matx = new int[n][n];
      int trace=0;
      int rowCount=0;
      int colCount=0;
      for(int j=0;j<n;j++){
        for(int k=0;k<n;k++){
          matx[j][k]=sc.nextInt();
        }
      }
      int[] rowArr =new int[n];
      int[] colArr =new int[n];

      for(int j=0;j<n;j++){
        for(int k=0;k<n;k++){
          rowArr[k]=0;
          colArr[k]=0;
          if(j==k){
            trace+=matx[j][k];
          }
        }
        for(int k=0;k<n;k++){
          if(rowArr[matx[j][k]-1]==0)
            rowArr[matx[j][k]-1]=1;
          else{
            rowCount++;
            break;
          }
        }
        for(int k=0;k<n;k++){
          if(colArr[matx[k][j]-1]==0)
            colArr[matx[k][j]-1]=1;
          else{
            colCount++;
            break;
          }
        }
      }
      op[i][0]=trace;
      op[i][1]=rowCount;
      op[i][2]=colCount;
    }
    for(int i=0;i<t;i++){
      System.out.println("Case #"+(i+1)+": "+op[i][0]+" "+op[i][1]+" "+op[i][2]);
    }
  }
}