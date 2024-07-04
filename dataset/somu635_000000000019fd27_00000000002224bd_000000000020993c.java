import java.util.HashSet;
import java.util.Scanner;

class Solution {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int a=1;a<=t;a++) {
      int n=sc.nextInt();
      int mat[][]=new int[n][n];
      for(int i=0;i<n;i++) 
        for(int j=0;j<n;j++)
        mat[i][j]=sc.nextInt();
      
      int trace=0;
      for(int i=0;i<n;i++)
        trace+=mat[i][i];
      
      int row=0,col=0;
      
      for(int i=0;i<n;i++) {
        HashSet hs=new HashSet<Integer>();
        for(int j=0;j<n;j++) {
          if(hs.contains(mat[i][j])) {
            row++;
            break;
          }else {
            hs.add(mat[i][j]);
          }
        }
      }
      
      for(int i=0;i<n;i++) {
        HashSet hs=new HashSet<Integer>();
        for(int j=0;j<n;j++) {
          if(hs.contains(mat[j][i])) {
            col++;
            break;
          }else {
            hs.add(mat[j][i]);
          }
        }
      }
      
      System.out.println("Case #"+a+": "+trace+" "+row+" "+col);
      
    }

  }

}
