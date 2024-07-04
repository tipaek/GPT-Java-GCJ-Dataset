

import java.util.ArrayList;
import java.util.Scanner;

 class Solution {
  static ArrayList<int[][]> res;
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int a=1;a<=t;a++) {
      int n=sc.nextInt();
      int sum=sc.nextInt();
      res=new ArrayList<int [][]>();
      
     ;
      
      
      if( !backtrack(sum,new int[n][n])) 
        System.out.println("Case #"+a+": IMPOSSIBLE");
      else {
        System.out.println("Case #"+a+": POSSIBLE");
        int [][]r=res.get(0);
        for(int i=0;i<n;i++) {
          for(int j=0;j<n;j++) {
            System.out.print(r[i][j]+" ");
          }
          System.out.println();
        }
      }
    }
  }
  static boolean backtrack(int sum,int [][]mat) {
    
    for(int r=0;r<mat.length;r++) {
      for(int c=0;c<mat.length;c++) {
        if(mat[r][c]==0) {
          for(int a=1;a<=mat.length ;a++) {
            
            if(checkrow(r,c,mat,a) && checkcol(r,c,mat,a)) {
              mat[r][c]=a;
              if(backtrack( sum, mat) && checksum(mat,sum)) {
                res.add(mat)  ;
                return true;
              }
              mat[r][c]=0;
            }
            
          }
          return false;
        }
      }
    }
    return true;
  }
  static boolean checkrow(int m,int n,int [][]mat,int a) {
    for(int i=0;i<mat.length;i++) {
      if(mat[m][i]==a)
        return false;
    }
    return true;
  }
  static boolean checkcol(int m,int n,int [][]mat,int a) {
    for(int i=0;i<mat.length;i++) {
      if(mat[i][n]==a)
        return false;
    }
    return true;
  }
  static boolean checksum(int mat[][],int sum) {
    int tempsum=0;
    for(int i=0;i<mat.length;i++) {
      tempsum+=mat[i][i];
    }
    if(tempsum==sum)
      return true;
    return false;
  }
}
