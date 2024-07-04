import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        
        int C = T;
        
        //cases 
        while(T-->0){
            int N = scan.nextInt();
            
            int[][] sche = new int[N][3];
            
            for(int i=0; i<N; i++){
                sche[i][2]=5;
            }
            
            sche[0][2]= 0;
            
            for(int i=0; i<N; i++){
                sche[i][0]= scan.nextInt(); sche[i][1]= scan.nextInt(); 
            }
            
            for(int i=1; i<N; i++){
                boolean one = true;
                boolean zero = true;
                for(int j=0; j<N; j++){
                    //through all the ones 
                    if(j!=i && sche[j][2]==1){
                        if(sche[i][0]>sche[j][0] && sche[i][0]<sche[j][1] || sche[i][1]>sche[j][0] && sche[i][1]<sche[j][1]){
                            one = false;
                        }
                    }
                }
                for(int j=0; j<N; j++){
                    //through all the ones 
                    if(j!=i && sche[j][2]==0){
                        if(sche[i][0]>sche[j][0] && sche[i][0]<sche[j][1] || sche[i][1]>sche[j][0] && sche[i][1]<sche[j][1]){
                            zero = false;
                        }
                    }
                }
                if(one){
                    sche[i][2]=1;
                }else if (zero){
                    sche[i][2]=0; 
                }
                
                
            }
            
            

            
            
            boolean print = true;
             for(int i=0; i<N; i++){
                 if(sche[i][2]==5){
                     System.out.print("Case #"+(C-T)+": "); 
                     System.out.println("IMPOSSIBLE");
                     print = false;
                     
                 }
            }
            if(print){
                System.out.print("Case #"+(C-T)+": "); 
                for(int i=0; i<N; i++){
                    if(sche[i][2]==1){
                        System.out.print("J");
                    }else{
                        System.out.print("C");
                    }
                }
            System.out.println();
            }
        
        
        
        }
        
        
    }
}