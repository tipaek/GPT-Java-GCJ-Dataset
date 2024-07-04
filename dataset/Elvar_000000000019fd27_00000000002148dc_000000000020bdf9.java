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
            String s = "";
            for(int j = 0; j<N;j++){
                int S = sc.nextInt();
                int E = sc.nextInt();
                if(!s.equals("IMPOSSIBLE")){
                boolean Jgetur = true;
                for(int k = 0; J[k][1]>0;k++){
                    int a = J[k][0];
                    int b = J[k][1];
                    if((a<=S && S<b) || (a<E && E<=b) || (S<=a && b<= E)){
                        Jgetur = false;
                    }
                }
                boolean Cgetur = true;
                for(int k = 0; C[k][1]>0;k++){
                    int a = C[k][0];
                    int b = C[k][1];
                    if((a<=S && S<b) || (a<E && E<=b) || (S<=a && b<= E)){
                        Cgetur = false;
                    }
                }
                if(Jgetur){
                    J[Jverk][0] = S;
                    J[Jverk][1] = E;
                    Jverk++;
                    s+= "J";
                }
                else if(Cgetur){
                    C[Cverk][0] = S;
                    C[Cverk][1] = E;
                    Cverk++;
                    s+= "C";
                }
                else{
                    s = "IMPOSSIBLE";
                }
                }
            }
            System.out.println("Case #"+(i+1)+": "+s);
        }
    }
}