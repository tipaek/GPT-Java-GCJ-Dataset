import java.util.Scanner;




public class Solution {

  
    public static void main(String[] args) {

       Scanner scan= new Scanner(System.in);
       int T =scan.nextInt();
       scan.nextLine();
      
       
       for(int t=1; t<=T; t++){
           
           int N=scan.nextInt();
           scan.nextLine();
           
           int matriz [][]  =new int [N][2];
           int matrizaux [][]  =new int [N][2];
           int arreglo []  =new int [N];
          
           for(int i=0; i<N; i++){
               matriz [i][0]=scan.nextInt();
               matrizaux [i][0]=matriz [i][0];
               matriz [i][1]=scan.nextInt();
               matrizaux [i][1]=matriz [i][1];
               scan.nextLine();
           }
           
           int j=0;
           while(j<N){
           
            for(int i=j; i<N; i++){
               if(matrizaux [j][0]>matrizaux [i][0]){
                  int aux= matrizaux [i][0];
                  matrizaux [i][0]=matrizaux [j][0];
                  matrizaux [j][0]=aux;
                  
                  aux= matrizaux [i][1];
                  matrizaux [i][1]=matrizaux [j][1];
                  matrizaux [j][1]=aux;
               }
            }
                   
              j++;
           }
           
        
           String orden="";
           boolean acruzab=false;
           
           int count=0;
           
          
               

                    arreglo[0]=0;   
                 for(int u=1; u<N; u++){
                    if(matrizaux [0][1]>matrizaux [u][0]){
                  
                  arreglo[u]=1;
                }else{
                        arreglo[u]=0;
                    }
               }
                 
               
     

          
              
           int arregloerroresu []  =new int [N*3];
           int arregloerroresk []  =new int [N*3];
           int h=0;
             for(int k=0; k<N; k++){
                  
                 for(int u=k+1; u<N; u++){
                    
                    
                    if(matrizaux [k][1]>matrizaux [u][0]){
                        
                  arregloerroresu [h]=u; 
                  arregloerroresk [h]=k;
                 
                 
                  h++;
                }
               }
                 
               
                }
             
             
             
             
             
            int q=0;
            while(q<h && !acruzab){
                
                for(int k=q+1; k<h; k++){
                   
                if( arregloerroresu [q]== arregloerroresu [k]){
                    
                    acruzab=true;
                    break;
                }
            }
                
             q++;
            }
           
            if(!acruzab){
                for(int i=0; i<h; i++){
                    if(arreglo[arregloerroresu [i]]==arreglo[arregloerroresk [i]]){
                        if(arreglo[arregloerroresu [i]]==0){
                             arreglo[arregloerroresu [i]]=1;
                        }else{
                            arreglo[arregloerroresu [i]]=0;
                        }  
                    }
                }
                
            }
            
            
            
            
             
             
               
               
              
               

          
           j=0;
         if(!acruzab){
           while(j<N){
           
            for(int i=0; i<N; i++){
               if(matriz [j][0]==matrizaux [i][0]){
                   if(arreglo[i]==0){
                       orden=orden+"C";
                       
                   }else{
                       orden=orden+"J";
                       
                   }
                  
               }
            }
                   
              j++;
           }
           System.out.println("Case #"+t+": "+orden);
          }else{
              System.out.println("Case #"+t+": IMPOSSIBLE");
          }
       
       }
       
       
     
         
       
        scan.close();
       }
  
        
    }