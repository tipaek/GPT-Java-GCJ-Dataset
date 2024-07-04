import java.util.Scanner;
import java.util.HashSet;
public class Solution{

static Scanner sc=new Scanner(System.in);
public static void main(String[] args){
HashSet<Integer> s=new HashSet<Integer>();
boolean f=true;
    int test=sc.nextInt(); int [][]a;
int col =0,row=0,trace=0,k;
  for(int i=0;i<test;i++){
     col =0;row=0;trace=0;
  int  N=sc.nextInt();
     a=new int [N][N];
      for(int j=0;j<N;j++){
f=true;
                for(k=0;k<N;k++){
                     a[j][k]=sc.nextInt();
                      if(j==k)
                           trace=trace+a[j][k];
               
                             if(f&&(s.add(a[j][k])==false)){
                                f= false;
                                  row++;  
                                      }
          }
              s.clear();
                    
}    
  
                        for(int j=0;j<N;j++){

                              for(k=0;k<N;k++){
                     
               
                             if((s.add(a[k][j])==false)){
                  
                                  col++;
                                  break;  
                                      }
                              }//k loop
                            s.clear();
                    
                  } //j lop      
            
       System.out.println("Case #"+(i+1)+": "+trace+" "+row+" "+col);
}
}
}