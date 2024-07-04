import java.util.*;

class Indiciium{
    public static void main(String args[]) throws Exception{
        Indiciium in = new Indiciium();
		
        in.my_fun();
    }
    void my_fun(){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++ ){
            int N = sc.nextInt();
          int K = sc.nextInt();
            int[][] arr = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
			
            int s = 1, trace = 0;
            while(s<=N){
                trace += arr[s][s];
                
                s++;
            }
            if(trace == K){
                System.out.println("POSSIBLE");
            }
            else{
                System.out.println("IMPOSSIBLE");
            }
        
		}
	
	}
	

	}