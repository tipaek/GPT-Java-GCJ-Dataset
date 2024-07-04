import java.util.*;
class Main{
public static void main(String[] rgs){
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  for(int i=0;i<n;i++){
      int si=sc.nextInt();
      int matrix[][]=new int[si][si];
      for(int k=0;k<si;k++){
          for(int l=0;l<si;l++){
              matrix[k][l]=sc.nextInt();
          }
          
      }
           int sumdiag=0;
           HashSet<Integer> column=new HashSet<Integer>();
           HashSet<Integer> row=new HashSet<Integer>();
           int rowcount=0;int colcount=0;int colchange=0,rowchange=0;
           for(int i1=0;i1<si;i1++) {
        	   sumdiag=matrix[i1][i1]+sumdiag;
        	   }
           for(int k1=0;k1<si;k1++){
        	   colchange=0;
               for(int l1=0;l1<si;l1++){
                   if(!column.add(matrix[k1][l1])&&colchange==0)
                		   {colcount++;colchange=1;}
                
               }
              
               column.clear();
               
           }
           for(int k2=0;k2<si;k2++){
        	   rowchange=0;
        	
               for(int l2=0;l2<si;l2++){
                   if(!row.add(matrix[l2][k2])&&rowchange==0)
                		   {rowcount++;rowchange=1;}
               }
               row.clear();
               
               
           }
           
         System.out.print("Case #"+(i+1)+":"+" "+sumdiag+" "+colcount+" "+rowcount);  
           
  }
    
    
}
}
    
    
    
    

    
