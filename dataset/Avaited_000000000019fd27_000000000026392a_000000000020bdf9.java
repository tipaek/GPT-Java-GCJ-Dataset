import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = null;
        in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i =1 ; i <= T; i++) {
            int N = in.nextInt();
            if(N==1){
                System.out.println("Case #"+i+": C");
            } else if(N == 2) {
                System.out.println("Case #"+i+": CJ");
            } else {
                char [] seq = new char[N];
                int [] C = new int[1440];
                int [] J = new int [1440];
                boolean isImpossible = false;
                for (int ii = 0; ii < N; ii++) {
                    int start = in.nextInt();
                    int end = in.nextInt();
                    if(C[start] == 0){
                        for(int jj = start; jj < end; jj++){
                            C[jj] = 1;
                        }
                        seq[ii] = 'C';
                    } else if (J[start] == 0){
                        for(int jj = start; jj < end; jj++){
                            J[jj] = 1;
                        }
                        seq[ii] = 'J';
                    } else {
                        isImpossible = true;
                    }
                }
                if(isImpossible){
                    System.out.println("Case #"+i+": IMPOSSIBLE");
                } else {
                    System.out.print("Case #"+i+": ");
                    for(int p = 0; p < N; p++){
                        System.out.print(seq[p]);
                    }
                    System.out.println();
                }
            }
        }
    }
}
