import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i<T; i++){
            int N = sc.nextInt();
            int[][] J = new int[N+1][2];
            int Jverk = 0;
            int[][] C = new int[N+1][2];
            int Cverk = 0;
            char[] strengur = new char[N];
            String s = "";
            int[] S = new int[N];
            int[] E = new int[N];
            for(int j = 0; j<N;j++){
                S[j] = sc.nextInt();
                E[j] = sc.nextInt();
            }
            int minnst = S[0];
            int visir = 0;
            for(int l = 0; l<N;l++){
                if(minnst>S[l]){
                    visir = l;
                    minnst = S[l];
                }
            }
            boolean[] vis = new boolean[N];
            for(int j =0 ; j<N;j++){
           
                if(!s.equals("IMPOSSIBLE")){
                vis[visir] = true;
                int S1 = S[visir];
                int E1 = E[visir];
                boolean Jgetur = true;
                for(int k = 0; J[k][1]>0;k++){
                    int a = J[k][0];
                    int b = J[k][1];
                    if((a<=S1 && S1<b) || (a<E1 && E1<=b) || (S1<=a && b<= E1)){
                        Jgetur = false;
                    }
                }
                boolean Cgetur = true;
                for(int k = 0; C[k][1]>0;k++){
                    int a = C[k][0];
                    int b = C[k][1];
                    if((a<=S1 && S1<b) || (a<E1 && E1<=b) || (S1<=a && b<= E1)){
                        Cgetur = false;
                    }
                }
                if(Jgetur){
                    J[Jverk][0] = S1;
                    J[Jverk][1] = E1;
                    Jverk++;
                    strengur[visir] = 'J';
                }
                else if(Cgetur){
                    C[Cverk][0] = S1;
                    C[Cverk][1] = E1;
                    Cverk++;
                    strengur[visir] = 'C';
                }
                else{
                    s = "IMPOSSIBLE";
                }
                minnst = 24*60+1;
                for(int l = 0; l<N; l++){
                    if(S[l]<minnst && !vis[l]){
                        minnst = S[l];
                        visir = l;
                    }
                }
                }
            }
            if(!s.equals("IMPOSSIBLE")){
                for(int k = 0; k<N;k++) s+= ""+strengur[k];
            }
            System.out.println("Case #"+(i+1)+": "+s);
        }
    }
}