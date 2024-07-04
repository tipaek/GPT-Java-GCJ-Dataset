import java.util.*;

public class Solution {
    private static HashMap<Integer, Object> perm2d = new HashMap<>();
    private static HashMap<Integer, List<int[]>> permute = new HashMap<>();

    public static void main(String[] args){
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
            createPermute(N);
        }

        int[][] arr = (int[][]) perm2d.get(N);

        List<int[]> permList = permute.get(N);
        for (int[] perm: permList){
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
                System.out.print(a2d[row][j] + "  ");
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



    private static void createPermute(int N){
        int[] n = new int[N];
        for (int i=0;i<N;i++){
            n[i] = i+1;
        }
        List<int[]> arr = new ArrayList<>();
        permute(arr, n, n.length);
        permute.put(N, arr);


    }



    private static void permute(List<int[]> permList, int[] a, int size) {

        if (size == 1){
            int[] ac = new int[a.length];
            System.arraycopy(a,0,ac,0,a.length);
            permList.add(ac);
        }


        for (int i=0; i<size; i++) {
            permute(permList, a, size-1);

            // if size is odd, swap first and last
            // element
            if (size % 2 == 1)
            {
                int temp = a[0];
                a[0] = a[size-1];
                a[size-1] = temp;
            }

            // If size is even, swap ith and last
            // element
            else {
                int temp = a[i];
                a[i] = a[size-1];
                a[size-1] = temp;
            }
        }
    }


}
