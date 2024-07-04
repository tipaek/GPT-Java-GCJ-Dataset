import java.util.Scanner;

/*@author Sebastian*/


public class CodeForces {

  
    public static void main(String[] args) {

       Scanner scan= new Scanner(System.in);
       int T =scan.nextInt();
       scan.nextLine();
      
        
       for(int t=1; t<=T; t++){
           
           int N=scan.nextInt();
           scan.nextLine();
           int matriz [][]  =new int [N][N] ;
           
          for(int i=0; i<N; i++){
               for(int j=0; j<N; j++){
              matriz[i][j]=scan.nextInt();
             }
                scan.nextLine();
          }
          
          int K=0;
          for(int k=0; k<N; k++){
             K= matriz[k][k]+K;
          }
          
          
          boolean repeat;
          int r=0;
            for(int i=0; i<N; i++){
                int J=0;
                while(J<N){
                repeat=false;
               for(int j=J; j<N; j++){
                   
                   if( matriz[i][J]==matriz[i][j] && J!=j){
                       r++;
                       repeat=true;
                       break;
                   }
 
               }
               J++;
                if(repeat){
                   break;
                }
                
               }
            }
            
         boolean repeatc;
          int c=0;
            for(int j=0; j<N; j++){
                int I=0;
                while(I<N){
                repeatc=false;
               for(int i=I; i<N; i++){
                   
                   if( matriz[I][j]==matriz[i][j] && I!=i){
                       c++;
                       repeatc=true;
                       break;
                   }
 
               }
               I++;
                if(repeatc){
                   break;
                }
                
               }
            }
           
           
           
            System.out.println("Case #"+t+": "+K+" "+r+" "+c);
       }
       
       
     
         
       
        scan.close();
       }
  
        
    }