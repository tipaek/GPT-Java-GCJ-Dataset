import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i<T; i++){
            int N = sc.nextInt();
            int t = 0;
            int c = 0;
            int r = 0;
            int[][] A = new int[N][N];
            boolean[][] seddalkur = new boolean[N+1][N+1];
            boolean[] dalkur = new boolean[N+1];
            boolean[][] sedlina = new boolean[N+1][N+1];
            boolean[] lina = new boolean[N+1];
            for(int j = 0; j<N;j++){
                for(int k =0; k<N;k++){
                    int a = sc.nextInt();
                    if(j == k) t+= a;
                    if(seddalkur[a][k] && !dalkur[k]) {
                        c++;
                        dalkur[k] = true;
                    }
                    seddalkur[a][k] = true;
                    if(sedlina[j][a] && !lina[j]){
                        r++;
                        lina[j] = true;
                    }
                    sedlina[j][a] = true;
                }
            }
            System.out.println("Case #"+(i+1)+": "+t+" "+r+" "+c);
        }
    }
}