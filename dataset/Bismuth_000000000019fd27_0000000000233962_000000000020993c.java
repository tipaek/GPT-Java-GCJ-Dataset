import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N;
        int M;
        int trace = 0;
        int bucketx[][];
        int buckety[][];
        int sumrow = 0;
        int sumcol = 0;
        boolean isCheckx = false;
        int isChecky[];
        for(int i =0; i<T; i++){
            N = sc.nextInt();
            bucketx = new int[N+1][N+1];
            buckety = new int[N+1][N+1];
            isChecky = new int[N];
            for(int j = 0; j<N;j++){
                for (int k = 0; k < N; k++) {
                    M = sc.nextInt();
                    if(j==k){
                        trace += M;
                    }
                    bucketx[j][M] += 1;
                    buckety[k][M] += 1;
                    
                    if(!isCheckx){
                        if(bucketx[j][M] >1){
                            sumrow++;
                            isCheckx = true;
                        }
                    }
                    
                    if(isChecky[k]==0){
                        if (buckety[k][M] > 1) {
                            sumcol++;
                            isChecky[k] = 1;
                        }
                    }
                }
                isCheckx = false;
            }
            System.out.println("case #"+(i+1)+": "+trace+" "+sumrow+" "+sumcol);
            trace = 0;

            sumrow = 0;
            sumcol = 0;
        }

    }

}