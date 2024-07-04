import java.util.Scanner;

class Solution {
  static int res[][];
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int a=1;a<=t;a++) {
      int n=sc.nextInt();
      int sum=sc.nextInt();
      
      res=new int[n][n];
      backtrack(0,0,sum,new int[n][n]);
      
      boolean flag=true;
      for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
          if(res[i][j]==0) {
             flag=false;
            break;
          }
        }
        if(flag==false)
          break;
      }
      if(flag==false) 
        System.out.println("Case #"+a+": IMPOSSIBLE");
      else {
        System.out.println("Case #"+a+": POSSIBLE");
        for(int i=0;i<n;i++) {
          for(int j=0;j<n;j++) {
            System.out.print(res[i][j]+" ");
          }
          System.out.println();
        }
      }
    }
  }
  static void backtrack(int i,int j,int sum,int [][]mat) {
    if(i<0 ||j<0 ||i>=mat.length||j>=mat.length||mat[i][j]!=0)
      return;
    
    for(int a=1;a<=mat.length;a++) {
      
      if(i==mat.length-1 && j==mat.length-1 && checkrow(i,j,mat,a) && checkcol(i,j,mat,a)) {
        int tempsum=0;
        for(int r=0;r<mat.length;r++) {
             tempsum+=mat[r][r];  
        }
        if(tempsum+a==sum) {
          mat[i][j]=a;
          res=mat;
        }
          
      }   
      else if(checkrow(i,j,mat,a) && checkcol(i,j,mat,a)) {
        mat[i][j]=a;
        backtrack(i+1,j,sum,mat);
        backtrack(i,j+1,sum,mat);
        backtrack(i-1,j,sum,mat);
        backtrack(i,j-1,sum,mat);
        
      }
      
    }
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
}
