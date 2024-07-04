import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static long [] MASK = new long[51];
    static long ALL_VISITED = 1;
    static {
        build(MASK);
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.next());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(sc.next());
            int K = Integer.parseInt(sc.next());
            
            int [][] answer = null;
            if (N <= 6) {
                int [][] sqr = new int[N][N];
                List<int[]> diagonals = possibleDiagonal(K, N);
                for (int[] d : diagonals) {
                    if (solve(sqr, d)) {
                        answer = sqr;
                        break;
                    }
                }
            }
            if (answer != null) {
                // print array
                System.out.printf("Case #%d: POSSIBLE\n", tc);
                for (int ir = 0; ir < answer.length; ir++) {
                    for (int ic = 0; ic < answer.length; ic++) {
                        if(ic > 0) {
                            System.out.print(' ');
                        }
                        System.out.print(answer[ir][ic]);
                    }
                    System.out.println();
                }
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", tc);
            }
        }
    }
    static boolean solve(int[][] sqr, int[] diagonal) {
        ALL_VISITED = 1;
        for(int i = 1 ; i < sqr.length ; i++) {
            ALL_VISITED <<= 1;
            ALL_VISITED |= 1;
        }
        long [] rmask = new long[sqr.length];
        long [] cmask = new long[sqr.length];
        for (int i = 0; i < sqr.length; i++) {
            sqr[i][i] = diagonal[i];
            rmask[i] = MASK[diagonal[i]];
            cmask[i] = MASK[diagonal[i]];
        }
        return solve(rmask, cmask, sqr, 0, 1);
    }
    static boolean solve(long[] rmask, long[] cmask, int[][] sqr, int ir, int ic) {
        if(ir == sqr.length) {
            return true;
        }
        long visited = rmask[ir] | cmask[ic];
        if(visited == ALL_VISITED) {
            return false;
        }
        long rcache, ccache;
        int nextRow, nextCol;
        for(int n = 1 ; n <= sqr.length; n++) {
            if((visited & MASK[n]) == 0) {
                rcache = rmask[ir];
                ccache = cmask[ic];
                rmask[ir] |= MASK[n];
                cmask[ic] |= MASK[n];
                sqr[ir][ic] = n;
                nextRow = ir + (ic+1) / sqr.length;
                nextCol = (ic+1) % sqr.length;
                if(nextRow == nextCol) {
                    nextRow = nextRow + (nextCol+1) / sqr.length;
                    nextCol = (nextCol+1) % sqr.length;
                }
                if (solve(rmask, cmask, sqr, nextRow, nextCol)) {
                    return true;
                }
                sqr[ir][ic] = 0;
                rmask[ir] = rcache;
                cmask[ic] = ccache;
            }
        }
        return false;
    }
    static void build(long[] mask) {
        mask[1] = 0x0000000000000001;
        for (int i = 2; i < mask.length; i++) {
            mask[i] = mask[i-1] << 1;
        }
    }

    static List<int[]> possibleDiagonal(int sum, int n) {
        int [] v = new int[n];
        List<int[]> holder = new ArrayList<int[]>();
        fitInt(holder, sum, v, 0, 1, n);
        return holder;
    }
    static void fitInt(List<int[]> holder, int sum, int[] v, int idx, int from, int to) {
//        cnt ++;
        if(v.length == idx) {
            if (sum == 0) {
                holder.add(Arrays.copyOf(v, v.length));
            }
            return;                
        }
        
        if(sum <= 0 ) {
            return;
        }
        // underflow
        int min = (v.length-idx)*from;
        if(sum < min) {
            return;
        }
        // overflow
        int max = (v.length-idx)*to;
        if (sum > max) {
            return;
        }
        
        int cached = v[idx];
        v[idx] = from;
        while(v[idx] <= to ) {
            fitInt(holder, sum - v[idx], v, idx+1, v[idx], to);
            v[idx] ++;
        }
        
        v[idx] = cached;
    }
}