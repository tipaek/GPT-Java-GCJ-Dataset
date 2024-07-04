import java.util.*;
class Codejam{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int i =1 ;i<=t;i++)
    {
      int N = sc.nextInt();
      int mat[][] = new int[N][N];
      for(int j = 0;j<N;j++){
        for(int k = 0;k<N;k++){
            mat[j][k] = sc.nextInt();
        }
      }
      int trace = 0,r = 0,c = 0;
      for(int j = 0;j<N;j++){

                   trace += mat[j][j];
      }
      for(int j = 0;j<N;j++)
      {
          for(int row=0;row<N;row++)
          {
          int r_count=0;
              for(int p = 0;p<N;p++)
              {
                  if(mat[j][row] == mat[j][p])
                    r_count++;
              }
              if(r_count>1){
                r++;
                break;
              }
          }
          for(int col=0;col<N;col++)
          {
          int c_count=0;
              for(int p = 0;p<N;p++)
              {
                  if(mat[col][j] == mat[p][j])
                  {
                      //System.out.print(mat[j][p]+" ");
                        c_count++;
                  }
              }
              if(c_count>1){
                c++;
                break;}
          }
         // System.out.println();

      }
      System.out.println("Case #"+i+": "+trace+" "+r+" "+c);

    }
  }
}
