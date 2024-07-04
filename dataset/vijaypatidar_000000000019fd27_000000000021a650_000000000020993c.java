import java.util.Scanner;

public class Vestigium{
    public static void main(String ...args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            int N = sc.nextInt();
            int[][] ar = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    ar[i][j] = sc.nextInt();
                }
            }
            
            // trace
            int trace = 0;
            for(int i=0;i<N;i++){
                trace+=ar[i][i];
            }
            
            
            int row = 0;
            boolean found = false;
            for(int i=0;i<N;i++){
                 
                for(int j=0;j<N;j++){
                    for(int k=j+1;k<N;k++){
                        if(ar[i][j]==ar[i][k]){
                            found = true;
                            j=N;
                            break;
                        }
                    }
                }
                
                if(found){
                    row+=1;
                    found=false;
                }
            }
            
            int col = 0;
            for(int i=0;i<N;i++){
                 
                for(int j=0;j<N;j++){
                    for(int k=j+1;k<N;k++){
                        if(ar[j][i]==ar[k][i]){
                            found = true;
                            j=N;
                            break;
                        }
                    }
                }
                
                if(found){
                    col+=1;
                    found=false;
                }
            }
            
            System.out.println("#"+t+":"+trace+" "+row+" "+col);
        }
    }
}