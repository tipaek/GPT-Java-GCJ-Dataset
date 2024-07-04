import java.util.Scanner;

public class Main {

    public static void Solution(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=1;i<=T;i++) {
            int N = sc.nextInt();
            int N2 = N*N;
            int K = sc.nextInt();
            int sum = (N2 + N)/2;
            boolean impossible = false;
            if(K<N || K>N2 || (N%2==0 && K==sum) || (K!=sum && N2%K != 0)) {
                impossible = true;
            }
            System.out.print("Case #" + i + ": ");
            if(impossible){
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println("POSSIBLE");
                if(K==sum){
                    for(int p=0;p<N;p++) {
                        for(int q=0;q<N;q++) {
                            int r=(p+q+N)%N;
                            if(r==0)r=N;
                            System.out.print(r + " ");
                        }
                        System.out.println();
                    }
                } else if(N2%K == 0) {
                    int r = N2/K;
                    for(int p=0;p<N;p++) {
                        for(int q=0;q<N;q++) {
                            if(q!=0)r--;
                            if(r==0)r=N;
                            System.out.print(r + " ");
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
