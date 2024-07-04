import java.util.Scanner;

public class Solution {
    

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int l=0;l<t;l++){
            int N=s.nextInt();
            int [][] A;
            boolean [][] B;
            int tra=0,ren=0,col=0;
            boolean g;
            A=new int[N][N];
            B=new boolean [N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    A[i][j]=s.nextInt();
                    B[i][A[i][j]-1]=true;
                    if(i==j) tra=tra+A[i][j];
                    
                }
            }
            for(int i=0;i<N;i++){
                g=true;
                for(int j=0;j<N;j++){
                    if(B[i][j]==false) g=false;
                    
                    B[i][j]=false;
                }
                if(g==false) ren++;
                
            }
            for(int j=0;j<N;j++){
                for(int i=0;i<N;i++){
                    B[A[i][j]-1][j]=true;
                }
            }
            for(int j=0;j<N;j++){
                g=true;
                for(int i=0;i<N;i++){
                    if(B[i][j]==false){
                        g=false;
                    }
                    
                }
                if(g==false) col++;
                
            }
            System.out.println("Case #"+(l+1)+": "+tra+" "+ren+" "+col);
        }
    }
    
}