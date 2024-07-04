
import java.util.Scanner;


/**
 *
 * @author EngOsm
 */
public class Solution {

    public static void main(String[] args) {
       
        Scanner input =new Scanner(System.in); 
        int T = input.nextInt();
  
          char pos='P';
           
          
          int i;
     for (int M=0;M<T;M++)
      { 
          pos='P'; 
          String Cam="Not Busy";
          String Jam="Not Busy";
            int N = input.nextInt();

            char []MT =new char [N] ; 
            int []C=new int [1441] ;
            int []J=new int [1441] ;
             
       for (int j=0;j<N;j++)
       {     

           int A= input.nextInt();
           int B= input.nextInt();  
           for (int i2=A+1;i2<B;i2++)
           {
            if (C[i2]==1) {Cam="Busy";
                          }
            if (J[i2]==1) {Jam="Busy";
                          }
            if (("Busy".equals(Cam))&&("Busy".equals(Jam))){
            pos='I';
                break;
            
            }   

           }
            if ("Not Busy".equals(Cam))
            {for (i=A;i<=B;i++)
             {C[i]=1;
             MT[j]='C';
             } 
            }
            else if ("Not Busy".equals(Jam))
            {for (i=A;i<=B;i++)
             {J[i]=1;
             MT[j]='J';
             } 
  
            }
           Cam="Not Busy";
          Jam="Not Busy";    
      }
       System.out.println();
     System.out.print("Case #" );  
     System.out.print(M+1); 
     System.out.print(": ");
      if (pos=='I')
      {   
       System.out.print("IMPOSSIBLE");
        pos='P';
          
    }
     else { 
          for (int i2=0;i2<N;i2++)
     { 
     System.out.print(MT[i2]);
         }  
    }
      
    
         }
    }
    
}
