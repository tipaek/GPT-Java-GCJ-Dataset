import java.util.*;
class Solution {
  public static void main(String []args) {
        Scanner s=new Scanner(System.in);
        
      int matrixNum=s.nextInt();
      int mO=0;
      for(int h=0; h<matrixNum; h++) {
          
          int matrixOrd=s.nextInt();
          mO=matrixOrd;
          int [][] matrix=new int[matrixOrd][matrixOrd];
          for(int i=0; i<matrixOrd; i++) {
              for(int j=0; j<matrixOrd; j++){
                  matrix[i][j]=s.nextInt();
              }
              
          }
      
      int t=0;
      for(int i=0; i<mO; i++){
          for(int j=0; j<mO; j++){
              
              if(i==j) {
                  t+=matrix[i][j];
                  break;
              }
          }
      }
      int r=0;
      int c=0;
      for(int i=0; i<mO; i++) {
          int[] rcounts=new int[mO];
          int[] ccounts=new int[mO];
          for(int j=0; j<mO; j++){
             int n=matrix[i][j];
             rcounts[n-1]++;
             if(rcounts[n-1]>1) {
                 r++;
                 break;
             }
          }
           for(int j=0; j<mO; j++){
             int n=matrix[j][i];
             ccounts[n-1]++;
             if(ccounts[n-1]>1) {
                 c++;
                 break;
             }
          }
          
       }
       System.out.println("Case #"+(h+1)+": "+t+" "+r+" "+c);
     }
     
  }
    
}