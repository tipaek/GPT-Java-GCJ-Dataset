import java.util.*;

class Solution{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int tr = sc.nextInt();
        for(int i=1;i<=tr;++i){
            int N = sc.nextInt();
            int[][] mat = new int[N][N];
            int trace = 0;
            //Input matrix and calculate k
            for(int j=0;j<N;++j){
                for(int k=0;k<N;++k){
                    mat[j][k] = sc.nextInt();
                    if(j==k) trace += mat[j][k];
                }
            }
            //Calculate r
            int vesR = 0;
            for(int j=0;j<N;++j){
                int[] cnt = new int[N];
                Arrays.fill(cnt, 0);
                boolean isunique = true;
                for(int k=0;k<N;++k){
                    ++cnt[mat[j][k]-1];
                    if(cnt[mat[j][k]-1]==2){
                        isunique = false;
                        break;
                    }
                }
                if(!isunique) ++ vesR;
            }
            
            //Calculate c
            int vesC = 0;
            for(int j=0;j<N;++j){
                int[] cnt = new int[N];
                Arrays.fill(cnt, 0);
                boolean isunique = true;
                for(int k=0;k<N;++k){
                    ++cnt[mat[k][j]-1];
                    if(cnt[mat[k][j]-1]==2){
                        isunique = false;
                        break;
                    }
                }
                if(!isunique) ++ vesC;
            }
            System.out.println("Case #"+tr+": "+trace+" "+vesR+" "+vesC);
        }
    }
}