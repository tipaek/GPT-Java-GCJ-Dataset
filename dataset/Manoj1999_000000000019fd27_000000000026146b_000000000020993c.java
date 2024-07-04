import java.util.*;
class Sol{
public static void Main(String[] rgs){
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  for(int i=0;i<n;i++){
      int si=sc.nextInt();
      int matrix[][]=new int[si][si];
      for(int k=0;k<si;k++){
          for(int l=0;l<si;l++){
              matrix[k][l]=sc.nextInt();
          }
           for(int k1=0;k1<si;k++){
          for(int l1=0;l1<si;l++){
              System.out.print(matrix[k1][l1]);
          }
          System.out.println();
          
      }
  }
    
    
    
}
    
    
    
    
}
    
}