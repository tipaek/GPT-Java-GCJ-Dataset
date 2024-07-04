// package codejam._2020_round1A;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main (String[] args) throws Exception {


//        String s = "3\n" +
//                "1\n" +
//                "4\n" +
//                "19";

        String s = "1\n" +
                "19";

        int T;
        Scanner scan = new Scanner(System.in);
        // Scanner scan = new Scanner(s);

        long time = System.currentTimeMillis();

        T = scan.nextInt();

        for (int t=1; t<=T; ++t) {
            System.out.println("Case #"+t+":");
            int N = scan.nextInt();

            --N;
            System.out.println("1 1");

            if (N>0) {
                System.out.println("2 1");
                --N;
            }
            int r=2;

            int[] R=new int[2]; R[0]=1; R[1]=1;
            int[] sumR=new int[2]; sumR[0]=1;sumR[1]=1;

            int k=0;
            while (N>0) {
                int[] _R = new int[R.length+1]; _R[0]=1; _R[_R.length-1]=1;
                int[] _sumR = new int[R.length+1]; _sumR[0]=1; _sumR[_R.length-1]=1;
                int to = _R.length/2 + _R.length%2;
                for (int i=1; i<to; ++i) {
                    _R[i] = R[i-1] + R[i];
                    _sumR[i] = _sumR[i-1] + _R[i];
                }
                if (_R.length%2==0) {
                    _R[to] = R[to-1] + R[to];
                    _sumR[to] = _sumR[to-1];
                }

                int _k = to-1;
                if (_sumR[_k]<=N) {
                    N-=_R[_k];
                    k=_k;
                    ++r;
                    R=_R;
                    System.out.println(r+" "+(_k+1));
                    continue;
                }

                if (k==0) {
                    --N;
                    System.out.println(r+" "+(k+1));
                }

                while (_sumR[k]>N && k>0) {
                    --k;
                    N-=R[k];
                    System.out.println(r+" "+(k+1));
                }
                ++r;
                R=_R;
            }
        }
    }
}
