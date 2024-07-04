
/**
 *
 * @author EngOsm
 */
import java.util.Scanner;
public class Solution {

    public static void main(String[] args) {
       
        Scanner input =new Scanner(System.in); 
        int T = input.nextInt();
  
          char pos;
           
          int i;
          
     for (int M=0;M<T;M++)
      { 
           int N = input.nextInt();
           pos='P'; 
          String Cam="Not Busy";
          String Jam="Not Busy";
           

            char []MT =new char [N] ; 
            int []C=new int [1441] ;
            int []J=new int [1441] ;

            int A= input.nextInt();
           int B= input.nextInt();  
            {for (int i3=A+1;i3<B;i3++)
             {C[i3]=1;
             MT[0]='C';
             } 

            
             
       for (int j=1;j<N;j++)
       {     

            A= input.nextInt();
           B= input.nextInt();  
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
            {for (int i3=A+1;i3<B;i3++)
             {C[i3]=1;
             MT[j]='C';
             } 
            }
            else if ("Not Busy".equals(Jam))
            {for (int i4=A;i4<=B;i4++)
             {J[i4]=1;
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
          for (int i5=0;i5<N;i5++)
     { 
     System.out.print(MT[i5]);
         }  
    }
      
    
         }
    }
    
}
}
