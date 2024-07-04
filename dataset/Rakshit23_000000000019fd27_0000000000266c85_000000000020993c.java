import java.util.*;
public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int a[][] = new int[N][N];
            int trace = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    a[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<N; i++){
                trace += a[i][i];
            }
            int rows = 0;
            for(int i=0; i<N; i++){
                int ar[] = new int[N];
                for(int j=0; j<N; j++){
                    int x = a[i][j];
                    ar[x-1] += 1;
                }
                for(int j=0; j<ar.length; j++){
                    if(ar[j]==0 || ar[j]>1){
                        rows += 1;
                        break;
                    }
                }
            }
            int cols = 0;
            for(int i=0; i<N; i++){
                int ar[] = new int[N];
                for(int j=0; j<N; j++){
                    int x = a[j][i];
                    ar[x-1] += 1;
                }
                for(int j=0; j<ar.length; j++){
                    if(ar[j]==0 || ar[j]>1){
                        cols += 1;
                        break;
                    }
                }
            }
            System.out.println("Case #"+(t+1)+": "+ trace + " " + rows + " " + cols);
        }
    }
}