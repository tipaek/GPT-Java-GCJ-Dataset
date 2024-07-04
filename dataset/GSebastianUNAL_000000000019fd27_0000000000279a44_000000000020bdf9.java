import java.util.Scanner;

/*@author Sebastian*/


public class CodeForces {

  
    public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
            int T =scan.nextInt();
            scan.nextLine();
            
            
            for(int t=1; t<=T; t++){
                
                int N=scan.nextInt();
                scan.nextLine();
                int n=4;
                
                int matriz [][]  =new int [N][n];
               
                n=N+N;
                int arregloerroresu []  =new int [n];
                
                int arregloerroresk []  =new int [n];
           
                String ordens="";
                boolean acruzab=false;
                int aux=0;
                
                for(int i=0; i<N; i++){
                    matriz [i][0]=i;
                    matriz [i][1]=scan.nextInt();
                    matriz [i][2]=scan.nextInt();  
                    if(i+1<N){
                         scan.nextLine();
                    }
                   
                }
                
                int j=0;
                while(j<N){
                    
                    for(int i=j; i<N; i++){
                        if(matriz[j][1]>matriz[i][1]){
                            aux= matriz[i][1];
                            matriz [i][1]=matriz [j][1];
                            matriz [j][1]=aux;
                            
                            aux= matriz [i][2];
                            matriz [i][2]=matriz [j][2];
                            matriz [j][2]=aux;
                            
                            aux= matriz [i][0];
                            matriz [i][0]=matriz [j][0];
                            matriz [j][0]=aux;
                        }
                    }
                    
                    j++;
                }
               
               
                
                
               
                matriz [0][3]=0;
                for(int i=1; i<N; i++){
                    if(matriz [0][2]>matriz [i][1]){
                        matriz [i][3]=1;
                    }else{
                         matriz [i][3]=0;
                    }
                }
                
                
                
               
                j=0;
                for(int k=0; k<N; k++){
                    
                    for(int i=k+1; i<N; i++){
                        
                        
                        if(matriz [k][2]>matriz [i][1]){
                            
                            arregloerroresu [j]=i;
                            arregloerroresk [j]=k;
                            
                            
                            j++;
                        }
                    }
                    
                    
                }
                
               
             
                
                int a=0;
                while(a<j && acruzab==false){
                    
                    for(int i=a+1; i<j; i++){
                        
                        if( arregloerroresu [a]== arregloerroresu [i]){
                            
                            acruzab=true;
                            break;
                        }
                    }
                    
                    a++;
                }
                
              
                if(acruzab==false){
                    for(int i=0; i<j; i++){
                        if(matriz[arregloerroresu [i]][3]==matriz[arregloerroresk [i]][3]){
                            if(matriz[arregloerroresu [i]][3]==0){
                                matriz[arregloerroresu [i]][3]=1;
                            }else{
                                matriz[arregloerroresu [i]][3]=0;
                            }
                        }  
                    }
                    
                }
                
                
                
    
                j=0;
                if(acruzab==false){
                    while(j<N){
                        
                        for(int i=0; i<N; i++){
                            if(j==matriz [i][0]){
                                if(matriz[i][3]==0){
                                    ordens=ordens+"C";
                                    
                                }else{
                                    ordens=ordens+"J";
                                    
                                }
                                
                            }
                        }
                        
                        j++;
                    }
                    System.out.println("Case #"+t+": "+ordens);
                }else{
                    System.out.println("Case #"+t+": IMPOSSIBLE");
                }
                
            }
    
        }
    
  
        
    }
    