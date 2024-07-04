import java.util.*;
public class Sol{
    public static void vestigium(int mat[][], int N){
        
        int dsum=0;
        int maxA=0, maxB=0, mA=0,  mB=0;
        for(int i=0;i<N;i++){
            int cAarr[]=new int[N+1];
            int cBarr[]=new int[N+1];
            for(int j=0;j<N;j++){
                if(i==j){
                    dsum+=mat[i][j];
                }
                cAarr[mat[i][j]]++;
                cBarr[mat[j][i]]++;
                if(cAarr[mat[i][j]]==2 && mA==maxA){
                    maxA++;
                }
                if(cBarr[mat[j][i]]==2 && mB==maxB){
                    maxB++;
                }
            }
            mA=maxA; mB=maxB;
        }
        
        System.out.println(dsum+" "+maxA+" "+maxB);
    }
    
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int T= sc.nextInt();
        for(int t=1;t<=T;t++){
            int N= sc.nextInt();
            int mat[][]= new int[N][N];
            
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    mat[i][j]=sc.nextInt();
                }
            }
            System.out.print("Case #"+t+": ");
            vestigium(mat,N);
            
        }
    }
}