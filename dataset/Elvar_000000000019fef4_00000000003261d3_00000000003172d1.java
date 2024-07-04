import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int x = 1; x<=T;x++){
            int N = sc.nextInt();
            int D = sc.nextInt();
            long[] A = new long[N];
            for(int i = 0; i<N;i++){
                A[i] = sc.nextLong();
            }
            int fjoldi = -1;
            if( D== 2){
                for(int i = 0; i<N;i++){
                    for(int j = i+1; j<N;j++){
                        if(A[i] == A[j]) fjoldi = 0;
                    }
                }
                if(fjoldi == -1) fjoldi = 1;
            }
            if(D== 3){
                for(int i = 0; i<N;i++){
                    for(int j = i+1; j<N;j++){
                        for(int k = j+1; k<N;k++){
                            if(A[i] == A[j] && A[j] == A[k]) fjoldi = 0;
                        }
                    }
                }
                if(fjoldi == -1){
                    for(int i = 0; i<N;i++){
                        for(int j = i+1; j<N;j++){
                            if(A[i] == 2*A[j] || A[j] == 2*A[i]) fjoldi = 1;
                            if(A[i] == A[j]){
                                for(int k = 0; k<N;k++){
                                    if(A[k]>A[i]) fjoldi = 1;
                                }
                            }
                        }
                    }
                }
                if(fjoldi == -1) fjoldi = 2;
                
            }
            System.out.println("Case #"+x+": "+fjoldi);
        }
    }
}