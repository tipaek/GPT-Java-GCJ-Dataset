/**
 *
 * @author EngOsm
 */

import java.util.Scanner;
public class NewMain {


    public static void main(String[] args) {
        
        Scanner input =new Scanner(System.in); 
        int T = input.nextInt();
      
     for (int i2=0;i2<T;i2++)
         { 
          int N = input.nextInt();
          int sum =0;
          int R=0;
          int C=0;
    
     int [][]MT =new int [N][N] ;
     
     int js=1;
     int jsc=1;
    
    for (int i=0;i<N;i++)
    {
      for (int j=0;j<N;j++) 
      {MT[i][j]= input.nextInt();}
    } 
         for (int k=0;k<N;k++) 
         {
          sum=sum+MT[k][k];
         }
 R=0;
for (int i1=0;i1<N;i1++)
    {
  js=1;
      for (int j1=0;j1<N;j1++) 
      {
         int s=1;
      while ( s<N-j1)
         {
          
        if (MT[i1][j1]==MT[i1][j1+s] )
        {R++;
         js=0;
        break ; 
       
       }  
        else {
            s++;
                }
        
      }
        if (js==0) {break;} 
      }

    }

 C=0;
for (int j3=0;j3<N;j3++)
    {
  jsc=1;
      for (int i3=0;i3<N;i3++) 
      {
         int sc=1;
      while ( sc<N-i3)
         {
        if (MT[i3][j3]==MT[i3+sc][j3] )
        {C++;
         jsc=0;
        break ; 
       }  
        else {sc++;}

      }
        if (jsc==0) {break;} 
      }
    }
       System.out.print("Case #" );
        System.out.print(i2+1);
        System.out.print(": ");
         System.out.print(sum );
         System.out.print(" ");
         System.out.print(R);
         System.out.print(" ");
         System.out.println(C);
    }
    }
}
