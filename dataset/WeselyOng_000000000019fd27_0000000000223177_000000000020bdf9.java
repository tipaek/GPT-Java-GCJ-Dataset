
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t =0; t<T; t++){
            int N = in.nextInt();
            int[][] arr = new int[N][2];
            for(int n=0; n < N; ++n){
                arr[n][0] = in.nextInt();
                arr[n][1] = in.nextInt();
            }
            solve(arr, t);
        }
    }

    public static void solve(int[][] arr, int t){
        StringBuilder sb = new StringBuilder();
        sb.append("Case #");
        sb.append(t);
        sb.append(": ");
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int c = 0, j = 0;
        for(int i=0; i<arr.length; i++){
            int start = arr[i][0];
            int end = arr[i][1];
            if(start >= c){
                c = end;
                sb.append("C");
            }else if(start >= j){
                j = end;
                sb.append("J");
            }else{
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
                return;
            }
        }
        System.out.println(sb.toString());
        return;
    }
}