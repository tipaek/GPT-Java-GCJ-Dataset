import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    private static HashMap<Integer, Object> perm2d = new HashMap<>();
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i=1;i<=t;i++){
            solve(sc,i);
        }

    }

    private static void solve(Scanner sc, int T) {
        int N = sc.nextInt();
        int trace = sc.nextInt();
        if (!perm2d.containsKey(N)){
            createPerm2d(N);
        }

        int[][] arr = (int[][]) perm2d.get(N);

        for (int i=0;i<N;i++){
            int[] perm = arr[i];
            int st = 0;
            for (int k=0;k<N;k++){
                int ri = perm[k] - 1;
                st += arr[ri][k];
            }
            if (st == trace){
                System.out.println(String.format("Case #%d: %s",T,"POSSIBLE"));
                printMatrix(arr, perm, N);
                return;
            }
        }
        System.out.println(String.format("Case #%d: %s",T,"IMPOSSIBLE"));
    }

    private static void printMatrix(int[][] a2d, int[] perm, int N){
        for (int value : perm) {
            int row = value - 1;
            for (int j = 0; j < N; j++) {
                System.out.print(a2d[row][j]);
            }
            System.out.println();
        }
    }

    private static void createPerm2d(int n) {
        int[][] arr2d = new int[n][];
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = i+1;
        }
        arr2d[0] = arr;

        for (int c=1;c<n;c++){
            int[] ar1 = new int[n];
            System.arraycopy(arr,1,ar1,0,n-1);
            ar1[n-1] = arr[0];
            arr2d[c] = ar1;
            arr = ar1;
        }
        perm2d.put(n,arr2d);
    }
}
