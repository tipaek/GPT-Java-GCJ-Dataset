import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Solution{
    public static void evaluate(int[][] acts, int x) {
        int c = 0;
        int j = 0;
        Arrays.sort(acts, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Double.compare(a[0], b[0]);
            }
        });
        StringBuilder sb = new StringBuilder();
        
        for(int[] act:acts){
            int start = act[0];
            int end = act[1];
            if (c <= start){
                sb.append("C");
                c = end;
                continue;
            }
            if (j <= start){
                sb.append("J");
                j = end;
            } else {
                System.out.println("Case #"+x+": IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #"+x+": "+sb.toString());
    }

     public static void main(String []args){
        Solution sol = new Solution();
        Scanner stdin = new Scanner(System.in);
        int T = stdin.nextInt();

        for(int t=0; t<T; t++){
            int N = stdin.nextInt();
            int[][] acts = new int[N][2];
            for(int i=0; i<N; i++){
                int start = stdin.nextInt();;
                int end = stdin.nextInt();;
                acts[i] = new int[]{start, end};
            }
            sol.evaluate(acts, t+1);
        }
     }
}