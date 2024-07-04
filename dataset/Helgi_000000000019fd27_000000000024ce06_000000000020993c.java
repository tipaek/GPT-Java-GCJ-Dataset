import java.util.Scanner;
public class Solution{
  public static void main(String[] args){
    
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    
    for(int d =0; d<T; d++){
      int n = scanner.nextInt();
      int column = 0;
      int row =0;
      int trace =0;
      int[][] a = new int[n][n];
      for(int i=0; i<n; i++)
       {
           for(int j=0; j<n; j++)
           {
               a[i][j] = scanner.nextInt();
           }
       }
      
      //trace
      for(int i =0; i<n; i++){
        for(int j =0; j<n;j++){
          if(j==i) trace+=a[i][j];
        }
      }
      
      
      //counting columns
      boolean afram = true;
      for(int i =0; i<n; i++){
        afram = true;
        for(int j =0; j<n && afram; j++){
          for(int k =j+1;k<n && afram;k++){
            if(a[i][j] == a[i][k]){
              column++;
              afram = false;
            }
          }
        }
      }
      
      //counting rows
      
      //transpose
      for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
      //count columns
      afram = true;
      for(int i =0; i<n; i++){
        afram = true;
        for(int j =0; j<n && afram; j++){
          for(int k =j+1;k<n && afram;k++){
            if(a[i][j] == a[i][k]){
              row++;
              afram = false;
            }
          }
        }
      }
      
      
      
     System.out.println("Case "+ "#"+ (d+1)+":"+ " "+trace+ " " + column+ " " + row); 
    }
  }
}