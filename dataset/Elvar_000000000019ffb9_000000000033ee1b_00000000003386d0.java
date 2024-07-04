import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int c = 1; c<=T;c++){
            int N = sc.nextInt();
            int[] x = new int[N];
            int[] y = new int[N];
            for(int i = 0; i<N;i++){
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
            int[][] ht = new int[N][N];
            int[][] hn = new int[N][N];
            for(int i = 0; i<N;i++){
                for(int j = 0; j<N;j++){
                    ht[i][j] = y[i]-y[j];
                    hn[i][j] = x[i]-x[j];
                    int d = gcd(ht[i][j],hn[i][j]);
                    ht[i][j] /= d;
                    hn[i][j] /= d;
                    if(ht[i][j] == 0) hn[i][j] = 1;
                    if(hn[i][j] == 0) ht[i][j] = 1;
                }
            }
            int mest = 0;
            for(int a = 0; a<N;a++){
                for(int b = a+1; b<N;b++){
                    int htprofa = ht[a][b];
                    int hnprofa = hn[a][b];
                    int fjoldi = 0;
                    boolean[] tekid = new boolean[N];
                    for(int i = 0; i<N;i++){
                        for(int j =i+1; j<N;j++){
                            if(ht[i][j] == htprofa && hn[i][j] == hnprofa){
                                if(!tekid[i]) fjoldi++;
                                if(!tekid[j])fjoldi++;
                                tekid[i] = true;
                                tekid[j] = true;
                                
                            }
                        }
                    }
                    if(fjoldi>mest) mest = fjoldi;
                }
            }
            int m = mest+2;
            while(m>N) m--;
            System.out.println("Case "+c+": "+m);
            
        }
    }
    public static int gcd(int a, int b){
        if(a<0) a= -a;
        if(b<0) b= -b;
        if(a == 0) return 1;
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}