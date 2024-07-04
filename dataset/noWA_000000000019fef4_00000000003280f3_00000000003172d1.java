import java.util.Arrays;
import static java.lang.Math.*;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int case_=1;case_<=t;++case_) {
            System.out.print("Case #"+case_+": ");
            int n = scan.nextInt(), d = scan.nextInt();
            long arr[] = new long[n];
            for(int i=0;i<n;++i) {
                arr[i] = scan.nextLong();
            }
            Arrays.sort(arr);
            HashSet<Long> poss = new HashSet<>();
            for(int i=0;i<n;++i) {
                long N = arr[i];
                for(long D=1;D*D<=N;++D) {
                    if(N%D==0) {
                        poss.add(D);
                        poss.add((N/D));
                    }
                }
            }
            int ans = d-1;
            for(long e : poss) {
                //System.out.print(e+" ");
                int need = d, ispe = 0;
                for(int i=0;i<n;++i) {
                    if(arr[i]%e==0) {
                        long n_pieces = arr[i]/e;
                        if(n_pieces>need) {
                            ispe+=need;
                            need = 0;
                        }
                        else if(n_pieces==need) {
                            ispe+=(need-1);
                            need = 0;
                        }
                        else {
                            ispe+=(n_pieces-1);
                            need-=n_pieces;
                        }
                        if(need==0) {
                            break;
                        }
                    }
                }
                if(need==0) {
                    ans = min(ans, ispe);
                }
            }
            //System.out.println();
            System.out.println(ans);

        }
    }
}